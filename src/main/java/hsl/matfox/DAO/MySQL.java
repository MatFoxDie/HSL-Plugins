package hsl.matfox.DAO;

import org.bukkit.ChatColor;

import java.sql.*;

public class MySQL {
    private static final String USERNAME = "gabs";
    private static final String PASSWORD = "P@kemon04";
    private static final String DATABASE_URL="jdbc:mysql://89.116.225.201:3306/happysuggarcraft";
    public static Connection createConnectionToMySQL() throws Exception {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
    }
    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();

        if(con!=null) {
            System.out.println(ChatColor.translateAlternateColorCodes('&',"&f&l[DATABASE] &a&lConexão com o banco realizada com sucesso!"));
            con.close();
        }
    }
}
