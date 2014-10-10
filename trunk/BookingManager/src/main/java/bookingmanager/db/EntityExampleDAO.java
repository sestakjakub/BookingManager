/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import bookingmanager.entity.EntityExample;
import javax.persistence.Query;

/**
 *
 * @author Robert
 */
public class EntityExampleDAO {
    
    private EntityManager em;
    
    public EntityExampleDAO(EntityManagerFactory emf){
        em = emf.createEntityManager();
    }
    
    public List<EntityExample> getAllExamples(){
        em.getTransaction().begin();
        Query query =  em.createNativeQuery("select * from example", EntityExample.class);
        em.getTransaction().commit();
        return query.getResultList();  
    }
    
    public void persistExample(EntityExample example){
        em.getTransaction().begin();
        em.persist(example);
        em.getTransaction().commit();
    }
}
