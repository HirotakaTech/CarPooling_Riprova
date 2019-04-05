package dao;

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

    public static boolean closeConnection() {
        boolean ok = true;
        if(con!=null){
        try {
            con.close();
            con=null;
        } catch (Exception e) {
            ok = false;
        }
        }
        return ok;
    }

}
