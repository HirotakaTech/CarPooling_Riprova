package dao;

import beans.Autista;
import beans.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class FeedbackDao {

    /**
     *
     * @return
     */
    public ArrayList<Feedback> findAll() {
        ArrayList<Feedback> lista = new ArrayList<>();
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();

            trovaFeedbackPasseggeri(st, lista);

            trovaFeedackAutisti(st, lista);
        } catch (Exception e) {
        } finally {
            Dao.closeConnection();
        }

        return lista;
    }

    public ArrayList<Feedback> findVotiPerAutisti() {
        ArrayList<Feedback> lista = new ArrayList<>();
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select FeedbackP.email_autista,avg(FeedbackP.voto) as Media_Voto from FeedbackP group by (FeedbackP.email_autista)");
            while (rs.next()) {
                Feedback fed = new Feedback();
                fed.setVoto(rs.getInt(2));
                fed.setEmailMandante(rs.getString(1));
                lista.add(fed);
            }
        } catch (Exception e) {
        } finally {
            Dao.closeConnection();
        }
        return lista;
    }

    public ArrayList<Feedback> findVotiPerPasseggeri() {
        ArrayList<Feedback> lista = new ArrayList<>();
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select FeedbackA.email_autista,avg(FeedbackA.voto) as Media_Voto from FeedbackA group by (FeedbackA.email_autista)");
            while (rs.next()) {
                Feedback fed = new Feedback();
                fed.setVoto(rs.getInt(2));
                fed.setEmailMandante(rs.getString(1));
                lista.add(fed);
            }
        } catch (Exception e) {
        } finally {
            Dao.closeConnection();
        }
        return lista;
    }

    public ArrayList<Feedback> findByEmail(String email) {
        ArrayList<Feedback> lista = new ArrayList<>();
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();

            trovaFeedbackPasseggeri(st, lista);

            trovaFeedackAutisti(st, lista);
        } catch (Exception e) {
        } finally {
            Dao.closeConnection();
        }

        return lista;
    }

    public ArrayList<Autista> findAutisti() {
        ArrayList<Autista> lista = new ArrayList<>();
        try {
            Connection con = Dao.getConnection();
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
        } catch (Exception e) {
        } finally {
            Dao.closeConnection();
        }
        return lista;
    }

    public boolean insertFeedbackP(Feedback fed) {
        boolean ok = true;
        String sql = "insert into FeedbackP VALUES(null,?,?,?,?)";
        Connection con = null;
        String error = "";
        String data = "";
        try {
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, fed.getVoto());
            st.setString(2, fed.getGiudizio());
            st.setString(3, fed.getEmailMandante());
            st.setString(4, fed.getEmailRicevente());
            st.execute();
        } catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage());
        } finally {
            Dao.closeConnection();
        }

        return ok;
    }

    public boolean insertFeedbackA(Feedback fed) {
        boolean ok = true;
        String sql = "insert into FeedbackA VALUES(null,?,?,?,?)";
        Connection con = null;
        String error = "";
        String data = "";
        try {
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, fed.getVoto());
            st.setString(2, fed.getGiudizio());
            st.setString(3, fed.getEmailMandante());
            st.setString(4, fed.getEmailRicevente());
            st.execute();
        } catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage());
        } finally {
            Dao.closeConnection();
        }

        return ok;
    }

    public static void main(String[] dsfas) {
        FeedbackDao dao = new FeedbackDao();
        ArrayList<Feedback> lista = dao.findAll();
        for (Feedback ciao : lista) {
            System.out.println(ciao.getEmailMandante());
        }
    }
    
     private void trovaFeedbackPasseggeri(Statement st, ArrayList<Feedback> lista) throws ClassNotFoundException, SQLException {

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
    }

    private void trovaFeedbackPasseggeri(Statement st, ArrayList<Feedback> lista) throws ClassNotFoundException, SQLException {

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
    }

    private void trovaFeedackAutisti(Statement st, ArrayList<Feedback> lista) throws SQLException {
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
    }
}
