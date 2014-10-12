package bookingmanager.db;

import bookingmanager.entity.Hotel;
import java.util.List;

/**
 * Interface HotelDAO
 * 
 * @author Jiří Kareš
 */
public interface HotelDAO {

    /**
     * Returns list of all hotels
     * 
     * @return hotels
     */
    public List<Hotel> getAllHotels();

    /**
     * Persists hotel
     * 
     * @param hotel hotel
     */
    public void persistHotel(Hotel hotel);

    /**
     * Returns hotel of given id, if exists
     * 
     * @param id hotel id
     * @return hotel
     */
    public Hotel getHotelById(long id);

    /**
     * Merges hotel
     * 
     * @param hotel hotel to be merged
     * @return merged hotel
     */
    public Hotel mergeHotel(Hotel hotel);

    /**
     * Removes hotel
     * 
     * @param hotel hotel to be removed
     */
    public void removeHotel(Hotel hotel);
}
