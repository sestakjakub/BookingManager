/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.webapp;

import cz.muni.fi.pa165.bookingmanager.api.dto.RoomDTO;

/**
 *
 * @author Jiří Kareš
 */
public class RoomFormular {

    private long id;
    private long hotelId;
    private int number;
    private int capacity;
    private float price;

    RoomFormular() {
        id = 0;
    }

    RoomFormular(RoomDTO roomDTO) {
        id = roomDTO.getId();
        hotelId = roomDTO.getHotel().getId();
        number = roomDTO.getRoomNumber();
        capacity = roomDTO.getCapacity();
        price = roomDTO.getPrice();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setHotelId(long id) {
        this.hotelId = id;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
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

    public void modifyDTO(RoomDTO original) {
        original.setId(id);
        original.setCapacity(capacity);
        original.setPrice(price);
        original.setRoomNumber(number);
    }
}
