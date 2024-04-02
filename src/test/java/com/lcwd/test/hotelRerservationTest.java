package com.lcwd.test;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class HotelFinderTest {

    @Test
    public void testFindBestRatedHotel() {

        Hotel bridgewood = new Hotel("Bridgewood", 4);
        bridgewood.addRate("11Sep2020", 100);
        bridgewood.addRate("12Sep2020", 100);

        Hotel lakewood = new Hotel("Lakewood", 5);
        lakewood.addRate("11Sep2020", 110);
        lakewood.addRate("12Sep2020", 90);


        HotelFinder finder = new HotelFinder();


        Hotel bestRatedHotel = finder.findBestRatedHotel(bridgewood, lakewood);


        assertEquals("Lakewood", bestRatedHotel.getName());
        assertEquals(5, bestRatedHotel.getRating());
    }
}
