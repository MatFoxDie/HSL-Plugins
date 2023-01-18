package hsl.matfox.DAO;

import hsl.matfox.models.Adventurer;
import org.bukkit.entity.Player;

import java.sql.*;

public class AdventurerDAO {
    public void save(Player player) {
        Adventurer a = Adventurer.getAdventurerByPlayer(player);
        String uuid = a.getUuid().toString();
        String name = a.getName();
        String displayName = a.getDisplayName();
        String permission = a.getPermissions();
        //String query = "{ CALL ss_sp_adventurer_register(?,?,?,?,?)}";
        String query = "CALL ss_sp_adventurer_register(?,?,?,?,1,?);";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = MySQL.createConnectionToMySQL();
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1, uuid);
            stmt.setString(2, name);
            stmt.setString(3, displayName);
            stmt.setString(4, permission);
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.executeQuery();
            int res = stmt.getInt(5);
            System.out.println(res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(conn!=null) {
                    conn.close();
                }
                if(pstm!=null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
