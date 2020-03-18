package com.earth2me.essentials.api.events;

import com.earth2me.essentials.Trade;
import net.ess3.api.IUser;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserHomeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private IUser user;
    private Location homeLocation;
    private String homeName;
    private Trade trade;
    private boolean cancelled = false;


    public UserHomeEvent(IUser user, Location homeLocation, String homeName, Trade trade) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.user = user;
        this.homeLocation = homeLocation;
        this.homeName = homeName;
        this.trade = trade;
    }

    public IUser getUser() {
        return user;
    }


    public String getHomeName() {
        return homeName;
    }

    public Location getHomeLocation() {
        return homeLocation;
    }

    /**
     * Getting payment handling information
     * @return The payment handling class
     */
    public Trade getTrade() {
        return trade;
    }

    public void setHomeLocation(Location homeLocation) {
        this.homeLocation = homeLocation;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}