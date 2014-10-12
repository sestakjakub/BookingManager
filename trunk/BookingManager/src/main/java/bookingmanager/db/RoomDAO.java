package bookingmanager.db;

import bookingmanager.entity.Room;
import java.util.List;

/**
 *
 * @author Kupker
 */
public interface RoomDAO {
    public List<Room> getAllRooms();
    public void persistRoom(Room room);
    public Room getRoomById(long id);
    public Room merge(Room room);
    public void remove(Room room);
}