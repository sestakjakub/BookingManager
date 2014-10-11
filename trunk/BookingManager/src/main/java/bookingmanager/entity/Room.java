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
 *
 * @author Jiří Kareš
 */
@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int roomNumber;

    @Column
    @ManyToOne
    private Hotel hotel;

    @Column
    private int capacity;

    @Column
    private int price;
    
    @OneToMany(mappedBy = "room")
    private ArrayList<Booking> bookings;

    public Room() {
        bookings = new ArrayList<>();
    }

    public Room(int id, int roomNumber, Hotel hotel, int capacity, int price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.hotel = hotel;
        this.capacity = capacity;
        this.price = price;
        bookings = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRoomNumber(int n) {
        roomNumber = n;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean addBooking(Booking booking) {
        return bookings.add(booking);
    }

    public boolean removeBooking(Booking booking) {
        return bookings.remove(booking);
    }

    public Booking getBooking(int id) {
        return bookings.get(id);
    }
}
