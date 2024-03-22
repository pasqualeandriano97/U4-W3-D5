package andrianoPasquale97;

import DAO.CatalogoDAO;
import com.github.javafaker.Faker;
import entities.Catalogo;
import entities.Libro;
import entities.Rivista;
import entities.Utente;
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

//       for (int i = 0; i < 10; i++) {
//          Libro libro= new Libro(Long.parseLong(faker.code().isbn13()), faker.book().title(),ran.nextInt(1900,2024) ,
//                  ran.nextInt(1,100),faker.book().author(), faker.book().genre());
//          catalogoDAO.saveCatalogo(libro);
//       }
//        for (int i = 0; i < 10; i++) {
//            Rivista rivista= new Rivista(Long.parseLong(faker.code().isbn13()), faker.book().title(),ran.nextInt(1900,2024) ,
//                    ran.nextInt(1,100), periodicità.values()[ran.nextInt(0, periodicità.values().length)]);
//            catalogoDAO.saveCatalogo(rivista);
//        }
        for (int i = 0; i < 10; i++) {
            Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(), ran.nextLong(1,1000000000000000L));

        }
    }
}
