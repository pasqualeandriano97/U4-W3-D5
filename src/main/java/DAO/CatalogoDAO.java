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
        transaction.commit();
        return searchQuery.getResultList();

    }
    public List<Catalogo> findCatalogoByYear(long anno){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Catalogo> searchQuery = em.createQuery("SELECT c FROM Catalogo c WHERE c.annoDiPubblicazione=:anno", Catalogo.class);

        searchQuery.setParameter("anno", anno);
        transaction.commit();
        return searchQuery.getResultList();

    }
    public List<Catalogo> findCatalogoByAuthor(String autore){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Catalogo> searchQuery = em.createQuery("SELECT l FROM Libro l WHERE l.autore=:autore", Catalogo.class);

        searchQuery.setParameter("autore", autore);
        transaction.commit();
        return searchQuery.getResultList();

    }
    public List<Catalogo> findCatalogoByTitle(String titolo){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Catalogo> searchQuery = em.createQuery("SELECT l FROM Libro l WHERE  LOWER(l.titolo) LIKE LOWER(:titolo)", Catalogo.class);

        searchQuery.setParameter("titolo", titolo+"%");
        transaction.commit();
        return searchQuery.getResultList();

    }
}
