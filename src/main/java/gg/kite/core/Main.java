package gg.kite.core;

import gg.kite.core.config.ConfigManager;
import gg.kite.core.listener.Processor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static final Logger LOGGER = Logger.getLogger("WitherStick");
    private ConfigManager configManager;
    private Processor processor;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);
        processor = new Processor(this);
        getServer().getPluginManager().registerEvents(processor, this);

        getCommand("witherstick").setExecutor((sender, command, label, args) -> {
            if (!(sender instanceof final org.bukkit.entity.Player player)) {
                sender.sendMessage(configManager.getMessageNoPlayer());
                return true;
            }

            if (!player.hasPermission("witherstick.use")) {
                player.sendMessage(configManager.getMessageNoPermission());
                return true;
            }

            gg.kite.core.util.Utils.giveWitherStick(player, configManager);
            player.sendMessage(configManager.getMessageReceived());
            return true;
        });

        LOGGER.info("WitherStick plugin enabled successfully");
    }

    @Override
    public void onDisable() {
        LOGGER.info("WitherStick plugin disabled");
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public Processor getProcessor() {
        return processor;
    }
}