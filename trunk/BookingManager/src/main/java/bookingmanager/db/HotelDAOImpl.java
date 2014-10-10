package bookingmanager.db;

import bookingmanager.entity.Hotel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kupker
 */
public class HotelDAOImpl implements HotelDAO {

    private EntityManager em;

    @Override
    public List<Hotel> getAllHotels() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from hotels", Hotel.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public void persist(Hotel hotel) {
        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();
    }

}
