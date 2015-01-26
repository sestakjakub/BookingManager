/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import java.util.Date;


/**
 *
 * @author Jiří Kareš
 */
public class BookingFormular {

    private long id;
    private long roomId;
    private long customerId;
    private long dateFrom;
    private long dateTo;

    BookingFormular() {
        id = 0;
    }

    BookingFormular(BookingDTO bookingDTO) {
        id = bookingDTO.getId();
        roomId = bookingDTO.getRoom().getId();
        customerId = bookingDTO.getCustomer().getId();
        dateFrom = bookingDTO.getDateFrom().getTime();
        dateTo = bookingDTO.getDateTo().getTime();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void modifyDTO(BookingDTO original, RoomService roomService, CustomerService customerService) {
        original.setId(id);
        original.setRoom(roomService.find(roomId));
        original.setCustomer(customerService.findCustomer(customerId));
        original.setDateFrom(new Date(dateFrom));
        original.setDateTo(new Date(dateTo));
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(long dateFrom) {
        this.dateFrom = dateFrom;
    }

    public long getDateTo() {
        return dateTo;
    }

    public void setDateTo(long dateTo) {
        this.dateTo = dateTo;
    }
}
