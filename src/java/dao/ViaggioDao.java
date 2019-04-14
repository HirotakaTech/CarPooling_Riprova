package dao;

import beans.Viaggio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author checc_000
 */
public class ViaggioDao {

    public ArrayList<Viaggio> getViaggi(String destinazione, String data_partenza, String ora, int costo) {
        Connection con = null;
        String sql = "select Viaggi.* from Viaggi inner join Prenotazioni"
                + " on Viaggi.id = Prenotazioni.id_viaggio"
                + " where citta_destinazione='" + destinazione
                + "' and data_partenza='" + data_partenza
                + "' and ora_partenza='" + ora
                + "' and prezzo_passeggero<=" + costo
                + " and accettazione=false";
        ArrayList<Viaggio> list = new ArrayList<>();
        try {
            con = Dao.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Viaggio aus = new Viaggio();
                aus.setId(res.getInt(1));
                aus.setCitta_partenza(res.getString(2));
                DateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
                
                aus.setData_partenza(
                        dateform.format(res.getDate(3)).toString());
                String time = res.getTime(4).toString();
                time = time.substring(0,5);
      
                aus.setOra_partenza(time);
                aus.setCitta_destinazione(res.getString(5));
                aus.setPrezzo(res.getFloat(6));
                aus.setTempi_stimati(res.getString(7));
                aus.setInfo_aggiuntive(res.getString(8));
                aus.setEmail_autista(res.getString(9));
                list.add(aus);

            }
        } catch (Exception e) {
            System.out.println("Errore");
        } finally {
            Dao.closeConnection();
        }
        return list;
    }

    public boolean insertViaggio(Viaggio viaggio){
        boolean ok = true;
        String sql = "insert into Viaggi values(NULL,?,?,?,?,?,?,?,?)";
        Connection con = null;
        try{
            con = Dao.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, viaggio.getCitta_partenza());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(viaggio.getData_partenza());
            pr.setDate(2, new java.sql.Date(date.getTime()));
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            long ms = sdf.parse(viaggio.getOra_partenza()).getTime();
            java.sql.Time t = new java.sql.Time(ms);
            pr.setTime(3, t);
            pr.setString(4, viaggio.getCitta_destinazione());
            pr.setFloat(5, viaggio.getPrezzo());
            long msTempi = sdf.parse(viaggio.getTempi_stimati()).getTime();
            java.sql.Time tTempi = new java.sql.Time(msTempi);
            pr.setTime(6, tTempi);
            pr.setString(7, viaggio.getInfo_aggiuntive());
            pr.setString(8, viaggio.getEmail_autista());
            pr.executeUpdate();
        }catch(Exception e){
            ok = false;
        }
        return ok;
    }
    
}
