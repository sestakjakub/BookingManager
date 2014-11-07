/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.RoomDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.BookingDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.CustomerDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.RoomDAOImpl;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

/**
 *
 * @author Jana
 */
public class RoomServiceImplTest {
    
    public RoomServiceImplTest() {
    }
    
    private RoomDTOConverter roomDTOConverter;
    
    @InjectMocks
    private CustomerServiceImpl customerService;
    @InjectMocks
    private HotelServiceImpl hotelService;
    @InjectMocks
    private BookingManagerServiceImpl bookingManagerService;
        
    @Mock
    private CustomerDAOImpl customerDAO;
    @Mock
    private BookingDAOImpl bookingDAO;
    
    @InjectMocks
    private RoomServiceImpl service;
    
    @Mock
    private RoomDAOImpl roomDAO;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roomDTOConverter = new RoomDTOConverter();
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of addRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testAddRoom() {
        System.out.println("addRoom");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        
        service.addRoom(roomDTO);
        
        verify(roomDAO, Mockito.times(1)).persistRoom(roomDTOConverter.dtoToEntity(roomDTO));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddRoomAsNull() {
        System.out.println("addRoomAsNull");
        
        RoomDTO roomDTO = null;
        
        service.addRoom(roomDTO);
        
        verifyZeroInteractions(roomDTO);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddRoomWithNegativeCapacity() {
        System.out.println("addRoomWithNegativeCapacity");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        roomDTO.setCapacity(-2);
        
        service.addRoom(roomDTO);
        
        verifyZeroInteractions(roomDTO);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddRoomWithNegativeNumber() {
        System.out.println("addRoomWithNegativeNumber");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        roomDTO.setRoomNumber(-22);
        
        service.addRoom(roomDTO);
        
        verifyZeroInteractions(roomDTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRoomWithNegativePrice() {
        System.out.println("addRoomWithNegativePrice");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        roomDTO.setCapacity(-2);
        
        service.addRoom(roomDTO);
        
        verifyZeroInteractions(roomDTO);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddRoomWithNullHotel() {
        System.out.println("addRoomWithNullHotel");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        roomDTO.setCapacity(-2);
        
        service.addRoom(roomDTO);
        
        verifyZeroInteractions(roomDTO);
    }
    
    /**
     * Test of deleteRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testDeleteRoom() {
        System.out.println("deleteRoom");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        
        service.addRoom(roomDTO);
        service.deleteRoom(roomDTO);
        
        verify(roomDAO, Mockito.times(1)).removeRoom(roomDTOConverter.dtoToEntity(roomDTO));
    }

    /**
     * Test of updateRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testUpdateRoom() {
        System.out.println("updateRoom");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        
        service.addRoom(roomDTO);
        service.updateRoom(roomDTO);
        
        verify(roomDAO, Mockito.times(1)).mergeRoom(roomDTOConverter.dtoToEntity(roomDTO));
    }
    
    @Test
    public void testIsRoomAvailable() {
        System.out.println("updateRoom");
        
        RoomDTO roomDTO = TestUtils.newRoomDTO();
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
                       
        service.addRoom(roomDTO);
        customerService.addCustomer(customerDTO);
        
        bookingManagerService.reserveRoomToCustomer(roomDTO, customerDTO, new Date(2013,1,1), new Date(2013,3,1));
        bookingManagerService.reserveRoomToCustomer(roomDTO, customerDTO, new Date(2013,5,1), new Date(2013,7,1));
//        
//        assertFalse(service.isAvailable(new Date(2013,2,1), new Date(2013,4,1), roomDTO));
//        assertFalse(service.isAvailable(new Date(2013,2,1), new Date(2013,6,1), roomDTO));
//        assertFalse(service.isAvailable(new Date(2013,4,1), new Date(2013,6,1), roomDTO));
//        assertFalse(service.isAvailable(new Date(2013,1,1), new Date(2013,8,1), roomDTO));
//        assertFalse(service.isAvailable(new Date(2013,2,1), new Date(2013,2,12), roomDTO));
//        
        
        assertTrue(service.isAvailable(new Date(2013,4,1), new Date(2013,4,12), roomDTO));
        assertTrue(service.isAvailable(new Date(2013,8,1), new Date(2013,8,12), roomDTO));
    }

    
    
}
