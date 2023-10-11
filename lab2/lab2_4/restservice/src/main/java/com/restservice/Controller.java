package com.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    private ArrayList<Show> shows = getData();

    @GetMapping("/api/quote")
    public Quote getRandomQuote() {
        Random random = new Random();
        int showIndex = random.nextInt(shows.size());
        Show show = shows.get(showIndex);
        int quoteIndex = random.nextInt(show.getQuotes().size());
        // System.out.println(showIndex + " " + quoteIndex);

        // for (Map.Entry<Integer, String> entry : show.getQuotes().entrySet()) {
        //     if (entry.getKey() == quoteIndex) {
        //         Map<Integer, String> map = new HashMap<>();
        //         map.put(show.getId(), entry.getValue());
        //         return map;
        //     }
        // }

        String randomQuote = show.getQuotes().get(quoteIndex);

        return new Quote(randomQuote);
    }

    @GetMapping("/api/shows")
    public ArrayList<ShowRec> getShows() {
        ArrayList<ShowRec> result = new ArrayList<>();
        for (Show show : shows) {
            result.add(new ShowRec(show.getId(), show.getName()));
        }
        return result;
    }

    @GetMapping("/api/quotes")
    public ShowQuotes getQuotesByShow(@RequestParam(value = "show", required = false) String showId) {
        ArrayList<Quote> quotes = new ArrayList<>();
        ShowRec showName = null;

        for (Show show : shows) {
            if (show.getId() == Integer.parseInt(showId)) {
                System.out.println(show.getId() + " " + showId);
                for (String quote : show.getQuotes()) {
                    quotes.add(new Quote(quote));
                }
                showName = new ShowRec(show.getId(), show.getName());
            }
            

        }
        return new ShowQuotes(showName, quotes);
    }

    public ArrayList<Show> getData() {
        ArrayList<Show> shows = new ArrayList<>();

        Show show1 = new Show(1, "The Simpsons");
        show1.addQuote("D'oh!");
        show1.addQuote("Eat my shorts!");
        show1.addQuote("Excellent...");
        shows.add(show1);

        Show show2 = new Show(2, "South Park");
        show2.addQuote("Oh my God, they killed Kenny!");
        show2.addQuote("Respect my authoritah!");
        shows.add(show2);

        Show show3 = new Show(3, "Friends");
        show3.addQuote("How you doin'?");
        show3.addQuote("We were on a break!");
        shows.add(show3);

        Show show4 = new Show(4, "The Office");
        show4.addQuote("That's what she said.");
        show4.addQuote("Bears, beets, Battlestar Galactica.");
        shows.add(show4);

        Show show5 = new Show(5, "Breaking Bad");
        show5.addQuote("I am the one who knocks.");
        show5.addQuote("Say my name.");
        shows.add(show5);

        return shows;
    }
}
