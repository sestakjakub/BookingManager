/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.db;

import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import java.util.List;

/**
 *
 * @author Robert Golej
 */
public interface CustomerDAO {
    
    /**
     * Persists customer
     * 
     * @param customer 
     */
    public void persistCustomer(Customer customer);
    
    /**
     * Gets customer entity by id.
     * 
     * @param id id of customer entity to be returned.
     * @return customer entity with given id.
     */
    public Customer getCustomerById(long id);
    
    /**
     * Merges customer.
     * 
     * @param customer customer entity to be merged.
     * @return merged customer entity.
     */
    public Customer mergeCustomer(Customer customer);
    
    /**
     * Removes customer.
     * 
     * @param customer customer to be removed.
     */
    public void removeCustomer(Customer customer);
    
    /**
     * Returns list of all customers.
     * 
     * @return list of all customers.
     */
    public List<Customer> getAllCustomers();
    
}
