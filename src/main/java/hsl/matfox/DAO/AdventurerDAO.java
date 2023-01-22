package hsl.matfox.DAO;

import hsl.matfox.models.Adventurer;
import hsl.matfox.models.Attributes;
import hsl.matfox.utils.JbcryptHSL;
import org.bukkit.entity.Player;

import javax.print.attribute.Attribute;
import java.sql.*;

public class AdventurerDAO {
    public void Funcao(String x, Boolean y) {

    }
    public int NewPlayer(Player player) {

        String hashPw1 = JbcryptHSL.hash("Example");

        Boolean teste = JbcryptHSL.verifyAndUpdateHash("password", hashPw1);

        Adventurer a = Adventurer.getAdventurerByPlayer(player);
        String uuid = a.getUuid().toString();
        String name = a.getName();
        String displayName = a.getDisplayName();
        String permission = a.getPermissions();
        System.out.println("test");
        //String query = "{ CALL ss_sp_adventurer_register(?,?,?,?,?)}";
        String query = "CALL ss_sp_adventurer_register(?,?,?,?,?);";
        Connection conn = null;
        PreparedStatement pstm = null;
        int res = 0;
        try{

            conn = MySQL.createConnectionToMySQL();
            System.out.println("test4");
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1, uuid);
            stmt.setString(2, name);
            stmt.setString(3, displayName);
            stmt.setString(4, permission);
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.executeQuery();
            res = stmt.getInt(5);

            System.out.println("teste2");

            NewPlayerAttributes(res);
        } catch (Exception e) {
            System.out.println(e.toString());
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
            return res;
        }
    }

    public void NewPlayerAttributes(int playerId){
        String query = "CALL ss_sp_attributes_register(?,?,?,?,?,?,?,?,?,?);";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            System.out.println(playerId);
            conn = MySQL.createConnectionToMySQL();
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, Attributes.basicPlayer.getAtk());
            stmt.setInt(2, Attributes.basicPlayer.getDef());
            stmt.setInt(3, Attributes.basicPlayer.getLife());
            stmt.setInt(4, Attributes.basicPlayer.getSP());
            stmt.setInt(5, Attributes.basicPlayer.getInt());
            stmt.setInt(6, Attributes.basicPlayer.getRes());
            stmt.setInt(7, Attributes.basicPlayer.getDex());
            stmt.setInt(8, Attributes.basicPlayer.getLuk());
            stmt.setInt(9, Attributes.basicPlayer.getAgi());
            stmt.setInt(10, playerId);
            stmt.executeQuery();

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
