/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.bookingmanager.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Robert
 */
public class EntityManagerSingleton {
    private static EntityManager entityManager = null;
    
    public static EntityManager getInstance() {
      if(entityManager == null) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookingManager");
          entityManager = emf.createEntityManager();
      }
      return entityManager;
   }
}
