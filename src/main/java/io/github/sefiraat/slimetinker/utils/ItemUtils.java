package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


        // General Material information
        lore.add(ThemeUtils.PASSIVE + "-".repeat(20));
        lore.add(ThemeUtils.CLICK_INFO + "Head : " + formatMaterialName(getToolHeadMaterial(c)));
        lore.add(ThemeUtils.CLICK_INFO + "Binding : " + formatMaterialName(getToolBindingMaterial(c)));
        lore.add(ThemeUtils.CLICK_INFO + "Rod : " + formatMaterialName(getToolRodMaterial(c)));
        lore.add(ThemeUtils.PASSIVE + "-".repeat(20));

        // Material properties
        // TODO Tool Properties
        lore.add("PROPERTIES GO HERE");
        lore.add(ThemeUtils.PASSIVE + "-".repeat(20));

        // Exp / Leveling / Mod Slot information
        lore.add(Experience.getLoreExp(c));
        lore.add(Experience.getLoreModSlots(c));
        lore.add(ThemeUtils.PASSIVE + "-".repeat(20));

        // Active Mods
        LinkedHashMap<String, Integer> mapAmounts = Modifications.getModificationMap(itemStack);
        Map<String, Integer> mapLevels = Modifications.getAllModLevels(itemStack);

        for (Map.Entry<String, Integer> entry : mapLevels.entrySet()) {
            int level = entry.getValue();
            Mod mod = Modifications.MODIFICATION_DEFINITIONS.get(entry.getKey());
            if (mod.getRequirementMap().containsKey(level + 1)) {
                String amountRequired = String.valueOf(mod.getRequirementMap().get(level + 1));
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey().toString()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (" + mapAmounts.get(entry.getKey()) + "/" + amountRequired + ")");
            } else {
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey().toString()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (MAX)");
            }
        }

        im.setLore(lore);
        itemStack.setItemMeta(im);

    }

    public static boolean isToolBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        // Tool is 'broken'
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
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
