package com.lcwd.test;

import java.util.*;

class Hotel {
    private String name;
    private int rating;
    private Map<String, Integer> rates;

    public Hotel(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.rates = new HashMap<>();
    }

    public void addRate(String date, int rate) {
        rates.put(date, rate);
    }

    public int getTotalRate(String fromDate, String toDate) {
        int totalRate = 0;
        for (String date = fromDate; !date.equals(toDate); ) {
            totalRate += rates.getOrDefault(date, 0);
            date = getNextDate(date);
        }
        return totalRate;
    }

    private String getNextDate(String date) {
        // Logic to get next date goes here
        // This is just a placeholder
        return date;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}

class HotelFinder {
    public Hotel findCheapestBestRatedHotel(Hotel... hotels) {
        Hotel cheapestHotel = null;
        int minRate = Integer.MAX_VALUE;
        int maxRating = Integer.MIN_VALUE;

        for (Hotel hotel : hotels) {
            int totalRate = hotel.getTotalRate("11Sep2020", "12Sep2020");
            if (totalRate < minRate || (totalRate == minRate && hotel.getRating() > maxRating)) {
                minRate = totalRate;
                maxRating = hotel.getRating();
                cheapestHotel = hotel;
            }
        }
        return cheapestHotel;
    }
}
