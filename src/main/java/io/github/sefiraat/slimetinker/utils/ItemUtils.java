package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.experience.Experience;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    @Nullable
    public static String getToolMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING)) {
            return null;
        }
        return c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getPartMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING)) {
            return null;
        }
        return c.get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING);
    }

    public static void rebuildToolLore(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ThemeUtils.CLICK_INFO + "Head : " + c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING));
        lore.add(ThemeUtils.CLICK_INFO + "Binding : " + c.get(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING));
        lore.add(ThemeUtils.CLICK_INFO + "Rod : " + c.get(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING));
        lore.add("");
        // TODO Tool Properties
        lore.add("PROPERTIES GO HERE");
        lore.add("");
        lore.add(Experience.getLoreExp(c));
        lore.add("");
        lore.add(Experience.getLoreModSlots(c));
        im.setLore(lore);
        itemStack.setItemMeta(im);
    }

}
