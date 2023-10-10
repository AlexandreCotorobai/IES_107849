package com.restservice;

import java.util.HashMap;
import java.util.Map;

public class Show {
    private int id;
    private String name;
    private Map<Integer, String> quotes;

    public Show(int id) {
        this.id = id;
        this.quotes = new HashMap<>();
    }

    public Show(int id, String name) {
        this.id = id;
        this.name = name;
        this.quotes = new HashMap<>();
    }

    public void addQuote(int quoteId, String quote) {
        quotes.put(quoteId, quote);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if (this.name == null) {
            return "Show Not Defined";
        }
        return this.name;
    }

    public Map<Integer, String> getQuotes() {
        return quotes;
    }
}
