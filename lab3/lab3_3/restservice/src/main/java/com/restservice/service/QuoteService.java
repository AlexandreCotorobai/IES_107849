package com.restservice.service;

import java.util.List;

import com.restservice.entity.Quote;

public interface QuoteService {
  public Quote getRandomQuote();

  public Quote getQuoteByMovie(Long movieId);

  public List<Quote> getQuotesByMovie(long movieId);

  public Quote getQuote(Long quoteId);

  public Quote postQuote(Quote quote);
}
