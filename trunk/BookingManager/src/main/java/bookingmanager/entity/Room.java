package bookingmanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class Room
 * 
 * @author Jiří Kareš
 */
@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int roomNumber;

    @Column
    @ManyToOne
    private Hotel hotel;

    @Column
    private int capacity;

    @Column
    private float price;
    
    @OneToMany(mappedBy = "room")
    private ArrayList<Booking> bookings;

    /**
     * Default Room constructor, sets default room id to 0.
     */
    public Room() {
        id = 0;
        bookings = new ArrayList<>();
    }

    /**
     * Room constructor
     * 
     * @param id room id
     * @param roomNumber room number
     * @param hotel hotel where the room is situated
     * @param capacity room capacity
     * @param price room price per night
     */
    public Room(long id, int roomNumber, Hotel hotel, int capacity, float price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.hotel = hotel;
        this.capacity = capacity;
        this.price = price;
        bookings = new ArrayList<>();
    }

    /**
     * Sets room id
     * @param id room id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns room id
     * 
     * @return room id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets room number
     * 
     * @param n room number
     */
    public void setRoomNumber(int n) {
        roomNumber = n;
    }

    /**
     * Returns room number
     * 
     * @return
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets hotel
     * 
     * @param hotel hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Returns hotel
     * 
     * @return hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets room capacity
     * 
     * @param capacity capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns room capacity
     * 
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets room price
     * 
     * @param price price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns room price
     * 
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Adds new booking to the room
     * 
     * @param booking booking to add
     * @return true if success, false otherwise
     */
    public boolean addBooking(Booking booking) {
        return bookings.add(booking);
    }

    /**
     * Removes given booking from the room
     * 
     * @param booking booking to remove
     * @return true if success, false otherwise
     */
    public boolean removeBooking(Booking booking) {
        return bookings.remove(booking);
    }

    /**
     * Returns list of room bookings
     * 
     * @return bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Room) {
            return id == ((Room)object).getId();
        }
        return false;
    }

    @Override
    public String toString() {
        return "bookingmanager.entity.Room[ id=" + id + " ]";
    }
}
