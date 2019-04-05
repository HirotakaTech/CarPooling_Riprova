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
public class Utente {
    protected String email;
    protected String password;
    protected String nome;
    protected String cognome;
    protected String data_nascita;
    protected String luogo;
    protected String telefono;

    public Utente(String email, String password, String nome, String cognome, 
            String data_nascita, String luogo, String telefono) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.luogo = luogo;
        this.telefono = telefono;
    }

    public Utente(){
        email = "";
        password = "";
        nome = "";
        cognome = "";
        luogo = "";
        telefono = "";
        data_nascita = "";
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(String data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
