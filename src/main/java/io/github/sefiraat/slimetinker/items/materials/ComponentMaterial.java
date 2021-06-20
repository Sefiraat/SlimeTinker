package io.github.sefiraat.slimetinker.items.materials;

import io.github.sefiraat.slimetinker.events.EventFriend;
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
    private boolean eventTick = false;
    private Consumer<EventFriend> eventTickConsumer;

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

}
