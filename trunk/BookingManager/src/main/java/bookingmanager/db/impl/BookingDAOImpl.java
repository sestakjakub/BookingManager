package bookingmanager.db.impl;

import bookingmanager.db.BookingDAO;
import bookingmanager.entity.Booking;
import bookingmanager.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Robert
 */
public class BookingDAOImpl implements BookingDAO {
    
    private EntityManager entityManager;
    
    public BookingDAOImpl(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookingManager");
        entityManager = emf.createEntityManager();
    }
    @Override
    public void persistBooking(Booking booking) {
        entityManager.getTransaction().begin();
        entityManager.persist(booking);
        entityManager.getTransaction().commit();
    }

    @Override
    public Booking getBookingById(long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from customer where id = :id", Booking.class);
        query.setParameter("id", id);
        entityManager.getTransaction().commit();
        
        Booking booking = (Booking) query.getSingleResult();
        return booking;
    }

    @Override
    public Booking mergeBooking(Booking booking) {
        entityManager.getTransaction().begin();
        
        Booking mergedBooking = entityManager.merge(booking);
        
        entityManager.getTransaction().commit();
        
        return mergedBooking;
    }

    @Override
    public void removeCustomer(Booking booking) {
        entityManager.getTransaction().begin();
        
        entityManager.remove(booking);
        
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Booking> getAllBooking() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from customer", Customer.class);
        entityManager.getTransaction().commit();
        
        return query.getResultList();
    }
    
}
