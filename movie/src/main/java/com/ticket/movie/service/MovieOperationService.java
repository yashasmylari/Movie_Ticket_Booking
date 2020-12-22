package com.ticket.movie.service;

import com.ticket.movie.model.Movie;

import java.util.List;

public interface MovieOperationService {


    public Movie addMovie(Movie movie);

    public List<Movie> getCurrentMovie();

    public Movie updateMovieInfo(Movie movie);

    public void deleteMovie(Movie movie);
}
