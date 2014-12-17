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

    @Autowired
    private HotelDTOConverter hotelConverter;
    
    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public void addHotel(HotelDTO hotelDTO) {

        if (hotelDTO == null) {
            throw new IllegalArgumentException("Hotel is null");
        } else if (hotelDTO.getAddress() == "") {
            throw new IllegalArgumentException("Hotel address is empty");
        } else if (hotelDTO.getName() == "") {
            throw new IllegalArgumentException("Hotel name is empty");
        } else if (hotelDTO.getPhoneNumber() == "") {
            throw new IllegalArgumentException("Hotel phone number is empty");
        } else if (hotelDTO.getAddress() == null){
            throw new IllegalArgumentException("Address is null");
        } else if (hotelDTO.getName() == null){
            throw new IllegalArgumentException("Name is null");
        } else if (hotelDTO.getPhoneNumber() == null){
            throw new IllegalArgumentException("Phone number is null");
        }
        
        hotelDAO.persistHotel(hotelConverter.dtoToEntity(hotelDTO));
    }

    @Override
    public void deleteHotel(HotelDTO hotelDTO) {

        if (hotelDTO == null) {
            throw new IllegalArgumentException("Hotel is null");
        }

        hotelDAO.removeHotel(hotelConverter.dtoToEntity(hotelDTO));
    }
    
    @Override
    public HotelDTO findHotel(long id) {
        return hotelConverter.entityToDto(hotelDAO.find(id));
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return hotelConverter.entityListToDtoList(hotelDAO.getAllHotels());
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {
        if (hotelDTO == null) {
            throw new IllegalArgumentException("null parameter");
        } else if (hotelDTO.getAddress() == "") {
            throw new IllegalArgumentException("Hotel address is empty");
        } else if (hotelDTO.getName() == "") {
            throw new IllegalArgumentException("Hotel name is empty");
        } else if (hotelDTO.getPhoneNumber() == "") {
            throw new IllegalArgumentException("Hotel phone number is empty");
        }

        hotelDAO.mergeHotel(hotelConverter.dtoToEntity(hotelDTO));
    }
}
