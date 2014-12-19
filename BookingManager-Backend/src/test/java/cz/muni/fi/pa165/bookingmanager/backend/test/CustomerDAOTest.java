/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.test;

import cz.muni.fi.pa165.bookingmanager.backend.db.CustomerDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jana
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class CustomerDAOTest {
    
    @Autowired
    CustomerDAO customerDAO;
    
    @Test
    @Rollback(true)
    public void persistCustomerTest()
    {
//        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
//        
//        customerDAO.persistCustomer(customer);
//        
//        Customer customer2 = customerDAO.getCustomerById(customer.getId());
//        
//        assertEquals("Persisted entity: " + customer.toString() + "does not equal to entity extracted from DB: " +
//                customer2.toString(), customer, customer2);
//    
//        customerDAO.removeCustomer(customer);
    }
    
//    @Test
//    @Rollback(true)
//    public void getAllCustomersTest(){
//        
//        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
//        Customer customer2 = createCustomer("Tomas Pittner", "Botanicka 69");
//        Customer customer3 = createCustomer("Filip Nguyen", "Botanicka 70");
//        
//        List<Customer> customers = Arrays.asList(customer, customer2, customer3);
//        
//        customerDAO.persistCustomer(customer);
//        customerDAO.persistCustomer(customer2);
//        customerDAO.persistCustomer(customer3);
//        
//        List<Customer> customersExtracted = customerDAO.getAllCustomers();
//        
//        Collections.sort(customers, idComparator);
//        Collections.sort(customersExtracted, idComparator);
//        
//        assertEquals("Number of persisted entities does not match to " + 
//                "number of entities extracted from DB", customers.size(), customersExtracted.size());
//        
//        assertEquals("List of entities extracted from DB does not match to list od entities persisted", customers, customersExtracted);
//        
//        customerDAO.removeCustomer(customer);
//        customerDAO.removeCustomer(customer2);
//        customerDAO.removeCustomer(customer3);
//    }
//    
//    @Test
//    @Rollback(true)
//    public void mergeCustomerTest()
//    {
//        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
//        
//        customerDAO.persistCustomer(customer);
//        
//        customer.setAddress("Manesova 12");
//        
//        Customer customerManaged = customerDAO.mergeCustomer(customer);
//        
//        Customer customer2 = customerDAO.getCustomerById(customer.getId());
//        assertEquals("Merged entity: " + customer.toString() + "does not equal to entity extracted from DB: " +
//                customer2.toString(), customer, customer2);
//        
//        customerManaged.setAddress("Malinovskeho namesti");
//        
//        customer2 = customerDAO.getCustomerById(customerManaged.getId());
//        assertEquals("Managed entity: " + customerManaged.toString() + "does not equal to entity extracted from DB: " +
//                customer2.toString(), customerManaged, customer2);
//               
//        customerDAO.removeCustomer(customerManaged);
//    }
//    
//    @Test
//    @Rollback(true)
//    public void updateCustomerTest()
//    {
//        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
//        Customer customer2 = createCustomer("Tomas Pittner", "Botanicka 69");
//        
//        customerDAO.persistCustomer(customer);
//        customerDAO.persistCustomer(customer2);
//        
//        customer.setName("Martin Kuba");
//        customer.setAddress("Kotlarska 45");
//        
//        Customer customerDB = customerDAO.getCustomerById(customer.getId());
//                
//        assertEquals("Entity: " + customer + "was not correctly updated in DB, actual entity: " + 
//                customerDB, customer, customerDB);
//        
//        Customer customerDB2 = customerDAO.getCustomerById(customer2.getId());
//        
//        assertEquals("Entity: " + customer2 + "was disturbed in DB while updating entity: " +
//                customer, customer2, customerDB2);
//        
//        customerDAO.removeCustomer(customer);
//        customerDAO.removeCustomer(customer2);
//    }
//    
//    @Test
//    @Rollback(true)
//    public void removeCustomerTest()
//    {
//        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
//        Customer customer2 = createCustomer("Tomas Pittner", "Botanicka 69");
//        
//        customerDAO.persistCustomer(customer);
//        customerDAO.persistCustomer(customer2);
//        
//        customerDAO.removeCustomer(customer);
//        
//        assertEquals("Entity: " + customer.toString() + 
//                "was not correctly removed from DB", 1, customerDAO.getAllCustomers().size());
//        
//        Customer customerDB = customerDAO.getCustomerById(customer2.getId());
//        
//        assertEquals("Entity: " + customer2.toString() +
//                "was disturbed while removing entity: " + customer.toString(), customer2, customerDB);
//        
//        
//        customerDAO.removeCustomer(customer2);
//    }
//    
//    
    
    private static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer r1, Customer r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
    
    private Customer createCustomer(String name, String address){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        
        return customer;
    }
}