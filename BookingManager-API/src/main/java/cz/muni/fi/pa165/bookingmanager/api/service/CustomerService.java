/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service;

import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author Robert
 */
public interface CustomerService {
    
    List<CustomerDTO> getAllCustomers();
    
    void addCustomer(CustomerDTO customer);
}
