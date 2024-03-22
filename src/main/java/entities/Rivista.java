package entities;
import enums.periodicità;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    private periodicità periodicità;


    public Rivista(long codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, periodicità periodicità) {
        super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }
}
