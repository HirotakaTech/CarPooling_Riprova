package dao;

import beans.Passeggero;
import beans.Prenotazione;
import beans.Viaggio;
import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che si occupa di gestire i dati relativi alle Prenotazioni all'interno
 * del database
 *
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class PrenotazioneDao extends Dao{

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
            con = getConnection();
            PreparedStatement pr = con.prepareStatement(sqlInsertPrenotazione);
            pr.setString(1, codice);
            pr.setBoolean(2, false);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            pr.setDate(3, java.sql.Date.valueOf(date));
            pr.setInt(4, idViaggio);
            pr.setString(5, email);
            pr.executeUpdate();
        } catch (SQLException ex) {
            ok = false;
            if (ex.getSQLState().equals("23000")) {
                throw new EccezioneDati("Hai già prenotato per questo viaggio!");
            } else {
                throw new EccezioneDati("Impossibile inserire informazioni della prenotazione. Riprovare.");
            }
        } catch (ClassNotFoundException ex) {
            throw new EccezioneDati("Impossibile inserire informazioni della prenotazione. Riprovare.");
        } finally {
            closeConnection(con);
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
            con = getConnection();
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
            closeConnection(con);
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
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlCodice);
            if (res.next()) {
                result = res.getString("codice");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile generare il codice della prenotazione.");
        } finally {
            closeConnection(con);
        }
        return result;
    }
    /**
     * Metodo per trovare tutte le prenotazioni effettuate su un autista.
     * @param accettazione true se si vogliono ottenere le prenotazioni accettate, false altrimenti
     * @param email email dell'autista
     * @return prenotazioni dell'autista
     */
    public ArrayList<Prenotazione> findAll(boolean accettazione, String email){
        String sql = "select * from Prenotazioni inner join Viaggi on id_viaggio=id "
                + "where accettazione=? and email_autista=?";
        Connection con = null;
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        try{
            con = getConnection();
            PreparedStatement p = con.prepareStatement(sql);
            p.setBoolean(1, accettazione);
            p.setString(2, email);
            ResultSet res = p.executeQuery();
            while(res.next()){
                String email_passeggero = res.getString("email_passeggero");
                SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
                String data = form.format(res.getDate(3));
                Prenotazione prenotazione = new Prenotazione(res.getBoolean("accettazione"),
                        res.getString("codice"), data);
                prenotazione.setEmail_passeggero(email_passeggero);
                Viaggio viag = ottieniViaggio(res, form);
                prenotazione.setViaggio(viag);
                prenotazioni.add(prenotazione);
            }
        }catch(ClassNotFoundException | SQLException e){
            throw new EccezioneDati("Si è verificato un problema: impossibile visualizzare le prenotazioni.");
        }
        return prenotazioni;
    }
    /**
     * Metodo per ottenere il viaggio relativo alla prenotazione.
     * @param res oggetto contenente le informazioni del viaggio
     * @param form form per formattare le date
     * @return viaggio relativo alla prenotazione
     * @throws SQLException lanciata se ci sono errori nell'ottenere i risultati dall'oggetto res
     */
    private Viaggio ottieniViaggio(ResultSet res, SimpleDateFormat form) throws SQLException {
        SimpleDateFormat oraForm = new SimpleDateFormat("HH:mm");
        Viaggio viag = new Viaggio();
        viag.setId(res.getInt("id"));
        viag.setCitta_partenza(res.getString("citta_partenza"));
        viag.setData_partenza(form.format(res.getDate("data_partenza")));
        String timePartenza = oraForm.format(res.getTime("ora_partenza"));
        timePartenza = timePartenza.substring(0,5);
        viag.setOra_partenza(timePartenza);
        viag.setCitta_destinazione(res.getString("citta_destinazione"));
        viag.setPrezzo(res.getFloat("prezzo_passeggero"));
        String tempiStimati = oraForm.format(res.getTime("tempi_stimati"));
        tempiStimati = tempiStimati.substring(0,5);
        viag.setTempi_stimati(tempiStimati);
        viag.setInfo_aggiuntive(res.getString("info_aggiuntive"));
        return viag;
    }
    /**
     * Metodo che permette all'autista di accettare la prenotazione di un passeggero.
     * @param codice codice della prenotazione
     * @return true se l'operazione ha esito positivo, false altrimenti
     */
    public boolean accettaPrenotazione(String codice){
        boolean ok = true;
        String sql ="update Prenotazioni set accettazione=1 where codice=?";
        Connection con = null;
        int rows = 0;
        try{
            con = getConnection();
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, codice);
            rows = p.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            ok = false;   
        }
        if(rows == 0 || rows == -1){
            ok = false;
        }
        return ok;
    }
}
