package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.apache.commons.lang.Validate;
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

    public static void setupExpNew(ItemMeta im) {
        PersistentDataAPI.setInt(im, SlimeTinker.inst().getKeys().getStExpCurrent(), 0);
        PersistentDataAPI.setDouble(im, SlimeTinker.inst().getKeys().getStExpRequired(), EXP_LEVEL_BASE);
        PersistentDataAPI.setInt(im, SlimeTinker.inst().getKeys().getStLevel(), 0);
        PersistentDataAPI.setInt(im, SlimeTinker.inst().getKeys().getStModSlots(), 0);
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

            silverChecks(itemStack, im, player);

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
        Validate.notNull(im, "Meta null, grr!");
        String type;
        if (ItemUtils.isTool(itemStack)) {
            type = PersistentDataAPI.getString(im, SlimeTinker.inst().getKeys().getToolInfoToolType());
        } else if (ItemUtils.isArmour(itemStack)) {
            type = PersistentDataAPI.getString(im, SlimeTinker.inst().getKeys().getArmourInfoArmourType());
        } else {
            throw new IllegalArgumentException("Trying to promote something that isn't armour or a tool!");
        }

        if (Guide.getGrowthMap().get(type).containsKey(level)) {
            itemStack.setType(Guide.getGrowthMap().get(type).get(level));
            ItemUtils.repairItem(itemStack);
            player.sendMessage(ThemeUtils.SUCCESS + "Your tool has been promoted!");
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

    private static void silverChecks(ItemStack itemStack, ItemMeta im, Player player) {
        if (ItemUtils.isEnchanting(itemStack)) {
            int number = ItemUtils.isEnchanting2(itemStack) ? 3 : 1;
            int amount = ThreadLocalRandom.current().nextInt(1, number + 1);
            for (int i = 0; i < amount; i++) {
                ItemUtils.incrementRandomEnchant(itemStack, im);
            }
            player.sendMessage(ThemeUtils.SUCCESS + "It also gained [" + amount + "] random enchantment(s)! Hope it's good :>");
        }
    }





}
