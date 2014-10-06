/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingmanager.entity;

import bookingmanager.db.EntityExampleDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Robert
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
        EntityExampleDAO entityExampleDAO = new EntityExampleDAO(emf);

        EntityExample example = new EntityExample();
        example.setFirstName("Robert");
        example.setLastName("Golej");
        example.setAddress("Doma");

        entityExampleDAO.persistExample(example);

        List<EntityExample> exampleList = entityExampleDAO.getAllExamples();
        System.out.print(exampleList.get(0).toString());

        emf.close();
    }
}
