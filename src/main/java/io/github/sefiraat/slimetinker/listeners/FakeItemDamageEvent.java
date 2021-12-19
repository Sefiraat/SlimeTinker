package io.github.sefiraat.slimetinker.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

public class FakeItemDamageEvent extends PlayerItemDamageEvent {
    public FakeItemDamageEvent(Player player, ItemStack what, int damage) {
        super(player, what, damage);
    }
}
