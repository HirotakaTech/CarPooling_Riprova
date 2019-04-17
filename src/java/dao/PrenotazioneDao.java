package dao;

import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che si occupa di gestire i dati relativi alle Prenotazioni all'interno
 * del database
 *
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class PrenotazioneDao {

    /**
     * Metodo per l'inserimento delle Prenotazioni all'interno del DB
     *
     * @param idViaggio Id del viaggio che si prenota
     * @param email Email del Passeggero che prenota
     * @return esito dell'insert
     */
    public boolean insertPrenotazioni(int idViaggio, String email) {
        boolean ok = true;
        String sqlInsertPrenotazione = "insert into Prenotazioni VALUES(?,?,?,?,?)";
        String codice = generaCodice(idViaggio, email);
        Connection con = null;
        try {
            con = Dao.getConnection();
            PreparedStatement pr = con.prepareStatement(sqlInsertPrenotazione);
            pr.setString(1, codice);
            pr.setBoolean(2, true);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            pr.setDate(3, java.sql.Date.valueOf(date));
            pr.setInt(4, idViaggio);
            pr.setString(5, email);
            pr.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            ok = false;
            throw new EccezioneDati("Impossibile inserire informazioni della prenotazione. Riprovare.");
        } finally {
            Dao.closeConnection();
        }
        return ok;
    }

    /**
     * Metodo che permette di conoscere se il Viaggio ha posti liberi
     *
     * @param idViaggio Id del Viaggio che si vuole controllare
     * @return se il Viaggio è libero oppure no
     */
    public boolean isPostiLiberi(int idViaggio) {
        boolean ok = true;
        String sqlPostiOccupati = "select Viaggi.id, count(*) as postiOccupati from Prenotazioni "
                + "inner join Viaggi on id_viaggio=Viaggi.id "
                + "inner join Autisti on Autisti.email=Viaggi.email_autista "
                + "inner join Passeggeri on email_passeggero=Passeggeri.email "
                + "where Viaggi.id =" + idViaggio + " "
                + "and accettazione = 1 "
                + "group by Viaggi.id";
        String sqlPostiMassimi = "select numero_posti from Autisti "
                + "inner join Viaggi on email_autista=email "
                + "where id=" + idViaggio;
        Connection con = null;
        try {
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlPostiOccupati);
            int postiOccupati = 0;
            if (res.next()) {
                postiOccupati = res.getInt("postiOccupati");
            }
            Statement st2 = con.createStatement();
            ResultSet res2 = st.executeQuery(sqlPostiMassimi);
            int postiMassimi = 0;
            if (res2.next()) {
                postiMassimi = res2.getInt("numero_posti");
            }
            if (postiOccupati >= postiMassimi) {
                ok = false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            ok = false;
            throw new EccezioneDati("Impossibile inserire verificare la disponibilità della prenotazione. Riprovare.");
        } finally {
            Dao.closeConnection();
        }
        return ok;
    }

    /**
     * Metodo che permette di generare il codice della prenotazione attraverso
     * una funzione hash(MD5) a partire dall'email e l'id
     *
     * @param idViaggio Id del Viaggio della prenotazione
     * @param email Email del Passeggero che prenota
     * @return il codice generato con la funzione hash
     */
    private String generaCodice(int idViaggio, String email) {
        String id = Integer.toString(idViaggio);
        String inputCodice = email + id;
        String sqlCodice = "SELECT MD5('+" + inputCodice + "') as codice";
        String result = null;
        Connection con = null;
        try {
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlCodice);
            if (res.next()) {
                result = res.getString("codice");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile generare il codice della prenotazione.");
        } finally {
            Dao.closeConnection();
        }
        return result;
    }
}
