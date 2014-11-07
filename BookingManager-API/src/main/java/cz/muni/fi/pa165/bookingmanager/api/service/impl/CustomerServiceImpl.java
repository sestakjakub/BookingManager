/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.CustomerDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.backend.db.CustomerDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Robert, Jiří Kareš
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private CustomerDTOConverter customerConverter;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerConverter.entityListToDtoList(customerDAO.getAllCustomers());
    }

    @Override
    public void addCustomer(CustomerDTO customer) {
        if (customer == null) {
            throw new IllegalArgumentException("null parameter");
        }
        
        if (customer.getAddress() == "")
            throw new IllegalArgumentException("Customer address is empty");
        if (customer.getName() == "")    
            throw new IllegalArgumentException("Customer name is empty");
        
        customerDAO.persistCustomer(customerConverter.dtoToEntity(customer));
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
        if (customer == null) {
            throw new IllegalArgumentException("null parameter");
        }
        
        customerDAO.removeCustomer(customerConverter.dtoToEntity(customer));
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        if (customer == null) {
            throw new IllegalArgumentException("null parameter");
        }
        
        if (customer.getAddress() == "")
            throw new IllegalArgumentException("Customer address is empty");
        if (customer.getName() == "")    
            throw new IllegalArgumentException("Customer name is empty");
        
        customerDAO.mergeCustomer(customerConverter.dtoToEntity(customer));
    }
}
