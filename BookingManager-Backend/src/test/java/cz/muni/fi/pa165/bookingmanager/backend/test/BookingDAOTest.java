/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.test;

import cz.muni.fi.pa165.bookingmanager.backend.db.BookingDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.CustomerDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.RoomDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
@Transactional
public class BookingDAOTest {

    @Autowired
    private BookingDAO bookingDAO;
    
    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    HotelDAO hotelDAO;
    
    @Autowired
    CustomerDAO customerDAO;
    
    @Test
    @Rollback(true)
    public void persistBookingTest() {
        Hotel hotel = TestUtils.createHotel("sdad", "dsaf", "dsad");
        hotelDAO.persistHotel(hotel);
        Room room = TestUtils.createRoom(11, 1, 100);
        room.setHotel(hotel);
        roomDAO.persistRoom(room);
        
        Customer customer = TestUtils.createCustomer("Petr Adamek", "Botanicka 68");
        customerDAO.persistCustomer(customer);
        
        Booking booking = TestUtils.createBooking(1000, 3000);

        booking.setCustomer(customer);
        booking.setRoom(room);
        
        bookingDAO.persistBooking(booking);

        Booking booking2 = bookingDAO.getBookingById(booking.getId());

        assertEquals("Persisted entity: " + booking.toString() + "does not equal to entity extracted from DB: "
                + booking2.toString(), booking, booking2);

    }

    @Test
    @Rollback(true)
    public void getAllBookingsTest() {

        Hotel hotel = TestUtils.createHotel("sdad", "dsaf", "dsad");
        hotelDAO.persistHotel(hotel);
        Room room = TestUtils.createRoom(11, 1, 100);
        room.setHotel(hotel);
        roomDAO.persistRoom(room);
        
        Customer customer = TestUtils.createCustomer("Petr Adamek", "Botanicka 68");
        customerDAO.persistCustomer(customer);
        
        
        
        Booking booking = TestUtils.createBooking(1000, 2000);
        Booking booking2 = TestUtils.createBooking(3000, 400);
        Booking booking3 = TestUtils.createBooking(5000, 6000);
        
        booking.setCustomer(customer);
        booking2.setCustomer(customer);
        booking3.setCustomer(customer);
        
        booking.setRoom(room);
        booking2.setRoom(room);
        booking3.setRoom(room);
        
        List<Booking> bookings = Arrays.asList(booking, booking2, booking3);


        bookingDAO.persistBooking(booking);
        bookingDAO.persistBooking(booking2);
        bookingDAO.persistBooking(booking3);

        List<Booking> bookingsExtracted = bookingDAO.getAllBookings();

        Collections.sort(bookings, idComparator);
        Collections.sort(bookingsExtracted, idComparator);

        assertEquals("Number of persisted entities does not match to "
                + "number of entities extracted from DB", bookings.size(), bookingsExtracted.size());

        assertEquals("List of entities extracted from DB does not match to list od entities persisted", bookings, bookingsExtracted);

    }

    @Test
    @Rollback(true)
    public void mergeBookingTest() {
        Hotel hotel = TestUtils.createHotel("sdad", "dsaf", "dsad");
        hotelDAO.persistHotel(hotel);
        Room room = TestUtils.createRoom(11, 1, 100);
        room.setHotel(hotel);
        roomDAO.persistRoom(room);
        
        Customer customer = TestUtils.createCustomer("Petr Adamek", "Botanicka 68");
        customerDAO.persistCustomer(customer);
        
        
        Booking booking = TestUtils.createBooking(2000, 3000);
        
        booking.setCustomer(customer);
        booking.setRoom(room);
        
        bookingDAO.persistBooking(booking);

        Booking bookingManaged = bookingDAO.mergeBooking(booking);
        
        bookingManaged.setDateFrom(1000);

        Booking booking2 = bookingDAO.getBookingById(booking.getId());
        assertEquals("Merged entity: " + booking.toString() + "does not equal to entity extracted from DB: "
                + booking2.toString(), booking, booking2);

        booking2 = bookingDAO.getBookingById(bookingManaged.getId());
        assertEquals("Managed entity: " + bookingManaged.toString() + "does not equal to entity extracted from DB: "
                + booking2.toString(), bookingManaged, booking2);
    }

    @Test
    @Rollback(true)
    public void updateBookingTest() {
        Hotel hotel = TestUtils.createHotel("sdad", "dsaf", "dsad");
        hotelDAO.persistHotel(hotel);
        Room room = TestUtils.createRoom(11, 1, 100);
        room.setHotel(hotel);
        roomDAO.persistRoom(room);
        
        Customer customer = TestUtils.createCustomer("Petr Adamek", "Botanicka 68");
        customerDAO.persistCustomer(customer);

        Booking booking = TestUtils.createBooking(1000, 2000);
        Booking booking2 = TestUtils.createBooking(3000, 4000);

        booking.setCustomer(customer);
        booking2.setCustomer(customer);
        booking.setRoom(room);
        booking2.setRoom(room);
        
        bookingDAO.persistBooking(booking);
        bookingDAO.persistBooking(booking2);

        Booking bookingDB = bookingDAO.getBookingById(booking.getId());

        assertEquals("Entity: " + booking + "was not correctly updated in DB, actual entity: "
                + bookingDB, booking, bookingDB);

        Booking bookingDB2 = bookingDAO.getBookingById(booking2.getId());

        assertEquals("Entity: " + booking2 + "was disturbed in DB while updating entity: "
                + booking, booking2, bookingDB2);

    }

    @Test
    @Rollback(true)
    public void removeBookingTest() {
        
        Hotel hotel = TestUtils.createHotel("sdad", "dsaf", "dsad");
        hotelDAO.persistHotel(hotel);
        Room room = TestUtils.createRoom(11, 1, 100);
        room.setHotel(hotel);
        roomDAO.persistRoom(room);
        
        Customer customer = TestUtils.createCustomer("Petr Adamek", "Botanicka 68");
        customerDAO.persistCustomer(customer);

        Booking booking = TestUtils.createBooking(1000, 2000);
        Booking booking2 = TestUtils.createBooking(3000, 4000);
        
        booking.setCustomer(customer);
        booking2.setCustomer(customer);
        booking.setRoom(room);
        booking2.setRoom(room);

        bookingDAO.persistBooking(booking);
        bookingDAO.persistBooking(booking2);

        bookingDAO.removeBooking(booking);

        assertEquals("Entity: " + booking.toString()
                + "was not correctly removed from DB", bookingDAO.getAllBookings().size(), 1);

        Booking bookingDB = bookingDAO.getBookingById(booking2.getId());

        assertEquals("Entity: " + booking2.toString()
                + "was disturbed while removing entity: " + booking.toString(), booking2, bookingDB);

        bookingDAO.removeBooking(booking2);
    }
    
    private static Comparator<Booking> idComparator = new Comparator<Booking>() {
        @Override
        public int compare(Booking b1, Booking b2) {
            return Long.valueOf(b1.getId()).compareTo(Long.valueOf(b2.getId()));
        }
    };
}
