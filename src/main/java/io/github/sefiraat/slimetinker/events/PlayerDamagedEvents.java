package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.utils.ItemUtils;
import lombok.experimental.UtilityClass;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@UtilityClass
public final class PlayerDamagedEvents {

    public static void rodAdamantite(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || friend.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            friend.setDamageMod(0);
        }
    }

    public static void rodInfinity(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() / 2);
    }

    public static void rodSingSilver(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(0);
        }
    }

    public static void bindSlime(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(friend.getDamageMod() / 2);
        }
    }

    public static void bindSlimesteel(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(friend.getDamageMod() / 2);
        }
    }

    public static void headReinforcedSlimesteel(EventFriend friend) {
        if (!ItemUtils.isToolBroken(friend.getHeldItem())) {
            ItemUtils.damageTool(friend.getHeldItem(), (int) friend.getInitialDamage());
            friend.setDamageMod(friend.getDamageMod() / 2);
        }
    }

    public static void headFerrosilicon(EventFriend friend) {
        friend.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 40, 0, true));
    }

    public static void bindGhostly(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            friend.setDamageMod(0);
        }
    }

}
