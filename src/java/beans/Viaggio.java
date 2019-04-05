/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author checc_000
 */
public class Viaggio {
    
    private int id;
    private String citta_partenza;
    private String citta_destinazione;
    private String data_partenza;
    private String ora_partenza;
    private float prezzo;
    private String tempi_stimati;//(In ore)
    private String info_aggiuntive;
    private String email_autista;

    public Viaggio(int id, String citta_partenza, String citta_destinazione, String data_partenza, String ora_partenza, int prezzo, String tempi_stimati, String info_aggiuntive, String email_autista) {
        this.id = id;
        this.citta_partenza = citta_partenza;
        this.citta_destinazione = citta_destinazione;
        this.data_partenza = data_partenza;
        this.ora_partenza = ora_partenza;
        this.prezzo = prezzo;
        this.tempi_stimati = tempi_stimati;
        this.info_aggiuntive = info_aggiuntive;
        this.email_autista = email_autista;
    }

    public Viaggio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCitta_partenza() {
        return citta_partenza;
    }

    public void setCitta_partenza(String citta_partenza) {
        this.citta_partenza = citta_partenza;
    }

    public String getCitta_destinazione() {
        return citta_destinazione;
    }

    public void setCitta_destinazione(String citta_destinazione) {
        this.citta_destinazione = citta_destinazione;
    }

    public String getData_partenza() {
        return data_partenza;
    }

    public void setData_partenza(String data_partenza) {
        this.data_partenza = data_partenza;
    }

    public String getOra_partenza() {
        return ora_partenza;
    }

    public void setOra_partenza(String ora_partenza) {
        this.ora_partenza = ora_partenza;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getTempi_stimati() {
        return tempi_stimati;
    }

    public void setTempi_stimati(String tempi_stimati) {
        this.tempi_stimati = tempi_stimati;
    }

    public String getInfo_aggiuntive() {
        return info_aggiuntive;
    }

    public void setInfo_aggiuntive(String info_aggiuntive) {
        this.info_aggiuntive = info_aggiuntive;
    }

    public String getEmail_autista() {
        return email_autista;
    }

    public void setEmail_autista(String email_autista) {
        this.email_autista = email_autista;
    }

    
    
}
