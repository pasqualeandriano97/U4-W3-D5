package entities;
import enums.periodicità;
import jakarta.persistence.Entity;


@Entity
public class Rivista extends Catalogo {
    private periodicità periodicità;


    public Rivista(long codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, periodicità periodicità) {
        super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }
}
