package com.earth2me.essentials.commands;

import com.earth2me.essentials.User;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import java.util.Collections;
import java.util.List;

import static com.earth2me.essentials.I18n.tl;


public class Commandtpo extends EssentialsCommand {
    public Commandtpo() {
        super("tpo");
    }

    @Override
    public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
        switch (args.length) {
            case 0:
                throw new NotEnoughArgumentsException();
            default:
                if (!user.isAuthorized("essentials.tp.offline")) {
                    throw new Exception(tl("noPerm", "essentials.tp.offline"));
                }

                final User toPlayer = getPlayer(server, args, 0, true, true);

                Location location = (toPlayer.getBase() != null && toPlayer.getBase().isOnline())  ? toPlayer.getLocation() : toPlayer.getLogoutLocation();
                user.getTeleport().now(location,false,TeleportCause.COMMAND);
                break;
        }
    }

    @Override
    protected List<String> getTabCompleteOptions(Server server, User user, String commandLabel, String[] args) {
        // Don't handle coords
        if (args.length == 1 || (args.length == 2 && user.isAuthorized("essentials.tp.others"))) {
            return getPlayers(server, user);
        } else {
            return Collections.emptyList();
        }
    }
}
