package com.ticket.movie.serviceimpl;

import com.ticket.movie.model.Movie;
import com.ticket.movie.repository.MovieInfoRepository;
import com.ticket.movie.service.MovieOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieOperationsServiceImpl implements MovieOperationService {

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieInfoRepository.save(movie);
    }

    @Override
    public List<Movie> getCurrentMovie() {
        return movieInfoRepository.findAll();
    }

    @Override
    public Movie updateMovieInfo(Movie movie) {
        return movieInfoRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieInfoRepository.delete(movie);
    }
}
