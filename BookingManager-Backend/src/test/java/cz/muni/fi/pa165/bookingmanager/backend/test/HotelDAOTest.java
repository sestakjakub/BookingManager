/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.test;

import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Jana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HotelDAOTest {
        
    @Autowired
    private HotelDAO hotelDAO;
    
    @Test
    public void persistHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", "123456");
        
        hotelDAO.persistHotel(hotel);
        
        Hotel hotel2 = hotelDAO.getHotelById(hotel.getId());
        
        assertEquals("Persisted entity: " + hotel.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotel, hotel2);
        
        hotelDAO.removeHotel(hotel);
    }
    
    @Test
    public void getAllHotelsTest(){
        
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", "123456");
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", "654321");
        Hotel hotel3 = createHotel("HolidayInn", "Botanicka 6", "134652");
        
        List<Hotel> hotels = Arrays.asList(hotel, hotel2, hotel3);
        
        hotelDAO.persistHotel(hotel);
        hotelDAO.persistHotel(hotel2);
        hotelDAO.persistHotel(hotel3);
        
        List<Hotel> hotelsExtracted = hotelDAO.getAllHotels();
        
        Collections.sort(hotels, idComparator);
        Collections.sort(hotelsExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", hotels.size(), hotelsExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", hotels, hotelsExtracted);
        
        hotelDAO.removeHotel(hotel);
        hotelDAO.removeHotel(hotel2);
        hotelDAO.removeHotel(hotel3);
    }
    
    @Test
    public void mergeHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", "123456");
        
        hotelDAO.persistHotel(hotel);
        
        hotel.setAddress("Manesova 12");
        
        Hotel hotelManaged = hotelDAO.mergeHotel(hotel);
        
        Hotel hotel2 = hotelDAO.getHotelById(hotel.getId());
        assertEquals("Merged entity: " + hotel.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotel, hotel2);
        
        hotelManaged.setAddress("Malinovskeho namesti");
        
        hotel2 = hotelDAO.getHotelById(hotelManaged.getId());
        assertEquals("Managed entity: " + hotelManaged.toString() + "does not equal to entity extracted from DB: " +
                hotel2.toString(), hotelManaged, hotel2);
        
        hotelDAO.removeHotel(hotel);
    }
    
    @Test
    public void updateHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", "123456");
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", "654321");
        
        hotelDAO.persistHotel(hotel);
        hotelDAO.persistHotel(hotel2);
        
        hotel.setName("Martin Kuba");
        hotel.setAddress("Kotlarska 45");
        
        Hotel hotelDB = hotelDAO.getHotelById(hotel.getId());
                
        assertEquals("Entity: " + hotel + "was not correctly updated in DB, actual entity: " + 
                hotelDB, hotel, hotelDB);
        
        Hotel hotelDB2 = hotelDAO.getHotelById(hotel2.getId());
        
        assertEquals("Entity: " + hotel2 + "was disturbed in DB while updating entity: " +
                hotel, hotel2, hotelDB2);
        
        hotelDAO.removeHotel(hotel);
        hotelDAO.removeHotel(hotel2);
    }
    
    @Test
    public void removeHotelTest()
    {
        Hotel hotel = createHotel("Ritz", "Ukrajinska 4", "123456");
        Hotel hotel2 = createHotel("Hilton", "Rumunska 5", "654321");
        
        hotelDAO.persistHotel(hotel);
        hotelDAO.persistHotel(hotel2);
        
        hotelDAO.removeHotel(hotel);
        
        assertEquals("Entity: " + hotel.toString() + 
                "was not correctly removed from DB", hotelDAO.getAllHotels().size(), 1);
        
        Hotel hotelDB = hotelDAO.getHotelById(hotel2.getId());
        
        assertEquals("Entity: " + hotel2.toString() +
                "was disturbed while removing entity: " + hotel.toString(), hotel2, hotelDB);
        
        hotelDAO.removeHotel(hotel2);
    }
    
    
    
    private static Comparator<Hotel> idComparator = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel r1, Hotel r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
    
    private Hotel createHotel(String name, String address, String phone){
        Hotel hotel = new Hotel();
        hotel.setAddress(address);
        hotel.setName(name);
        hotel.setPhoneNumber(phone);
        
        return hotel;
    }
}
