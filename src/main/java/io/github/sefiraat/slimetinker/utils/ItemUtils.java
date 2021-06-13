package io.github.sefiraat.slimetinker.utils;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class ItemUtils {

    private ItemUtils() {
        throw new IllegalStateException("Utility class");
    }

    @Nullable
    public static String getItemName(ItemStack itemStack) {
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (slimefunItem == null) {
            if (!itemStack.hasItemMeta()) {
                return itemStack.getType().toString();
            }
        } else {
            return slimefunItem.getId();
        }
        return null;
    }

}
