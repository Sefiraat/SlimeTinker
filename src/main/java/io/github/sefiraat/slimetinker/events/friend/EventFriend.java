package io.github.sefiraat.slimetinker.events.friend;

import io.github.sefiraat.slimetinker.utils.ItemUtils;
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

    /**
     * Denotes if any of the event channels actually triggered.
     */
    private boolean actionTaken = false;

    /**
     * The type of item that the friend is currently working on
     */
    private ActiveFriendElement activeFriendElement;
    private TraitEventType eventType;

    @Nullable
    private ItemStack tool;
    @Nullable
    private ItemStack helmet;
    @Nullable
    private ItemStack chestplate;
    @Nullable
    private ItemStack leggings;
    @Nullable
    private ItemStack boots;

    private Player player;

    /**
     * The block broken in BlockBreakEvents
     */
    private Block block;

    /**
     * The entity doing the damaging (for EntityDamageEvents)
     * Otherwise use player for PlayerDamageEvents
     */
    private Entity damagedEntity;

    /**
     * The entity doing the damaging (for PlayerDamageEvents)
     * Otherwise use player for EntityDamageEvents
     */
    private Entity damagingEntity;

    private EntityDamageEvent.DamageCause cause;
    private double initialDamage = 0;

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
    private Double damageOverride = null;

    private Collection<ItemStack> drops;
    private Collection<ItemStack> addDrops;
    private Collection<ItemStack> removeDrops;

    private boolean duraliumCheck = false;
    private boolean metalCheck = false;
    private boolean cancelEvent = false;

    // Skill-part counters
    private int charged = 0;
    private int segganesson = 0;
    private double segganessonDamage = 0;
    private int hypercube = 0;
    private int noClip = 0;
    private int brightBurn = 0;
    private int compounding = 0;
    private int positivity = 0;
    private int negativity = 0;
    private int hyperbolic = 0;
    private int gravity = 0;
    private int manners = 0;
    private int kingsman = 0;
    private int infinity = 0;

    private boolean blocksIntoInv = false;

    public void incrementItemExpMod(double amount) {
        incrementItemExpMod(activeFriendElement, amount);
    }

    public void incrementItemExpMod(ActiveFriendElement element, double amount) {
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
                throw new IllegalStateException("Unexpected value: " + element);
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
                throw new IllegalStateException("Unexpected value: " + element);
        }
    }

    public void setExpMod(double amount) {
        setExpMod(activeFriendElement, amount);
    }

    public ItemStack getActiveStack(ActiveFriendElement element) {
        switch (element) {
            case TOOL:
                return tool;
            case HELMET:
                return helmet;
            case CHESTPLATE:
                return chestplate;
            case LEGGINGS:
                return leggings;
            case BOOTS:
                return boots;
            default:
                throw new IllegalStateException("Unexpected value: " + element);
        }
    }

    public ItemStack getActiveStack() {
        return getActiveStack(activeFriendElement);
    }

    public Integer getActiveLevel(ActiveFriendElement element) {
        switch (element) {
            case TOOL:
                return getToolLevel();
            case HELMET:
                return getHelmLevel();
            case CHESTPLATE:
                return getChestLevel();
            case LEGGINGS:
                return getLegLevel();
            case BOOTS:
                return getBootLevel();
            default:
                throw new IllegalStateException("Unexpected value: " + element);
        }
    }

    public int getActiveLevel() {
        return getActiveLevel(activeFriendElement);
    }

    @Nullable
    public Integer getToolLevel() {
        return ItemUtils.getTinkerLevel(tool);
    }
    @Nullable
    public Integer getHelmLevel() {
        return ItemUtils.getTinkerLevel(helmet);
    }
    @Nullable
    public Integer getChestLevel() {
        return ItemUtils.getTinkerLevel(chestplate);
    }
    @Nullable
    public Integer getLegLevel() {
        return ItemUtils.getTinkerLevel(leggings);
    }
    @Nullable
    public Integer getBootLevel() {
        return ItemUtils.getTinkerLevel(boots);
    }

    public EventFriend (Player p, TraitEventType type) {
        this.player = p;
        this.eventType = type;
    }

}
