package DAO;


import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void saveUtente(Utente utente) {
        EntityTransaction transaction = em.getTransaction();


        transaction.begin();
        em.persist(utente);
        transaction.commit();

        System.out.println("Utente salvato con successo");
    }

    public Utente findUtenteByTessera(long tessera) {
        Utente utente = em.find(Utente.class, tessera);
        return utente;
    }
}
