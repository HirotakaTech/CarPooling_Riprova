package dao;

import exceptions.EccezioneDati;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class Dao {

    private static Connection con;
    /**
     * Metodo che consente di instaurare una connessione con il database del CarPooling.
     * @return connessione generata col database 
     * @throws ClassNotFoundException viene lanciata quando i driver jdbc non sono stati caricati correttamente
     * @throws SQLException avviene quando è presente un errore nella connessione con il database
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            ResourceBundle bun = ResourceBundle.getBundle("parametri");
            String url = bun.getString("URL");
            String user = bun.getString("USER");
            String passwd = bun.getString("PASSWD");
            con = DriverManager.getConnection(url, user, passwd);
        }
        return con;
    }
    /**
     * Metodo volto alla chiusura della connessione col database.
     * @return true se viene chiusa la connessione con successo, false altrimenti
     */
    public static boolean closeConnection() {
        boolean ok = true;
        if(con!=null){
        try {
            con.close();
            con=null;
        } catch (SQLException e) {
            ok = false;
            throw new EccezioneDati("Problema di chiusura della comunicazione del database.");
        }
        }
        return ok;
    }

}
