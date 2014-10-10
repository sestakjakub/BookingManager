package bookingmanager.db;

import bookingmanager.entity.Room;
import java.util.List;

/**
 *
 * @author Kupker
 */
public interface RoomDAO {
    public List<Room> getAllRooms();
    public void persist(Room room);
}