package io.github.sefiraat.slimetinker.events;

import lombok.experimental.UtilityClass;
import org.bukkit.event.entity.EntityDamageEvent;

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
}
