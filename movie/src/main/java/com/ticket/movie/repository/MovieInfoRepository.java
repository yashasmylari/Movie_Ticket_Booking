package com.ticket.movie.repository;

import com.ticket.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends MongoRepository<Movie, String> {
}
