package com.ticket.movie.service;

import com.ticket.movie.model.BookingTransactions;

public interface BookingTransactionService {

    public String bookTicket(BookingTransactions bookingTransactions);

    public String cancelTicket(String bookingReferenceId);

}
