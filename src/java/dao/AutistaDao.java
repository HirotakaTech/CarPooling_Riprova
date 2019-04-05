/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Autista;
import beans.Viaggio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F
 */
public class AutistaDao{
    
    public ArrayList<Autista> getAutista(Viaggio viaggio){
        Connection con = null;
        String sql = "select Autisti.* from Autisti inner join Viaggi"
                + " on Autisti.email = Viaggi.email"
           + " inner join Prenotazioni on Prenotazioni.id_viaggio = Viaggi.id"
                + " where citta_partenza =" + viaggio.getCitta_partenza()
                 + " and citta_destinazione=" + viaggio.getCitta_destinazione()
                + " and data_partenza =" + viaggio.getData_partenza()
                + " and accettazione = false";
        ArrayList<Autista> list = new ArrayList<>();
        try{
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
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
        }catch(Exception e){
            
        }finally{
            Dao.closeConnection();
        }
        return list;
    }
    public boolean insertAutista(String email, Autista au){
        boolean ok = false;
        String sql = "insert into Autisti VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        try{
            con = Dao.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, au.getEmail());
            st.setInt(2, au.getNumero_posti());
            st.setString(3, au.getData_scadenza_patente());
            st.setString(4, au.getFoto());
            st.setString(5, au.getNumero_patente());
            st.setString(6, au.getTarga_auto());
            st.setString(7, au.getModello_auto());
            ok = st.execute();
        }catch(Exception e){
            
        }finally{
            Dao.closeConnection();
        }
        return ok;
    }
}
