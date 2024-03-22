package entities;


import jakarta.persistence.Entity;

@Entity
public class Libro extends Catalogo {
    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(long codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine) {
        super(codiceISBN, titolo, annoDiPubblicazione, numeroPagine);
    }

    public Libro(long codiceISBN, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN,titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +

                '}';
    }
}
