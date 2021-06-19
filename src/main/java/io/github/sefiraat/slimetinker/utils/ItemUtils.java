package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.properties.Properties;
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


    public static void incrementRepair(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        damageable.setDamage(Math.max((damageable.getDamage() - 1), 0));
        itemStack.setItemMeta(im);
    }

    public static void incrementRepair(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        damageable.setDamage(Math.max((damageable.getDamage() - amount), 0));
        itemStack.setItemMeta(im);
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

        String matHead = getToolHeadMaterial(c);
        String matBind = getToolBindingMaterial(c);
        String matRod = getToolRodMaterial(c);

        // General Material information
        lore.add(line());
        lore.add(ThemeUtils.CLICK_INFO + "H: " + formatMaterialName(matHead));
        lore.add(ThemeUtils.CLICK_INFO + "B: " + formatMaterialName(matBind));
        lore.add(ThemeUtils.CLICK_INFO + "R: " + formatMaterialName(matRod));
        lore.add(line());

        // Material properties
        lore.add(formatPropertyName(matHead, Properties.PROP_MAP_HEAD.get(matHead)));
        lore.add(formatPropertyName(matBind, Properties.PROP_MAP_BIND.get(matBind)));
        lore.add(formatPropertyName(matRod, Properties.PROP_MAP_ROD.get(matRod)));
        lore.add(line());

        // Exp / Leveling / Mod Slot information
        lore.add(Experience.getLoreExp(c));
        lore.add(Experience.getLoreModSlots(c));
        lore.add(line());

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
        if (!mapLevels.isEmpty()) {
            lore.add(line());
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
        String s = c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING);
        assert s != null;
        return s;
    }

    public static String getToolBindingMaterial(PersistentDataContainer c) {
        String s =  c.get(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING);
        assert s != null;
        return s;
    }

    public static String getToolRodMaterial(PersistentDataContainer c) {
        String s =  c.get(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING);
        assert s != null;
        return s;
    }

    public static String formatMaterialName(String s) {
        return ChatColor.of(ComponentMaterials.getById(s).getColorHex()) + ThemeUtils.toTitleCase(s);
    }

    public static String formatPropertyName(String s, String p) {
        return ChatColor.of(ComponentMaterials.getById(s).getColorHex()) + ThemeUtils.toTitleCase(p);
    }

    public static String line() {
        return ThemeUtils.PASSIVE + "-".repeat(25);
    }

}
