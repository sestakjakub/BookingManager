/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.test;

import bookingmanager.db.CustomerDAO;
import bookingmanager.db.impl.CustomerDAOImpl;
import bookingmanager.entity.Customer;
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
        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
        
        CustomerDAO customerDAOManager = new CustomerDAOImpl();
        customerDAOManager.persistCustomer(customer);
        
        Customer customer2 = customerDAOManager.getCustomerById(customer.getId());
        
        assertEquals("Persisted entity: " + customer.toString() + "does not equal to entity extracted from DB: " +
                customer2.toString(), customer, customer2);
    
        customerDAOManager.removeCustomer(customer);
    }
    
    @Test
    public void getAllCustomersTest(){
        
        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
        Customer customer2 = createCustomer("Tomas Pittner", "Botanicka 69");
        Customer customer3 = createCustomer("Filip Nguyen", "Botanicka 70");
        
        List<Customer> customers = Arrays.asList(customer, customer2, customer3);
        
        CustomerDAO customerDAOManager = new CustomerDAOImpl();
        customerDAOManager.persistCustomer(customer);
        customerDAOManager.persistCustomer(customer2);
        customerDAOManager.persistCustomer(customer3);
        
        List<Customer> customersExtracted = customerDAOManager.getAllCustomers();
        
        Collections.sort(customers, idComparator);
        Collections.sort(customersExtracted, idComparator);
        
        assertEquals("Number of persisted entities does not match to " + 
                "number of entities extracted from DB", customers.size(), customersExtracted.size());
        
        assertEquals("List of entities extracted from DB does not match to list od entities persisted", customers, customersExtracted);
        
        customerDAOManager.removeCustomer(customer);
        customerDAOManager.removeCustomer(customer2);
        customerDAOManager.removeCustomer(customer3);
    }
    
    @Test
    public void mergeCustomerTest()
    {
        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
        
        CustomerDAO customerDAOManager = new CustomerDAOImpl();
        customerDAOManager.persistCustomer(customer);
        
        customer.setAddress("Manesova 12");
        
        Customer customerManaged = customerDAOManager.mergeCustomer(customer);
        
        Customer customer2 = customerDAOManager.getCustomerById(customer.getId());
        assertEquals("Merged entity: " + customer.toString() + "does not equal to entity extracted from DB: " +
                customer2.toString(), customer, customer2);
        
        customerManaged.setAddress("Malinovskeho namesti");
        
        customer2 = customerDAOManager.getCustomerById(customerManaged.getId());
        assertEquals("Managed entity: " + customerManaged.toString() + "does not equal to entity extracted from DB: " +
                customer2.toString(), customerManaged, customer2);
               
        customerDAOManager.removeCustomer(customerManaged);
    }
    
    @Test
    public void updateCustomerTest()
    {
        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
        Customer customer2 = createCustomer("Tomas Pittner", "Botanicka 69");
        
        CustomerDAO customerDAOManager = new CustomerDAOImpl();
        customerDAOManager.persistCustomer(customer);
        customerDAOManager.persistCustomer(customer2);
        
        customer.setName("Martin Kuba");
        customer.setAddress("Kotlarska 45");
        
        Customer customerDB = customerDAOManager.getCustomerById(customer.getId());
                
        assertEquals("Entity: " + customer + "was not correctly updated in DB, actual entity: " + 
                customerDB, customer, customerDB);
        
        Customer customerDB2 = customerDAOManager.getCustomerById(customer2.getId());
        
        assertEquals("Entity: " + customer2 + "was disturbed in DB while updating entity: " +
                customer, customer2, customerDB2);
        
        customerDAOManager.removeCustomer(customer);
        customerDAOManager.removeCustomer(customer2);
    }
    
    @Test
    public void removeCustomerTest()
    {
        Customer customer = createCustomer("Petr Adamek", "Botanicka 68");
        Customer customer2 = createCustomer("Tomas Pittner", "Botanicka 69");
        
        CustomerDAO customerDAOManager = new CustomerDAOImpl();
        customerDAOManager.persistCustomer(customer);
        customerDAOManager.persistCustomer(customer2);
        
        customerDAOManager.removeCustomer(customer);
        
        assertEquals("Entity: " + customer.toString() + 
                "was not correctly removed from DB", 1, customerDAOManager.getAllCustomers().size());
        
        Customer customerDB = customerDAOManager.getCustomerById(customer2.getId());
        
        assertEquals("Entity: " + customer2.toString() +
                "was disturbed while removing entity: " + customer.toString(), customer2, customerDB);
        
        
        customerDAOManager.removeCustomer(customer2);
    }
    
    
    
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
