package com.restservice;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Show {
    private int id;
    private String name;
    // private Map<Integer, String> quotes;
    private ArrayList<String> quotes;

    public Show(int id) {
        this.id = id;
        this.quotes = new ArrayList<>();
    }

    public Show(int id, String name) {
        this.id = id;
        this.name = name;
        this.quotes = new ArrayList<>();
    }

    public void addQuote(String quote) {
        quotes.add(quote);
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

    public ArrayList<String> getQuotes() {
        return quotes;
    }
}
