package com.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    private ArrayList<Show> shows = getData();

    @GetMapping("/api/quote")
    public Map<Integer, String> getRandomQuote() {
        Random random = new Random();
        int showIndex = random.nextInt(shows.size());
        Show show = shows.get(showIndex);
        int quoteIndex = random.nextInt(show.getQuotes().size())+1;
        System.out.println(showIndex + " " + quoteIndex);

        for (Map.Entry<Integer, String> entry : show.getQuotes().entrySet()) {
            if (entry.getKey() == quoteIndex) {
                Map<Integer, String> map = new HashMap<>();
                map.put(show.getId(), entry.getValue());
                return map;
            }
        }
        return null;
    }

    @GetMapping("/api/shows")
    public Map<Integer, String> getShows() {
        Map<Integer, String> map = new HashMap<>();
        for (Show show : shows) {
            map.put(show.getId(), show.getName());
        }
        return map;
    }

    @GetMapping("/api/quotes")
    public Map<String, Map<Integer, String>> getQuotesByShow(@RequestParam(value = "show", required = false) String showId) {
        Map<String, Map<Integer, String>> quotes = new HashMap<>();

        for (Show show : shows) {
            if (show.getId() == Integer.parseInt(showId)) {
                quotes.put(show.getName(), show.getQuotes());
            }
        }
        return quotes;
    }

    public ArrayList<Show> getData() {
        ArrayList<Show> shows = new ArrayList<>();

        Show show1 = new Show(1, "The Simpsons");
        show1.addQuote(1, "D'oh!");
        show1.addQuote(2, "Eat my shorts!");
        show1.addQuote(3, "Excellent...");
        shows.add(show1);

        Show show2 = new Show(2, "South Park");
        show2.addQuote(1, "Oh my God, they killed Kenny!");
        show2.addQuote(2, "Respect my authoritah!");
        shows.add(show2);

        Show show3 = new Show(3, "Friends");
        show3.addQuote(1, "How you doin'?");
        show3.addQuote(2, "We were on a break!");
        shows.add(show3);

        Show show4 = new Show(4, "The Office");
        show4.addQuote(1, "That's what she said.");
        show4.addQuote(2, "Bears, beets, Battlestar Galactica.");
        shows.add(show4);

        Show show5 = new Show(5, "Breaking Bad");
        show5.addQuote(1, "I am the one who knocks.");
        show5.addQuote(2, "Say my name.");
        shows.add(show5);

        return shows;
    }
}
