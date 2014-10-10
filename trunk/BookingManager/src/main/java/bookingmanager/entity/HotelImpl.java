package bookingmanager.entity;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jiří Kareš
 */
@Entity
@Table(name = "rooms")
public class HotelImpl implements Hotel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String address;
    
    @Column
    private int phoneNumber;
    
    private final ArrayList<Room> rooms; // We should consider the use of map<Integer, Room> instead of list

    public HotelImpl() {
        rooms = new ArrayList<>();
    }

    public HotelImpl(int id, String name, String Address, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        rooms = new ArrayList<>();
    }

    @Override
    public boolean addRoom(Room room) {
        return rooms.add(room);
    }

    @Override
    public boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    @Override
    public Room getRoom(int roomId) {
        return rooms.get(id);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }

};
