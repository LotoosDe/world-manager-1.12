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
        if (existsFAWE) {
            getFaweActor(player).toggle("fawe.bypass");
        }
    }

    public FawePlayer getFaweActor(Player player) {
        return FawePlayer.wrap(player);
    }
}
