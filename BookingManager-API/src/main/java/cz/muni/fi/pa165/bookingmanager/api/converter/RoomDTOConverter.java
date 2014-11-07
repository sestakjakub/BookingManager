package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author Jiří Kareš
 */
public class RoomDTOConverter {
    
    private Mapper mapper;

    public RoomDTOConverter() {
        mapper = new DozerBeanMapper();
    }
    
    public RoomDTO entityToDto(Room entity) {
        if (entity == null) {
            return null;
        }

        return mapper.map(entity, RoomDTO.class);
    }

    public Room dtoToEntity(RoomDTO dto) {
        if (dto == null) {
            return null;
        }

        return mapper.map(dto, Room.class);
    }
}
