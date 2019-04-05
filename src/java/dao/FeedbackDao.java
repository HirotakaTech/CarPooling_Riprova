package dao;

import beans.Feedback;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            ResultSet rs = st.executeQuery("select * from FeedbackP");
            Feedback fed = new Feedback();
            while (rs.next()) {
                
                fed.setId(rs.getInt(1));
                fed.setGiudizio(rs.getString(3));
                fed.setVoto(rs.getFloat(2));
                fed.setEmailMandante(rs.getString(4));
                fed.setEmailRicevente(rs.getString(5));
                
                lista.add(fed);
            }
        } catch (Exception e) {
        } finally {
            Dao.closeConnection();
        }

        return lista;
    }
    public static void main(String[] dsfas){
        FeedbackDao dao=new FeedbackDao();
        ArrayList<Feedback> lista=dao.findAll();
        for(Feedback ciao:lista){
            System.out.println(ciao.getEmailMandante());
        }
    }
}
