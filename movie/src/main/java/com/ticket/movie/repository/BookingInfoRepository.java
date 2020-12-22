package com.ticket.movie.repository;

import com.ticket.movie.model.BookingTransactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingInfoRepository extends MongoRepository<BookingTransactions,String> {
}
