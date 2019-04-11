/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Utente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author checc_000
 */
public class PasseggeroDao {

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
        } catch (Exception e) {
            ok = false;
        } finally {
            Dao.closeConnection();
        }
        return ok;
    }
    
    
    public boolean isPasseggero(String email) {
        boolean found = false;
        Utente ute = null;
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Passeggeri.* from Passeggeri where Passeggeri.email='" + email + "'");
            if(rs.next()){
                found = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtenteDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UtenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return found;

    }

}
