/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.HotelDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.HotelDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


/**
 *
 * @author Jana
 */
public class HotelServiceImplTest {
//    
//    private HotelDTOConverter hotelDTOconverter;
//    
//    public HotelServiceImplTest() {
//        
//    }
//    
//    @InjectMocks
//    private HotelServiceImpl service;
//    
//    @Mock
//    private HotelDAOImpl hotelDAO;
//    
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        hotelDTOconverter = new HotelDTOConverter();
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addHotel method, of class HotelServiceImpl.
//     */
//    @Test
//    public void testAddHotel() {
//        System.out.println("addHotel");
//        
//        HotelDTO hotelDTO = TestUtils.newHotelDTO();
//        
//        service.addHotel(hotelDTO);
//        
//        verify(hotelDAO, Mockito.times(1)).persistHotel(hotelDTOconverter.dtoToEntity(hotelDTO));
//        
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddHotelAsNull() {
//        System.out.println("addHotelAsNull");
//        
//        HotelDTO hotelDTO = null;
//        
//        service.addHotel(hotelDTO);
//        
//        verifyZeroInteractions(hotelDAO);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddHotelWithNullName() {
//        System.out.println("addHotelWithNullName");
//        
//        HotelDTO hotelDTO = TestUtils.newHotelDTO();
//        hotelDTO.setName(null);
//        
//        service.addHotel(hotelDTO);
//        
//        verifyZeroInteractions(hotelDAO);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddHotelWithNullAddress() {
//        System.out.println("addHotelWithNullAddress");
//        
//        HotelDTO hotelDTO = TestUtils.newHotelDTO();
//        hotelDTO.setAddress(null);
//        
//        service.addHotel(hotelDTO);
//        
//        verifyZeroInteractions(hotelDAO);
//    }
//    
//    /**
//     * Test of deleteHotel method, of class HotelServiceImpl.
//     */
//    @Test
//    public void testDeleteHotel() {
//        System.out.println("deleteHotel");
//        
//        HotelDTO hotelDTO = TestUtils.newHotelDTO();
//        
//        service.addHotel(hotelDTO);
//        service.deleteHotel(hotelDTO);
//        
//        verify(hotelDAO, Mockito.times(1)).removeHotel(hotelDTOconverter.dtoToEntity(hotelDTO));
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testDeleteHotelAsNull() {
//        System.out.println("addHotelAsNull");
//        
//        HotelDTO hotelDTO = null;
//        
//        service.deleteHotel(hotelDTO);
//        
//        verifyZeroInteractions(hotelDAO);
//    }
//
//    /**
//     * Test of getAllHotels method, of class HotelServiceImpl.
//     */
//    @Test
//    public void testGetAllHotels() {
//        System.out.println("getAllHotels");
//        
//        HotelDTO hotelDTO = TestUtils.newHotelDTO();
//        
//        service.addHotel(hotelDTO);
//        service.getAllHotels();
//        
//        verify(hotelDAO, Mockito.times(1)).getAllHotels();
//    }
//    
//    
}
