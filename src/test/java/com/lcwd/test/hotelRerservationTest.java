package com.lcwd.test;


import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;

class HotelFinderTest {

    @Test
    public void testFindCheapestHotel() {
        String startDateStr = "10Sep2020";
        String endDateStr = "11Sep2020";

        String expectedHotel = "Lakewood";
        int expectedTotalRates = 220;

        LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("ddMMMyyyy"));
        LocalDate endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ofPattern("ddMMMyyyy"));

        HotelFinder hotelFinder = new HotelFinder();
        String cheapestHotel = hotelFinder.findCheapestHotel(startDate, endDate);
        int totalRates = hotelFinder.calculateTotalRates(cheapestHotel, startDate, endDate);

        assertEquals(expectedHotel, cheapestHotel);
        assertEquals(expectedTotalRates, totalRates);
    }
}
