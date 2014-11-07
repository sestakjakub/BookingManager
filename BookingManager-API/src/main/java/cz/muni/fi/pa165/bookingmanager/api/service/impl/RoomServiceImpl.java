/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.RoomDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import cz.muni.fi.pa165.bookingmanager.backend.db.RoomDAO;
import java.util.List;

/**
 *
 * @author Robert
 */
public class RoomServiceImpl implements RoomService {
    
    private RoomDAO roomDAO;
    private RoomDTOConverter roomConverter;

    @Override
    public void addRoom(RoomDTO room) {
        if (room == null){
            throw new IllegalArgumentException("null parameter");
        }
        
        roomDAO.persistRoom(roomConverter.dtoToEntity(room));
    }

    @Override
    public void deleteRoom(RoomDTO room) {
        if (room == null){
            throw new IllegalArgumentException("null parameter");
        }
        
        roomDAO.removeRoom(roomConverter.dtoToEntity(room));
    }

    @Override
    public void updateRoom(RoomDTO room) {
        if (room == null){
            throw new IllegalArgumentException("null parameter");
        }
        
        roomDAO.mergeRoom(roomConverter.dtoToEntity(room));
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomConverter.entityListToDtoList(roomDAO.getAllRooms());
    }

    
}
