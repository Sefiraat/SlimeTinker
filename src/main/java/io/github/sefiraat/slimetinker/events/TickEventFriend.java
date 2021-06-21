package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

@Data
public class TickEventFriend {

    private final ItemStack heldItem;
    private final Player player;
    private final Map<PotionEffectType, Integer> potionEffects = new HashMap<>();

    public TickEventFriend(ItemStack heldItem, Player player) {

        this.heldItem = heldItem;
        this.player = player;
    }

}
