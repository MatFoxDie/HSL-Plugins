package hsl.matfox.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.HashMap;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adventurer {
    private static final HashMap<String, Adventurer> adventurers = new HashMap<>();
    private Integer id;
    private String uuid;
    private String nick;
    private String password;
    private String displayNick;
    private String permission;
    private Date createdAt;
    private Attributes attributes;


    public Adventurer(Player player) {
        setNick(player.getName());
        setDisplayNick(player.getDisplayName());
        setUuid(player.getUniqueId().toString());
        setPassword("teste");
        setPermission("Player");
        adventurers.put(uuid, this);
    }

    public static Adventurer getAdventurerByUUID(String id) {
        for (Adventurer obj : adventurers.values()) {
            if (obj.getUuid().equals(id)) {
                return obj;
            }
        }
        return null;
    }
}
