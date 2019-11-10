package com.earth2me.essentials.api;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ESAPIUtil {

    public static User getUser(Player player){
        return Essentials.instance.getUser(player);
    }

    public static User getUser(UUID playerUUID){
        return Essentials.instance.getUser(playerUUID);
    }

    public static boolean isIgnoring(Player player, Player otherPlayer){
        User userPlayer = getUser(player);
        User userOtherPlayer = getUser(otherPlayer);
        return userPlayer.isIgnoredPlayer(userOtherPlayer);
    }

}
