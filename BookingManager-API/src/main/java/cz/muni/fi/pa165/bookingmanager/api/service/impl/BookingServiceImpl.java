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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robert
 */
@Service
public class BookingServiceImpl implements BookingService{
    
    @Autowired
    private BookingDTOConverter bookingConverter;
    @Autowired
    private BookingDAO bookingDAO;

    @Override
    public void updateBooking(BookingDTO booking) {
        bookingDAO.mergeBooking(bookingConverter.dtoToEntity(booking));
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingConverter.entityListToDtoList(bookingDAO.getAllBookings());
    }

    @Override
    public BookingDTO findBooking(long id) {
        return bookingConverter.entityToDto(bookingDAO.getBookingById(id));
    }

    @Override
    public void addBooking(BookingDTO booking) {
        bookingDAO.persistBooking(bookingConverter.dtoToEntity(booking));
    }

    @Override
    public void deleteBooking(BookingDTO booking) {
        bookingDAO.removeBooking(bookingConverter.dtoToEntity(booking));
    }

}
