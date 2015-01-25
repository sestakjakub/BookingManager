/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.HotelDTO;

/**
 *
 * @author Jiří Kareš
 */
public class HotelFormular {
    
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    
    HotelFormular() {
        id = 0;
    }
    
    HotelFormular(HotelDTO hotelDTO) {
        id = hotelDTO.getId();
        name = hotelDTO.getName();
        address = hotelDTO.getAddress();
        phoneNumber = hotelDTO.getPhoneNumber();
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void modifyDTO(HotelDTO original) {
        original.setId(id);
        original.setName(name);
        original.setAddress(address);
        original.setPhoneNumber(phoneNumber);
    }
}
