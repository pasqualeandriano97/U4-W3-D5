package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Utente {
    private String nome;
    private String cognome;
    private Date dataNascita;
    @Id
    @GeneratedValue
    private long numeroDiTessera;
    @OneToMany(mappedBy = "utente")

    private List<Prestito> catalogo;

    public Utente() {
    }

    public Utente(String nome, String cognome, Date dataNascita, long numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroDiTessera = numeroDiTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }
}
