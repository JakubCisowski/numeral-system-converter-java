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
        entityManagerFactory = Persistence.createEntityManagerFactory("NumeralSystemConverterProd");
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
            String newInputNumber = newObject.getInputNumber();
            String newInputSystem = newObject.getInputSystem();
            String newOutputNumber = newObject.getOutputNumber();
            String newOutputSystem = newObject.getOutputSystem();
            long objId = newObject.getId();

            Query query = em.createQuery("UPDATE RegistryEntry h SET h.inputnumber = ?1 WHERE h.id = ?2");
            Query query2 = em.createQuery("UPDATE RegistryEntry h SET h.inputsystem = ?1 WHERE h.id = ?2");
            Query query3 = em.createQuery("UPDATE RegistryEntry h SET h.outputnumber = ?1 WHERE h.id = ?2");
            Query query4 = em.createQuery("UPDATE RegistryEntry h SET h.outputsystem = ?1 WHERE h.id = ?2");
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