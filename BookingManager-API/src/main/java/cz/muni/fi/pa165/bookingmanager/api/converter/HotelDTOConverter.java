/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;

/**
 *
 * @author Jakub
 */
public class HotelDTOConverter {
    public static HotelDTO entityToDto(Hotel entity) {
		if (entity == null)
			return null;

		HotelDTO dto = new HotelDTO();
		dto.setId(entity.getId());
                dto.setName(entity.getName());
                dto.setAddress(entity.getAddress());
                dto.setPhoneNumber(entity.getPhoneNumber());
                
                //TODO
                //dto.setRooms(entity.getRooms());
                
		
		return dto;
	}
    
    public static Hotel dtoToEntity(HotelDTO dto) {
		if (dto == null)
			return null;

		Hotel entity = new Hotel();
		entity.setId(dto.getId());
                entity.setName(dto.getName());
                entity.setAddress(dto.getAddress());
                entity.setPhoneNumber(dto.getPhoneNumber());
                
                //TODO
                //entity.setRooms(dto.getRooms());
		
                
		return entity;
	}

}
