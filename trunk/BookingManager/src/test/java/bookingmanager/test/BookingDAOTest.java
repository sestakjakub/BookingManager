/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.impl.BookingDAOImpl;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Booking;
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
public class BookingDAOTest {
    
    public BookingDAOTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void persistBookingTest()
    {
        Booking booking = new Booking(1,);
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        
        Booking booking2 = bookingEntityManager.getBookingById(booking.getId());
        
        assertEquals("Persisted entity: " + booking.toString() + "does not equal to entity extracted from DB: " +
                booking2.toString(), booking, booking2);
    
    }
    
    @Test
    public void getAllBookingsTest(){
        
        Booking booking = new Booking(1, "Ritz", "Ukrajinska 4", 123456);
        Booking booking2 = new Booking(2, "Hilton", "Rumunska 5", 654321);
        Booking booking3 = new Booking(3, "HolidayInn", "Botanicka 6", 134652);
        
        List<Booking> bookings = Arrays.asList(booking, booking2, booking3);
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);
        bookingEntityManager.persistBooking(booking3);
        
        List<Booking> bookingsExtracted = bookingEntityManager.getAllBookings();
        
        Collections.sort(bookings, idComparator);
        Collections.sort(bookingsExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", bookings.size(), bookingsExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", bookings, bookingsExtracted);
        
    }
    
    @Test
    public void findBookingByIdTest(){
        // the same as PersistBookingTest?
    }
    
    @Test
    public void mergeBookingTest()
    {
        Booking booking = new Booking(1, "Ritz", "Ukrajinska 4", 123456);
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        
        booking.setAddress("Manesova 12");
        
        Booking bookingManaged = bookingEntityManager.mergeBooking(booking);
        
        Booking booking2 = bookingEntityManager.getBookingById(booking.getId());
        assertEquals("Merged entity: " + booking.toString() + "does not equal to entity extracted from DB: " +
                booking2.toString(), booking, booking2);
        
        bookingManaged.setAddress("Malinovskeho namesti");
        
        booking2 = bookingEntityManager.getBookingById(bookingManaged.getId());
        assertEquals("Managed entity: " + bookingManaged.toString() + "does not equal to entity extracted from DB: " +
                booking2.toString(), bookingManaged, booking2);
               
    }
    
    @Test
    public void updateBookingTest()
    {
        Booking booking = new Booking(1, "Ritz", "Ukrajinska 4", 123456);
        Booking booking2 = new Booking(2, "Hilton", "Rumunska 5", 654321);
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);
        
        booking.setName("Martin Kuba");
        booking.setAddress("Kotlarska 45");
        
        Booking bookingDB = bookingEntityManager.getBookingById(booking.getId());
                
        assertEquals("Entity: " + booking + "was not correctly updated in DB, actual entity: " + 
                bookingDB, booking, bookingDB);
        
        Booking bookingDB2 = bookingEntityManager.getBookingById(booking2.getId());
        
        assertEquals("Entity: " + booking2 + "was disturbed in DB while updating entity: " +
                booking, booking2, bookingDB2);
        
    }
    
    @Test
    public void removeBookingTest()
    {
        Booking booking = new Booking(1, "Ritz", "Ukrajinska 4", 123456);
        Booking booking2 = new Booking(2, "Hilton", "Rumunska 5", 654321);
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);
        
        bookingEntityManager.removeBooking(booking);
        
        assertEquals("Entity: " + booking.toString() + 
                "was not correctly removed from DB", bookingEntityManager.getAllBookings().size(), 1);
        
        Booking bookingDB = bookingEntityManager.getBookingById(booking2.getId());
        
        assertEquals("Entity: " + booking2.toString() +
                "was disturbed while removing entity: " + booking.toString(), booking2, bookingDB);
    }
    
    
    
    private static Comparator<Booking> idComparator = new Comparator<Booking>() {
        @Override
        public int compare(Booking r1, Booking r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
}
