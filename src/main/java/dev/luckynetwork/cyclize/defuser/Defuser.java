package dev.luckynetwork.cyclize.defuser;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Defuser extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DefuseListener(), this);
    }

}

class DefuseListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        if (entity.getType() != EntityType.PRIMED_TNT) return;

        Entity sourceEntity = ((TNTPrimed)entity).getSource();
        if (sourceEntity.getType() != EntityType.PLAYER) return;

        Player source = (Player)sourceEntity;
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have successfully defused &l"+source.getName()+"'s&a TNT!"));
        entity.remove();

    }

}
