package com.betaken.tpposition;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TpPosition extends JavaPlugin implements Listener{

    public void onEnable() {
        getCommand("teleport").setExecutor(new TpPositionCommand());
        getCommand("tp").setExecutor(new TpPositionCommand2());
        getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {

    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        Player p = e.getPlayer();

        p.sendMessage(ChatColor.GOLD + "Teleported to " + e.getTarget().getX() + ", " + e.getTarget().getY() + ", " + e.getTarget().getZ() + "!");
    }
}
