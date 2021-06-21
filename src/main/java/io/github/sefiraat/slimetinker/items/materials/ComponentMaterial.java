package io.github.sefiraat.slimetinker.items.materials;

import io.github.sefiraat.slimetinker.events.BlockBreakEventFriend;
import io.github.sefiraat.slimetinker.events.DurabilityEventFriend;
import io.github.sefiraat.slimetinker.events.EntityDamageEventFriend;
import io.github.sefiraat.slimetinker.events.TickEventFriend;
import lombok.Data;
import net.md_5.bungee.api.ChatColor;

import java.util.function.Consumer;

@Data
public class ComponentMaterial {

    private final String id;
    private final String colorHex;
    private final boolean validToolHead;
    private final boolean validToolBind;
    private final boolean validToolRod;
    private final String formNugget;
    private final String formIngot;
    private final String formBlock;
    private final String formOre;
    private final String formGem;
    private final String formDust;
    private final String formBoot;
    private final String formLeg;
    private final String formChest;
    private final String formHelm;
    
    private boolean eventTickHead = false;
    private Consumer<TickEventFriend> tickConsumerHead;
    private boolean eventEntityDamagedHead = false;
    private Consumer<EntityDamageEventFriend> entityDamagedConsumerHead;
    private boolean eventDurabilityHead = false;
    private Consumer<DurabilityEventFriend> durabilityConsumerHead;
    private boolean eventBlockBreakHead = false;
    private Consumer<BlockBreakEventFriend> blockBreakConsumerHead;

    private boolean eventTickBind = false;
    private Consumer<TickEventFriend> tickConsumerBind;
    private boolean eventEntityDamagedBind = false;
    private Consumer<EntityDamageEventFriend> entityDamagedConsumerBind;
    private boolean eventDurabilityBind = false;
    private Consumer<DurabilityEventFriend> durabilityConsumerBind;
    private boolean eventBlockBreakBind = false;
    private Consumer<BlockBreakEventFriend> blockBreakConsumerBind;

    private boolean eventTickRod = false;
    private Consumer<TickEventFriend> tickConsumerRod;
    private boolean eventEntityDamagedRod = false;
    private Consumer<EntityDamageEventFriend> entityDamagedConsumerRod;
    private boolean eventDurabilityRod = false;
    private Consumer<DurabilityEventFriend> durabilityConsumerRod;
    private boolean eventBlockBreakRod = false;
    private Consumer<BlockBreakEventFriend> blockBreakConsumerRod;
    
    public ComponentMaterial(String id,
                             String colorHex,
                             boolean validToolHead,
                             boolean validToolBind,
                             boolean validToolRod,
                             String formNugget,
                             String formIngot,
                             String formBlock,
                             String formOre,
                             String formGem,
                             String formDust,
                             String formBoot,
                             String formLeg,
                             String formChest,
                             String formHelm)
    {
        this.id = id;
        this.colorHex = colorHex;
        this.validToolHead = validToolHead;
        this.validToolBind = validToolBind;
        this.validToolRod = validToolRod;
        this.formNugget = formNugget;
        this.formIngot = formIngot;
        this.formBlock = formBlock;
        this.formOre = formOre;
        this.formGem = formGem;
        this.formDust = formDust;
        this.formBoot = formBoot;
        this.formLeg = formLeg;
        this.formChest = formChest;
        this.formHelm = formHelm;
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

}
