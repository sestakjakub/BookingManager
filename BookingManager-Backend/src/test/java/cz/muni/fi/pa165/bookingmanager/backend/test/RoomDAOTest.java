/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.test;

import cz.muni.fi.pa165.bookingmanager.backend.db.RoomDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class RoomDAOTest {
    
    @Autowired
    private RoomDAO roomDAO;
    
    @Test
    @Rollback(true)
    public void removeRoomTest()
    {
//        Room room = TestUtils.createRoom( 11, 1, 100);
//        Room room2 = TestUtils.createRoom(12, 2, 200);
//        
//        roomDAO.persistRoom(room);
//        roomDAO.persistRoom(room2);
//        
//        roomDAO.removeRoom(room);
//        
//        assertEquals("Entity: " + room.toString() + 
//                "was not correctly removed from DB", roomDAO.getAllRooms().size(), 1);
//        
//        Room roomDB = roomDAO.getRoomById(room2.getId());
//        
//        assertEquals("Entity: " + room2.toString() +
//                "was disturbed while removing entity: " + room.toString(), room2, roomDB);
        
    }
    
//    @Test
//    @Rollback(true)
//    public void getAllRoomsTest(){
//        
//        Room room = TestUtils.createRoom(11, 1, 100);
//        Room room2 = TestUtils.createRoom(12, 2, 200);
//        Room room3 = TestUtils.createRoom(13, 3, 300);
//        
//        List<Room> rooms = Arrays.asList(room, room2, room3);
//        
//        roomDAO.persistRoom(room);
//        roomDAO.persistRoom(room2);
//        roomDAO.persistRoom(room3);
//        
//        List<Room> roomsExtracted = roomDAO.getAllRooms();
//        
//        Collections.sort(rooms, idComparator);
//        Collections.sort(roomsExtracted, idComparator);
//        
//        assertEquals("Number of persisted entities does not match to " + 
//                "number of entities extracted from DB", rooms.size(), roomsExtracted.size());
//        
//        assertEquals("List of entities extracted from DB does not match to list od entities persisted", rooms, roomsExtracted);
//        
//    }
//    
//    @Test
//    @Rollback(true)
//    public void persistRoomTest()
//    {
//        Room room = TestUtils.createRoom(11, 1, 100);
//        
//        roomDAO.persistRoom(room);
//        
//        Room room2 = roomDAO.getRoomById(room.getId());
//        
//        assertEquals("Persisted entity: " + room.toString() + "does not equal to entity extracted from DB: " +
//                room2.toString(), room, room2);
//        
//    }
//    
//    @Test
//    @Rollback(true)
//    public void mergeRoomTest()
//    {
//        Room room = TestUtils.createRoom(11, 1, 100);
//        
//        roomDAO.persistRoom(room);
//        
//        room.setCapacity(10);
//        
//        Room roomManaged = roomDAO.mergeRoom(room);
//        
//        Room room2 = roomDAO.getRoomById(room.getId());
//        assertEquals("Merged entity: " + room.toString() + "does not equal to entity extracted from DB: " +
//                room2.toString(), room, room2);
//        
//        roomManaged.setCapacity(12);
//        
//        room2 = roomDAO.getRoomById(roomManaged.getId());
//        assertEquals("Managed entity: " + roomManaged.toString() + "does not equal to entity extracted from DB: " +
//                room2.toString(), roomManaged, room2);
//        
//    }
//    
//    @Test
//    @Rollback(true)
//    public void updateRoomTest()
//    {
//        Room room = TestUtils.createRoom( 11, 1, 100);
//        Room room2 = TestUtils.createRoom(12, 2, 200);
//        
//        roomDAO.persistRoom(room);
//        roomDAO.persistRoom(room2);
//        
//        room.setCapacity(10);
//        room.setPrice(200);
//        room.setRoomNumber(12);
//        
//        Room roomDB = roomDAO.getRoomById(room.getId());
//                
//        assertEquals("Entity: " + room + "was not correctly updated in DB, actual entity: " + 
//                roomDB, room, roomDB);
//        
//        Room roomDB2 = roomDAO.getRoomById(room2.getId());
//        
//        assertEquals("Entity: " + room2 + "was disturbed in DB while updating entity: " +
//                room, room2, roomDB2);
//        
//    }
//    
//    
//    
//    
    
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
