package DAO;

import entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CatalogoDAO {
    private final EntityManager em;
    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }
    public void saveCatalogo(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();

        System.out.println("Elemento catalogo salvato con successo");
    }

}
