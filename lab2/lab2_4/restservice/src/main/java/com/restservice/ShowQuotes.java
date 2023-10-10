package com.restservice;

import java.util.ArrayList;

public record ShowQuotes(String name, ArrayList<Quote> quotes) { }