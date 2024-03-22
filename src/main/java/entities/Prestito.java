package entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prestito {
    @Id
    @GeneratedValue
    private long codicePrestito;

    @ManyToOne
    @JoinColumn(name = "utente_numeroDiTessera")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "catalogo_codiceISBN")

    public Catalogo elementoPrestato;
    private Date dataInizio;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;


    public Prestito(Utente utente, Catalogo elementoPrestato, Date dataInizio, Date dataRestituzionePrevista, Date dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }


}
