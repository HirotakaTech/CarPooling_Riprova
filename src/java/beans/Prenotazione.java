package beans;

import java.util.Date;

/**
 *
 * @author Bartelloni-Bellezza
 */
public class Prenotazione {
    
    private boolean accettazione;
    private String codice;
    private String data;

    public Prenotazione(boolean accettazione, String codice, String data) {
        this.accettazione = accettazione;
        this.codice = codice;
        this.data = data;
    }

    public Prenotazione() {
        
    }

    public boolean isAccettazione() {
        return accettazione;
    }

    public void setAccettazione(boolean accettazione) {
        this.accettazione = accettazione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
