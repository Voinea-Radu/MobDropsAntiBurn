package dev.lightdream.mobdropsantiburn;

import dev.lightdream.mobdropsantiburn.managers.EventManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {
    //Settings
    public final static String PROJECT_NAME = "SpigotTemplate";
    public final static String PROJECT_ID = "st";

    //Managers
    private EventManager eventManager;

    @Override
    public void onEnable() {
        eventManager = new EventManager(this);
    }

    @Override
    public void onDisable() {
        //Save files

        //Save to db
    }
}
