package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.utils.ItemUtils;
import lombok.experimental.UtilityClass;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class DurabilityEvents {

    public static void rodAluBronze(EventFriend friend) {
        friend.setDurabilityMod(friend.getDurabilityMod() + 1);
    }

    public static void headSolder(EventFriend friend) {
        ItemMeta im = friend.getHeldItem().getItemMeta();
        assert im != null;
        Damageable damageable = (Damageable) im;
        damageable.setDamage(friend.getHeldItem().getType().getMaxDurability() - 1);
        friend.getHeldItem().setItemMeta(im);
        friend.setCancelEvent(true);
    }

    public static void headAluminum(EventFriend friend) {
        if (ThreadLocalRandom.current().nextInt(1,4) == 1) {
            ItemUtils.incrementRepair(friend.getHeldItem(), 1);
            friend.setCancelEvent(true);
        }
    }

    public static void rodAluminum(EventFriend friend) {
        friend.setDurabilityMod(friend.getDurabilityMod() + 1);
    }

    public static void explosive(EventFriend friend) {
        friend.setDurabilityMod(friend.getDurabilityMod() + 17);
    }

    public static void headSingInfinity(EventFriend friend) {
        friend.setDurabilityMod(0);
    }

    public static void headMythril(EventFriend friend) {
        friend.setDurabilityMod(friend.getDurabilityMod() + 0.5);
    }

    public static void headInfinity(EventFriend friend) {
        friend.setDurabilityMod(0);
    }

    public static void headSingAluminum(EventFriend friend) {
        if (ThreadLocalRandom.current().nextInt(1,4) == 1) {
            ItemUtils.incrementRepair(friend.getHeldItem(), 2);
            friend.setCancelEvent(true);
        }
    }

    public static void rodSingAluminum(EventFriend friend) {
        friend.setDurabilityMod(friend.getDurabilityMod() + 1);
    }
}
