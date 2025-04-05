package gg.kite.core.listener;

import gg.kite.core.Main;
import gg.kite.core.util.Utils;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Logger;

public class Processor implements Listener {
    private static final Logger LOGGER = Logger.getLogger("WitherStick");
    private final Main plugin;
    private long lastCleanup = System.currentTimeMillis();

    public Processor(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (System.currentTimeMillis() - lastCleanup > 60000) {
            cleanup();
        }

        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (!shouldProcessEvent(event, item)) {
            return;
        }

        event.setCancelled(true);

        if (!player.hasPermission("witherstick.use")) {
            player.sendMessage(plugin.getConfigManager().getMessageNoPermission());
            return;
        }

        if (player.hasCooldown(Material.STICK)) {
            player.sendMessage(plugin.getConfigManager().getMessageCooldown());
            return;
        }

        launchWitherSkull(player);
    }

    private boolean shouldProcessEvent(PlayerInteractEvent event, ItemStack item) {
        return item != null &&
                Utils.isWitherStick(item, plugin.getConfigManager()) &&
                event.getAction().isRightClick();
    }

    private void launchWitherSkull(Player player) {
        try {
            WitherSkull skull = player.launchProjectile(WitherSkull.class);
            skull.setVelocity(player.getLocation().getDirection()
                    .multiply(plugin.getConfigManager().getSkullVelocity()));
            skull.setCharged(plugin.getConfigManager().isChargedSkull());

            player.setCooldown(Material.STICK, plugin.getConfigManager().getCooldownTicks());

            if (plugin.getConfigManager().isSoundEnabled()) {
                player.getWorld().playSound(
                        player.getLocation(),
                        plugin.getConfigManager().getSoundEffect(),
                        SoundCategory.PLAYERS,
                        plugin.getConfigManager().getSoundVolume(),
                        plugin.getConfigManager().getSoundPitch()
                );
            }

            player.sendMessage(plugin.getConfigManager().getMessageLaunched());
        } catch (Exception e) {
            LOGGER.severe("Error launching wither skull: " + e.getMessage());
            player.sendMessage(plugin.getConfigManager().getMessageError());
        }
    }

    private void cleanup() {
        lastCleanup = System.currentTimeMillis();
    }
}