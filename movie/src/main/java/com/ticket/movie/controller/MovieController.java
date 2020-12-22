package com.ticket.movie.controller;


import com.ticket.movie.model.Movie;
import com.ticket.movie.service.MovieOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieoperations")
public class MovieController {

    @Autowired
    private MovieOperationService movieOperationService;


    @PostMapping(value = "/newmovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie newMovies(@RequestBody Movie movie){
        return movieOperationService.addMovie(movie);
    }

    @GetMapping(value = "/getmovies")
    public List<Movie> getCurrentMovie(){
        return movieOperationService.getCurrentMovie();
    }

    @PutMapping(value = "/updatemovie")
    public Movie updateMovieInfo(@RequestBody Movie movie){
        return movieOperationService.updateMovieInfo(movie);
    }

    @DeleteMapping(value = "/deletemovie")
    public String deleteMovie(@RequestBody Movie movie){
        movieOperationService.deleteMovie(movie);
        return "Movie Deleted";
    }



}
