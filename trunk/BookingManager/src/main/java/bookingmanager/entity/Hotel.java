package bookingmanager.entity;


/**
 *
 * @author Jiří Kareš
 */
public interface Hotel {
    public boolean addRoom(Room room);
    public boolean removeRoom(Room room);
    public Room getRoom(int roomId);
    
    public void setId(int id);
    public int getId();
    
    public void setName(String name);
    public String getName();
    
    public void setAddress(String address);
    public String getAddress();
    
    public void setPhoneNumber(int phoneNumber);
    public int getPhoneNumber();
}
