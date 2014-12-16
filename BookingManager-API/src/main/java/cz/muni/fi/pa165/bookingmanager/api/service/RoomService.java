/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface RoomService {
    
    void addRoom(RoomDTO room);
    
    void deleteRoom(RoomDTO room);
    
    void updateRoom(RoomDTO room);
    
    List<RoomDTO> getAllRooms();
    
    RoomDTO find(long id);
    
    boolean isAvailable(Date from, Date to, RoomDTO room);
}
