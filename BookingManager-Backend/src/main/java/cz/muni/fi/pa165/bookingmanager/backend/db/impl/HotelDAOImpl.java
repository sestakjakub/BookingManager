package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.HotelDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Hotel;
import cz.muni.fi.pa165.bookingmanager.utils.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * Class HotelDAOImpl
 * 
 * @author JiĹ™Ă­ KareĹˇ
 */
@Repository
public class HotelDAOImpl implements HotelDAO {

    private EntityManager entityManager;

    /**
     * Default constructor
     */
    public HotelDAOImpl() {
        entityManager = EntityManagerSingleton.getInstance();
    }

    @Override
    public List<Hotel> getAllHotels() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from hotel", Hotel.class);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public void persistHotel(Hotel hotel) {
        entityManager.getTransaction().begin();
        entityManager.persist(hotel);
        entityManager.getTransaction().commit();
    }

    @Override
    public Hotel getHotelById(long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from hotel where id = :id", Hotel.class);
        query.setParameter("id", id);
        entityManager.getTransaction().commit();

        return (Hotel) query.getSingleResult();
    }

    @Override
    public Hotel mergeHotel(Hotel hotel) {
        entityManager.getTransaction().begin();
        Hotel mergedHotel = entityManager.merge(hotel);
        entityManager.getTransaction().commit();

        return mergedHotel;
    }

    @Override
    public void removeHotel(Hotel hotel) {
        entityManager.getTransaction().begin();
        entityManager.remove(hotel);
        entityManager.getTransaction().commit();
    }

}
