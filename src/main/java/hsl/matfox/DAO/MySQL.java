package hsl.matfox.DAO;

import hsl.matfox.utils.ConfigurationManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;

import java.sql.*;

public class MySQL {


    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL="";
    public static Connection createConnectionToMySQL() throws Exception {
        ConfigurationManager cm = ConfigurationManager.getInstance();
        Configuration configuration = cm.loadConfig();
        configuration.getString("");
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();

        if(con!=null) {
            System.out.println(ChatColor.translateAlternateColorCodes('&',"&f&l[DATABASE] &a&lConexão com o banco realizada com sucesso."));
            con.close();
        }
    }
}
