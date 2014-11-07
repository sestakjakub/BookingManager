/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakub
 */
public class CustomerDTO {
    
    public CustomerDTO() {
        this.bookings = new ArrayList<>();
    }
    
    private long id;
    
    private String name;
    
    private String address;
    
    private List<BookingDTO> bookings;
    
    public void addBooking(BookingDTO booking) {
        bookings.add(booking);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerDTO other = (CustomerDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer[ id=" + id + ", name= " + name + " ,address: " + address + "]";
    }
    
}
