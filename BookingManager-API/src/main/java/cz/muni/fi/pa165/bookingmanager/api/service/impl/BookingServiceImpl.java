/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.BookingDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.BookingService;
import cz.muni.fi.pa165.bookingmanager.backend.db.BookingDAO;
import java.util.List;

/**
 *
 * @author Robert
 */
public class BookingServiceImpl implements BookingService{
    private BookingDTOConverter bookingConverter;
    private BookingDAO bookingDAO;

    @Override
    public void updateBooking(BookingDTO booking) {
        if (booking == null) {
            throw new IllegalArgumentException("null parameter");
        }
        
        bookingDAO.mergeBooking(bookingConverter.dtoToEntity(booking));
    }

    @Override
    public void addBooking(BookingDTO booking) {
        if (booking == null) {
            throw new IllegalArgumentException("null parameter");
        }

        bookingDAO.persistBooking(bookingConverter.dtoToEntity(booking));
    }

    @Override
    public void deleteBooking(BookingDTO booking) {
        if (booking == null) {
            throw new IllegalArgumentException("null parameter");
        }
        
        bookingDAO.removeBooking(bookingConverter.dtoToEntity(booking));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingConverter.entityListToDtoList(bookingDAO.getAllBookings());
    }
    
}
