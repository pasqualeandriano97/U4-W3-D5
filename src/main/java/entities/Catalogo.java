package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Catalogo {
    @Id
    protected long codiceISBN;
    protected String titolo;
    protected int annoDiPubblicazione;
    protected int numeroPagine;
    @OneToMany(mappedBy = "catalogo")
    protected List<Prestito> prestiti;

    public Catalogo(long codiceISBN,String titolo, int annoDiPubblicazione, int numeroPagine) {
    }
}

