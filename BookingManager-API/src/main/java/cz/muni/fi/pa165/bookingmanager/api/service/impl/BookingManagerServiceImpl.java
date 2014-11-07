/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingManagerService;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingService;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert, Jiří Kareš
 */
public class BookingManagerServiceImpl implements BookingManagerService {

    private BookingService bookingService;
    private RoomService roomService;
    private HotelService hotelService;
    private CustomerService customerService;

    public BookingManagerServiceImpl() {
        bookingService = new BookingServiceImpl();
        roomService = new RoomServiceImpl();
        hotelService = new HotelServiceImpl();
        customerService = new CustomerServiceImpl();
    }

    @Override
    public void reserveRoomToCustomer(RoomDTO room, CustomerDTO customer) {
        BookingDTO booking = new BookingDTO();
        booking.setCustomer(customer);
        room.addBooking(booking);
        customer.addBooking(booking);

        roomService.updateRoom(room);
        customerService.updateCustomer(customer);
        bookingService.addBooking(booking);
    }

    @Override
    public List<RoomDTO> getAvailableRoomsOfHotel(HotelDTO hotel) {
        //TODO: date from, date to as params
        return null;
    }

    @Override
    public List<BookingDTO> getReservationsOfHotel(HotelDTO hotel) {
        List<RoomDTO> rooms = hotel.getRooms();
        List<BookingDTO> bookings = new ArrayList();

        for (RoomDTO room : rooms) {
            for (BookingDTO booking : room.getBookings()) {
                bookings.add(booking);
            }
        }
        
        return bookings;
    }
}
