package hsl.matfox.DAO;

import hsl.matfox.utils.ConfigurationManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;

import java.sql.*;

public class MySQL {
    public static Connection createConnectionToMySQL() throws Exception {
        ConfigurationManager cm = ConfigurationManager.getInstance();
        Configuration configuration = cm.loadConfig();
        String DATABASE_URL = configuration.getString("database-conection.URL");
        String USERNAME = configuration.getString("database-conection.USER");
        String PASSWORD = configuration.getString("database-conection.PASS");


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
