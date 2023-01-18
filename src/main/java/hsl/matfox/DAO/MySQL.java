package hsl.matfox.DAO;

import java.sql.*;

public class MySQL {
    public static void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://89.116.225.201:3306/happysuggarcraft","gabs", "P@kemon04");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM test");
            while (rs.next()) {
                System.out.println(rs.getString("id"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
