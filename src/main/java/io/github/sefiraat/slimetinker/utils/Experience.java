package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class Experience {

    public static final double EXP_LEVEL_BASE = 100;
    public static final double EXP_GROWTH = 1.3;

    public static void setupExpNew(PersistentDataContainer c) {
        c.set(SlimeTinker.inst().getKeys().getStExpCurrent(), PersistentDataType.INTEGER, 0);
        c.set(SlimeTinker.inst().getKeys().getStExpRequired(), PersistentDataType.DOUBLE, EXP_LEVEL_BASE);
        c.set(SlimeTinker.inst().getKeys().getStLevel(), PersistentDataType.INTEGER, 0);
        c.set(SlimeTinker.inst().getKeys().getStModSlots(), PersistentDataType.INTEGER, 0);
    }

    public static void addExp(ItemStack itemStack, int amount, Player player, boolean tool) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        if (copperChecks(itemStack, player, amount)) {
            return;
        }

        // Add the EXP given
        int currentExp = c.get(SlimeTinker.inst().getKeys().getStExpCurrent(), PersistentDataType.INTEGER);
        double expRequired = c.get(SlimeTinker.inst().getKeys().getStExpRequired(), PersistentDataType.DOUBLE);
        int level = c.get(SlimeTinker.inst().getKeys().getStLevel(), PersistentDataType.INTEGER);
        int modSlots = c.get(SlimeTinker.inst().getKeys().getStModSlots(), PersistentDataType.INTEGER);
        int newExp = 0;

        // Emerald mod
        Map<String, Integer> modLevels = Modifications.getAllModLevels(itemStack);

        if (modLevels.containsKey(Material.EMERALD.toString())) { // EMERALD
            int eLevel = modLevels.get(Material.EMERALD.toString());
            if (eLevel > 0) amount = tool ? amount + eLevel : (int) Math.ceil(amount * (eLevel * 0.1));
        }

        // Check if it's due to level up
        if ((currentExp + amount) >= expRequired) {

            level++;
            modSlots++;
            expRequired = (expRequired * EXP_GROWTH);
            promoteMaterial(itemStack, level, player);
            player.sendMessage(ThemeUtils.SUCCESS + "Your Tinker's tool has leveled up! +1 Modifier Slot");

            silverChecks(itemStack, player);

        } else {
            newExp = currentExp + amount;
        }

        c.set(SlimeTinker.inst().getKeys().getStExpCurrent(), PersistentDataType.INTEGER, newExp);
        c.set(SlimeTinker.inst().getKeys().getStExpRequired(), PersistentDataType.DOUBLE, expRequired);
        c.set(SlimeTinker.inst().getKeys().getStLevel(), PersistentDataType.INTEGER, level);
        c.set(SlimeTinker.inst().getKeys().getStModSlots(), PersistentDataType.INTEGER, modSlots);

        itemStack.setItemMeta(im);

        ItemUtils.rebuildTinkerLore(itemStack);

    }

    private static void promoteMaterial(ItemStack itemStack, int level, Player player) {
        // Already at max promotion
        if (level > (Guide.LEVEL_TOOLS_NETHERITE + 1)) {
            return;
        }
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        String toolType = im.getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);
        if (Guide.getGrowthMap().get(toolType).containsKey(level)) {
            itemStack.setType(Guide.getGrowthMap().get(toolType).get(level));
            ItemUtils.repairTool(itemStack);
            player.sendMessage(ThemeUtils.SUCCESS + "Your tool has been promoted!");
            ItemUtils.repairTool(itemStack);
        }

    }

    private static boolean copperChecks(ItemStack itemStack, Player player, int amount) {
        if (ItemUtils.isConductive1(itemStack)) {
            player.giveExp(amount);
            return true;
        } else if (ItemUtils.isConductive2(itemStack)) {
            player.giveExp((int) Math.ceil(amount * 1.5));
            return true;
        }
        return false;
    }

    private static void silverChecks(ItemStack itemStack, Player player) {
        if (ItemUtils.isEnchanting(itemStack)) {
            int number = ItemUtils.isEnchanting2(itemStack) ? 3 : 1;
            int amount = ThreadLocalRandom.current().nextInt(1, number + 1);
            for (int i = 0; i < amount; i++) {
                ItemUtils.incrementRandomEnchant(itemStack);
            }
            player.sendMessage(ThemeUtils.SUCCESS + "It also gained [" + amount + "] random enchantment(s)! Hope it's good :>");
        }
    }





}
