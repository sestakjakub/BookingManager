/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.CustomerDTO;


/**
 *
 * @author Jiří Kareš
 */
public class CustomerFormular {
    
    private long id;
    private String name;
    private String address;
    private String username;
    private String password;
    
    CustomerFormular() {
        id = 0;
    }
    
    CustomerFormular(CustomerDTO customerDTO) {
        id = customerDTO.getId();
        name = customerDTO.getName();
        address = customerDTO.getAddress();
        username = customerDTO.getUsername();
        password = customerDTO.getPassword();
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
    
    public void modifyDTO(CustomerDTO original) {
        original.setId(id);
        original.setName(name);
        original.setAddress(address);
        original.setUsername(username);
        original.setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
