/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.HotelDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.HotelService;
import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jakub
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDAO hotelDao;

    @Override
    public void addHotel(HotelDTO hotelDTO) {
        
        if (hotelDTO == null){
            throw new IllegalArgumentException("Hotel is null");
        }
        
        hotelDao.persistHotel(HotelDTOConverter.dtoToEntity(hotelDTO));
    }

    @Override
    public void deleteHotel(HotelDTO hotelDTO) {
        
        if (hotelDTO == null){
            throw new IllegalArgumentException("Hotel is null");
        }
        
        hotelDao.removeHotel(HotelDTOConverter.dtoToEntity(hotelDTO));
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotelList= hotelDao.getAllHotels();
        
        List<HotelDTO> hotelDtoList = new ArrayList<>();
        
        for (Hotel hotel: hotelList){
            hotelDtoList.add(HotelDTOConverter.entityToDto(hotel));
        }
        
        return hotelDtoList;
    }
    
}
