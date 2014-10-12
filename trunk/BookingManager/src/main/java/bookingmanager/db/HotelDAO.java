package bookingmanager.db;

import bookingmanager.entity.Hotel;
import java.util.List;

/**
 *
 * @author Kupker
 */
public interface HotelDAO {
    public List<Hotel> getAllHotels();
    public void persistHotel(Hotel hotel);
    public Hotel getHotelById(long id);
    public Hotel mergeHotel(Hotel hotel);
    public void removeHotel(Hotel hotel);
}
