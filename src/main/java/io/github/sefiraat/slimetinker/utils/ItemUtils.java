package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.md_5.bungee.api.ChatColor;
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
        lore.add(ThemeUtils.CLICK_INFO + "Head : " + formatMaterialName(getToolHeadMaterial(c)));
        lore.add(ThemeUtils.CLICK_INFO + "Binding : " + formatMaterialName(getToolBindingMaterial(c)));
        lore.add(ThemeUtils.CLICK_INFO + "Rod : " + formatMaterialName(getToolRodMaterial(c)));
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

    public static String getToolHeadMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING);
    }

    public static String getToolBindingMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING);
    }

    public static String getToolRodMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING);
    }

    public static String formatMaterialName(String s) {
        return ChatColor.of(ComponentMaterials.getById(s).getColorHex()) + ThemeUtils.toTitleCase(s);
    }

}
