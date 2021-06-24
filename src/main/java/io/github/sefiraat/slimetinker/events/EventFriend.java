package io.github.sefiraat.slimetinker.events;

import lombok.Data;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
public class EventFriend {

    private ItemStack heldItem;
    private Player player;
    private Block block;
    private Entity damagedEntity;
    private EntityDamageEvent.DamageCause cause;

    private int toolLevel;

    private final Map<PotionEffectType, Integer> potionEffects = new HashMap<>();

    private double toolExpMod = 1;
    private double playerExpMod = 1;
    private double durabilityMod = 1;
    private double damageMod = 1;

    private Collection<ItemStack> drops;
    private Collection<ItemStack> addDrops;
    private Collection<ItemStack> removeDrops;

    private boolean duraliumCheck = false;
    private boolean metalCheck = false;
    private boolean cancelEvent = false;
    private int charged = 0;

    public EventFriend() {

    }

}
