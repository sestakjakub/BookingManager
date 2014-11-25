package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.BookingDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Booking;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Robert
 */
@Repository
public class BookingDAOImpl implements BookingDAO {

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
    public void persistBooking(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    @Transactional
    public Booking getBookingById(long id) {
        Query query = entityManager.createNativeQuery("select * from booking where id = :id", Booking.class);
        query.setParameter("id", id);

        Booking booking = (Booking) query.getSingleResult();
        return booking;
    }

    @Override
    @Transactional
    public Booking mergeBooking(Booking booking) {
        Booking mergedBooking = entityManager.merge(booking);

        return mergedBooking;
    }

    @Override
    @Transactional
    public void removeBooking(Booking booking) {
        Booking mergedBooking = this.mergeBooking(booking);
        entityManager.remove(mergedBooking);
    }

    @Override
    @Transactional
    public List<Booking> getAllBookings() {
        Query query = entityManager.createNativeQuery("select * from booking", Booking.class);

        return query.getResultList();
    }
}
