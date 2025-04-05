package gg.kite.core.util;

import gg.kite.core.config.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils {
    public static void giveWitherStick(Player player, ConfigManager config) {
        ItemStack witherStick = new ItemStack(Material.STICK);
        ItemMeta meta = witherStick.getItemMeta();

        if (meta != null) {
            meta.displayName(LegacyComponentSerializer.legacySection().deserialize(config.getWitherStickName()));
            meta.setCustomModelData(config.getCustomModelData());
            meta.setUnbreakable(config.isUnbreakable());
            witherStick.setItemMeta(meta);
        }

        player.getInventory().addItem(witherStick);
    }

    public static boolean isWitherStick(ItemStack item, ConfigManager config) {
        if (item == null || item.getType() != Material.STICK || !item.hasItemMeta()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        Component displayName = meta.displayName();
        String name = displayName != null ? LegacyComponentSerializer.legacySection().serialize(displayName) : "";
        return meta != null &&
                config.getWitherStickName().equals(name) &&
                meta.hasCustomModelData() &&
                meta.getCustomModelData() == config.getCustomModelData();
    }
}