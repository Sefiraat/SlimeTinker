package io.github.sefiraat.slimetinker.events.friend;

import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventFriend {

    private final Map<PotionEffectType, Integer> potionEffects = new HashMap<>();
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
     * The block broken in BlockBreakEvents
     */
    private Action action;
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

    private boolean daxiAbsorption;
    private boolean daxiFortitude;
    private boolean daxiSaturation;
    private boolean daxiRegeneration;

    private boolean blocksIntoInv = false;

    public Map<PotionEffectType, Integer> getPotionEffects() {
        return potionEffects;
    }

    public boolean isActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(boolean actionTaken) {
        this.actionTaken = actionTaken;
    }

    public ActiveFriendElement getActiveFriendElement() {
        return activeFriendElement;
    }

    public void setActiveFriendElement(ActiveFriendElement activeFriendElement) {
        this.activeFriendElement = activeFriendElement;
    }

    public TraitEventType getEventType() {
        return eventType;
    }

    public void setEventType(TraitEventType eventType) {
        this.eventType = eventType;
    }

    @Nullable
    public ItemStack getTool() {
        return tool;
    }

    public void setTool(@Nullable ItemStack tool) {
        this.tool = tool;
    }

    @Nullable
    public ItemStack getHelmet() {
        return helmet;
    }

    public void setHelmet(@Nullable ItemStack helmet) {
        this.helmet = helmet;
    }

    @Nullable
    public ItemStack getChestplate() {
        return chestplate;
    }

    public void setChestplate(@Nullable ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    @Nullable
    public ItemStack getLeggings() {
        return leggings;
    }

    public void setLeggings(@Nullable ItemStack leggings) {
        this.leggings = leggings;
    }

    @Nullable
    public ItemStack getBoots() {
        return boots;
    }

    public void setBoots(@Nullable ItemStack boots) {
        this.boots = boots;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Entity getDamagedEntity() {
        return damagedEntity;
    }

    public void setDamagedEntity(Entity damagedEntity) {
        this.damagedEntity = damagedEntity;
    }

    public Entity getDamagingEntity() {
        return damagingEntity;
    }

    public void setDamagingEntity(Entity damagingEntity) {
        this.damagingEntity = damagingEntity;
    }

    public EntityDamageEvent.DamageCause getCause() {
        return cause;
    }

    public void setCause(EntityDamageEvent.DamageCause cause) {
        this.cause = cause;
    }

    public double getInitialDamage() {
        return initialDamage;
    }

    public void setInitialDamage(double initialDamage) {
        this.initialDamage = initialDamage;
    }

    public double getToolExpMod() {
        return toolExpMod;
    }

    public void setToolExpMod(double toolExpMod) {
        this.toolExpMod = toolExpMod;
    }

    public double getHelmExpMod() {
        return helmExpMod;
    }

    public void setHelmExpMod(double helmExpMod) {
        this.helmExpMod = helmExpMod;
    }

    public double getChestExpMod() {
        return chestExpMod;
    }

    public void setChestExpMod(double chestExpMod) {
        this.chestExpMod = chestExpMod;
    }

    public double getLeggingsExpMod() {
        return leggingsExpMod;
    }

    public void setLeggingsExpMod(double leggingsExpMod) {
        this.leggingsExpMod = leggingsExpMod;
    }

    public double getBootsExpMod() {
        return bootsExpMod;
    }

    public void setBootsExpMod(double bootsExpMod) {
        this.bootsExpMod = bootsExpMod;
    }

    public double getPlayerExpMod() {
        return playerExpMod;
    }

    public void setPlayerExpMod(double playerExpMod) {
        this.playerExpMod = playerExpMod;
    }

    public double getDurabilityMod() {
        return durabilityMod;
    }

    public void setDurabilityMod(double durabilityMod) {
        this.durabilityMod = durabilityMod;
    }

    public double getDamageMod() {
        return damageMod;
    }

    public void setDamageMod(double damageMod) {
        this.damageMod = damageMod;
    }

    public Double getDamageOverride() {
        return damageOverride;
    }

    public void setDamageOverride(Double damageOverride) {
        this.damageOverride = damageOverride;
    }

    public Collection<ItemStack> getDrops() {
        return drops;
    }

    public void setDrops(Collection<ItemStack> drops) {
        this.drops = drops;
    }

    public Collection<ItemStack> getAddDrops() {
        return addDrops;
    }

    public void setAddDrops(Collection<ItemStack> addDrops) {
        this.addDrops = addDrops;
    }

    public Collection<ItemStack> getRemoveDrops() {
        return removeDrops;
    }

    public void setRemoveDrops(Collection<ItemStack> removeDrops) {
        this.removeDrops = removeDrops;
    }

    public boolean isDuraliumCheck() {
        return duraliumCheck;
    }

    public void setDuraliumCheck(boolean duraliumCheck) {
        this.duraliumCheck = duraliumCheck;
    }

    public boolean isMetalCheck() {
        return metalCheck;
    }

    public void setMetalCheck(boolean metalCheck) {
        this.metalCheck = metalCheck;
    }

    public boolean isCancelEvent() {
        return cancelEvent;
    }

    public void setCancelEvent(boolean cancelEvent) {
        this.cancelEvent = cancelEvent;
    }

    public int getCharged() {
        return charged;
    }

    public void setCharged(int charged) {
        this.charged = charged;
    }

    public int getSegganesson() {
        return segganesson;
    }

    public void setSegganesson(int segganesson) {
        this.segganesson = segganesson;
    }

    public double getSegganessonDamage() {
        return segganessonDamage;
    }

    public void setSegganessonDamage(double segganessonDamage) {
        this.segganessonDamage = segganessonDamage;
    }

    public int getHypercube() {
        return hypercube;
    }

    public void setHypercube(int hypercube) {
        this.hypercube = hypercube;
    }

    public int getNoClip() {
        return noClip;
    }

    public void setNoClip(int noClip) {
        this.noClip = noClip;
    }

    public int getBrightBurn() {
        return brightBurn;
    }

    public void setBrightBurn(int brightBurn) {
        this.brightBurn = brightBurn;
    }

    public int getCompounding() {
        return compounding;
    }

    public void setCompounding(int compounding) {
        this.compounding = compounding;
    }

    public int getPositivity() {
        return positivity;
    }

    public void setPositivity(int positivity) {
        this.positivity = positivity;
    }

    public int getNegativity() {
        return negativity;
    }

    public void setNegativity(int negativity) {
        this.negativity = negativity;
    }

    public int getHyperbolic() {
        return hyperbolic;
    }

    public void setHyperbolic(int hyperbolic) {
        this.hyperbolic = hyperbolic;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getManners() {
        return manners;
    }

    public void setManners(int manners) {
        this.manners = manners;
    }

    public int getKingsman() {
        return kingsman;
    }

    public void setKingsman(int kingsman) {
        this.kingsman = kingsman;
    }

    public int getInfinity() {
        return infinity;
    }

    public void setInfinity(int infinity) {
        this.infinity = infinity;
    }

    public boolean isDaxiAbsorption() {
        return daxiAbsorption;
    }

    public void setDaxiAbsorption(boolean daxiAbsorption) {
        this.daxiAbsorption = daxiAbsorption;
    }

    public boolean isDaxiFortitude() {
        return daxiFortitude;
    }

    public void setDaxiFortitude(boolean daxiFortitude) {
        this.daxiFortitude = daxiFortitude;
    }

    public boolean isDaxiSaturation() {
        return daxiSaturation;
    }

    public void setDaxiSaturation(boolean daxiSaturation) {
        this.daxiSaturation = daxiSaturation;
    }

    public boolean isDaxiRegeneration() {
        return daxiRegeneration;
    }

    public void setDaxiRegeneration(boolean daxiRegeneration) {
        this.daxiRegeneration = daxiRegeneration;
    }

    public boolean isBlocksIntoInv() {
        return blocksIntoInv;
    }

    public void setBlocksIntoInv(boolean blocksIntoInv) {
        this.blocksIntoInv = blocksIntoInv;
    }

    public EventFriend(Player p, TraitEventType type) {
        this.player = p;
        this.eventType = type;
    }

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

}
