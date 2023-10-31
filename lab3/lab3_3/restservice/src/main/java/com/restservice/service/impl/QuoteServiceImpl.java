package com.restservice.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;

import com.restservice.entity.Quote;
import com.restservice.repository.QuoteRepository;
import com.restservice.service.QuoteService;


@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {
  private QuoteRepository quoteRepository;

  @Override
  public Quote getRandomQuote() {
    Random rand = new Random();
    List<Quote> quotes = quoteRepository.findAll();
    return quotes.get(rand.nextInt(quotes.size()));
  }

  @Override
  public Quote getQuoteByMovie(Long movieId) {
    Random rand = new Random();
    List<Quote> quotes = this.getQuotesByMovie(movieId);
    return quotes.get(rand.nextInt(quotes.size()));
  }

  @Override
  public List<Quote> getQuotesByMovie(long movieId) {
    List<Quote> quotes = quoteRepository.findAll();
    quotes.removeIf(quote -> quote.getMovie().getId() != movieId);
    return quotes;
  }

  @Override
  public Quote getQuote(Long quoteId) {
    return quoteRepository.findById(quoteId).orElseThrow();
  }

  @Override
  public Quote postQuote(Quote quote) {
    return quoteRepository.save(quote);
  }
}
