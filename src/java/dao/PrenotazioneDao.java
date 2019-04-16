/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author checc_000
 */
public class PrenotazioneDao {
    public boolean insertPrenotazioni(int idViaggio, String email){
        boolean ok = true;
        String sqlInsertPrenotazione = "insert into Prenotazioni VALUES(?,?,?,?,?)";
        String codice = generaCodice(idViaggio, email);
        Connection con = null;
        try {
            con = Dao.getConnection();
            PreparedStatement pr = con.prepareStatement(sqlInsertPrenotazione);
            pr.setString(1, codice);
            pr.setBoolean(2, true);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            pr.setDate(3, java.sql.Date.valueOf(date));
            pr.setInt(4, idViaggio);
            pr.setString(5, email);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrenotazioneDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrenotazioneDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Dao.closeConnection();
        }
        return ok;
    }
    public boolean isPostiLiberi(int idViaggio){
        boolean ok = true;
        String sqlPostiOccupati = "select Viaggi.id, count(*) as postiOccupati from Prenotazioni "
                + "inner join Viaggi on id_viaggio = Viaggi.id "
                + "inner join Autisti on Autisti.email = Viaggi.email "
                + "inner join Passeggeri on email_passeggero = Passeggeri.id "
                + "where Viaggi.id =" + idViaggio + " "
                + "and accettazione = 'TRUE' "
                + "group by Viaggi.id";
        String sqlPostiMassimi = "select numero_posti from Autisti "
                + "inner join Viaggi on email_autista = email "
                + "where id =" + idViaggio;
        Connection con = null;
        try {
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlPostiOccupati);
            Statement st2 = con.createStatement();
            ResultSet res2 = st.executeQuery(sqlPostiMassimi);
            int postiMassimi = 0;
            if(res2.next()){
                 postiMassimi = res2.getInt("numero_posti");
            }
            int postiOccupati = 0;
            if(res.next()){
                postiOccupati = res.getInt("postiOccupati");
            }
            if(postiOccupati >= postiMassimi){
                ok = false;
            } 
    }catch(Exception e){
        ok = false;
    } finally{
            Dao.closeConnection();
        }
        return ok;
}

    private String generaCodice(int idViaggio, String email) {
        String id = Integer.toString(idViaggio);
        String inputCodice = email + id;
        String sqlCodice = "SELECT MD5('+" + inputCodice + "') as codice";
        String result = null;
        Connection con = null;
        try{
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sqlCodice);
            if(res.next()){
                result = res.getString("codice");
            }
        }catch(Exception e){
            
        } finally {
            Dao.closeConnection();
        }
        return result;
    }
}