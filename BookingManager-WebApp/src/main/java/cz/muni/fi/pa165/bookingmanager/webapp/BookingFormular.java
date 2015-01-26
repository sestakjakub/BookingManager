/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.api.service.RoomService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jiří Kareš
 */
public class BookingFormular {

    private long id;
    private long roomId;
    private long customerId;
    private String dateFrom;
    private String dateTo;

    BookingFormular() {
        id = 0;
    }

    BookingFormular(BookingDTO bookingDTO) {
        id = bookingDTO.getId();
        roomId = bookingDTO.getRoom().getId();
        customerId = bookingDTO.getCustomer().getId();
        dateFrom = new Date(bookingDTO.getDateFrom()).toString();
        dateTo = new Date(bookingDTO.getDateTo()).toString();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void modifyDTO(BookingDTO original, RoomService roomService, CustomerService customerService){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        original.setId(id);
        original.setRoom(roomService.find(roomId));
        original.setCustomer(customerService.findCustomer(customerId));
        try {
            original.setDateFrom(df.parse(dateFrom).getTime());
            original.setDateTo(df.parse(dateTo).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(BookingFormular.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
