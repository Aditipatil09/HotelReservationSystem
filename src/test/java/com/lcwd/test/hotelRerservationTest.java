package com.lcwd.test;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class HotelFinderTest {

    @Test
    public void testFindCheapestBestRatedHotel() {

        Hotel bridgewood = new Hotel("Bridgewood", 4);
        bridgewood.addRate("11Sep2020", 100);
        bridgewood.addRate("12Sep2020", 100);

        Hotel lakewood = new Hotel("Lakewood", 3);
        lakewood.addRate("11Sep2020", 110);
        lakewood.addRate("12Sep2020", 90);


        HotelFinder finder = new HotelFinder();


        Hotel cheapestHotel = finder.findCheapestBestRatedHotel(bridgewood, lakewood);


        assertEquals("Bridgewood", cheapestHotel.getName());
        assertEquals(4, cheapestHotel.getRating());
        assertEquals(200, cheapestHotel.getTotalRate("11Sep2020", "12Sep2020"));
    }
}
