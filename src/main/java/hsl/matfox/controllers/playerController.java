package hsl.matfox.controllers;

import hsl.matfox.models.Adventurer;
import hsl.matfox.models.Attributes;
import org.bukkit.entity.Player;

public class playerController {
    public static void newPlayer(Player p){
        new Adventurer(p);

        System.out.println("Novo player criado nos registros");
    }
    public static void playerSetLife(Player p){
        p.setHealthScale(Adventurer.getAdventurerByUUID(p.getUniqueId()).getAttributes().getLife());
    }

}
