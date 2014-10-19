/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.RoomDAO;
import bookingmanager.db.impl.RoomDAOImpl;
import bookingmanager.entity.Hotel;
import bookingmanager.entity.Room;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jana
 */
public class RoomDAOTest {
    
    public RoomDAOTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void removeRoomTest()
    {
        Room room = TestUtils.createRoom( 11, 1, 100);
        Room room2 = TestUtils.createRoom(12, 2, 200);
        
        RoomDAO roomDAOManager = new RoomDAOImpl();
        roomDAOManager.persistRoom(room);
        roomDAOManager.persistRoom(room2);
        
        roomDAOManager.removeRoom(room);
        
        assertEquals("Entity: " + room.toString() + 
                "was not correctly removed from DB", roomDAOManager.getAllRooms().size(), 1);
        
        Room roomDB = roomDAOManager.getRoomById(room2.getId());
        
        assertEquals("Entity: " + room2.toString() +
                "was disturbed while removing entity: " + room.toString(), room2, roomDB);
        
        roomDAOManager.removeRoom(room2);
        
    }
    
    @Test
    public void getAllRoomsTest(){
        
        Room room = TestUtils.createRoom(11, 1, 100);
        Room room2 = TestUtils.createRoom(12, 2, 200);
        Room room3 = TestUtils.createRoom(13, 3, 300);
        
        List<Room> rooms = Arrays.asList(room, room2, room3);
        
        RoomDAO roomDAOManager = new RoomDAOImpl();
        roomDAOManager.persistRoom(room);
        roomDAOManager.persistRoom(room2);
        roomDAOManager.persistRoom(room3);
        
        List<Room> roomsExtracted = roomDAOManager.getAllRooms();
        
        Collections.sort(rooms, idComparator);
        Collections.sort(roomsExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", rooms.size(), roomsExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", rooms, roomsExtracted);
        
        
        roomDAOManager.removeRoom(room);
        roomDAOManager.removeRoom(room2);
        roomDAOManager.removeRoom(room3);
    }
    
    @Test
    public void persistRoomTest()
    {
        Room room = TestUtils.createRoom(11, 1, 100);
        
        RoomDAO roomDAOManager = new RoomDAOImpl();
        roomDAOManager.persistRoom(room);
        
        Room room2 = roomDAOManager.getRoomById(room.getId());
        
        assertEquals("Persisted entity: " + room.toString() + "does not equal to entity extracted from DB: " +
                room2.toString(), room, room2);
        
        roomDAOManager.removeRoom(room);
    }
    
    @Test
    public void mergeRoomTest()
    {
        Room room = TestUtils.createRoom(11, 1, 100);
        
        RoomDAO roomDAOManager = new RoomDAOImpl();
        roomDAOManager.persistRoom(room);
        
        room.setCapacity(10);
        
        Room roomManaged = roomDAOManager.mergeRoom(room);
        
        Room room2 = roomDAOManager.getRoomById(room.getId());
        assertEquals("Merged entity: " + room.toString() + "does not equal to entity extracted from DB: " +
                room2.toString(), room, room2);
        
        roomManaged.setCapacity(12);
        
        room2 = roomDAOManager.getRoomById(roomManaged.getId());
        assertEquals("Managed entity: " + roomManaged.toString() + "does not equal to entity extracted from DB: " +
                room2.toString(), roomManaged, room2);
        
        roomDAOManager.removeRoom(roomManaged);
    }
    
    @Test
    public void updateRoomTest()
    {
        Room room = TestUtils.createRoom( 11, 1, 100);
        Room room2 = TestUtils.createRoom(12, 2, 200);
        
        RoomDAO roomDAOManager = new RoomDAOImpl();
        roomDAOManager.persistRoom(room);
        roomDAOManager.persistRoom(room2);
        
        room.setCapacity(10);
        room.setPrice(200);
        room.setRoomNumber(12);
        
        Room roomDB = roomDAOManager.getRoomById(room.getId());
                
        assertEquals("Entity: " + room + "was not correctly updated in DB, actual entity: " + 
                roomDB, room, roomDB);
        
        Room roomDB2 = roomDAOManager.getRoomById(room2.getId());
        
        assertEquals("Entity: " + room2 + "was disturbed in DB while updating entity: " +
                room, room2, roomDB2);
        
        roomDAOManager.removeRoom(roomDB);
        roomDAOManager.removeRoom(roomDB2);
    }
    
    
    
    
    
    private static Comparator<Room> idComparator = new Comparator<Room>() {
        @Override
        public int compare(Room r1, Room r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
    
    private Room createRoom(int roomNumber, Hotel hotel, int capacity, int price){
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setHotel(hotel);
        room.setCapacity(capacity);
        room.setPrice(price);
        
        return room;
        
    }
}
