/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.db;

import bookingmanager.entity.Booking;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface BookingDAO{
    /**
     * Persists booking
     * 
     * @param booking 
     */
    public void persistBooking(Booking booking);
    
    /**
     * Gets booking entity by id.
     * 
     * @param id id of booking entity to be returned.
     * @return booking entity with given id.
     */
    public Booking getBookingById(long id);
    
    /**
     * Merges booking.
     * 
     * @param booking customer entity to be merged.
     * @return merged customer entity.
     */
    public Booking mergeBooking(Booking booking);
    
    /**
     * Removes booking.
     * 
     * @param booking booking to be removed.
     */
    public void removeBooking(Booking booking);
    
    /**
     * Returns list of all bookings.
     * 
     * @return list of all bookings.
     */
    public List<Booking> getAllBookings();
}
