package com.betaken.tpposition;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerTeleportEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private Player player;
    private Location target;

    public PlayerTeleportEvent(Player player, Location target) {
        this.player = player;
        this.target = target;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getTarget() {
        return target;
    }
}