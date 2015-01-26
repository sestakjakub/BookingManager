/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServiceClient;

import cz.muni.fi.pa165.bookingmanager.ws.generated.AddCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.AddHotelRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.Customer;
import cz.muni.fi.pa165.bookingmanager.ws.generated.EditCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.EditHotelRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllCustomerResponse;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllHotelRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.GetAllHotelResponse;
import cz.muni.fi.pa165.bookingmanager.ws.generated.Hotel;
import cz.muni.fi.pa165.bookingmanager.ws.generated.RemoveCustomerRequest;
import cz.muni.fi.pa165.bookingmanager.ws.generated.RemoveHotelRequest;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 *
 * @author Robo
 */
public class WebServiceClient {
    
    @Autowired
    private WebServiceTemplate wsTemplate;
    
    public void sendHotelAddRequest(String name, String address, String phoneNumber) {
        AddHotelRequest addHotelRequest = new AddHotelRequest();
        Hotel hotel = new Hotel();
        
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setPhoneNumber(phoneNumber);
        
        addHotelRequest.setHotel(hotel);
        
        wsTemplate.marshalSendAndReceive(addHotelRequest);
    }
    
    public void sendHotelRemoveRequest(BigInteger hotelId){
        Hotel hotel = new Hotel();
        
        hotel.setId(hotelId);
        
        RemoveHotelRequest removeHotelRequest = new RemoveHotelRequest();
        removeHotelRequest.setHotel(hotel);
        
        wsTemplate.marshalSendAndReceive(removeHotelRequest);
    }
    
    public void sendEditHotelRequest(BigInteger hotelId, String name, String address, String phoneNumber){
        Hotel hotel = new Hotel();
        
        hotel.setId(hotelId);
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setPhoneNumber(phoneNumber);
        
        EditHotelRequest editHotelRequest = new EditHotelRequest();
        editHotelRequest.setHotel(hotel);
        
        wsTemplate.marshalSendAndReceive(editHotelRequest);
    }
    
    public List<Hotel> sendGetAllHotelsRequest(){
        GetAllHotelRequest getAllHotel = new GetAllHotelRequest();
        
        GetAllHotelResponse getAllHotelResponse =  (GetAllHotelResponse) wsTemplate.marshalSendAndReceive(getAllHotel);
        
        return getAllHotelResponse.getHotels().getHotel();
    }
    
    
    public void sendCustomerAddRequest(String name, String address) {
        AddCustomerRequest addCustomerRequest = new AddCustomerRequest();
        Customer customer = new Customer();
        
        customer.setName(name);
        customer.setAddress(address);
        
        addCustomerRequest.setCustomer(customer);
        
        wsTemplate.marshalSendAndReceive(addCustomerRequest);
    }
    
    public void sendCustomerRemoveRequest(BigInteger customerId){
        Customer customer = new Customer();
        
        customer.setId(customerId);
        
        RemoveCustomerRequest removeCustomerRequest = new RemoveCustomerRequest();
        removeCustomerRequest.setCustomer(customer);
        
        wsTemplate.marshalSendAndReceive(removeCustomerRequest);
    }
    
    public void sendEditCustomerRequest(BigInteger customerId, String name, String address){
        Customer customer = new Customer();
        
        customer.setId(customerId);
        customer.setName(name);
        customer.setAddress(address);
        
        EditCustomerRequest editCustomerRequest = new EditCustomerRequest();
        editCustomerRequest.setCustomer(customer);
        
        wsTemplate.marshalSendAndReceive(editCustomerRequest);
    }
    
    public List<Customer> sendGetAllCustomersRequest(){
        GetAllCustomerRequest getAllCustomers = new GetAllCustomerRequest();
        
        GetAllCustomerResponse getAllCustomerResponse =  (GetAllCustomerResponse) wsTemplate.marshalSendAndReceive(getAllCustomers);
        
        return getAllCustomerResponse.getCustomers().getCustomer();
    }
}
