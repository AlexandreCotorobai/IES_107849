package com.restservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.restservice.entity.*;

import com.restservice.service.*;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class Controller {
    private QuoteService quoteService;
    private MovieService movieService;

    @GetMapping("/api/quote")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/api/quotes/{movieId}")
    public List<Quote> getQuotesByMovie(@PathVariable(name = "movieId") Long movieId) {
        return quoteService.getQuotesByMovie(movieId);
    }

    @GetMapping("/api/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/api/movie/{movieId}")
    public Movie getMovie(@PathVariable(name = "movieId") Long movieId) {
        return movieService.getMovie(movieId);
    }

    @PostMapping("/api/movie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.postMovie(movie);
    }

    @PostMapping("/api/quote")
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.postQuote(quote);
    }

}
