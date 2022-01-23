package pl.polsl.controllers;

import pl.polsl.entities.RegistryEntry;

import javax.persistence.*;
import java.util.List;

/**
 * Database communication controller.
 * @author Jakub Cisowski
 * @version 1.0
 */
public class DatabaseController {

    private final EntityManagerFactory entityManagerFactory;

    public DatabaseController() {
        entityManagerFactory = Persistence.createEntityManagerFactory("TextCompressionProd");
    }

    public void persistObject(Object object) {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(object);
            em.getTransaction().commit();
            System.out.println("Object persisted");
        }
        catch (PersistenceException ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }

    public void findObjects() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        try {
            Query query = em.createQuery("SELECT h FROM RegistryEntry h");
            List<RegistryEntry> entries = query.getResultList();
        }
        catch (PersistenceException ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }

    public void updateObject(RegistryEntry newObject) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        try {
            String newResult = newObject.getResult();
            long objId = newObject.getId();

            Query query = em.createQuery("UPDATE RegistryEntry h SET h.result = ?1 WHERE h.id = ?2");
        }
        catch (PersistenceException ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }

}