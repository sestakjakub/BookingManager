package bookingmanager.db;

import bookingmanager.entity.Room;
import java.util.List;

/**
 * Interface RoomDAO
 * 
 * @author Jiří Kareš
 */
public interface RoomDAO {

    /**
     * Returns list of rooms
     * @return rooms
     */
    public List<Room> getAllRooms();
    
    /**
     * Persists room
     * @param room room
     */
    public void persistRoom(Room room);
    
    /**
     * Returns room of given id, if exists
     * @param id room id
     * @return room
     */
    public Room getRoomById(long id);
    
    /**
     * Merges room
     * @param room room to be merged
     * @return Room merged room
     */
    public Room mergeRoom(Room room);
    
    /**
     * Removes room
     * @param room to be removed
     */
    public void removeRoom(Room room);
}