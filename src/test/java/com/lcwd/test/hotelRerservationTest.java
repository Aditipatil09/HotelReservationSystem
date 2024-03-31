package com.lcwd.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HotelReservationSystemTest {

    @Test
    public void testAddHotelAndSetRegularRate() {
        HotelReservationSystem reservationSystem = new HotelReservationSystem();


        reservationSystem.addHotel("Lakewood");


        reservationSystem.setRegularRate("Lakewood", "Weekday", 110);
        reservationSystem.setRegularRate("Lakewood", "Weekend", 90);


        Assertions.assertEquals(110, reservationSystem.getRegularRate("Lakewood", "Weekday"));
        Assertions.assertEquals(90, reservationSystem.getRegularRate("Lakewood", "Weekend"));


    }
}
