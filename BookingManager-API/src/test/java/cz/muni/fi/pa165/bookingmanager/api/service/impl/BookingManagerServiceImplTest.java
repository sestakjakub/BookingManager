/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.CustomerDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.converter.RoomDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.BookingDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.CustomerDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.RoomDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Jana, Jiří Kareš
 */
public class BookingManagerServiceImplTest {
    
    public BookingManagerServiceImplTest() {
    }
    
    private RoomDTOConverter roomDTOConverter;
    private CustomerDTOConverter customerDTOConverter;
    
    @InjectMocks
    private RoomServiceImpl roomService;
    @InjectMocks
    private CustomerServiceImpl customerService;
    @InjectMocks
    private HotelServiceImpl hotelService;
    @InjectMocks
    private BookingManagerServiceImpl bookingManagerService;
    
    
    @Mock
    private RoomDAOImpl roomDAO;
    @Mock
    private CustomerDAOImpl customerDAO;
    @Mock
    private BookingDAOImpl bookingDAO;
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roomDTOConverter = new RoomDTOConverter();
        customerDTOConverter = new CustomerDTOConverter();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of reserveRoomToCustomer method, of class BookingManagerServiceImpl.
     */
    @Test
    public void testReserveRoomToCustomer() {
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
        
        bookingManagerService.reserveRoomToCustomer(roomDTO, customerDTO, new Date(2013,1,1),new Date(2013,2,15));
        
        verify(roomDAO, Mockito.times(1)).mergeRoom(roomDTOConverter.dtoToEntity(roomDTO));
        verify(customerDAO, Mockito.times(1)).mergeCustomer(customerDTOConverter.dtoToEntity(customerDTO));
        verify(bookingDAO, Mockito.times(1)).persistBooking(Mockito.any(Booking.class));
        
    }

    /**
     * Test of getAvailableRoomsOfHotel method, of class BookingManagerServiceImpl.
     */
    @Test
    public void testGetAvailableRoomsOfHotelByDates() {
        
        HotelDTO hotel = new HotelDTO();
        hotel.setAddress("Brno");
        hotel.setName("Hotel v Brně");
        hotel.setPhoneNumber("2222");
        hotelService.addHotel(hotel);
        
        CustomerDTO customer = new CustomerDTO();
        customerService.addCustomer(customer);
        
        RoomDTO room = new RoomDTO();
        roomService.addRoom(room);
        
        bookingManagerService.reserveRoomToCustomer(room, customer, new Date(1000), new Date(1100));
        List<RoomDTO> availableRooms = bookingManagerService.getAvailableRoomsOfHotelByDates(hotel, new Date(1000), new Date(1100));
        assertTrue(availableRooms.isEmpty());
    }

    /**
     * Test of getReservationsOfHotelByDates method, of class BookingManagerServiceImpl.
     */
    @Test
    public void testGetReservationsOfHotelByDates() {
        HotelDTO hotel = new HotelDTO();
        CustomerDTO customer = new CustomerDTO();
        RoomDTO room = new RoomDTO();
        List<RoomDTO> rooms = new ArrayList();
        rooms.add(room);
        hotel.setRooms(rooms);
        bookingManagerService.reserveRoomToCustomer(room, customer, new Date(1000), new Date(1100));
        List<BookingDTO> reservedRooms = bookingManagerService.getReservationsOfHotelByDates(hotel, new Date(500), new Date(1200));
        assertFalse(reservedRooms.isEmpty());
    }
}
