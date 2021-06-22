package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

@Data
public class PlayerDamagedEventFriend {

    private final ItemStack heldItem;
    private final Player player;
    private final int toolLevel;
    private final EntityDamageEvent.DamageCause cause;
    private double damageMod = 1;

    public PlayerDamagedEventFriend(ItemStack heldItem, Player player, int toolLevel, EntityDamageEvent.DamageCause cause) {

        this.heldItem = heldItem;
        this.player = player;
        this.toolLevel = toolLevel;
        this.cause = cause;
    }

}
