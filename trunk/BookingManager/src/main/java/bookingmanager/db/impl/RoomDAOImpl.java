package bookingmanager.db.impl;

import bookingmanager.db.RoomDAO;
import bookingmanager.entity.Room;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class RoomDAOImpl implements RoomDAO {

    private EntityManager em;

    @Override
    public List<Room> getAllRooms() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from rooms", Room.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public void persist(Room room) {
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
    }
    
}
