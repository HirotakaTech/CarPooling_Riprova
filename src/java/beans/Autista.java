/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author checc_000
 */
public class Autista extends Utente{
    
    private int numero_posti;
    private String data_scadenza_patente;
    private String foto; //URL
    private String numero_patente;
    private String targa_auto;
    private String modello_auto;

    public Autista(int numero_posti, String data_scadenza_patente, String foto, String numero_patente, String targa_auto, String modello_auto) {
        this.numero_posti = numero_posti;
        this.data_scadenza_patente = data_scadenza_patente;
        this.foto = foto;
        this.numero_patente = numero_patente;
        this.targa_auto = targa_auto;
        this.modello_auto = modello_auto;
    }
    
    public Autista(){
        
    }

    public int getNumero_posti() {
        return numero_posti;
    }

    public void setNumero_posti(int numero_posti) {
        this.numero_posti = numero_posti;
    }

    public String getData_scadenza_patente() {
        return data_scadenza_patente;
    }

    public void setData_scadenza_patente(String data_scadenza_patente) {
        this.data_scadenza_patente = data_scadenza_patente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNumero_patente() {
        return numero_patente;
    }

    public void setNumero_patente(String numero_patente) {
        this.numero_patente = numero_patente;
    }

    public String getTarga_auto() {
        return targa_auto;
    }

    public void setTarga_auto(String targa_auto) {
        this.targa_auto = targa_auto;
    }

    public String getModello_auto() {
        return modello_auto;
    }

    public void setModello_auto(String modello_auto) {
        this.modello_auto = modello_auto;
    }
    
    
    
}
