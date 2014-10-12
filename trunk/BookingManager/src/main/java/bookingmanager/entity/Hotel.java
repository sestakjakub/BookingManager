package bookingmanager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany
    private List<Room> rooms;

    /**
     * Default Hotel constructor, sets hotel id to 0.
     */
    public Hotel() {
    }

    /**
     * Hotel constructor
     * 
     * @param id hotel id
     * @param name hotel name
     * @param address hotel address
     * @param phoneNumber hotel phone number
     */
    public Hotel(String name, String address, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        rooms = new ArrayList<>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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
        int hash = 5;
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
        final Hotel other = (Hotel) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookingmanager.entity.Hotel[ id=" + id + " ]";
    }
};
