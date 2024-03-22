package entities;

import jakarta.persistence.*;

import java.util.Calendar;
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

    public Prestito() {
    }

    public Prestito(Utente utente, Catalogo elementoPrestato, Date dataInizio, Date dataRestituzioneEffettiva) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInizio);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = cal.getTime();
        this.dataRestituzioneEffettiva = dataInizio.after(dataRestituzioneEffettiva) ? dataInizio : dataRestituzioneEffettiva;
    }


}
