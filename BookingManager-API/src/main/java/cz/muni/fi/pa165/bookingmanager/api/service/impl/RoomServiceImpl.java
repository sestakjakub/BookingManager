/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.RoomDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import cz.muni.fi.pa165.bookingmanager.backend.db.RoomDAO;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robert
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDAO roomDAO;
    @Autowired
    private RoomDTOConverter roomConverter;

    @Override
    public void addRoom(RoomDTO room) {
        if (room == null) {
            throw new IllegalArgumentException("null parameter");
        }

        if (room.getCapacity() < 0) {
            throw new IllegalArgumentException("Room capacity is negative");
        }
        if (room.getHotel() == null) {
            throw new IllegalArgumentException("Room is not assigned to hotel");
        }
        if (room.getPrice() < 0) {
            throw new IllegalArgumentException("Room price is negative");
        }
        if (room.getRoomNumber() < 0) {
            throw new IllegalArgumentException("Room number is negative");
        }

        if (roomDAO == null) {
            throw new IllegalArgumentException("roomDAO is null");
        }

        if (roomConverter == null) {
            throw new IllegalArgumentException("roomConverter is null");
        }
        
        roomDAO.persistRoom(roomConverter.dtoToEntity(room));
    }

    @Override
    public void deleteRoom(RoomDTO room) {
        if (room == null) {
            throw new IllegalArgumentException("null parameter");
        }

        roomDAO.removeRoom(roomConverter.dtoToEntity(room));
    }

    @Override
    public void updateRoom(RoomDTO room) {
        if (room == null) {
            throw new IllegalArgumentException("null parameter");
        }

        if (room.getCapacity() < 0) {
            throw new IllegalArgumentException("Room capacity is negative");
        }
        if (room.getHotel() == null) {
            throw new IllegalArgumentException("Room is not assigned to hotel");
        }
        if (room.getPrice() < 0) {
            throw new IllegalArgumentException("Room price is negative");
        }
        if (room.getRoomNumber() < 0) {
            throw new IllegalArgumentException("Room number is negative");
        }

        roomDAO.mergeRoom(roomConverter.dtoToEntity(room));
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return roomConverter.entityListToDtoList(roomDAO.getAllRooms());
    }

    @Override
    public boolean isAvailable(long from, long to, RoomDTO room) {
//        for (BookingDTO booking : room.getBookings()) {
//            if ((from.before(booking.getDateFrom()) && to.after(booking.getDateFrom()))
//                    || (booking.getDateFrom().before(from) && booking.getDateTo().after(from))
//                    || (booking.getDateFrom().before(from) && booking.getDateTo().after(to))
//                    || (from.before(booking.getDateFrom()) && to.after(booking.getDateTo()))) {
//                return false;
//            }
//        } FIX THIS

        return true;
    }

    @Override
    public RoomDTO find(long id) {
        return roomConverter.entityToDto(roomDAO.getRoomById(id));
    }
}
