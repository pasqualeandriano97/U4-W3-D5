package entities;


import jakarta.persistence.Entity;

@Entity
public class Libro extends Catalogo {
    private String autore;
    private String genere;


    public Libro(long codiceISBN,String titolo,int annoDiPubblicazione,int numeroPagine,String autore, String genere) {
        super(codiceISBN,titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
