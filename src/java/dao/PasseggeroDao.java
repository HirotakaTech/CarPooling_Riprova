package dao;

import beans.Utente;
import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che si occupa di gestire i dati relativi ai Passeggeri
 *
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class PasseggeroDao {

    /**
     * Metodo che inserisce un passeggero all'interno del database a partire da
     * l'email e il documento
     *
     * @param email L'email del Passeggero
     * @param documento Il numero di Documento del Passeggero
     * @return esito dell'insert
     */
    public boolean insertPasseggero(String email, String documento) {
        boolean ok = true;
        String sql = "insert into Passeggeri VALUES(?,?)";
        Connection con = null;
        try {
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, documento);
            st.execute();
        } catch (ClassNotFoundException | SQLException e) {
            ok = false;
            throw new EccezioneDati("Impossibile inserire informazioni del passeggero. Riprovare");
        } finally {
            Dao.closeConnection();
        }
        return ok;
    }

    /**
     * Metodo che permette di sapere se un determinato Utente è un passeggero
     *
     * @param email Email dell'utente
     * @return True se è un passeggero, False altrimenti
     */
    public boolean isPasseggero(String email) {
        boolean found = false;
        Utente ute = null;
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Passeggeri.* from Passeggeri where Passeggeri.email='" + email + "'");
            if (rs.next()) {
                found = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile inserire informazioni del passeggero. Riprovare");
        } finally {
            Dao.closeConnection();
        }
        return found;
    }

}
