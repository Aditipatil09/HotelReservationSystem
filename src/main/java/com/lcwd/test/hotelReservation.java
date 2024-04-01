package com.lcwd.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

class HotelFinder {

    public static final Map<String, Map<LocalDate, Integer>> hotels = new HashMap<>();

    static {
        Map<LocalDate, Integer> lakewoodRates = new HashMap<>();
        lakewoodRates.put(LocalDate.parse("2020-09-10"), 100);
        lakewoodRates.put(LocalDate.parse("2020-09-11"), 120);
        hotels.put("Lakewood", lakewoodRates);

        Map<LocalDate, Integer> beachwoodRates = new HashMap<>();
        beachwoodRates.put(LocalDate.parse("2020-09-10"), 150);
        beachwoodRates.put(LocalDate.parse("2020-09-11"), 140);
        hotels.put("Beachwood", beachwoodRates);

        Map<LocalDate, Integer> parkviewRates = new HashMap<>();
        parkviewRates.put(LocalDate.parse("2020-09-10"), 130);
        parkviewRates.put(LocalDate.parse("2020-09-11"), 110);
        hotels.put("Parkview", parkviewRates);
    }

    public static void main(String[] args) {
        String startDateStr = "10Sep2020";
        String endDateStr = "11Sep2020";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        String cheapestHotel = findCheapestHotel(startDate, endDate);
        int totalRates = calculateTotalRates(cheapestHotel, startDate, endDate);

        System.out.println("Cheapest hotel: " + cheapestHotel + ", Total Rates: $" + totalRates);
    }

    public static String findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        String cheapestHotel = null;
        int cheapestRate = Integer.MAX_VALUE;

        for (String hotel : hotels.keySet()) {
            int totalRate = calculateTotalRates(hotel, startDate, endDate);
            if (totalRate < cheapestRate) {
                cheapestRate = totalRate;
                cheapestHotel = hotel;
            }
        }
        return cheapestHotel;
    }

    public static int calculateTotalRates(String hotel, LocalDate startDate, LocalDate endDate) {
        int totalRate = 0;
        Map<LocalDate, Integer> rates = hotels.get(hotel);

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            totalRate += rates.getOrDefault(date, 0);
        }
        return totalRate;
    }
}
