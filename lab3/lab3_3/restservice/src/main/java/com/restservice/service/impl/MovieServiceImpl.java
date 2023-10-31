package com.restservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import lombok.AllArgsConstructor;

import com.restservice.entity.Movie;
import com.restservice.repository.MovieRepository;
import com.restservice.service.MovieService;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
  private MovieRepository movieRepository;

  @Override
  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  @Override
  public Movie getMovie(Long movieId) {
    return movieRepository.findById(movieId).orElseThrow();
  }

  @Override
  public Movie postMovie(Movie movie) {
    return movieRepository.save(movie);
  }
}
