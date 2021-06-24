package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.events.BlockBreakEventFriend;
import io.github.sefiraat.slimetinker.events.DurabilityEventFriend;
import io.github.sefiraat.slimetinker.events.EntityDamageEventFriend;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEventFriend;
import io.github.sefiraat.slimetinker.events.TickEventFriend;
import lombok.Data;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;

import javax.annotation.Nullable;
import java.util.function.Consumer;

@Data
public class ComponentMaterial {

    private final String id;
    private final String colorHex;
    private final CMToolMakeup cmToolMakeup;
    private final CMForms cmForms;
    private final CMLiquid cmLiquid;
    private final CMAlloy cmAlloy;
    
    private boolean eventTickHead = false;
    private Consumer<TickEventFriend> tickConsumerHead;
    private boolean eventEntityDamagedHead = false;
    private Consumer<EntityDamageEventFriend> entityDamagedConsumerHead;
    private boolean eventDurabilityHead = false;
    private Consumer<DurabilityEventFriend> durabilityConsumerHead;
    private boolean eventBlockBreakHead = false;
    private Consumer<BlockBreakEventFriend> blockBreakConsumerHead;
    private boolean eventPlayerDamagedHead = false;
    private Consumer<PlayerDamagedEventFriend> playerDamagedConsumerHead;

    private boolean eventTickBind = false;
    private Consumer<TickEventFriend> tickConsumerBind;
    private boolean eventEntityDamagedBind = false;
    private Consumer<EntityDamageEventFriend> entityDamagedConsumerBind;
    private boolean eventDurabilityBind = false;
    private Consumer<DurabilityEventFriend> durabilityConsumerBind;
    private boolean eventBlockBreakBind = false;
    private Consumer<BlockBreakEventFriend> blockBreakConsumerBind;
    private boolean eventPlayerDamagedBind = false;
    private Consumer<PlayerDamagedEventFriend> playerDamagedConsumerBind;

    private boolean eventTickRod = false;
    private Consumer<TickEventFriend> tickConsumerRod;
    private boolean eventEntityDamagedRod = false;
    private Consumer<EntityDamageEventFriend> entityDamagedConsumerRod;
    private boolean eventDurabilityRod = false;
    private Consumer<DurabilityEventFriend> durabilityConsumerRod;
    private boolean eventBlockBreakRod = false;
    private Consumer<BlockBreakEventFriend> blockBreakConsumerRod;
    private boolean eventPlayerDamagedRod = false;
    private Consumer<PlayerDamagedEventFriend> playerDamagedConsumerRod;
    
    public ComponentMaterial(String id,
                             String colorHex,
                             CMToolMakeup cmToolMakeup,
                             CMForms cmForms,
                             @Nullable CMLiquid cmLiquid,
                             @Nullable CMAlloy cmAlloy)
    {
        this.id = id;
        this.colorHex = colorHex;
        this.cmToolMakeup = cmToolMakeup;
        this.cmForms = cmForms;
        this.cmLiquid = cmLiquid;
        this.cmAlloy = cmAlloy;
    }

    public ChatColor getColor() {
        return ChatColor.of(colorHex);
    }
    
    public void addHeadTickEvent(Consumer<TickEventFriend> consumer) {
        eventTickHead = true;
        tickConsumerHead = consumer;
    }    
    public void addHeadDamageEvent(Consumer<EntityDamageEventFriend> consumer) {
        eventEntityDamagedHead = true;
        entityDamagedConsumerHead = consumer;
    }    
    public void addHeadDuraEvent(Consumer<DurabilityEventFriend> consumer) {
        eventDurabilityHead = true;
        durabilityConsumerHead = consumer;
    }    
    public void addHeadBlockBreakEvent(Consumer<BlockBreakEventFriend> consumer) {
        eventBlockBreakHead = true;
        blockBreakConsumerHead = consumer;
    }
    public void addHeadPlayerDamagedEvent(Consumer<PlayerDamagedEventFriend> consumer) {
        eventPlayerDamagedHead = true;
        playerDamagedConsumerHead = consumer;
    }

    public void addBindTickEvent(Consumer<TickEventFriend> consumer) {
        eventTickBind = true;
        tickConsumerBind = consumer;
    }
    public void addBindDamageEvent(Consumer<EntityDamageEventFriend> consumer) {
        eventEntityDamagedBind = true;
        entityDamagedConsumerBind = consumer;
    }
    public void addBindDuraEvent(Consumer<DurabilityEventFriend> consumer) {
        eventDurabilityBind = true;
        durabilityConsumerBind = consumer;
    }
    public void addBindBlockBreakEvent(Consumer<BlockBreakEventFriend> consumer) {
        eventBlockBreakBind = true;
        blockBreakConsumerBind = consumer;
    }
    public void addBindPlayerDamagedEvent(Consumer<PlayerDamagedEventFriend> consumer) {
        eventPlayerDamagedBind = true;
        playerDamagedConsumerBind = consumer;
    }

    public void addRodTickEvent(Consumer<TickEventFriend> consumer) {
        eventTickRod = true;
        tickConsumerRod = consumer;
    }
    public void addRodDamageEvent(Consumer<EntityDamageEventFriend> consumer) {
        eventEntityDamagedRod = true;
        entityDamagedConsumerRod = consumer;
    }
    public void addRodDuraEvent(Consumer<DurabilityEventFriend> consumer) {
        eventDurabilityRod = true;
        durabilityConsumerRod = consumer;
    }
    public void addRodBlockBreakEvent(Consumer<BlockBreakEventFriend> consumer) {
        eventBlockBreakRod = true;
        blockBreakConsumerRod = consumer;
    }
    public void addRodPlayerDamagedEvent(Consumer<PlayerDamagedEventFriend> consumer) {
        eventPlayerDamagedRod = true;
        playerDamagedConsumerRod = consumer;
    }

    public boolean isValidToolHead() {
        return cmToolMakeup.isValidHead();
    }

    public boolean isValidToolBinder() {
        return cmToolMakeup.isValidBinder();
    }

    public boolean isValidToolRod() {
        return cmToolMakeup.isValidRod();
    }

    public String getFormNugget() {
        return cmForms.getFormNugget();
    }

    public String getFormIngot() {
        return cmForms.getFormIngot();
    }

    public String getFormBlock() {
        return cmForms.getFormBlock();
    }

    public String getFormOre() {
        return cmForms.getFormOre();
    }

    public String getFormGem() {
        return cmForms.getFormGem();
    }

    public String getFormDust() {
        return cmForms.getFormDust();
    }

    public String getFormBoot() {
        return cmForms.getFormBoot();
    }

    public String getFormLeg() {
        return cmForms.getFormLeg();
    }

    public String getFormChest() {
        return cmForms.getFormChest();
    }

    public String getFormHelm() {
        return cmForms.getFormHelm();
    }

    public SlimefunItemStack getLiquidItemStack(int amount) {
        return new SlimefunItemStack(cmLiquid.getItemStack(), amount);
    }

}
