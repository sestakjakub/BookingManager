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
import java.util.Date;
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
    public void persistBookingTest() {
        Booking booking = TestUtils.createBooking(new Date(2014, 10, 14), new Date(2014, 10, 15));

        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);

        Booking booking2 = bookingEntityManager.getBookingById(booking.getId());

        assertEquals("Persisted entity: " + booking.toString() + "does not equal to entity extracted from DB: "
                + booking2.toString(), booking, booking2);

        bookingEntityManager.removeBooking(booking2);
    }

    @Test
    public void getAllBookingsTest() {

        Booking booking = TestUtils.createBooking(new Date(2014, 10, 14), new Date(2014, 10, 15));
        Booking booking2 = TestUtils.createBooking(new Date(2014, 10, 15), new Date(2014, 10, 16));
        Booking booking3 = TestUtils.createBooking(new Date(2014, 10, 6), new Date(2014, 10, 7));

        List<Booking> bookings = Arrays.asList(booking, booking2, booking3);

        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);
        bookingEntityManager.persistBooking(booking3);

        List<Booking> bookingsExtracted = bookingEntityManager.getAllBookings();

        Collections.sort(bookings, idComparator);
        Collections.sort(bookingsExtracted, idComparator);

        assertEquals("Number of persisted entities does not match to "
                + "number of entities extracted from DB", bookings.size(), bookingsExtracted.size());

        assertEquals("List of entities extracted from DB does not match to list od entities persisted", bookings, bookingsExtracted);

        bookingEntityManager.removeBooking(booking);
        bookingEntityManager.removeBooking(booking2);
        bookingEntityManager.removeBooking(booking3);

    }

    @Test
    public void mergeBookingTest() {
        Booking booking = TestUtils.createBooking(new Date(2014, 10, 14), new Date(2014, 10, 15));

        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);

        Booking bookingManaged = bookingEntityManager.mergeBooking(booking);
        
        bookingManaged.setDateFrom(new Date(2014, 10, 12));

        Booking booking2 = bookingEntityManager.getBookingById(booking.getId());
        assertEquals("Merged entity: " + booking.toString() + "does not equal to entity extracted from DB: "
                + booking2.toString(), booking, booking2);

        booking2 = bookingEntityManager.getBookingById(bookingManaged.getId());
        assertEquals("Managed entity: " + bookingManaged.toString() + "does not equal to entity extracted from DB: "
                + booking2.toString(), bookingManaged, booking2);
        bookingEntityManager.removeBooking(booking2);
    }

    @Test
    public void updateBookingTest() {

        Booking booking = TestUtils.createBooking(new Date(2013, 10, 14), new Date(2014, 10, 14));
        Booking booking2 = TestUtils.createBooking(new Date(2014, 10, 14), new Date(2014, 10, 15));

        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);

        Booking bookingDB = bookingEntityManager.getBookingById(booking.getId());

        assertEquals("Entity: " + booking + "was not correctly updated in DB, actual entity: "
                + bookingDB, booking, bookingDB);

        Booking bookingDB2 = bookingEntityManager.getBookingById(booking2.getId());

        assertEquals("Entity: " + booking2 + "was disturbed in DB while updating entity: "
                + booking, booking2, bookingDB2);

        bookingEntityManager.removeBooking(booking);
        bookingEntityManager.removeBooking(booking2);
    }

    @Test
    public void removeBookingTest() {

        Booking booking = TestUtils.createBooking(new Date(2014, 10, 14), new Date(2014, 10, 15));
        Booking booking2 = TestUtils.createBooking(new Date(2014, 10, 14), new Date(2014, 10, 15));

        BookingDAOImpl bookingEntityManager = new BookingDAOImpl();
        bookingEntityManager.persistBooking(booking);
        bookingEntityManager.persistBooking(booking2);

        bookingEntityManager.removeBooking(booking);

        assertEquals("Entity: " + booking.toString()
                + "was not correctly removed from DB", bookingEntityManager.getAllBookings().size(), 1);

        Booking bookingDB = bookingEntityManager.getBookingById(booking2.getId());

        assertEquals("Entity: " + booking2.toString()
                + "was disturbed while removing entity: " + booking.toString(), booking2, bookingDB);

        bookingEntityManager.removeBooking(booking2);
    }
    
    private static Comparator<Booking> idComparator = new Comparator<Booking>() {
        @Override
        public int compare(Booking b1, Booking b2) {
            return Long.valueOf(b1.getId()).compareTo(Long.valueOf(b2.getId()));
        }
    };
}
