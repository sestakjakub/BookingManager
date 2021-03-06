package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jiří Kareš
 */
@Component
public class RoomDTOConverter {

    @Autowired
    private Mapper mapper;

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

    public List<RoomDTO> entityListToDtoList(List<Room> entities) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        List<RoomDTO> dtoList = new ArrayList();

        for (Room entity : entities) {
            dtoList.add(mapper.map(entity, RoomDTO.class));
        }

        return dtoList;
    }
}
