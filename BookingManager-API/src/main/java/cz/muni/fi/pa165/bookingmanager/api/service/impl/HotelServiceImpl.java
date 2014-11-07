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
 * @author Jakub, Jiří Kareš
 */
@Service
public class HotelServiceImpl implements HotelService {
    
    private HotelDTOConverter hotelConverter = new HotelDTOConverter();
    
    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public void addHotel(HotelDTO hotelDTO) {
        
        if (hotelDTO == null){
            throw new IllegalArgumentException("Hotel is null");
        }
        else if (hotelDTO.getId() < 0)
            throw new IllegalArgumentException("Hotel id is negative");
        else if (hotelDTO.getAddress() == "")
            throw new IllegalArgumentException("Hotel address is empty");
        else if (hotelDTO.getName() == "")
            throw new IllegalArgumentException("Hotel name is empty");
        else if (hotelDTO.getPhoneNumber() == "")
            throw new IllegalArgumentException("Hotel phone number is empty");
        
        hotelDAO.persistHotel(hotelConverter.dtoToEntity(hotelDTO));
    }

    @Override
    public void deleteHotel(HotelDTO hotelDTO) {
        
        if (hotelDTO == null){
            throw new IllegalArgumentException("Hotel is null");
        }
        
        hotelDAO.removeHotel(hotelConverter.dtoToEntity(hotelDTO));
    }
    
    

    @Override
    public List<HotelDTO> getAllHotels() {
        return hotelConverter.entityListToDtoList(hotelDAO.getAllHotels());
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {
        if (hotelDTO == null) {
            throw new IllegalArgumentException("null parameter");
        }
        
        hotelDAO.mergeHotel(hotelConverter.dtoToEntity(hotelDTO));
    }
    
}
