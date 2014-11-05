/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.test;

import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.HotelDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
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
        
        HotelDAO hoteDAOManager = new HotelDAOImpl();
        hoteDAOManager.persistHotel(hotel);
        
        Hotel hotel2 = hoteDAOManager.getHotelById(hotel.getId());
        
        assertEquals("Persisted entity: " + hotel.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotel, hotel2);
        
        hoteDAOManager.removeHotel(hotel);
    }
    
    @Test
    public void getAllHotelsTest(){
        
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", 654321);
        Hotel hotel3 = createHotel("HolidayInn", "Botanicka 6", 134652);
        
        List<Hotel> hotels = Arrays.asList(hotel, hotel2, hotel3);
        
        HotelDAO hoteDAOManager = new HotelDAOImpl();
        hoteDAOManager.persistHotel(hotel);
        hoteDAOManager.persistHotel(hotel2);
        hoteDAOManager.persistHotel(hotel3);
        
        List<Hotel> hotelsExtracted = hoteDAOManager.getAllHotels();
        
        Collections.sort(hotels, idComparator);
        Collections.sort(hotelsExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", hotels.size(), hotelsExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", hotels, hotelsExtracted);
        
        hoteDAOManager.removeHotel(hotel);
        hoteDAOManager.removeHotel(hotel2);
        hoteDAOManager.removeHotel(hotel3);
    }
    
    @Test
    public void mergeHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        
        HotelDAO hoteDAOManager = new HotelDAOImpl();
        hoteDAOManager.persistHotel(hotel);
        
        hotel.setAddress("Manesova 12");
        
        Hotel hotelManaged = hoteDAOManager.mergeHotel(hotel);
        
        Hotel hotel2 = hoteDAOManager.getHotelById(hotel.getId());
        assertEquals("Merged entity: " + hotel.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotel, hotel2);
        
        hotelManaged.setAddress("Malinovskeho namesti");
        
        hotel2 = hoteDAOManager.getHotelById(hotelManaged.getId());
        assertEquals("Managed entity: " + hotelManaged.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotelManaged, hotel2);
        
        hoteDAOManager.removeHotel(hotel);
    }
    
    @Test
    public void updateHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", 654321);
        
        HotelDAO hoteDAOManager = new HotelDAOImpl();
        hoteDAOManager.persistHotel(hotel);
        hoteDAOManager.persistHotel(hotel2);
        
        hotel.setName("Martin Kuba");
        hotel.setAddress("Kotlarska 45");
        
        Hotel hotelDB = hoteDAOManager.getHotelById(hotel.getId());
                
        assertEquals("Entity: " + hotel + "was not correctly updated in DB, actual entity: " + 
                hotelDB, hotel, hotelDB);
        
        Hotel hotelDB2 = hoteDAOManager.getHotelById(hotel2.getId());
        
        assertEquals("Entity: " + hotel2 + "was disturbed in DB while updating entity: " +
                hotel, hotel2, hotelDB2);
        
        hoteDAOManager.removeHotel(hotel);
        hoteDAOManager.removeHotel(hotel2);
    }
    
    @Test
    public void removeHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", 123456);
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", 654321);
        
        HotelDAO hoteDAOManager = new HotelDAOImpl();
        hoteDAOManager.persistHotel(hotel);
        hoteDAOManager.persistHotel(hotel2);
        
        hoteDAOManager.removeHotel(hotel);
        
        assertEquals("Entity: " + hotel.toString() + 
                "was not correctly removed from DB", hoteDAOManager.getAllHotels().size(), 1);
        
        Hotel hotelDB = hoteDAOManager.getHotelById(hotel2.getId());
        
        assertEquals("Entity: " + hotel2.toString() +
                "was disturbed while removing entity: " + hotel.toString(), hotel2, hotelDB);
        
        hoteDAOManager.removeHotel(hotel2);
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
