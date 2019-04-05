/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author checc_000
 */
public class PasseggeroDao{

    public boolean insertPasseggero(String email, String documento) {
        boolean ok = true;
        String sql = "insert into Passeggeri VALUES(?,?)";
        Connection con = null;
        try {
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, documento);
            ok = st.execute();
        } catch (Exception e) {
            ok = false;
        } finally{
            Dao.closeConnection();
        }
        return ok;
    }

}
