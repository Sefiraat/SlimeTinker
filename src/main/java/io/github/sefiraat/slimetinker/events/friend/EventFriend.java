package io.github.sefiraat.slimetinker.events.friend;

import lombok.Data;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
public class EventFriend {

    private boolean active;
    private TraitEventType eventType;

    private ItemStack heldItem;
    @Nullable
    private ItemStack helmet;
    @Nullable
    private ItemStack chestplate;
    @Nullable
    private ItemStack leggings;
    @Nullable
    private ItemStack boots;

    private Player player;
    private Block block;
    private Entity damagedEntity;
    private EntityDamageEvent.DamageCause cause;
    private double initialDamage = 0;

    private int toolLevel;

    private final Map<PotionEffectType, Integer> potionEffects = new HashMap<>();

    // Settle event value modifiers
    private double toolExpMod = 1;
    private double helmExpMod = 1;
    private double chestExpMod = 1;
    private double leggingsExpMod = 1;
    private double bootsExpMod = 1;
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

    private int segganesson = 0;
    private double segganessonDamage = 0;

    private int hypercube = 0;
    private int noClip = 0;

    private boolean blocksIntoInv = false;

    public void incrementExpMod(ActiveFriendElement element, double amount) {
        switch (element) {
            case TOOL:
                toolExpMod += amount;
                break;
            case HELMET:
                helmExpMod += amount;
                break;
            case CHESTPLATE:
                chestExpMod += amount;
                break;
            case LEGGINGS:
                leggingsExpMod += amount;
                break;
            case BOOTS:
                bootsExpMod += amount;
                break;
            default:
        }
    }

    public void setExpMod(ActiveFriendElement element, double amount) {
        switch (element) {
            case TOOL:
                toolExpMod = amount;
                break;
            case HELMET:
                helmExpMod = amount;
                break;
            case CHESTPLATE:
                chestExpMod = amount;
                break;
            case LEGGINGS:
                leggingsExpMod = amount;
                break;
            case BOOTS:
                bootsExpMod = amount;
                break;
            default:
        }
    }

}
