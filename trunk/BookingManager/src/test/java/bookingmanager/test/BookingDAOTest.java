/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.impl.BookingDAOImpl;
import bookingmanager.db.impl.CustomerDAOImpl;
import bookingmanager.db.impl.RoomDAOImpl;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Customer;
import bookingmanager.entity.Hotel;
import bookingmanager.entity.Room;
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
        Customer customer = new Customer();
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        
        
        Booking booking = createBooking(customer, room);
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        
        Booking booking2 = bookingEntityManager.getBookingById(booking.getId());
        
        assertEquals("Persisted entity: " + booking.toString() + "does not equal to entity extracted from DB: " +
                booking2.toString(), booking, booking2);
        
        Customer customer2 = customerEntityManager.getCustomerById(customer.getId());
        Room room2 = roomEntityManager.getRoomById(room.getId());        
        
        assertTrue("Entity: " + customer2.toString() + "does not contain mapping for entity:" +
                booking.toString(), customer2.getBookings().contains(booking)); 
        
        assertTrue("Entity: " + room2.toString() + "does not contain mapping for entity:" +
                booking.toString(), room2.getBookings().contains(booking));   
        // TODO: must unite approach for getting Booking from Customer and Room
    }
    
    @Test
    public void getAllBookingsTest(){
        
        Booking booking = createBooking(new Customer(), new Room());
        Booking booking2 = createBooking(new Customer(), new Room());
        Booking booking3 = createBooking(new Customer(), new Room());
        
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
        Booking booking = createBooking(new Customer(), new Room());
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        
        Room room = new Room();
        booking.setRoom(room);
        
        Booking bookingManaged = bookingEntityManager.mergeBooking(booking);
        
        Booking booking2 = bookingEntityManager.getBookingById(booking.getId());
        assertEquals("Merged entity: " + booking.toString() + "does not equal to entity extracted from DB: " +
                booking2.toString(), booking, booking2);
        Room room2 = new Room();
        bookingManaged.setRoom(room2);
        
        booking2 = bookingEntityManager.getBookingById(bookingManaged.getId());
        assertEquals("Managed entity: " + bookingManaged.toString() + "does not equal to entity extracted from DB: " +
                booking2.toString(), bookingManaged, booking2);
               
    }
    
    @Test
    public void updateBookingTest()
    {
        Customer customer = new Customer();
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        
        
        Booking booking = new Booking();
        Booking booking2 = createBooking(new Customer(), new Room());
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);
        
        Customer customer2 = new Customer();
        booking.setCustomer(customer2);
        
        Booking bookingDB = bookingEntityManager.getBookingById(booking.getId());
                
        assertEquals("Entity: " + booking + "was not correctly updated in DB, actual entity: " + 
                bookingDB, booking, bookingDB);
        
        Booking bookingDB2 = bookingEntityManager.getBookingById(booking2.getId());
        
        assertEquals("Entity: " + booking2 + "was disturbed in DB while updating entity: " +
                booking, booking2, bookingDB2);
        
        assertTrue("Entity: " + customer.toString() + "contains not correctly updated version of entity: " +
                booking.toString(), customer.getBookings().contains(booking));
        
        assertTrue("Entity: " + room.toString() + "contains not correctly updated version of entity: " +
                booking.toString(), room.getBookings().contains(booking));
                
    }
    
    @Test
    public void removeBookingTest()
    {
        Customer customer = new Customer();
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        
        
        Booking booking = createBooking(customer, room);
        Booking booking2 = createBooking(new Customer(), new Room());
        
        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);
        
        bookingEntityManager.removeBooking(booking);
        
        assertEquals("Entity: " + booking.toString() + 
                "was not correctly removed from DB", bookingEntityManager.getAllBookings().size(), 1);
        
        Booking bookingDB = bookingEntityManager.getBookingById(booking2.getId());
        
        assertEquals("Entity: " + booking2.toString() +
                "was disturbed while removing entity: " + booking.toString(), booking2, bookingDB);
        
        assertFalse("Entity: " + booking.toString() + "was not correctly removed from entity: " +
                customer.toString(), customer.getBookings().contains(booking));
        
        assertFalse("Entity: " + booking.toString() + "was not correctly removed from entity: " +
                room.toString(), room.getBookings().contains(booking));
          
    }
    
    
    
    private static Comparator<Booking> idComparator = new Comparator<Booking>() {
        @Override
        public int compare(Booking b1, Booking b2) {
            return Long.valueOf(b1.getId()).compareTo(Long.valueOf(b2.getId()));
        }
    };
    
    private Booking createBooking(Customer customer, Room room){
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);
        
        return booking;
    }
}
