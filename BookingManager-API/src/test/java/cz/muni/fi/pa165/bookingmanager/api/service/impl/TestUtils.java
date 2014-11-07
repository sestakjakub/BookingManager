/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jana
 */
public class TestUtils {
    
    public static RoomDTO newRoomDTO(){
        RoomDTO room = new RoomDTO();
        room.setCapacity(2);
        room.setPrice(1222);
        room.setHotel(new HotelDTO());
        room.setRoomNumber(45);
        
        List<BookingDTO> bookings = Arrays.asList(new BookingDTO());
        room.setBookings(bookings);
                
        return room;        
    }
    
    
    public static HotelDTO newHotelDTO(){
        HotelDTO hotel = new HotelDTO();
        hotel.setAddress("Botanicka 14");
        hotel.setName("Modra ustrica");
        hotel.setPhoneNumber(123456);
        
        List<RoomDTO> rooms = Arrays.asList(new RoomDTO());
        hotel.setRooms(rooms);
        
        return hotel;
    }
    
    
    public static CustomerDTO newCustomerDTO(){
        CustomerDTO customer = new CustomerDTO();
        
        customer.setName("Tomas Pittner");
        customer.setAddress("Ucitelska 12");
        
        List<BookingDTO> bookings = Arrays.asList(new BookingDTO());
        customer.setBookings(bookings);
        
        return customer;
    }
    
    // to be deleted
    public static BookingDTO newBookingDTO(CustomerDTO customer, RoomDTO room, Date from, Date to){
        BookingDTO booking = new BookingDTO();
        
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setDateFrom(from);
        booking.setDateTo(to);
        
        return booking;
    }
}
