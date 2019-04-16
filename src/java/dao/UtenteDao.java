package dao;

import beans.Utente;
import exceptions.EccezioneDati;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author checc_000
 */
public class UtenteDao {

    public boolean login(String email, String password) {
        boolean logged = false;
        String sql = "select email,password from Utenti"
                + " where email='" + email + "'"
                + " and password='" + password + "'";
        Connection con = null;
        try {
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                logged = true;
            }
        } catch (Exception e) {

        } finally {
            Dao.closeConnection();
        }
        return logged;
    }

    public boolean findUser(String email) {
        boolean find = false;
        String sql = "select email,password from Utenti"
                + " where email='" + email + "'";
        Connection con = null;
        try {
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                find = true;
            }
        } catch (Exception e) {

        } finally {
            Dao.closeConnection();
        }
        return find;
    }

    public boolean inserisciUtente(Utente user) {
        boolean ok = true;
        String sql = "insert into Utenti VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        String error = "";
        String data = "";
        try {
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user.getEmail());
            st.setString(2, user.getNome());
            st.setString(3, user.getCognome());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(user.getData_nascita());
            data = formatter.format(date);
            st.setDate(4, new java.sql.Date(date.getTime()));
            st.setString(5, user.getLuogo());
            st.setString(6, user.getTelefono());
            st.setString(7, user.getPassword());
            st.execute();
        } catch (SQLException sx) {
            ok = false;
            error = sx.getSQLState();
            if (sx.getSQLState().equals("22001")) {
                throw new EccezioneDati("Un dato che è stato inserito risulta troppo lungo!");
            }
        } catch (Exception e) {
            ok = false;
            System.out.println(e.getMessage());
        } finally {
            Dao.closeConnection();
        }
        return ok;
    }

    public Utente findByEmail(String email) {

        Utente ute = null;
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Utenti.* from Utenti where Utenti.email='" + email + "'");
            ute = new Utente();
            while (rs.next()) {
                ute.setEmail(rs.getString(1));
                ute.setNome(rs.getString(2));
                ute.setCognome(rs.getString(3));
                ute.setData_nascita(rs.getDate(4).toString());
                ute.setLuogo(rs.getString(5));
                ute.setTelefono(rs.getString(6));
                ute.setPassword(rs.getString(7));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtenteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtenteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Dao.closeConnection();
        }

        return ute;

    }

    public Utente findByName(String name) {

        Utente ute = null;
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Utenti.* from Utenti where Utenti.nome='" + name + "'");
            ute = new Utente();
            while (rs.next()) {
                ute.setEmail(rs.getString(1));
                ute.setNome(rs.getString(2));
                ute.setCognome(rs.getString(3));
                ute.setData_nascita(rs.getDate(4).toString());
                ute.setLuogo(rs.getString(5));
                ute.setTelefono(rs.getString(6));
                ute.setPassword(rs.getString(7));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtenteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtenteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Dao.closeConnection();
        }

        return ute;

    }

}
