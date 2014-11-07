package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jiří Kareš
 */
@Component("bookingConvertor")
public class BookingDTOConverter {

    private Mapper mapper;

    public BookingDTOConverter() {
        mapper = new DozerBeanMapper();
    }

    public BookingDTO entityToDto(Booking entity) {
        if (entity == null) {
            return null;
        }

        return mapper.map(entity, BookingDTO.class);
    }

    public Booking dtoToEntity(BookingDTO dto) {
        if (dto == null) {
            return null;
        }

        return mapper.map(dto, Booking.class);
    }

    public List<BookingDTO> entityListToDtoList(List<Booking> entities) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        List<BookingDTO> dtoList = new ArrayList();

        for (Booking entity : entities) {
            dtoList.add(mapper.map(entity, BookingDTO.class));
        }

        return dtoList;
    }
}
