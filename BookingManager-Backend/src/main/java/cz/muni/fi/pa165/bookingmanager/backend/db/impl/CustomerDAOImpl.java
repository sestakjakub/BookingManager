/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.CustomerDAO;
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
 * DAO class of customer entity.
 *
 * @author Robert
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persistCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        Query query = entityManager.createNativeQuery("select * from customer where id = :id", Customer.class);
        query.setParameter("id", id);

        Customer customer = (Customer) query.getSingleResult();
        return customer;
    }

    @Override
    public Customer mergeCustomer(Customer customer) {

        Customer mergedCustomer = entityManager.merge(customer);


        return mergedCustomer;
    }

    @Override
    public void removeCustomer(Customer customer) {

        entityManager.remove(customer);

    }

    @Override
    public List<Customer> getAllCustomers() {

        Query query = entityManager.createNativeQuery("select * from customer", Customer.class);

        return query.getResultList();
    }
}
