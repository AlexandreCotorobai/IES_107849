package com.restservice.service;

import com.restservice.entity.Movie;


import java.util.List;

public interface MovieService {
  public List<Movie> getMovies();

  public Movie getMovie(Long movieId);

  public Movie postMovie(Movie movie);
}

