package hsl.matfox.controllers;

import hsl.matfox.models.Adventurer;
import org.bukkit.entity.Player;
import service.AdventurerService;

import java.io.IOException;

public class PlayerController {
    public Integer newPlayer(Player p){
        Integer id= null;
        try {
            AdventurerService service = new AdventurerService();
            Adventurer aventureiro = new Adventurer(p);
            id = service.register(aventureiro);
            aventureiro.setId(id);
            System.out.println("Id: " + id);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
    public static void playerSetLife(Player p){
        p.setHealthScale(Adventurer.getAdventurerByUUID(p.getUniqueId().toString()).getAttributes().getLife());
    }

}
