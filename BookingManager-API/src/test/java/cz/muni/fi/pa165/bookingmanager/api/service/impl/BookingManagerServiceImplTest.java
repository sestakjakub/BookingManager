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

/**
 *
 * @author Jana
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
        
        bookingManagerService.reserveRoomToCustomer(roomDTO, customerDTO);
        
        verify(roomDAO, Mockito.times(1)).mergeRoom(roomDTOConverter.dtoToEntity(roomDTO));
        verify(customerDAO, Mockito.times(1)).mergeCustomer(customerDTOConverter.dtoToEntity(customerDTO));
        verify(bookingDAO, Mockito.times(1)).persistBooking(Mockito.any(Booking.class));
        
    }

    /**
     * Test of getAvailableRoomsOfHotel method, of class BookingManagerServiceImpl.
     */
    @Test
    public void testGetAvailableRoomsOfHotel() {
        
    }

    /**
     * Test of getReservationsOfHotel method, of class BookingManagerServiceImpl.
     */
    @Test
    public void testGetReservationsOfHotel() {
        
    }
    
}
