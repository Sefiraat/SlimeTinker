package io.github.sefiraat.slimetinker.utils;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.factories.CMManager;
import io.github.sefiraat.slimetinker.items.componentmaterials.recipes.MoltenResult;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UtilityClass
public final class ItemUtils {

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
        lore.add(ThemeUtils.getLine());
        lore.add(ThemeUtils.CLICK_INFO + "H: " + formatMaterialName(matHead));
        lore.add(ThemeUtils.CLICK_INFO + "B: " + formatMaterialName(matBind));
        lore.add(ThemeUtils.CLICK_INFO + "R: " + formatMaterialName(matRod));
        lore.add(ThemeUtils.getLine());

        // Material properties
        lore.add(formatPropertyName(matHead, CMManager.getTraitName(matHead, TraitPartType.HEAD)));
        lore.add(formatPropertyName(matBind, CMManager.getTraitName(matBind, TraitPartType.BINDER)));
        lore.add(formatPropertyName(matRod, CMManager.getTraitName(matRod, TraitPartType.ROD)));
        lore.add(ThemeUtils.getLine());

        // Exp / Leveling / Mod Slot information
        lore.add(Experience.getLoreExp(c));
        lore.add(Experience.getLoreModSlots(c));
        lore.add(ThemeUtils.getLine());

        // Active Mods
        Map<String, Integer> mapAmounts = Modifications.getModificationMap(itemStack);
        Map<String, Integer> mapLevels = Modifications.getAllModLevels(itemStack);

        for (Map.Entry<String, Integer> entry : mapLevels.entrySet()) {
            int level = entry.getValue();
            Mod mod = Modifications.getMODIFICATION_DEFINITIONS().get(entry.getKey());
            if (mod.getRequirementMap().containsKey(level + 1)) {
                String amountRequired = String.valueOf(mod.getRequirementMap().get(level + 1));
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (" + mapAmounts.get(entry.getKey()) + "/" + amountRequired + ")");
            } else {
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (MAX)");
            }
        }
        if (!mapLevels.isEmpty()) {
            lore.add(ThemeUtils.getLine());
        }

        im.setLore(lore);
        itemStack.setItemMeta(im);

    }

    public static void rebuildToolName(ItemStack itemStack) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matHead = getToolHeadMaterial(c);
        String matBind = getToolBindingMaterial(c);
        String matRod = getToolRodMaterial(c);
        String toolType = getToolTypeName(c);

        String name =
                        CMManager.getById(matHead).getColor() + ThemeUtils.toTitleCase(matHead) + "-" +
                        CMManager.getById(matBind).getColor() + ThemeUtils.toTitleCase(matBind) + "-" +
                        CMManager.getById(matRod).getColor() + ThemeUtils.toTitleCase(matRod) + " " +
                        ChatColor.WHITE + ThemeUtils.toTitleCase(toolType);


        im.setDisplayName(name);
        itemStack.setItemMeta(im);

    }

    public static boolean isToolBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        // Tool is 'broken'
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    public static void damageTool(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        if ((damageable.getDamage() + amount) >= itemStack.getType().getMaxDurability()) { // This will break the tool, lets stop that!
            damageable.setDamage(itemStack.getType().getMaxDurability() - 1);
        } else {
            damageable.setDamage(damageable.getDamage() + amount);
        }
        itemStack.setItemMeta(im);
    }

    public static void repairTool(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        assert d != null;
        d.setDamage(0);
        itemStack.setItemMeta(im);
    }

    public static void repairTool(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        assert d != null;
        d.setDamage(Math.max(d.getDamage() - amount, 0));
        itemStack.setItemMeta(im);
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

    public static String getToolTypeName(PersistentDataContainer c) {
        String s = c.get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);
        assert s != null;
        return s;
    }

    public static String formatMaterialName(String s) {
        return CMManager.getById(s).getColor() + ThemeUtils.toTitleCase(s);
    }

    public static String formatPropertyName(String s, String p) {
        return CMManager.getColorById(s) + p;
    }

    public static boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.inst().getCmManager().meltingRecipes.containsKey(StackUtils.getIDorType(itemStack));
    }

    public static MoltenResult getMoltenResult(ItemStack itemStack) {
        return SlimeTinker.inst().getCmManager().meltingRecipes.get(StackUtils.getIDorType(itemStack));
    }
}
