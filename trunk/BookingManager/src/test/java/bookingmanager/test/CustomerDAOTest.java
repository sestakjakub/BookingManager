/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.impl.CustomerDAOImpl;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Customer;
import bookingmanager.entity.Hotel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jana
 */
public class CustomerDAOTest {
    
    public CustomerDAOTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void persistCustomerTest()
    {
        Customer customer = new Customer(1, "Petr Adamek", "Botanicka 68", new ArrayList<Booking>());
        
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persist(customer);
        
        Customer customer2 = customerEntityManager.getCustomerById(customer.getId());
        
        assertEquals("Persisted entity: " + customer.toString() + "does not equal to entity extracted from DB: " +
                customer2.toString(), customer, customer2);
    
    }
    
    @Test
    public void getAllCustomersTest(){
        
        Customer customer = new Customer(1, "Petr Adamek", "Botanicka 68", new ArrayList<Booking>());
        Customer customer2 = new Customer(2, "Tomas Pittner", "Botanicka 69", new ArrayList<Booking>());
        Customer customer3 = new Customer(3, "Filip Nguyen", "Botanicka 70", new ArrayList<Booking>());
        
        List<Customer> customers = Arrays.asList(customer, customer2, customer3);
        
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        customerEntityManager.persistCustomer(customer2);
        customerEntityManager.persistCustomer(customer3);
        
        List<Customer> customersExtracted = customerEntityManager.getAllCustomers();
        
        Collections.sort(customers, idComparator);
        Collections.sort(customersExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", customers.size(), customersExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", customers, customersExtracted);
        
    }
    
    @Test
    public void findCustomerByIdTest(){
        // the same as PersistCustomerTest?
    }
    
    @Test
    public void mergeCustomerTest()
    {
        Customer customer = new Customer(1, "Petr Adamek", "Botanicka 68", new ArrayList<Booking>());
        
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        
        customer.setAddress("Manesova 12");
        
        Customer customerManaged = customerEntityManager.mergeCustomer(customer);
        
        Customer customer2 = customerEntityManager.getCustomerById(customer.getId());
        assertEquals("Merged entity: " + customer.toString() + "does not equal to entity extracted from DB: " +
                customer2.toString(), customer, customer2);
        
        customerManaged.setAddress("Malinovskeho namesti");
        
        customer2 = customerEntityManager.getCustomerById(customerManaged.getId());
        assertEquals("Managed entity: " + customerManaged.toString() + "does not equal to entity extracted from DB: " +
                customer2.toString(), customerManaged, customer2);
               
    }
    
    @Test
    public void updateCustomerTest()
    {
        Customer customer = new Customer(1, "Petr Adamek", "Botanicka 68", new ArrayList<Booking>());
        Customer customer2 = new Customer(2, "Tomas Pittner", "Botanicka 69", new ArrayList<Booking>());
        
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        customerEntityManager.persistCustomer(customer2);
        
        customer.setName("Martin Kuba");
        customer.setAddress("Kotlarska 45");
        
        Customer customerDB = customerEntityManager.getCustomerById(customer.getId());
                
        assertEquals("Entity: " + customer + "was not correctly updated in DB, actual entity: " + 
                customerDB, customer, customerDB);
        
        Customer customerDB2 = customerEntityManager.getCustomerById(customer2.getId());
        
        assertEquals("Entity: " + customer2 + "was disturbed in DB while updating entity: " +
                customer, customer2, customerDB2);
        
    }
    
    @Test
    public void removeCustomerTest()
    {
        Customer customer = new Customer(1, "Petr Adamek", "Botanicka 68", new ArrayList<Booking>());
        Customer customer2 = new Customer(2, "Tomas Pittner", "Botanicka 69", new ArrayList<Booking>());
        
        CustomerDAOImpl customerEntityManager = new CustomerDAOImpl();
        customerEntityManager.persistCustomer(customer);
        customerEntityManager.persistCustomer(customer2);
        
        customerEntityManager.removeCustomer(customer);
        
        assertEquals("Entity: " + customer.toString() + 
                "was not correctly removed from DB", customerEntityManager.getAllCustomers().size(), 1);
        
        Customer customerDB = customerEntityManager.getCustomerById(customer2.getId());
        
        assertEquals("Entity: " + customer2.toString() +
                "was disturbed while removing entity: " + customer.toString(), customer2, customerDB);
    }
    
    
    
    private static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer r1, Customer r2) {
            return Long.valueOf(r1.getId()).compareTo(Long.valueOf(r2.getId()));
        }
    };
}
