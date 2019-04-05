package dao;

import beans.Viaggio;
import java.sql.Connection;
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

    public ArrayList<Viaggio> getViaggi(String destinazione, String data_partenza, String ora, float costo) {
        Connection con = null;
        String sql = "select Viaggi.* from Viaggi inner join Prenotazioni"
                + " on Viaggi.id = Prenotazioni.id_viaggio"
                + " where citta_destinazione=" + destinazione
                + " and data_partenza=" + data_partenza
                + " and ora_partenza=" + ora
                + " and costo<=" + costo
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
                        dateform.format(res.getDate(3)));
                String time = res.getTime(4).toString();
                time = time.substring(6);
                aus.setOra_partenza(time);
                aus.setCitta_destinazione(res.getString(5));
                aus.setPrezzo(res.getFloat(5));
                aus.setTempi_stimati(res.getFloat(6));
                aus.setInfo_aggiuntive(res.getString(7));
                aus.setEmail_autista(res.getString(8));
                list.add(aus);

            }
        } catch (Exception e) {

        } finally {
            Dao.closeConnection();
        }
        return list;
    }

}
