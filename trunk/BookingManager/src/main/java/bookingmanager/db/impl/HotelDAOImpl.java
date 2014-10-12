package bookingmanager.db.impl;

import bookingmanager.db.HotelDAO;
import bookingmanager.entity.Hotel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Class HotelDAOImpl
 * 
 * @author Jiří Kareš
 */
public class HotelDAOImpl implements HotelDAO {

    private EntityManager em;

    /**
     * Default constructor
     */
    public HotelDAOImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookingManager");
        em = emf.createEntityManager();
    }

    @Override
    public List<Hotel> getAllHotels() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from hotel", Hotel.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public void persistHotel(Hotel hotel) {
        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();
    }

    @Override
    public Hotel getHotelById(long id) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from hotel where id = :id", Hotel.class);
        query.setParameter("id", id);
        em.getTransaction().commit();

        return (Hotel) query.getSingleResult();
    }

    @Override
    public Hotel mergeHotel(Hotel hotel) {
        em.getTransaction().begin();
        Hotel mergedHotel = em.merge(hotel);
        em.getTransaction().commit();

        return mergedHotel;
    }

    @Override
    public void removeHotel(Hotel hotel) {
        em.getTransaction().begin();
        em.remove(hotel);
        em.getTransaction().commit();
    }

}
