package dev.lightdream.mobdropsantiburn.managers;

import dev.lightdream.mobdropsantiburn.Main;
import dev.lightdream.mobdropsantiburn.utils.Utils;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftItem;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventManager implements Listener {

    public final Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        for (int i = 0; i < event.getDrops().size(); i++) {
            event.getDrops().set(i, Utils.setNBT(event.getDrops().get(i), "do_not_burn", true));
        }
    }
    /*

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemBurn(EntityCombustEvent e) {
        if (e.getEntityType() == EntityType.DROPPED_ITEM) {
            System.out.println("cancel");
            e.getEntity().setFireTicks(0);
            e.setCancelled(true);
        }
    }
    */

    @EventHandler
    public void on(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof CraftItem) {
            System.out.println(entity);
            Boolean doNotBurn = (Boolean) Utils.getNBT(((CraftItem) entity).getItemStack(), "do_not_burn");
            if (doNotBurn != null && doNotBurn) {
                System.out.println("cancel");
                event.getEntity().setFireTicks(0);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void on(EntityCombustEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof CraftItem) {
            System.out.println(entity);
            Boolean doNotBurn = (Boolean) Utils.getNBT(((CraftItem) entity).getItemStack(), "do_not_burn");
            if (doNotBurn != null && doNotBurn) {
                System.out.println("cancel");
                event.getEntity().setFireTicks(0);
                event.setCancelled(true);
            }
        }
    }
}
