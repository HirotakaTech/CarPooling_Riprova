package dao;

import beans.Autista;
import beans.Utente;
import beans.Viaggio;
import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F
 */
public class AutistiDao extends Dao {

    /**
     * Metodo che consente, dato un determinato viaggio, di ottenere l'autista.
     *
     * @param viaggio viaggio compiuto da un autista
     * @return lista di autisti associati ad un viaggio
     */
    public ArrayList<Autista> getAutista(Viaggio viaggio) {
        Connection con = null;
        String sql = "select Autisti.* from Autisti inner join Viaggi"
                + " on Autisti.email = Viaggi.email"
                + " inner join Prenotazioni on Prenotazioni.id_viaggio = Viaggi.id"
                + " where citta_partenza =" + viaggio.getCitta_partenza()
                + " and citta_destinazione=" + viaggio.getCitta_destinazione()
                + " and data_partenza =" + viaggio.getData_partenza()
                + " and accettazione = false";
        ArrayList<Autista> list = new ArrayList<>();
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Autista au = new Autista();
                au.setEmail(res.getString(1));
                au.setNumero_posti(res.getInt(2));
                DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
                au.setData_scadenza_patente(
                        dateform.format(res.getDate(3)));
                au.setFoto(res.getString(4));
                au.setNumero_patente(res.getString(5));
                au.setTarga_auto(res.getString(6));
                au.setModello_auto(res.getString(7));
                list.add(au);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile ricavare autisti.");
        } finally {
            closeConnection(con);
        }
        return list;
    }

    /**
     * Metodo che consente di inserire nel database un autista.
     *
     * @param au autista da inserire nel database
     * @return true se la procedura ha esito positivo, false altrimenti
     */
    public boolean insertAutista(Autista au) {
        boolean ok = true;
        String sql = "insert into Autisti VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, au.getEmail());
            st.setInt(2, au.getNumero_posti());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(au.getData_scadenza_patente());
            String data = formatter.format(date);
            st.setDate(3, new java.sql.Date(date.getTime()));
            st.setString(4, au.getFoto());
            st.setString(5, au.getNumero_patente());
            st.setString(6, au.getTarga_auto());
            st.setString(7, au.getModello_auto());
            st.execute();
        } catch (SQLException sx) {
            ok = false;
            if (sx.getSQLState().equals("22001")) {
                throw new EccezioneDati("Un dato che è stato inserito risulta troppo lungo!");
            }
        } catch (ClassNotFoundException | ParseException e) {
            ok = false;
            throw new EccezioneDati("Inserimento dell'autista fallito.");
        } finally {
            closeConnection(con);
        }
        return ok;
    }

    /**
     * Metodo che controlla se un determinato utente è un autista.
     *
     * @param email email dell'utente
     * @return true se l'utente risulta un autista, false altrimenti
     */
    public boolean isAutista(String email) {
        boolean found = false;
        Utente ute = null;
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Autisti.* from Autisti where Autisti.email='" + email + "'");
            if (rs.next()) {
                found = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile verificare identità dell'utente connesso.");
        } finally {
            closeConnection(con);
        }

        return found;

    }

    /**
     * Metodo che ritorna l'email di un autista, dato l'id del viaggio a cui è
     * associato.
     *
     * @param idViaggio id del viaggio
     * @return email dell'autista
     */
    public String findAutista(int idViaggio) {
        String autista = null;
        String sql = "select email_autista from Viaggi where id=" + idViaggio;
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                autista = res.getString("email_autista");
            }
        } catch (Exception e) {
            throw new EccezioneDati("Impossibile trovare autista nell'archivio.");
        } finally {
            closeConnection(con);
        }
        return autista;
    }
}
