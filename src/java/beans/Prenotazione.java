package beans;

import java.util.Date;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class Prenotazione {
    
    private boolean accettazione;
    private String codice;
    private String data;
    /**
     * Metodo costruttore per la creazione della prenotazione.
     * @param accettazione booleano che indica se la prenotazione è stata accettata dall'autista o meno
     * @param codice codice identificativo della prenotazione
     * @param data data della prenotazione
     */
    public Prenotazione(boolean accettazione, String codice, String data) {
        this.accettazione = accettazione;
        this.codice = codice;
        this.data = data;
    }
    /**
     * Metodo costruttore di default.
     */
    public Prenotazione() {
        
    }
    /**
     * Metodo che ritorna accettazione.
     * @return true se la prenotazione è stata accettata, false altrimenti
     */
    public boolean isAccettazione() {
        return accettazione;
    }   
    /**
     * Metodo setter che imposta il valore di accettazione.
     * @param accettazione booleano che indica se la prenotazione è stata accettata
     */
    public void setAccettazione(boolean accettazione) {
        this.accettazione = accettazione;
    }
    /**
     * Metodo getter che ritorna il codice della prenotazione.
     * @return stringa del codice della prenotazione
     */
    public String getCodice() {
        return codice;
    }
    /**
     * Metodo setter per il codice della prenotazione.
     * @param codice stringa univoca della prenotazione
     */
    public void setCodice(String codice) {
        this.codice = codice;
    }
    /**
     * Metodo che consente di ottenere la data della prenotazione.
     * @return data della prenotazione
     */
    public String getData() {
        return data;
    }
    /**
     * Metodo che consente di impostare la data della prenotazione.
     * @param data data della prenotazione
     */
    public void setData(String data) {
        this.data = data;
    }
    
}
