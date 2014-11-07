/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jiří Kareš
 */
public class HotelDTOConverterTest {
    private HotelDTOConverter converter;
    
    public HotelDTOConverterTest() {
        converter = new HotelDTOConverter();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of entityToDto method, of class HotelDTOConverter.
     */
    @org.junit.Test
    public void testEntityToDto() {
        System.out.println("entityToDto");
        
        Hotel hotel = new Hotel();
        hotel.setId(1991);
        
        List<Room> rooms = new ArrayList();
        Room room1 = new Room();
        Room room2 = new Room();
        room1.setHotel(hotel);
        room2.setHotel(hotel);
        rooms.add(room1);
        rooms.add(room2);
        hotel.setRooms(rooms);
        
        HotelDTO dto = converter.entityToDto(hotel);
        
        
        assertEquals(hotel.getId(), dto.getId());
        assertEquals(hotel.getRooms().size(), dto.getRooms().size());
        assertEquals(hotel.getRooms().get(0).getHotel().getId(), dto.getRooms().get(0).getHotel().getId());
        System.out.println("Testuju ID hotelu: " + hotel.getRooms().get(0).getHotel().getId());
    }

    /**
     * Test of dtoToEntity method, of class HotelDTOConverter.
     */
    @org.junit.Test
    public void testDtoToEntity() {
        System.out.println("dtoToEntity");
        HotelDTO dto = new HotelDTO();
        dto.setId(1991);
        List<RoomDTO> rooms = new ArrayList();
        rooms.add(new RoomDTO());
        dto.setRooms(rooms);
        
        Hotel entity = converter.dtoToEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getRooms().size(), entity.getRooms().size());
    }
}