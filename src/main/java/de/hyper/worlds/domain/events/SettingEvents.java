package de.hyper.worlds.domain.events;

import de.hyper.worlds.common.enums.SettingType;
import de.hyper.worlds.common.obj.world.PlayerUseWorldChatEvent;
import de.hyper.worlds.common.obj.world.ServerWorld;
import de.hyper.worlds.common.obj.world.ServerWorldSettingChangedEvent;
import de.hyper.worlds.common.obj.world.setting.StatePart;
import de.hyper.worlds.common.obj.world.setting.WorldSetting;
import de.hyper.worlds.common.util.Converter;
import de.hyper.worlds.domain.WorldManagement;
import de.hyper.worlds.domain.using.Performance;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.List;

public class SettingEvents implements Listener {

    Performance performance = WorldManagement.get().getPerformance();

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        performance.checkAndUnloadAllUnloadWorlds();
        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            if (!player.hasPermission("worldmanager.admin.bypass.settings.gamemode")) {
                WorldSetting setting = serverWorld.getWorldSetting(SettingType.GAMEMODE);
                StatePart part = setting.getState().getActive();
                String value = part.getValue();
                if (!value.equals("keep")) {
                    player.setGameMode(GameMode.valueOf(value.toUpperCase()));
                }
            }
        }
    }

    @EventHandler
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            if (!player.hasPermission("worldmanager.admin.bypass.settings.gamemode")) {
                WorldSetting setting = serverWorld.getWorldSetting(SettingType.GAMEMODE);
                StatePart part = setting.getState().getActive();
                String value = part.getValue();
                if (!value.equals("keep")) {
                    player.setGameMode(GameMode.valueOf(value.toUpperCase()));
                }
            }
        }
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_BURN);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onBlockGrow(BlockGrowEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_GROW);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_FROM_TO);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_FORM);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onEntityBlockForm(EntityBlockFormEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.ENTITY_BLOCK_FORM);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_SPREAD);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent event) {
        if (event.getEntity() instanceof Animals || event.getEntity() instanceof Monster) {
            World world = event.getEntity().getWorld();
            ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
            if (serverWorld != null) {
                WorldSetting setting = serverWorld.getWorldSetting(SettingType.MOB_SPAWNING);
                StatePart part = setting.getState().getActive();
                boolean value = Converter.getBoolean(part.getValue());
                event.setCancelled(!value);
            }
        }
    }

    @EventHandler
    public void onCreateSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Animals || event.getEntity() instanceof Monster) {
            World world = event.getEntity().getWorld();
            ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
            if (serverWorld != null) {
                WorldSetting setting = serverWorld.getWorldSetting(SettingType.MOB_SPAWNING);
                StatePart part = setting.getState().getActive();
                boolean value = Converter.getBoolean(part.getValue());
                event.setCancelled(!value);
            }
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        World world = event.getEntity().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.HUNGER);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                player.setFoodLevel(20);
            }
        }
    }

    @EventHandler
    public void onEntityPotionEffect(PotionSplashEvent event) {
        World world = event.getEntity().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.POTION);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onLingeringPotionSplash(LingeringPotionSplashEvent event) {
        World world = event.getEntity().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.POTION);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        performance.checkAndUnloadAllUnloadWorlds();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        performance.checkAndUnloadAllUnloadWorlds();
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.EXPLOSION);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        World world = event.getEntity().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.EXPLOSION);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.LEAF_DECAY);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onServerWorldChangedSetting(ServerWorldSettingChangedEvent event) {
        World world = event.getWorld();
        ServerWorld serverWorld = event.getServerWorld();
        SettingType settingType = event.getSettingType();
        WorldSetting setting = serverWorld.getWorldSetting(event.getSettingType());
        StatePart part = setting.getState().getActive();
        String value = part.getValue();
        if (settingType == SettingType.TIME) {
            if (value.equals("-1")) {
                world.setGameRuleValue("duDayligtCycle", "true");
            } else {
                world.setGameRuleValue("duDayligtCycle", "false");
                world.setTime(Converter.getPositiveLong(value));
            }
        }
        if (settingType == SettingType.MOB_DROPS) {
            world.setGameRuleValue("doEntityDrops", "false");
        }
        if (settingType == SettingType.WEATHER) {
            if (value.equals("running")) {
                world.setGameRuleValue("doWeatherCycle", "true");
                return;
            }
            world.setGameRuleValue("doWeatherCycle", "false");
            if (value.equals("sun")) {
                world.setStorm(false);
                world.setThundering(false);
            } else if (value.equals("rain")) {
                world.setStorm(true);
                world.setThundering(false);
            } else if (value.equals("storm")) {
                world.setStorm(true);
                world.setThundering(true);
            }
        }
        if (settingType == SettingType.RANDOMTICKSPEED) {
            world.setGameRuleValue("randomTickSpeed", "" + Converter.getInteger(value));
        }
        if (settingType == SettingType.SIZE) {
            WorldBorder border = world.getWorldBorder();
            border.setCenter(serverWorld.getSpawnLocation());
            border.setSize(Converter.getDouble(value));
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        World world = event.getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.WEATHER);
            StatePart part = setting.getState().getActive();
            String value = part.getValue();
            if (!value.equals("running")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_FADE);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.REDSTONE);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            if (!value) {
                event.setNewCurrent(0);
            }
        }
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            Block block = event.getBlock();
            //boolean powerable = isPowerable(block);
            SettingType settingType = SettingType.BLOCK_PHYSICS;
            WorldSetting setting = serverWorld.getWorldSetting(settingType);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    public boolean isPowerable(Block block) {
        List<Material> materialList = List.of(Material.REDSTONE, Material.PISTON_BASE, Material.PISTON_STICKY_BASE,
                Material.WOOD_BUTTON, Material.STONE_BUTTON, Material.POWERED_RAIL,
                Material.COMMAND, Material.COMMAND_CHAIN, Material.COMMAND_MINECART,
                Material.COMMAND_REPEATING, Material.DIODE, Material.REDSTONE_COMPARATOR,
                Material.REDSTONE_TORCH_ON, Material.REDSTONE_TORCH_ON, Material.REDSTONE_WIRE,
                Material.REDSTONE_LAMP_ON, Material.REDSTONE_LAMP_OFF, Material.OBSERVER,
                Material.HOPPER, Material.DISPENSER, Material.DROPPER,
                Material.LEVER, Material.DAYLIGHT_DETECTOR, Material.TRIPWIRE,
                Material.TRIPWIRE_HOOK, Material.TRAPPED_CHEST, Material.TNT,
                Material.NOTE_BLOCK, Material.WOOD_PLATE, Material.STONE_PLATE,
                Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.DARK_OAK_DOOR,
                Material.IRON_DOOR, Material.IRON_TRAPDOOR, Material.JUNGLE_DOOR,
                Material.SPRUCE_DOOR, Material.ACACIA_FENCE_GATE, Material.BIRCH_FENCE_GATE,
                Material.DARK_OAK_FENCE_GATE, Material.JUNGLE_FENCE_GATE, Material.SPRUCE_FENCE_GATE,
                Material.REDSTONE_BLOCK);
        return materialList.contains(block.getType());
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        World world = event.getBlock().getWorld();
        ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
        if (serverWorld != null) {
            WorldSetting setting = serverWorld.getWorldSetting(SettingType.BLOCK_PHYSICS);
            StatePart part = setting.getState().getActive();
            boolean value = Converter.getBoolean(part.getValue());
            event.setCancelled(!value);
        }
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (WorldManagement.get().getConfiguration().getData("enableable-world-chats").asBoolean()) {
            Player player = event.getPlayer();
            World world = player.getWorld();
            ServerWorld serverWorld = WorldManagement.get().getCache().getServerWorld(world.getName());
            if (serverWorld != null) {
                WorldSetting setting = serverWorld.getWorldSetting(SettingType.WORLDCHAT);
                StatePart part = setting.getState().getActive();
                boolean value = Converter.getBoolean(part.getValue());
                event.setCancelled(value);
                if (value) {
                    performance.sync(() -> {
                        String message = event.getMessage();
                        PlayerUseWorldChatEvent eventToCall = new PlayerUseWorldChatEvent(player, WorldManagement.get().getCache().getServerUser(player.getUniqueId()), serverWorld, message);
                        Bukkit.getPluginManager().callEvent(eventToCall);
                        if (!eventToCall.isCancelled()) {
                            BaseComponent baseComponent;
                            if (eventToCall.getMessageAsComponent() != null) {
                                baseComponent = eventToCall.getMessageAsComponent();
                            } else {
                                baseComponent = WorldManagement.get().getLoadHelper().getDefaultMessageComponentForWorldChat(eventToCall);
                            }
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                if (players.getWorld().equals(world)) {
                                    players.spigot().sendMessage(baseComponent);
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}