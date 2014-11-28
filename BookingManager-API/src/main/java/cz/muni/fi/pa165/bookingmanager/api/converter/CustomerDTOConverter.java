package cz.muni.fi.pa165.bookingmanager.api.converter;

import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
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
public class CustomerDTOConverter {

    @Autowired
    private Mapper mapper;

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

    public List<CustomerDTO> entityListToDtoList(List<Customer> entities) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        List<CustomerDTO> dtoList = new ArrayList();

        for (Customer entity : entities) {
            dtoList.add(mapper.map(entity, CustomerDTO.class));
        }

        return dtoList;
    }
}
