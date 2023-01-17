package hsl.matfox.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class onPlayerFoodLevelChangeEvent implements Listener {
    @EventHandler
    public void FoodLevelChangeEvent(FoodLevelChangeEvent e) {
        int foodLevel = e.getFoodLevel();
        if(foodLevel < 20) {
            e.setFoodLevel(20);
        }
    }
}
