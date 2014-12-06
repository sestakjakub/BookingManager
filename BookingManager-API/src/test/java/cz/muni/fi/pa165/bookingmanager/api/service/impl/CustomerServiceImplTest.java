/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.service.impl;

import cz.muni.fi.pa165.bookingmanager.api.converter.CustomerDTOConverter;
import cz.muni.fi.pa165.bookingmanager.api.dto.BookingDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;
import cz.muni.fi.pa165.bookingmanager.backend.db.impl.CustomerDAOImpl;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author Jana
 */

@ContextConfiguration(locations = {"classpath:springApplicationContext.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    
    public CustomerServiceImplTest() {
    }
    
    @Mock
    private CustomerDTOConverter customerConverter;
    
    @InjectMocks
    private CustomerServiceImpl customerService;
    
    @Mock
    private CustomerDAOImpl customerDAO;
    

    /**
     * Test of getAllCustomers method, of class CustomerServiceImpl.
     */
    @Test
    public void testGetAllCustomers() {
        System.out.println("getAllCustomers");
        
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
        
        customerService.addCustomer(customerDTO);
        customerService.getAllCustomers();
        
        verify(customerDAO, Mockito.times(1)).getAllCustomers();
    }

    /**
     * Test of addCustomer method, of class CustomerServiceImpl.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
        
        customerService.addCustomer(customerDTO);
        
        verify(customerDAO, Mockito.times(1)).persistCustomer(customerConverter.dtoToEntity(customerDTO));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomerAsNull() {
        System.out.println("addCustomerAsNull");
        
        CustomerDTO customerDTO = null;
        
        customerService.addCustomer(customerDTO);
        
        verifyZeroInteractions(customerDTO);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomerWithNullName() {
        System.out.println("addCustomerWithNullName");
        
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
        customerDTO.setName(null);
        
        customerService.addCustomer(customerDTO);
        
        verifyZeroInteractions(customerDTO);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomerWithNullAddress() {
        System.out.println("addCustomerWithNullAddress");
        
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
        customerDTO.setAddress(null);
        
        customerService.addCustomer(customerDTO);
        
        verifyZeroInteractions(customerDTO);
    }
    
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        
        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
        
        customerService.addCustomer(customerDTO);
        customerService.deleteCustomer(customerDTO);
        
        verify(customerDAO, Mockito.times(1)).removeCustomer(customerConverter.dtoToEntity(customerDTO));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteCustomerAsNull() {
        System.out.println("deleteCustomerAsNull");
        
        CustomerDTO customerDTO = null;
        
        customerService.deleteCustomer(customerDTO);
        
        verifyZeroInteractions(customerDTO);
    }
    
    
}
