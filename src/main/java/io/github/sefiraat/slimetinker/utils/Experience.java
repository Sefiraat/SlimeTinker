package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Tools;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class Experience {

    public static final double EXP_LEVEL_BASE = 100;
    public static final double EXP_GROWTH = 1.3;

    public static void setupExpNewTool(PersistentDataContainer c) {
        c.set(SlimeTinker.inst().getKeys().getToolExpCurrent(), PersistentDataType.INTEGER, 0);
        c.set(SlimeTinker.inst().getKeys().getToolExpRequired(), PersistentDataType.DOUBLE, EXP_LEVEL_BASE);
        c.set(SlimeTinker.inst().getKeys().getToolLevel(), PersistentDataType.INTEGER, 0);
        c.set(SlimeTinker.inst().getKeys().getToolModSlots(), PersistentDataType.INTEGER, 0);
    }

    public static void addToolExp(ItemStack itemStack, int amount, Player player) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;

        // Add the EXP given
        PersistentDataContainer c = im.getPersistentDataContainer();
        int currentExp = c.get(SlimeTinker.inst().getKeys().getToolExpCurrent(), PersistentDataType.INTEGER);
        double expRequired = c.get(SlimeTinker.inst().getKeys().getToolExpRequired(), PersistentDataType.DOUBLE);
        int level = c.get(SlimeTinker.inst().getKeys().getToolLevel(), PersistentDataType.INTEGER);
        int modSlots = c.get(SlimeTinker.inst().getKeys().getToolModSlots(), PersistentDataType.INTEGER);
        int newExp = 0;

        // Check if it's due to level up
        if ((currentExp + amount) >= expRequired) {
            level++;
            modSlots++;
            expRequired = (expRequired * EXP_GROWTH);
            promoteMaterial(itemStack, level, player);
            player.sendMessage(ThemeUtils.SUCCESS + "Your Tinker's tool has leveled up! +1 Modifier Slot");
        } else {
            newExp = currentExp + amount;
        }

        c.set(SlimeTinker.inst().getKeys().getToolExpCurrent(), PersistentDataType.INTEGER, newExp);
        c.set(SlimeTinker.inst().getKeys().getToolExpRequired(), PersistentDataType.DOUBLE, expRequired);
        c.set(SlimeTinker.inst().getKeys().getToolLevel(), PersistentDataType.INTEGER, level);
        c.set(SlimeTinker.inst().getKeys().getToolModSlots(), PersistentDataType.INTEGER, modSlots);

        itemStack.setItemMeta(im);

        ItemUtils.rebuildToolLore(itemStack);

    }

    public static int getToolExp(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolExpCurrent(), PersistentDataType.INTEGER);
    }

    public static int getToolRequiredExp(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolExpRequired(), PersistentDataType.DOUBLE).intValue();
    }

    public static int getToolLevel(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolLevel(), PersistentDataType.INTEGER);
    }

    public static int getToolModifierSlots(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolModSlots(), PersistentDataType.INTEGER);
    }

    public static String getLoreExp(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Level: " +
                ChatColor.WHITE + Experience.getToolLevel(c) +
                ThemeUtils.PASSIVE + " (" + Experience.getToolExp(c) + " / " + Experience.getToolRequiredExp(c) + ")";
    }

    public static String getLoreModSlots(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Modifier Slots: " +
                ChatColor.WHITE + Experience.getToolModifierSlots(c);
    }

    private static void promoteMaterial(ItemStack itemStack, int level, Player player) {
        // Already at max promotion
        if (level > (Tools.LEVEL_NETHERITE + 1)) {
            return;
        }
        String toolType = itemStack.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);
        if (Tools.toolGrowthMap.get(toolType).containsKey(level)) {
            itemStack.setType(Tools.toolGrowthMap.get(toolType).get(level));
            player.sendMessage(ThemeUtils.SUCCESS + "Your tool has been promoted!");
        }

    }



}
