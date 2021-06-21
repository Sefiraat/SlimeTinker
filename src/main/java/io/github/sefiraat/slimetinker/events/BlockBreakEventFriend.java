package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

@Data
public class BlockBreakEventFriend {

    private final ItemStack heldItem;
    private final Player player;
    private double toolExpMod = 1;
    private double playerExpMod = 1;

    private Collection<ItemStack> drops;
    private Collection<ItemStack> addDrops;
    private Collection<ItemStack> removeDrops;
    private boolean duraliumCheck = false;


    public BlockBreakEventFriend(ItemStack heldItem, Player player) {

        this.heldItem = heldItem;
        this.player = player;
    }

}
