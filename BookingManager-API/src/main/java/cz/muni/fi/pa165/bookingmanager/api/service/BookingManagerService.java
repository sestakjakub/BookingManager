/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface BookingManagerService {
    
    void reserveRoomToCustomer(RoomDTO room, CustomerDTO customer, long from, long to);
    
    List<RoomDTO> getAvailableRoomsOfHotelByDates(HotelDTO hotel, long from, long to);
    
    List<BookingDTO> getReservationsOfHotelByDates(HotelDTO hotel, long from, long to);
    
}
