package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class WorldUtils {

    public static void dropItem(ItemStack i, Player p) {
        dropItem(p.getWorld(), p.getLocation(), i);
    }

    public static void dropItem(ItemStack i, Location l) {
        Validate.notNull(l.getWorld(), "Location doesn't have a world");
        dropItem(l.getWorld(), l, i);
    }

    public static void dropItem(ItemStack i, Block b) {
        dropItem(b.getWorld(), b.getLocation(), i);
    }

    public static void dropItem(World w, Location l, ItemStack i) {
        w.dropItemNaturally(l, i);
    }

}
