package bookingmanager.entity;


/**
 *
 * @author Jiří Kareš
 */
public interface Room {
    public void setId(int id);
    public int getId();
    
    public void setRoomNumber(int n);
    public int getRoomNumber();
    
    public void setHotel(Hotel hotel);
    public Hotel getHotel();
    
    public void setCapacity(int capacity);
    public int getCapacity();
    
    public void setPrice(int price);
    public int getPrice();
    
//    public boolean addBooking(Booking booking);
//    public boolean removeBooking(Booking booking);
//    public Booking getBooking(int id);
}
