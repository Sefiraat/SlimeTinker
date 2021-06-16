package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
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
        lore.add("");
        lore.add(ThemeUtils.CLICK_INFO + "Head : " + formatMaterialName(getToolHeadMaterial(c)));
        lore.add(ThemeUtils.CLICK_INFO + "Binding : " + formatMaterialName(getToolBindingMaterial(c)));
        lore.add(ThemeUtils.CLICK_INFO + "Rod : " + formatMaterialName(getToolRodMaterial(c)));

        // Material properties
        lore.add("");
        // TODO Tool Properties
        lore.add("PROPERTIES GO HERE");

        // Exp / Leveling information
        lore.add("");
        lore.add(Experience.getLoreExp(c));

        // Modification Information
        lore.add("");
        lore.add(Experience.getLoreModSlots(c));

        LinkedHashMap<Material, Integer> mapAmounts = Modifications.getModificationMap(itemStack);
        Map<Material, Integer> mapLevels = Modifications.getAllModLevels(itemStack);

        for (Map.Entry<Material, Integer> entry : mapLevels.entrySet()) {
            lore.add(ThemeUtils.toTitleCase(entry.getKey().toString()) + " - " + entry.getValue() + " (" + mapAmounts.get(entry.getKey()) + ")"); // TODO fetch the max required
        }

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
