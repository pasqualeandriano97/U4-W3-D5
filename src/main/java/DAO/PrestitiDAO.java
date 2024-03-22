package DAO;

import entities.Prestito;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitiDAO {
    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }

    public void savePrestito(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();


        transaction.begin();
        em.persist(prestito);
        transaction.commit();

        System.out.println("Prestito salvato con successo");
    }
}
