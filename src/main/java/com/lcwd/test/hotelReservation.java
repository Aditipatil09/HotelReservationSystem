package com.lcwd.test;

import java.util.HashMap;
import java.util.Map;

class Hotel {
    private String name;
    private Map<String, Integer> regularRates;

    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setRegularRate(String day, int rate) {
        regularRates.put(day, rate);
    }

    public int getRegularRate(String day) {
        return regularRates.getOrDefault(day, 0);
    }
}

class HotelReservationSystem {
    private Map<String, Hotel> hotels; // Map to store hotels by name

    public HotelReservationSystem() {
        this.hotels = new HashMap<>();
    }

    public void addHotel(String name) {
        hotels.put(name, new Hotel(name));
    }

    public void setRegularRate(String hotelName, String day, int rate) {
        Hotel hotel = hotels.get(hotelName);
        if (hotel != null) {
            hotel.setRegularRate(day, rate);
        } else {
            System.out.println("Hotel '" + hotelName + "' not found.");
        }
    }

    public int getRegularRate(String hotelName, String day) {
        Hotel hotel = hotels.get(hotelName);
        if (hotel != null) {
            return hotel.getRegularRate(day);
        } else {
            System.out.println("Hotel '" + hotelName + "' not found.");
            return 0;
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem reservationSystem = new HotelReservationSystem();
        reservationSystem.addHotel("Lakewood");
        reservationSystem.setRegularRate("Lakewood", "Weekday", 110);
        reservationSystem.setRegularRate("Lakewood", "Weekend", 90);

        System.out.println("Regular rate for Lakewood on Weekday: $" + reservationSystem.getRegularRate("Lakewood", "Weekday"));
        System.out.println("Regular rate for Lakewood on Weekend: $" + reservationSystem.getRegularRate("Lakewood", "Weekend"));
        System.out.println("Regular rate for Lakewood on Sunday: $" + reservationSystem.getRegularRate("Lakewood", "Sunday"));
    }
}

