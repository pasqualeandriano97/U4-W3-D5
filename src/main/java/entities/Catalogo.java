package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalogo {
    @Id
    protected long codiceISBN;
    protected String titolo;
    protected int annoDiPubblicazione;
    protected int numeroPagine;
    @OneToOne(mappedBy = "elementoPrestato")
    protected Prestito prestito;

    public Catalogo() {
    }

    public Catalogo(long codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}

