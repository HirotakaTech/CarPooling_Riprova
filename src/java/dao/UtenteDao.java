package dao;

import beans.Utente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        boolean ok = false;
        String sql = "insert into Utenti VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        try {
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user.getEmail());
            st.setString(2, user.getNome());
            st.setString(3, user.getCognome());
            st.setString(4, user.getData_nascita());
            st.setString(5, user.getLuogo());
            st.setString(6, user.getTelefono());
            st.setString(7, user.getPassword());
            ok = st.execute();
        } catch (Exception e) {

        } finally {
            Dao.closeConnection();
        }
        return ok;
    }

}
