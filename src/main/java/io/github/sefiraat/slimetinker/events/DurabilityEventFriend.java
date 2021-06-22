package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

@Data
public class DurabilityEventFriend {

    private final ItemStack heldItem;
    private final Player player;
    private final PlayerItemDamageEvent event;
    private double durabilityMod = 1;

    public DurabilityEventFriend(ItemStack heldItem, Player player, PlayerItemDamageEvent event) {

        this.heldItem = heldItem;
        this.player = player;
        this.event = event;
    }

}
