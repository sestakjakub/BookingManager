/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.impl.HotelDAOImpl;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Hotel;
import bookingmanager.entity.Hotel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jana
 */
public class HotelDAOTest {
    
    public HotelDAOTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void persistHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        
        HotelDAOImpl hotelEntityManager = new HotelDAOImpl();
        hotelEntityManager.persistHotel(hotel);
        
        Hotel hotel2 = hotelEntityManager.getHotelById(hotel.getId());
        
        assertEquals("Persisted entity: " + hotel.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotel, hotel2);
        
        hotelEntityManager.removeHotel(hotel);
    }
    
    @Test
    public void getAllHotelsTest(){
        
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", 654321);
        Hotel hotel3 = createHotel("HolidayInn", "Botanicka 6", 134652);
        
        List<Hotel> hotels = Arrays.asList(hotel, hotel2, hotel3);
        
        HotelDAOImpl hotelEntityManager = new HotelDAOImpl();
        hotelEntityManager.persistHotel(hotel);
        hotelEntityManager.persistHotel(hotel2);
        hotelEntityManager.persistHotel(hotel3);
        
        List<Hotel> hotelsExtracted = hotelEntityManager.getAllHotels();
        
        Collections.sort(hotels, idComparator);
        Collections.sort(hotelsExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", hotels.size(), hotelsExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", hotels, hotelsExtracted);
        
        hotelEntityManager.removeHotel(hotel);
        hotelEntityManager.removeHotel(hotel2);
        hotelEntityManager.removeHotel(hotel3);
    }
    
    @Test
    public void findHotelByIdTest(){
        // the same as PersistHotelTest?
    }
    
    @Test
    public void mergeHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        
        HotelDAOImpl hotelEntityManager = new HotelDAOImpl();
        hotelEntityManager.persistHotel(hotel);
        
        hotel.setAddress("Manesova 12");
        
        Hotel hotelManaged = hotelEntityManager.mergeHotel(hotel);
        
        Hotel hotel2 = hotelEntityManager.getHotelById(hotel.getId());
        assertEquals("Merged entity: " + hotel.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotel, hotel2);
        
        hotelManaged.setAddress("Malinovskeho namesti");
        
        hotel2 = hotelEntityManager.getHotelById(hotelManaged.getId());
        assertEquals("Managed entity: " + hotelManaged.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotelManaged, hotel2);
        
        hotelEntityManager.removeHotel(hotel);
    }
    
    @Test
    public void updateHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", 654321);
        
        HotelDAOImpl hotelEntityManager = new HotelDAOImpl();
        hotelEntityManager.persistHotel(hotel);
        hotelEntityManager.persistHotel(hotel2);
        
        hotel.setName("Martin Kuba");
        hotel.setAddress("Kotlarska 45");
        
        Hotel hotelDB = hotelEntityManager.getHotelById(hotel.getId());
                
        assertEquals("Entity: " + hotel + "was not correctly updated in DB, actual entity: " + 
                hotelDB, hotel, hotelDB);
        
        Hotel hotelDB2 = hotelEntityManager.getHotelById(hotel2.getId());
        
        assertEquals("Entity: " + hotel2 + "was disturbed in DB while updating entity: " +
                hotel, hotel2, hotelDB2);
        
        hotelEntityManager.removeHotel(hotel);
        hotelEntityManager.removeHotel(hotel2);
    }
    
    @Test
    public void removeHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", 654321);
        
        HotelDAOImpl hotelEntityManager = new HotelDAOImpl();
        hotelEntityManager.persistHotel(hotel);
        hotelEntityManager.persistHotel(hotel2);
        
        hotelEntityManager.removeHotel(hotel);
        
        assertEquals("Entity: " + hotel.toString() + 
                "was not correctly removed from DB", hotelEntityManager.getAllHotels().size(), 1);
        
        Hotel hotelDB = hotelEntityManager.getHotelById(hotel2.getId());
        
        assertEquals("Entity: " + hotel2.toString() +
                "was disturbed while removing entity: " + hotel.toString(), hotel2, hotelDB);
        
        hotelEntityManager.removeHotel(hotel2);
    }
    
    
    
    private static Comparator<Hotel> idComparator = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel r1, Hotel r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
    
    private Hotel createHotel(String name, String address, int phone){
        Hotel hotel = new Hotel();
        hotel.setAddress(address);
        hotel.setName(name);
        hotel.setPhoneNumber(phone);
        
        return hotel;
    }
}
