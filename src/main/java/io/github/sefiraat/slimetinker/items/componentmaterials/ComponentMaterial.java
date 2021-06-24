package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import lombok.Data;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class ComponentMaterial {

    private final String id;
    private final String colorHex;
    private final CMToolMakeup cmToolMakeup;
    private final CMForms cmForms;
    private final CMLiquid cmLiquid;
    private final CMAlloy cmAlloy;
    private final Map<TraitEventType, Map<TraitPartType, Consumer<EventFriend>>> events = new EnumMap<>(TraitEventType.class);

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

    /**
     *
     * Runs an event based on the type of event the listener is requesting and the tool part.
     * If an event does not exist, nothing happens.
     *
     * @param type "The type of event that will be triggered. Different events can fire based on the listener (tick event) raising
     * @param part "The tool part to be tested against this material type"
     * @param friend "The EventFriend to be carried through the events to the settle phase"
     */
    public void runEvent(TraitEventType type, TraitPartType part, EventFriend friend) {
        if(!events.containsKey(type)) {
            SlimeTinker.inst().getLogger().info("No events of that type");
            return;
        }
        SlimeTinker.inst().getLogger().info("Events of type found, checking part");
        Map<TraitPartType, Consumer<EventFriend>> map = events.get(type);
        if (!map.containsKey(part)) {
            SlimeTinker.inst().getLogger().info("No events of that part");
            return;
        }
        SlimeTinker.inst().getLogger().info("Running event");
        map.get(part).accept(friend);
    }

    public void addEvent(TraitEventType eventType, TraitPartType partType, Consumer<EventFriend> consumer) {
        Map<TraitPartType, Consumer<EventFriend>> map;
        if (events.containsKey(eventType)) {
            map = events.get(eventType);
        } else {
            map = new EnumMap<>(TraitPartType.class);
        }
        map.put(partType, consumer);
        events.put(eventType, map);
    }

}
