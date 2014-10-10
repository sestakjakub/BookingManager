/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.db.impl;

import bookingmanager.db.CustomerDAO;
import bookingmanager.entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * DAO class of customer entity.
 * 
 * @author Robert
 */
@Stateless
public class CustomerDAOImpl implements CustomerDAO {
    
    private EntityManager entityManager;
    
    public CustomerDAOImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookingManager");
        entityManager = emf.createEntityManager();
    }

    @Override
    public void persistCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
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
        entityManager.getTransaction().begin();
        
        Customer mergedCustomer = entityManager.merge(customer);
        
        entityManager.getTransaction().commit();
        
        return mergedCustomer;
        
    }
}
