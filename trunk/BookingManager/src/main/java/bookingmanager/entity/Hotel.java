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
 * Class Hotel
 * 
 * @author Jiří Kareš
 */
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private int phoneNumber;

    @OneToMany(mappedBy = "hotel")
    private final ArrayList<Room> rooms; // We should consider the use of map<Integer, Room> instead of list

    /**
     * Default Hotel constructor, sets hotel id to 0.
     */
    public Hotel() {
        id = 0;
        rooms = new ArrayList<>();
    }

    /**
     * Hotel constructor
     * 
     * @param id hotel id
     * @param name hotel name
     * @param address hotel address
     * @param phoneNumber hotel phone number
     */
    public Hotel(long id, String name, String address, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        rooms = new ArrayList<>();
    }

    /**
     * Adds new room to the hotel
     * 
     * @param room room to add
     * @return true if success, false otherwise
     */
    public boolean addRoom(Room room) {
        return rooms.add(room);
    }

    /**
     * Removes room from the hotel
     * 
     * @param room room to remove
     * @return true if success, false otherwise
     */
    public boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    /**
     * Returns room list of current hotel
     * 
     * @return room list
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets hotel id
     * 
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns hotel id
     * 
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets hotel name
     * 
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns hotel name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets hotel address
     * 
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns hotel address 
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets hotel phone number
     * 
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns hotel phone number
     * 
     * @return phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Hotel) {
            return id == ((Hotel)object).getId();
        }
        return false;
    }

    @Override
    public String toString() {
        return "bookingmanager.entity.Hotel[ id=" + id + " ]";
    }
};
