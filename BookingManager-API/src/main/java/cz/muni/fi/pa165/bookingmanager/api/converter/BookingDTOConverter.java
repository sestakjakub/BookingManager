package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author Jiří Kareš
 */
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
}
