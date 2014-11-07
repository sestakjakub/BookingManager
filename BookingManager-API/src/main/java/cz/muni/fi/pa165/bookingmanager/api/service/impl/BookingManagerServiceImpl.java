/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.BookingDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.converter.CustomerDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.converter.HotelDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.converter.RoomDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingManagerService;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingService;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import cz.muni.fi.pa165.bookingmanager.backend.db.BookingDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.CustomerDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.db.RoomDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robert, Jiří Kareš
 */
@Service
public class BookingManagerServiceImpl implements BookingManagerService {

    @Autowired
    private HotelDAO hotelDAO;
    @Autowired
    private RoomDAO roomDAO;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    private RoomDTOConverter roomDTOConverter = new RoomDTOConverter();
    @Autowired
    private CustomerDTOConverter customerDTOConverter = new CustomerDTOConverter();
    @Autowired
    private BookingDTOConverter bookingDTOConverter = new BookingDTOConverter();
    @Autowired
    private HotelDTOConverter hotelDTOConverter = new HotelDTOConverter();
    @Autowired
    private RoomServiceImpl roomService;

    public BookingManagerServiceImpl() {
    }

    @Override
    public void reserveRoomToCustomer(RoomDTO room, CustomerDTO customer, Date from, Date to) {

        if (to.before(from)) {
            throw new IllegalArgumentException("Date from is after date to");
        }

        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }

        if (room == null) {
            throw new IllegalArgumentException("Room is null");
        }
        
        roomService = new RoomServiceImpl();
        if (!roomService.isAvailable(from, to, room)){
            throw new IllegalArgumentException("Room is not available");
        }

        BookingDTO booking = new BookingDTO();
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setDateFrom(from);
        booking.setDateTo(to);

        room.addBooking(booking);
        customer.addBooking(booking);

        roomDAO.mergeRoom(roomDTOConverter.dtoToEntity(room));
        customerDAO.mergeCustomer(customerDTOConverter.dtoToEntity(customer));
        bookingDAO.persistBooking(bookingDTOConverter.dtoToEntity(booking));
    }

    @Override
    public List<RoomDTO> getAvailableRoomsOfHotelByDates(HotelDTO hotel, Date from, Date to) {
        if (hotel == null){
            throw new IllegalArgumentException("Hotel is null");
        }
        
        List<RoomDTO> roomList = hotel.getRooms();
        List<RoomDTO> availableRoomList = new ArrayList<>();
        
        for (RoomDTO room: roomList){
            if (roomService.isAvailable(from, to, room)){
            availableRoomList.add(room);
            }
        }
        
        return availableRoomList;
    }

    @Override
    public List<BookingDTO> getReservationsOfHotelByDates(HotelDTO hotel, Date from, Date to) {
        
        if (hotel == null){
            throw new IllegalArgumentException("Hotel is null");
        }
        
        if (from.after(to)){
            throw new IllegalArgumentException("From date is after to");
        }
        
        List<RoomDTO> rooms = hotel.getRooms();
        
        List<BookingDTO> bookings = new ArrayList();

        for (RoomDTO room : rooms) {
            for (BookingDTO booking : room.getBookings()) {
                if (!roomService.isAvailable(from, to, room)){
                    bookings.add(booking);
                }
            }
        }

        return bookings;
    }
}
