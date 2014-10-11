package bookingmanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jiří Kareš
 */
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String address;
    
    @Column
    private int phoneNumber;
    
    @OneToMany(mappedBy = "hotel")
    private final ArrayList<Room> rooms; // We should consider the use of map<Integer, Room> instead of list

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public Hotel(int id, String name, String address, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        rooms = new ArrayList<>();
    }

    public boolean addRoom(Room room) {
        return rooms.add(room);
    }

    public boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    public Room getRoom(int roomId) {
        return rooms.get(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

};
