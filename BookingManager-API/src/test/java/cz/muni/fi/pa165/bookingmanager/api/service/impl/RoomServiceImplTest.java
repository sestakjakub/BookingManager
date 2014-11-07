/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.RoomDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.RoomDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Jana
 */
public class RoomServiceImplTest {
    
    public RoomServiceImplTest() {
    }
    
    private RoomDTOConverter roomDTOConverter;
    
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

    
    
}
