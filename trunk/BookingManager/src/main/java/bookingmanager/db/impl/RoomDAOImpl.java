package bookingmanager.db.impl;

import bookingmanager.db.RoomDAO;
import bookingmanager.entity.Room;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Class RoomDAOImpl
 * 
 * @author Jiří Kareš
 */
public class RoomDAOImpl implements RoomDAO {

    private EntityManager em;
    
    /**
     * Default constructor
     */
    public RoomDAOImpl()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookingManager");
        em = emf.createEntityManager();
    };

    @Override
    public List<Room> getAllRooms() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from room", Room.class);
        em.getTransaction().commit();
        
        return query.getResultList();
    }

    @Override
    public void persistRoom(Room room) {
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
    }

    @Override
    public Room getRoomById(long id) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from room where id = :id", Room.class);
        query.setParameter("id", id);
        em.getTransaction().commit();
        
        return (Room) query.getSingleResult();
    }

    @Override
    public Room merge(Room room) {
        em.getTransaction().begin();
        Room mergedRoom = em.merge(room);
        em.getTransaction().commit();
        
        return mergedRoom;
    }

    @Override
    public void remove(Room room) {
        em.getTransaction().begin();
        em.remove(room);
        em.getTransaction().commit();
    }

}
