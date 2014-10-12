/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Robert Golej
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    
    public Customer() {}
    
    public Customer(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookings = new ArrayList<Booking>();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "address")
    private String address;
    
    @OneToMany
    private List<Booking> bookings;

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
    // Beware of param id, it's an index of position in the list, not the booking ID
    public Booking getBookingById(int id){
        return bookings.get(id);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Consider "return Long.hashCode(id);", it presumes id of type long instead of Long
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookingmanager.entity.Cutomer[ id=" + id + " ]";
    }
    
}
