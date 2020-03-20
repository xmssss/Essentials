package com.earth2me.essentials;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;

public class FCBukkitUtil {
    private static HashSet<String> fakePlayers = new HashSet<>(Arrays.asList(
            "[computercraft]",
            "[cofh]",
            "[buildcraft]",
            "[mekanism]",
            "[minefactoryreloaded]",
            "[computercraft]",
            "[forestry]",
            "[openmods]",
            "[extrautilities]",
            "[minecraft]",
            "[draconic-evolution]",
            "[eiokillera]",
            "[eiofarmer]",
            "[fakethaumcraftgolem]",
            "fakethaumcraftgolem",
            "[pr_fake]",
            "[tt]",
            "fakethaumcraft",
            "fakethaumcraftbore",
            "[thaumcrafttablet]"
    ));

    public static HashSet<String> getFakePlayers() {
        return fakePlayers;
    }

    public static boolean isFakePlayer(Player player){
        try {
            return fakePlayers.contains(player.getName().toLowerCase());
        }catch (Throwable ignored){
            return true;
        }
    }
}
