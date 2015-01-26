/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service;

import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author Robert, Jiří Kareš
 */
public interface CustomerService {
    
    List<CustomerDTO> getAllCustomers();
    
    CustomerDTO findCustomer(long id);
    
    CustomerDTO findCustomer(String username);
    
    void addCustomer(CustomerDTO customer);
    
    void deleteCustomer(CustomerDTO customer);
    
    void updateCustomer(CustomerDTO customer);
}
