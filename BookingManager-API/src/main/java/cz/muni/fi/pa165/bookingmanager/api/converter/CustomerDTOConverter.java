package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 *
 * @author Jiří Kareš
 */
public class CustomerDTOConverter {

    private Mapper mapper;

    public CustomerDTOConverter() {
        mapper = new DozerBeanMapper();
    }
    
    public CustomerDTO entityToDto(Customer entity) {
        if (entity == null) {
            return null;
        }

        return mapper.map(entity, CustomerDTO.class);
    }

    public Customer dtoToEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }

        return mapper.map(dto, Customer.class);
    }
}
