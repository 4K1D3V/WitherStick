package gg.kite.core.config;

import gg.kite.core.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final Main plugin;
    private FileConfiguration config;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    public int getCooldownTicks() {
        return config.getInt("cooldown-ticks", 60);
    }

    public double getSkullVelocity() {
        return config.getDouble("skull-velocity", 1.5);
    }

    public String getWitherStickName() {
        return config.getString("wither-stick-name", "§5Wither Wand");
    }

    public int getCustomModelData() {
        return config.getInt("custom-model-data", 1001);
    }

    public boolean isUnbreakable() {
        return config.getBoolean("unbreakable", false);
    }

    public boolean isChargedSkull() {
        return config.getBoolean("charged-skull", false);
    }

    public boolean isSoundEnabled() {
        return config.getBoolean("sound-enabled", true);
    }

    public String getSoundEffect() {
        return config.getString("sound-effect", "entity.wither.shoot");
    }

    public float getSoundVolume() {
        return (float) config.getDouble("sound-volume", 1.0);
    }

    public float getSoundPitch() {
        return (float) config.getDouble("sound-pitch", 1.0);
    }

    public String getMessageNoPlayer() {
        return config.getString("messages.no-player", "§cThis command can only be used by players!");
    }

    public String getMessageNoPermission() {
        return config.getString("messages.no-permission", "§cYou don't have permission to use this!");
    }

    public String getMessageReceived() {
        return config.getString("messages.received", "§aYou received a Wither Wand!");
    }

    public String getMessageCooldown() {
        return config.getString("messages.cooldown", "§cWither Wand is on cooldown!");
    }

    public String getMessageLaunched() {
        return config.getString("messages.launched", "§dWither Skull launched!");
    }

    public String getMessageError() {
        return config.getString("messages.error", "§cError launching wither skull!");
    }
}