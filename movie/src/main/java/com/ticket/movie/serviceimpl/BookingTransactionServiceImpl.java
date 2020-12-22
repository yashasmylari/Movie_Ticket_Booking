package com.ticket.movie.serviceimpl;

import com.ticket.movie.model.BookingTransactions;
import com.ticket.movie.model.Movie;
import com.ticket.movie.model.User;
import com.ticket.movie.repository.BookingInfoRepository;
import com.ticket.movie.repository.MovieInfoRepository;
import com.ticket.movie.repository.UserInfoRepository;
import com.ticket.movie.service.BookingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingTransactionServiceImpl implements BookingTransactionService {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    private Movie movie;
    private String result;
    private BookingTransactions bookingTransactions;
    private User user;

    @Override
    public String bookTicket(BookingTransactions bookingTransactions) {

        if (isTicketAvailable(bookingTransactions.getMovieId(),bookingTransactions.getTicketCount())){
            bookingTransactions = bookingInfoRepository.save(bookingTransactions);
            if (getUserDetails(bookingTransactions.getUserId()) == null){
                result = "Your User Id is not valid";
            } else{
                movie = getMovieDetails(bookingTransactions.getMovieId());
                int remainingTickets = movie.getTotalTickets() - bookingTransactions.getTicketCount();
                movie.setTotalTickets(remainingTickets);
                movieInfoRepository.save(movie);

                result = "Your ticket booked and Reference ID: " + bookingTransactions.get_id();
            }

        } else {
            result = "Requested number of tickets are not available";
        }
        return result;
    }

    @Override
    public String cancelTicket(String bookingReferenceId) {

        int totalTickets;
        bookingTransactions = getTicketDetails(bookingReferenceId);
        if (bookingTransactions == null){
            result = "Please Enter the valid Booking reference number";
        } else {
            String movieId = bookingTransactions.getMovieId();
            movie = getMovieDetails(movieId);
            if (movie == null){
                result = "Please Enter the valid Movie reference ID";
            } else {
                int canceledTickets = bookingTransactions.getTicketCount();
                totalTickets = canceledTickets + movie.getTotalTickets();
                movie.setTotalTickets(totalTickets);
                movieInfoRepository.save(movie);
                bookingInfoRepository.delete(bookingTransactions);
                result = "Your Ticket has been canceled successfully";
            }

        }

        return result;
    }


    public User getUserDetails(String userId){
        Optional<User> registeredUser = userInfoRepository.findById(userId);
        if (registeredUser.isEmpty()){
            return null;
        } else{
            user = registeredUser.get();
            return user;
        }
    }
    public BookingTransactions getTicketDetails(String referenceID){
        Optional<BookingTransactions> bookedTicket = bookingInfoRepository.findById(referenceID);
        if (bookedTicket.isEmpty()){
            return null;
        } else {
            bookingTransactions = bookedTicket.get();
            return bookingTransactions;
        }

    }

    public Movie getMovieDetails(String movieId){

        Optional<Movie> optionalMovie = movieInfoRepository.findById(movieId);
        if (optionalMovie.isEmpty()){
            return null;
        } else{
            movie = optionalMovie.get();
            return movie;
        }

    }

    public boolean isTicketAvailable(String movieId, int bookedTicket){

        Optional<Movie> optionalMovie = movieInfoRepository.findById(movieId);
        movie = optionalMovie.get();
        int remainingTicket = movie.getTotalTickets();

        if (remainingTicket < bookedTicket){
            return false;
        }else {
            return true;
        }

    }

}
