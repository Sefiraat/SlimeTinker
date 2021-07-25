package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkArmour;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.checkTool;
import static io.github.sefiraat.slimetinker.events.friend.EventChannels.settlePotionEffects;

public class ArmourRemove extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.inst().getServer().getOnlinePlayers()) {

            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();

            if (helmet != null && ItemUtils.isTinkersBroken(helmet) && !ItemUtils.doesNotUnequip(helmet)) {
                unequip(player, helmet);
            }
            if (chestplate != null && ItemUtils.isTinkersBroken(chestplate) && !ItemUtils.doesNotUnequip(chestplate)) {
                unequip(player, chestplate);
            }
            if (leggings != null && ItemUtils.isTinkersBroken(leggings) && !ItemUtils.doesNotUnequip(leggings)) {
                unequip(player, leggings);
            }
            if (boots != null && ItemUtils.isTinkersBroken(boots) && !ItemUtils.doesNotUnequip(boots)) {
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
            player.sendMessage(ThemeUtils.WARNING + "A piece of armour has broken! It's been placed in your inventory." );
        } else {
            player.getWorld().dropItemNaturally(player.getLocation(), newItem);
            player.sendMessage(ThemeUtils.WARNING + "A piece of armour has broken! You had no room for it and it has been dropped." );
        }
    }


}
