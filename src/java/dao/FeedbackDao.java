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
            Connection con= Dao.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from feedbacka,feedbackb");
            
        } catch(Exception e){
            
        }finally{
           Dao.closeConnection();
        }
        
        return lista;
    }

}
