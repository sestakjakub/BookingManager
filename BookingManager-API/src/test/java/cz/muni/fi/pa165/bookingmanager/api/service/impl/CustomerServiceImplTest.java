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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Jana
 */
public class CustomerServiceImplTest {
//    
//    public CustomerServiceImplTest() {
//    }
//    
//    private CustomerDTOConverter customerDTOConverter;
//    
//    @InjectMocks
//    private CustomerServiceImpl service;
//    
//    @Mock
//    private CustomerDAOImpl customerDAO;
//    
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        customerDTOConverter = new CustomerDTOConverter();
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getAllCustomers method, of class CustomerServiceImpl.
//     */
//    @Test
//    public void testGetAllCustomers() {
//        System.out.println("getAllCustomers");
//        
//        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
//        
//        service.addCustomer(customerDTO);
//        service.getAllCustomers();
//        
//        verify(customerDAO, Mockito.times(1)).getAllCustomers();
//    }
//
//    /**
//     * Test of addCustomer method, of class CustomerServiceImpl.
//     */
//    @Test
//    public void testAddCustomer() {
//        System.out.println("addCustomer");
//        
//        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
//        
//        service.addCustomer(customerDTO);
//        
//        verify(customerDAO, Mockito.times(1)).persistCustomer(customerDTOConverter.dtoToEntity(customerDTO));
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddCustomerAsNull() {
//        System.out.println("addCustomerAsNull");
//        
//        CustomerDTO customerDTO = null;
//        
//        service.addCustomer(customerDTO);
//        
//        verifyZeroInteractions(customerDTO);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddCustomerWithNullName() {
//        System.out.println("addCustomerWithNullName");
//        
//        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
//        customerDTO.setName(null);
//        
//        service.addCustomer(customerDTO);
//        
//        verifyZeroInteractions(customerDTO);
//    }
//    
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddCustomerWithNullAddress() {
//        System.out.println("addCustomerWithNullAddress");
//        
//        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
//        customerDTO.setAddress(null);
//        
//        service.addCustomer(customerDTO);
//        
//        verifyZeroInteractions(customerDTO);
//    }
//    
//    @Test
//    public void testDeleteCustomer() {
//        System.out.println("deleteCustomer");
//        
//        CustomerDTO customerDTO = TestUtils.newCustomerDTO();
//        
//        service.addCustomer(customerDTO);
//        service.deleteCustomer(customerDTO);
//        
//        verify(customerDAO, Mockito.times(1)).removeCustomer(customerDTOConverter.dtoToEntity(customerDTO));
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testDeleteCustomerAsNull() {
//        System.out.println("deleteCustomerAsNull");
//        
//        CustomerDTO customerDTO = null;
//        
//        service.deleteCustomer(customerDTO);
//        
//        verifyZeroInteractions(customerDTO);
//    }
//    
//    
}
