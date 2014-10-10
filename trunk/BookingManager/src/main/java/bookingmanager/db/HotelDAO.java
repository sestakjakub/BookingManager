package bookingmanager.db;

import bookingmanager.entity.Hotel;
import java.util.List;

/**
 *
 * @author Kupker
 */
public interface HotelDAO {
    public List<Hotel> getAllHotels();
    public void persist(Hotel hotel);
}
