/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.backend.db.impl;

import cz.muni.fi.pa165.bookingmanager.backend.db.CustomerDAO;
import cz.muni.fi.pa165.bookingmanager.backend.entity.Customer;
import cz.muni.fi.pa165.bookingmanager.utils.EntityManagerSingleton;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * DAO class of customer entity.
 * 
 * @author Robert
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    
    private EntityManager entityManager;
    
    public CustomerDAOImpl() {
        entityManager = EntityManagerSingleton.getInstance();
    }

    @Override
    public void persistCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }
    
    @Override
    public Customer getCustomerById(long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from customer where id = :id", Customer.class);
        query.setParameter("id", id);
        entityManager.getTransaction().commit();
        
        Customer customer = (Customer) query.getSingleResult();
        return customer;
    }
    
    @Override
    public Customer mergeCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        
        Customer mergedCustomer = entityManager.merge(customer);
        
        entityManager.getTransaction().commit();
        
        return mergedCustomer;
    }

    @Override
    public void removeCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        
        entityManager.remove(customer);
        
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Customer> getAllCustomers() {
        
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("select * from customer", Customer.class);
        entityManager.getTransaction().commit();
        
        return query.getResultList();
    }
    
}
