package entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;

public class Prestito {

    @ManyToOne
    @JoinColumn(name = "utente_numeroDiTessera")
    private Utente utente;

    @OneToMany
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
