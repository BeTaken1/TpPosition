package com.betaken.tpposition;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpPositionCommand2 implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {

        if (s instanceof Player) {
            if (c.getName().equalsIgnoreCase("tp")) {
                if (s.hasPermission("tp.use")) {
                    Player p = (Player) s;
                    if (args.length == 0) {
                        p.sendMessage(ChatColor.RED + "Please supply a player to teleport to!");
                        return true;
                    }
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "That player isn't online!");
                        return true;
                    }
                    p.teleport(target);

                    PlayerTeleportEvent event = new PlayerTeleportEvent(p, target.getLocation());

                    Bukkit.getServer().getPluginManager().callEvent(event);
                }
            }
        }

        return false;
    }
}