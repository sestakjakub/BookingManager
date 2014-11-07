/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import java.util.List;

/**
 *
 * @author Jakub
 */
public interface HotelService {
    
    public void addHotel(HotelDTO hotelDTO);
   
    public void deleteHotel(HotelDTO hotelDTO);
    
    public void updateHotel(HotelDTO hotelDTO);
    
    public List<HotelDTO> getAllHotels();
    
}
