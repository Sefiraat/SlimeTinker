package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Data
public class EntityDamageEventFriend {

    private final ItemStack heldItem;
    private final Player player;
    private final Entity damagedEntity;
    private final int toolLevel;

    private double damageMod = 1;
    private double toolExpMod = 1;
    private double playerExpMod = 1;
    private boolean duraliumCheck = false;
    private int charged = 0;

    public EntityDamageEventFriend(ItemStack heldItem, Player player, Entity damagedEntity, int toolLevel) {

        this.heldItem = heldItem;
        this.player = player;
        this.damagedEntity = damagedEntity;
        this.toolLevel = toolLevel;
    }

}
