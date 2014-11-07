package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.BookingDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import cz.muni.fi.pa165.bookingmanager.utils.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robert
 */
@Repository
public class BookingDAOImpl implements BookingDAO {
    
    private EntityManager entityManager;
    
    public BookingDAOImpl(){
        entityManager = EntityManagerSingleton.getInstance();
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
        Query query = entityManager.createNativeQuery("select * from booking where id = :id", Booking.class);
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
    public void removeBooking(Booking booking) {
        entityManager.getTransaction().begin();
        
        entityManager.remove(booking);
        
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Booking> getAllBookings() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from booking", Booking.class);
        entityManager.getTransaction().commit();
        
        return query.getResultList();
    }

}
