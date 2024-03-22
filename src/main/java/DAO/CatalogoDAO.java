package DAO;

import entities.Catalogo;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
    public Catalogo findCatalogoByISBN(long isbn) {
        Catalogo catalogo = em.find(Catalogo.class, isbn);
        return catalogo;
    }
    public void findCatalogoByNameAndDelete(long ISBN){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Query deleteQuery = em.createQuery("DELETE FROM Catalogo a WHERE a.codiceISBN = :ISBN");
        deleteQuery.setParameter("ISBN", ISBN);
        deleteQuery.executeUpdate();
        transaction.commit();
        System.out.println("Elemento catalogo eliminato con successo");
    }
    public List<Catalogo> findCatalogoByISBNQ(long ISBN){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Catalogo> searchQuery = em.createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN=:ISBN", Catalogo.class);

        searchQuery.setParameter("ISBN", ISBN);
        return searchQuery.getResultList();

    }
}
