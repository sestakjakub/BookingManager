package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.RoomDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Room;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class RoomDAOImpl
 * 
 * @author JiĹ™Ă­ KareĹˇ
 */
@Repository
public class RoomDAOImpl implements RoomDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Room> getAllRooms() {
        Query query = entityManager.createNativeQuery("select * from room", Room.class);
        
        return query.getResultList();
    }

    @Override
    @Transactional
    public void persistRoom(Room room) {
        entityManager.persist(room);
    }

    @Override
    @Transactional
    public Room getRoomById(long id) {
        Query query = entityManager.createNativeQuery("select * from room where id = :id", Room.class);
        query.setParameter("id", id);
        
        return (Room) query.getSingleResult();
    }

    @Override
    @Transactional
    public Room mergeRoom(Room room) {
        Room mergedRoom = entityManager.merge(room);
        return mergedRoom;
    }

    @Override
    @Transactional
    public void removeRoom(Room room) {
        Room mergedRoom = this.mergeRoom(room);
        entityManager.remove(mergedRoom);
    }

}
