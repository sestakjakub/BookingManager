/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.ws.endpoint;

import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;
import cz.muni.fi.pa165.bookingmanager.api.service.CustomerService;
import cz.muni.fi.pa165.bookingmanager.ws.generated.AddCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.Customer;
import cz.muni.fi.pa165.bookingmanager.ws.generated.Customers;
import cz.muni.fi.pa165.bookingmanager.ws.generated.EditCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllCustomerResponse;
import cz.muni.fi.pa165.bookingmanager.ws.generated.RemoveCustomerRequest;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Robo
 */
@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE_URI = "myTargetNamespace";
    
    @Autowired
    CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddCustomerRequest")
    public void handleAddCustomerRequest(@RequestPayload AddCustomerRequest addCustomerRequest){
        
        Customer customer = addCustomerRequest.getCustomer();
        
        String customerName = customer.getName();
        String customerAddress = customer.getAddress();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customerAddress);
        customerDTO.setAddress(customerAddress);
        
        customerService.addCustomer(customerDTO);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCustomerRequest")
    public @ResponsePayload GetAllCustomerResponse handleGetAllCustomers(@RequestPayload GetAllCustomerRequest getAllCustomerRequest){

        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();

        Customers customers = new Customers();
        
        for (CustomerDTO customerDTO: customerDTOList){
            
            Customer customer = new Customer();
            customer.setId(BigInteger.valueOf(customerDTO.getId()));
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            
            customers.getCustomer().add(customer);
        }
        GetAllCustomerResponse getAllCustomerResponse = new GetAllCustomerResponse();
        getAllCustomerResponse.setCustomers(customers);
        
        return getAllCustomerResponse;
    }
    
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditCustomerRequest")
    public void handleEditCustomerRequest(@RequestPayload EditCustomerRequest editCustomerRequest){

        long customerId = editCustomerRequest.getCustomer().getId().longValue();
        
        CustomerDTO customerDTO = customerService.findCustomer(customerId);
        
        Customer customer = editCustomerRequest.getCustomer();
        
        String customerName = customer.getName();
        String customerAddress = customer.getAddress();

        customerDTO.setName(customerName);
        customerDTO.setAddress(customerAddress);

        customerService.updateCustomer(customerDTO);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RemoveCustomerRequest")
    public void handleDeleteCustomerRequest(@RequestPayload RemoveCustomerRequest removeCustomerRequest){

        long customerId = removeCustomerRequest.getCustomer().getId().longValue();
        
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerId);
        
        customerService.deleteCustomer(customerDTO);
    }
    
}
