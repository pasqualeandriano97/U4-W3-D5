package andrianoPasquale97;

import DAO.CatalogoDAO;
import DAO.PrestitiDAO;
import DAO.UtenteDAO;
import com.github.javafaker.Faker;
import entities.*;
import enums.periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Random;

public class Application {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    public static void main(String[] args) {
       EntityManager em = emf.createEntityManager();
       Faker faker = new Faker();
       Random ran = new Random();
       CatalogoDAO catalogoDAO = new CatalogoDAO(em);
       UtenteDAO utenteDAO = new UtenteDAO(em);
       PrestitiDAO prestitoDAO = new PrestitiDAO(em);


//       for (int i = 0; i < 10; i++) {
//          Libro libro= new Libro(Long.parseLong(faker.code().isbn10()), faker.book().title(),ran.nextInt(1900,2024) ,
//                  ran.nextInt(1,100),faker.book().author(), faker.book().genre());
//          catalogoDAO.saveCatalogo(libro);
//       }
//        for (int i = 0; i < 10; i++) {
//            Rivista rivista= new Rivista(Long.parseLong(faker.code().isbn13()), faker.book().title(),ran.nextInt(1900,2024) ,
//                    ran.nextInt(1,100), periodicità.values()[ran.nextInt(0, periodicità.values().length)]);
//            catalogoDAO.saveCatalogo(rivista);
//        }
//        for (int i = 0; i < 10; i++) {
//            Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(), ran.nextLong(1,10000000L));
//            Utente utenteMerged = em.merge(utente);
//            utenteDAO.saveUtente(utenteMerged);
//        }
//        (Utente utente, Catalogo elementoPrestato, Date dataInizio, Date dataRestituzionePrevista, Date dataRestituzioneEffettiva)
//        Utente utente= utenteDAO.findUtenteByTessera(1);
//        Catalogo elementoPrestato = catalogoDAO.findCatalogoByISBN(25725734);
//        Prestito prestito = new Prestito(utente, elementoPrestato, faker.date().birthday(), faker.date().birthday());
//        prestitoDAO.savePrestito(prestito);
        catalogoDAO.findCatalogoByNameAndDelete(25725734);
        System.out.println("Elemento del catalogo per isbn"+catalogoDAO.findCatalogoByISBNQ(35172908));
        System.out.println("Elemento del catalogo per anno di pubblicazione"+catalogoDAO.findCatalogoByYear(2016));
        System.out.println("Elemento del catalogo per autore"+catalogoDAO.findCatalogoByAuthor("Val Bednar"));
        System.out.println("Elemento del catalogo per autore"+catalogoDAO.findCatalogoByTitle("now"));

    }
}
