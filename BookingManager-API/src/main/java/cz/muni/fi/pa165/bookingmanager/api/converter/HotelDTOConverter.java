/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author Jakub Šesták, Jiří Kareš
 */
public class HotelDTOConverter {

    private Mapper mapper;

    public HotelDTOConverter() {
        mapper = new DozerBeanMapper();
    }

    public HotelDTO entityToDto(Hotel entity) {
        if (entity == null) {
            return null;
        }

        return mapper.map(entity, HotelDTO.class);
    }

    public Hotel dtoToEntity(HotelDTO dto) {
        if (dto == null) {
            return null;
        }
        
        return mapper.map(dto, Hotel.class);
    }
    
    public List<HotelDTO> entityListToDtoList(List<Hotel> entities) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        List<HotelDTO> dtoList = new ArrayList();
        
        for (Hotel entity : entities)
        {
            dtoList.add(mapper.map(entity, HotelDTO.class));
        }
        
        return dtoList;
    }
}
