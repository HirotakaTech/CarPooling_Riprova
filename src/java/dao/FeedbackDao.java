package dao;

import beans.Autista;
import beans.Feedback;
import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class FeedbackDao extends Dao {

    /**
     * Metodo che consente di ottenere tutte le valutazioni effettuate.
     *
     * @return lista di valutazioni dei vari utenti
     */
    public ArrayList<Feedback> findAll() {
        ArrayList<Feedback> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();

            trovaFeedbackPasseggeri(st, lista);

            trovaFeedackAutisti(st, lista);
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile visualizzare i feedback.");
        } finally {
            closeConnection(con);
        }

        return lista;
    }

    /**
     * Metodo che consente agli autisti di visualizzare il voto medio per
     * passeggero.
     *
     * @return lista di valutazioni degli autisti con le rispettive medie
     */
    public ArrayList<Feedback> findVotiPerAutisti() {
        ArrayList<Feedback> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select FeedbackP.email_autista,avg(FeedbackP.voto) as Media_Voto from FeedbackP group by (FeedbackP.email_autista)");
            while (rs.next()) {
                Feedback fed = new Feedback();
                fed.setVoto(rs.getInt(2));
                fed.setEmailMandante(rs.getString(1));
                lista.add(fed);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile trovare i voti dei passeggeri.");
        } finally {
            closeConnection(con);
        }
        return lista;
    }

    /**
     * Metodo che consente di ottenere le valutazioni degli autisti,
     * visualizzandone le loro medie.
     *
     * @return lista di valutazioni medie per autista
     */
    public ArrayList<Feedback> findVotiPerPasseggeri() {
        ArrayList<Feedback> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select FeedbackA.email_autista,avg(FeedbackA.voto) as Media_Voto from FeedbackA group by (FeedbackA.email_autista)");
            while (rs.next()) {
                Feedback fed = new Feedback();
                fed.setVoto(rs.getInt(2));
                fed.setEmailMandante(rs.getString(1));
                lista.add(fed);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile trovare i voti degli autisti.");
        } finally {
            closeConnection(con);
        }
        return lista;
    }

    /**
     * Metodo che consente di ottenere le valutazioni rivolte ad una persona.
     *
     * @param email email della persona di cui si vuole visualizzare le
     * valutazioni
     * @return lista di valutazioni di un determinato utente
     */
    public ArrayList<Feedback> findByEmail(String email) {
        ArrayList<Feedback> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            lista = trovaFeedbackByEmail(st, email);
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile trovare l'email nei voti registrati.");
        } finally {
            closeConnection(con);
        }

        return lista;
    }

    /**
     * Metodo che consente gli autisti nei feedback.
     *
     * @return una lista di autisti presenti nei feedback degli autisti
     */
    public ArrayList<Autista> findAutisti() {
        ArrayList<Autista> lista = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Autisti.* from FeedbackA,Autisti where FeedbackA.email_autista=Autisti.email");
            while (rs.next()) {
                Autista au = new Autista();
                au.setNumero_posti(rs.getInt(2));
                au.setFoto(rs.getString("foto"));

                au.setData_scadenza_patente(rs.getDate("data_scadenza_patente").toString());
                au.setNumero_patente(rs.getString("numero_patente"));
                au.setTarga_auto(rs.getString("targa_auto"));
                au.setModello_auto(rs.getString("modello"));
                au.setEmail(rs.getString("email"));
                lista.add(au);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new EccezioneDati("Impossibile trovare autista.");
        } finally {
            closeConnection(con);
        }
        return lista;
    }

    /**
     * Metodo che consente di inserire un feedback del passeggero.
     *
     * @param fed valutazione dell'autista nei confronti del passeggero
     * @return true se l'inserimento va a buon fine, false altrimenti
     */
    public boolean insertFeedbackP(Feedback fed) {
        boolean ok = true;
        String sql = "insert into FeedbackP VALUES(null,?,?,?,?)";
        Connection con = null;
        String error = "";
        String data = "";
        try {
            con = getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, fed.getVoto());
            st.setString(2, fed.getGiudizio());
            st.setString(3, fed.getEmailMandante());
            st.setString(4, fed.getEmailRicevente());
            st.execute();
        } catch (ClassNotFoundException | SQLException e) {
            ok = false;
            throw new EccezioneDati("Impossibile inserire valutazione.");
        } finally {
            closeConnection(con);
        }

        return ok;
    }

    /**
     * Metodo che inserisce i feedback degli autisti.
     *
     * @param fed valutazione dell'autista fatta da un passeggero
     * @return true se valutazione viene inserita correttamente, false
     * altrimenti
     */
    public boolean insertFeedbackA(Feedback fed) {
        boolean ok = true;
        String sql = "insert into FeedbackA VALUES(null,?,?,?,?)";
        Connection con = null;
        String error = "";
        String data = "";
        try {
            con = getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, fed.getVoto());
            st.setString(2, fed.getGiudizio());
            st.setString(3, fed.getEmailMandante());
            st.setString(4, fed.getEmailRicevente());
            st.execute();
        } catch (ClassNotFoundException | SQLException e) {
            ok = false;
            throw new EccezioneDati("Impossibile inserire valutazione");
        } finally {
            closeConnection(con);
        }

        return ok;
    }

    /**
     * Metodo che consente di trovare i feedback dei passeggeri.
     *
     * @param st statement mediante il quale si esegue la query per selezionare
     * le valutazioni dei passeggeri
     * @param lista lista di valutazioni dei passeggeri
     */
    private void trovaFeedbackPasseggeri(Statement st, ArrayList<Feedback> lista) {

        try {
            ResultSet rs = st.executeQuery("select * from FeedbackP");
            while (rs.next()) {
                Feedback fed = new Feedback();

                fed.setId(rs.getInt(1));
                fed.setGiudizio(rs.getString(3));
                fed.setVoto(rs.getInt(2));
                fed.setEmailMandante(rs.getString(5));
                fed.setEmailRicevente(rs.getString(4));

                lista.add(fed);
            }
        } catch (SQLException ex) {
            throw new EccezioneDati("Impossibile trovare valutazioni dei passeggeri.");
        }
    }

    /**
     * Metodo che consente di trovare i feedback degli autisti.
     *
     * @param st statement mediante il quale si esegue la query per selezionare
     * le valutazioni degli autisti
     * @param lista lista di valutazioni degli autisti
     */
    private void trovaFeedackAutisti(Statement st, ArrayList<Feedback> lista) {
        try {
            ResultSet rs = st.executeQuery("select * from FeedbackA");
            while (rs.next()) {
                Feedback fed = new Feedback();

                fed.setId(rs.getInt(1));
                fed.setGiudizio(rs.getString(3));
                fed.setVoto(rs.getInt(2));
                fed.setEmailMandante(rs.getString(5));
                fed.setEmailRicevente(rs.getString(4));

                lista.add(fed);
            }
        } catch (SQLException ex) {
            throw new EccezioneDati("Impossibile trovare valutazioni autisti.");
        }
    }

    /**
     * Metodo che consente di trovare i feedback ricevuti da un utente.
     *
     * @param st statement che ci consente di eseguire le query per ottenere i
     * feedback
     * @param email email dell'utente di cui vogliamo conoscere i feedback
     * @return lista di feedback dell'utente
     * @throws SQLException viene lanciata se è presente un errore relativo al
     * linguaggio sql
     * @throws ClassNotFoundException viene lanciata se non viene trovato il
     * driver per utilizzare le jdbc
     */
    private ArrayList<Feedback> trovaFeedbackByEmail(Statement st,
            String email) throws SQLException, ClassNotFoundException {
        ArrayList<Feedback> list = new ArrayList<>();
        ResultSet res = st.executeQuery("select * from FeedbackA where email_autista='" + email + "'");
        while (res.next()) {
            list.add(new Feedback(res.getString("giudizio"), res.getInt("voto"),
                    res.getString("email_passeggero"), res.getString("email_autista")));
        }

        res = st.executeQuery("select * from FeedbackP where email_passeggero='" + email + "'");
        while (res.next()) {
            list.add(new Feedback(res.getString("giudizio"), res.getInt("voto"),
                    res.getString("email_autista"), res.getString("email_passeggero")));
        }

        return list;
    }
}
