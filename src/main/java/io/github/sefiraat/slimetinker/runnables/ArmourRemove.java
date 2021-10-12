package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ArmourRemove extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.inst().getServer().getOnlinePlayers()) {

            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();

            if (ItemUtils.isArmour(helmet) && ItemUtils.isTinkersBroken(helmet) && ItemUtils.doesUnequipWhenBroken(helmet)) {
                unequip(player, helmet);
            }
            if (ItemUtils.isArmour(chestplate) && ItemUtils.isTinkersBroken(chestplate) && ItemUtils.doesUnequipWhenBroken(chestplate)) {
                unequip(player, chestplate);
            }
            if (ItemUtils.isArmour(leggings) && ItemUtils.isTinkersBroken(leggings) && ItemUtils.doesUnequipWhenBroken(leggings)) {
                unequip(player, leggings);
            }
            if (ItemUtils.isArmour(boots) && ItemUtils.isTinkersBroken(boots) && ItemUtils.doesUnequipWhenBroken(boots)) {
                unequip(player, boots);
            }

        }
    }

    private void unequip(Player player, ItemStack itemStack) {
        Inventory i = player.getInventory();
        ItemStack newItem = itemStack.clone();
        itemStack.setAmount(0);
        if (i.firstEmpty() > -1) {
            i.addItem(newItem);
            player.sendMessage(ThemeUtils.WARNING + "A piece of armour has broken! It's been placed in your inventory.");
        } else {
            player.getWorld().dropItemNaturally(player.getLocation(), newItem);
            player.sendMessage(ThemeUtils.WARNING + "A piece of armour has broken! You had no room for it and it has been dropped.");
        }
    }


}
