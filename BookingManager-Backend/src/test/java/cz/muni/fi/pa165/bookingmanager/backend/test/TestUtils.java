/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.test;

import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
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
    
    public static Booking createBooking(long dateFrom, long dateTo){
        Booking booking = new Booking();
        booking.setDateFrom(dateFrom);
        booking.setDateTo(dateTo);
        return booking;
    }
    
    public static Hotel createHotel(String name, String address, String phone){
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
