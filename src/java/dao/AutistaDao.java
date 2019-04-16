/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public boolean insertAutista(Autista au){
        boolean ok = true;
        String sql = "insert into Autisti VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        try{
            con = Dao.getConnection();
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
        }catch(SQLException sx){
            ok = false;
            if(sx.getSQLState().equals("22001")){
                throw new EccezioneDati("Un dato che è stato inserito risulta troppo lungo!");
            }
        }
        catch(Exception e){
            ok = false;
        }finally{
            Dao.closeConnection();
        }
        return ok;
    }
    
    public boolean isAutista(String email) {
        boolean found = false;
        Utente ute = null;
        try {
            Connection con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Autisti.* from Autisti where Autisti.email='" + email + "'");
            if(rs.next()){
                found = true;
            }

        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        } finally{
            Dao.closeConnection();
        }

        return found;

    }
    public String findAutista(int idViaggio){
        String autista = null;
        String sql = "select email_autista from Viaggi where id="+ idViaggio;
        Connection con = null;
        try{
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if(res.next()){
                autista = res.getString("email_autista");
            }
        }catch(Exception e){
            
        } finally {
            Dao.closeConnection();
        }
        return autista;
    }
}
