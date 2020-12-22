package com.ticket.movie.controller;

import com.ticket.movie.model.BookingTransactions;
import com.ticket.movie.service.BookingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookingoperations")
public class BookingTransactionController {

    @Autowired
    private BookingTransactionService bookingTransactionService;

    @PostMapping(value = "/bookticket")
    @ResponseStatus(HttpStatus.CREATED)
    public String ticketConfirmation(@RequestBody BookingTransactions bookingTransactions){
        return bookingTransactionService.bookTicket(bookingTransactions);
    }

    @GetMapping(value = "/canceltickets")
    public String ticketCancelation(@RequestParam String bookingId){
        return bookingTransactionService.cancelTicket(bookingId);
    }

}
