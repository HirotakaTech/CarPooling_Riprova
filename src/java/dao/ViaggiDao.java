package dao;

import beans.Viaggio;
import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Metodo che gestisce i dati relativi ai Viaggi all'interno del database
 *
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class ViaggiDao extends Dao {

    /**
     * Metodo che viene utilizzato per ottenere i viaggi a partire dai parametri
     * questo metodo è utilizzato nella ricerca
     *
     * @param destinazione La città di destinazione del viaggio
     * @param data_partenza La data di partenza
     * @param ora L'ora di partenza
     * @param costo Il costo del viaggio
     * @return Una lista di Bean Viaggio dei viaggi ottenuti
     */
    public ArrayList<Viaggio> getViaggi(String destinazione, String data_partenza, String ora, int costo) {
        Connection con = null;
        String sql = "select * from Viaggi"
                + " where citta_destinazione='" + destinazione
                + "' and data_partenza='" + data_partenza
                + "' and prezzo_passeggero<=" + costo;
        ArrayList<Viaggio> list = new ArrayList<>();
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Viaggio aus = new Viaggio();
                aus.setId(res.getInt(1));
                aus.setCitta_partenza(res.getString(2));
                DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

                aus.setData_partenza(
                        dateform.format(res.getDate(3)).toString());
                SimpleDateFormat form = new SimpleDateFormat("HH:mm");
                String time = form.format(res.getTime(4));
                time = time.substring(0, 5);

                aus.setOra_partenza(time);
                aus.setCitta_destinazione(res.getString(5));
                aus.setPrezzo(res.getFloat(6));
                aus.setTempi_stimati(res.getString(7));
                aus.setInfo_aggiuntive(res.getString(8));
                aus.setEmail_autista(res.getString(9));
                list.add(aus);

            }
        } catch (ClassNotFoundException | SQLException e) {

            throw new EccezioneDati("Impossibile consultare l'archivio per i viaggi. Riprovare.");
        } finally {
            closeConnection(con);
        }
        return list;
    }

    /**
     * Metodo che permette di ottenere la lista dei viaggi che sono stati
     * prenotati da un Passeggero
     *
     * @param email Email del Passeggero
     * @return Lista di Bean Viaggio dei viaggi che ha prenotato il Passeggero
     */
    public ArrayList<Viaggio> findViaggiPrenotati(String email) {
        ArrayList<Viaggio> lista = new ArrayList<>();
        String sql = "select Viaggi.* from Viaggi,Utenti where Viaggi.email_autista=Utenti.email and Utenti.email='" + email + "'";
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Viaggio aus = new Viaggio();
                aus.setId(res.getInt(1));
                aus.setCitta_partenza(res.getString(2));
                DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

                aus.setData_partenza(
                        dateform.format(res.getDate(3)).toString());
                String time = res.getTime(4).toString();
                time = time.substring(0, 5);

                aus.setOra_partenza(time);
                aus.setCitta_destinazione(res.getString(5));
                aus.setPrezzo(res.getFloat(6));
                aus.setTempi_stimati(res.getString(7));
                aus.setInfo_aggiuntive(res.getString(8));
                aus.setEmail_autista(res.getString(9));
                lista.add(aus);

            }
        } catch (Exception e) {
            System.out.println("Errore");
        } finally {
            closeConnection(con);
        }
        return lista;
    }

    /**
     * Metodo che permette di ottenere la lista dei viaggi a partire dall'email
     * dell'utente
     *
     * @param email Email dell'utente di cui ricercare i Viaggi
     * @return Lista di Bean Viaggio dei viaggi dell'utente
     */
    public ArrayList<Viaggio> findByEmail(String email) {
        ArrayList<Viaggio> lista = new ArrayList<>();
        String sql = "select Viaggi.* from Prenotazioni,Viaggi where Viaggi.id=Prenotazioni.id_Viaggio and Prenotazioni.email_passeggero='" + email + "'";
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Viaggio aus = new Viaggio();
                aus.setId(res.getInt(1));
                aus.setCitta_partenza(res.getString(2));
                DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

                aus.setData_partenza(
                        dateform.format(res.getDate(3)).toString());
                String time = res.getTime(4).toString();
                time = time.substring(0, 5);

                aus.setOra_partenza(time);
                aus.setCitta_destinazione(res.getString(5));
                aus.setPrezzo(res.getFloat(6));
                aus.setTempi_stimati(res.getString(7));
                aus.setInfo_aggiuntive(res.getString(8));
                aus.setEmail_autista(res.getString(9));
                lista.add(aus);

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile trovare i viaggi. Riprovare.");
        } finally {
            closeConnection(con);
        }
        return lista;
    }

    /**
     * Metodo per ottenere tutti i viaggi presenti nel database
     *
     * @return Lista di Bean Viaggio
     */
    public ArrayList<Viaggio> findAll() {
        ArrayList<Viaggio> lista = new ArrayList<>();
        String sql = "select Viaggi.* from Viaggi order by data_partenza";
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Viaggio aus = new Viaggio();
                aus.setId(res.getInt(1));
                aus.setCitta_partenza(res.getString(2));
                DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

                aus.setData_partenza(
                        dateform.format(res.getDate(3)).toString());
                String time = res.getTime(4).toString();
                time = time.substring(0, 5);

                aus.setOra_partenza(time);
                aus.setCitta_destinazione(res.getString(5));
                aus.setPrezzo(res.getFloat(6));
                aus.setTempi_stimati(res.getString(7));
                aus.setInfo_aggiuntive(res.getString(8));
                aus.setEmail_autista(res.getString(9));
                lista.add(aus);

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile visualizzare i viaggi. Riprovare.");
        } finally {
            closeConnection(con);
        }
        return lista;
    }

    /**
     * Metodo per l'inserimento di un viaggio all'interno del DB
     *
     * @param viaggio Bean Viaggio da inserire
     * @return esito dell'insert
     */
    public boolean insertViaggio(Viaggio viaggio) {
        boolean ok = true;
        String sql = "insert into Viaggi values(NULL,?,?,?,?,?,?,?,?)";
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, viaggio.getCitta_partenza());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(viaggio.getData_partenza());
            pr.setDate(2, new java.sql.Date(date.getTime()));
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            long ms = sdf.parse(viaggio.getOra_partenza()).getTime();
            Time t = new Time(ms);
            pr.setTime(3, t);
            pr.setString(4, viaggio.getCitta_destinazione());
            pr.setFloat(5, viaggio.getPrezzo());
            long msTempi = sdf.parse(viaggio.getTempi_stimati()).getTime();
            Time tTempi = new Time(msTempi);
            pr.setTime(6, tTempi);
            pr.setString(7, viaggio.getInfo_aggiuntive());
            pr.setString(8, viaggio.getEmail_autista());
            pr.executeUpdate();
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            ok = false;
            throw new EccezioneDati("Impossibile inserire informazioni del viaggio. Riprovare.");
        } finally {
            closeConnection(con);
        }
        return ok;
    }

}
