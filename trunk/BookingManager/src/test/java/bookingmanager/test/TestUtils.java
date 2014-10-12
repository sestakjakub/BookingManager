/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.entity.Booking;
import bookingmanager.entity.Customer;
import bookingmanager.entity.Hotel;
import bookingmanager.entity.Room;
import java.util.Date;

/**
 *
 * @author Robert
 */
public class TestUtils {
    
    public static Room createRoom(int roomNumber, int capacity, int price){
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setCapacity(capacity);
        room.setPrice(price);
        return room;
    }
    
    public static Booking createBooking(Date dateFrom, Date dateTo){
        Booking booking = new Booking();
        booking.setDateFrom(dateFrom);
        booking.setDateTo(dateTo);
        return booking;
    }
    
    public static Hotel createHotel(String name, String address, int phone){
        Hotel hotel = new Hotel();
        hotel.setAddress(address);
        hotel.setName(name);
        hotel.setPhoneNumber(phone);
        return hotel;
    }
    
    public static Customer createCustomer(String name, String address){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        return customer;
    }

}
