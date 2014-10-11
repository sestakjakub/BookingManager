/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.impl.RoomDAOImpl;
import bookingmanager.entity.Hotel;
import bookingmanager.entity.Room;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void persistRoomTest()
    {
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        
        Room room2 = roomEntityManager.getRoomById(room.getId());
        
        assertEquals("Persisted entity: " + room.toString() + "does not equal to entity extracted from DB: " +
                room2.toString(), room, room2);
    
    }
    
    @Test
    public void getAllRoomsTest(){
        
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        Room room2 = new Room(2, 12, new Hotel(), 2, 200);
        Room room3 = new Room(3, 13, new Hotel(), 3, 300);
        
        List<Room> rooms = Arrays.asList(room, room2, room3);
        
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        roomEntityManager.persistRoom(room2);
        roomEntityManager.persistRoom(room3);
        
        List<Room> roomsExtracted = roomEntityManager.getAllRooms();
        
        Collections.sort(rooms, idComparator);
        Collections.sort(roomsExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", rooms.size(), roomsExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", rooms, roomsExtracted);
        
    }
    
    @Test
    public void findRoomByIdTest(){
        // the same as PersistRoomTest?
    }
    
    @Test
    public void mergeRoomTest()
    {
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        
        room.setCapacity(10);
        
        Room roomManaged = roomEntityManager.merge(room);
        
        Room room2 = roomEntityManager.getRoomById(room.getId());
        assertEquals("Merged entity: " + room.toString() + "does not equal to entity extracted from DB: " +
                room2.toString(), room, room2);
        
        roomManaged.setCapacity(12);
        
        room2 = roomEntityManager.getRoomById(roomManaged.getId());
        assertEquals("Managed entity: " + roomManaged.toString() + "does not equal to entity extracted from DB: " +
                room2.toString(), roomManaged, room2);
               
    }
    
    @Test
    public void updateRoomTest()
    {
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        Room room2 = new Room(2, 12, new Hotel(), 2, 200);
        
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        roomEntityManager.persistRoom(room2);
        
        room.setCapacity(10);
        room.setPrice(200);
        room.setRoomNumber(12);
        
        Room roomDB = roomEntityManager.getRoomById(room.getId());
                
        assertEquals("Entity: " + room + "was not correctly updated in DB, actual entity: " + 
                roomDB, room, roomDB);
        
        Room roomDB2 = roomEntityManager.getRoomById(room2.getId());
        
        assertEquals("Entity: " + room2 + "was disturbed in DB while updating entity: " +
                room, room2, roomDB2);
        
    }
    
    @Test
    public void removeRoomTest()
    {
        Room room = new Room(1, 11, new Hotel(), 1, 100);
        Room room2 = new Room(2, 12, new Hotel(), 2, 200);
        
        RoomDAOImpl roomEntityManager = new RoomDAOImpl();
        roomEntityManager.persistRoom(room);
        roomEntityManager.persistRoom(room2);
        
        roomEntityManager.remove(room);
        
        assertEquals("Entity: " + room.toString() + 
                "was not correctly removed from DB", roomEntityManager.getAllRooms().size(), 1);
        
        Room roomDB = roomEntityManager.getRoomById(room2.getId());
        
        assertEquals("Entity: " + room2.toString() +
                "was disturbed while removing entity: " + room.toString(), room2, roomDB);
    }
    
    
    
    private static Comparator<Room> idComparator = new Comparator<Room>() {
        @Override
        public int compare(Room r1, Room r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
}
