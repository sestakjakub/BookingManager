/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.api.dto;

import java.util.List;

/**
 *
 * @author Jakub
 */
public class RoomDTO {
    private long id;

    private int roomNumber;

    private HotelDTO hotel;

    private int capacity;

    private float price;
    
    private List<BookingDTO> bookings;

    public RoomDTO() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setRoomNumber(int n) {
        roomNumber = n;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final RoomDTO other = (RoomDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Room[ id=" + id + ", room number=" + roomNumber + ", capacity: " + capacity + " ]";
    }
}
