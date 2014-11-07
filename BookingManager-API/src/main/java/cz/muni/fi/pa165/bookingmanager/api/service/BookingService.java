/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import java.util.List;

/**
 *
 * @author Robert, Jiří Kareš
 */
public interface BookingService {
    
    void updateBooking(BookingDTO booking);
}
