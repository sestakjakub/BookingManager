package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import cz.muni.fi.pa165.bookingmanager.utils.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class HotelDAOImpl
 * 
 * @author JiĹ™Ă­ KareĹˇ
 */
@Repository
public class HotelDAOImpl implements HotelDAO {

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
    public List<Hotel> getAllHotels() {
        Query query = entityManager.createNativeQuery("select * from hotel", Hotel.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void persistHotel(Hotel hotel) {
        entityManager.persist(hotel);
    }

    @Override
    @Transactional
    public Hotel findHotel(long id) {
        Query query = entityManager.createNativeQuery("select * from hotel where id = :id", Hotel.class);
        query.setParameter("id", id);

        return (Hotel) query.getSingleResult();
    }

    @Override
    @Transactional
    public Hotel mergeHotel(Hotel hotel) {
        Hotel mergedHotel = entityManager.merge(hotel);

        return mergedHotel;
    }

    @Override
    @Transactional
    public void removeHotel(Hotel hotel) {
        Hotel mergedHotel = this.mergeHotel(hotel);
        entityManager.remove(mergedHotel);
    }

}
