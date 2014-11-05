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
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Jakub
 */
public class HotelServiceImpl implements HotelService {
    
    @Autowired
	private HotelDAO hotelDao;
    
    @Override
    public HotelDTO create(HotelDTO hotelDTO) {
            HotelDTO dto = null;
            Hotel hotel = null;
            try {
                    hotel = hotelDao.create(HotelDTOConverter.dtoToEntity(hotelDTO));
                    dto = HotelDTOConverter.entityToDto(hotel);
            } catch (IllegalArgumentException e) {
                    throw new Exception(
                                    "Error occured during storing Hotel", e);
            }
            return dto;
    }
}
