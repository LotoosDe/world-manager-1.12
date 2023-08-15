package de.hyper.worlds.domain.using.apis;

import com.boydti.fawe.object.FawePlayer;
import de.hyper.worlds.domain.WorldManagement;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FaweAPI {

    private final List<Player> hasWEA;
    private boolean existsFAWE;

    public FaweAPI() {
        existsFAWE = WorldManagement.get().getDependencyManager().getDependency("FaweBukkit").isEnabled();
        if (!existsFAWE) {
            WorldManagement.get().getLogger().warning(
                    "Plugin FastAsyncWorldEdit wasn't found, make sure to install FastAsyncWorldEdit to enable FAWE support.");
        }
        hasWEA = new CopyOnWriteArrayList<>();
    }

    public void setWEA(Player player, boolean allowed) {
        System.out.println("setWEA for " + player.getName() + " to " + allowed);
        try {
            System.out.println(player.getName() + ": fawe exists");
            if (!hasWEA.contains(player) && allowed) {
                System.out.println(player.getName() + ": hat noch kein wea & soll haben");
                System.out.println(player.getName() + ": toggle: " + getFaweActor(player).toggle("fawe.bypass"));
                System.out.println(player.getName() + ": add: " + hasWEA.add(player));
            } else if (hasWEA.contains(player) && !allowed) {
                getFaweActor(player).toggle("fawe.bypass");
                hasWEA.remove(player);
                System.out.println(player.getName() + ": wea wurde entfernt");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FawePlayer getFaweActor(Player player) {
        return FawePlayer.wrap(player);
    }
}
