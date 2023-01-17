package hsl.matfox.models;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Adventurer {
    private String name;
    private UUID uuid;
    private Attributes attributes;
    public Adventurer(Player player, Attributes attributes) {
        this.name = player.getName();
        this.uuid = player.getUniqueId();
        this.attributes =  attributes;
        adventurers.put(uuid, this);
    }
    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }
    public Attributes getAttributes() {
        return attributes;
    }
    private static final HashMap<UUID, Adventurer> adventurers = new HashMap<UUID, Adventurer>();

    public static Adventurer getAdventurer(Player p) {
        Adventurer a = adventurers.get(p.getUniqueId());
        return a != null ? a : new Adventurer(p, a.attributes);
    }

    @Deprecated
    public static Adventurer getAdventurer(String name) {
        for (Adventurer a : adventurers.values())
            if (a.getName().equalsIgnoreCase(name))
                return a;
        return null;
    }


}
