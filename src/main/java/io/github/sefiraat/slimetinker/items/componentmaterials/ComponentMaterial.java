package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import lombok.Data;
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
    @Nullable
    private final CMLiquid cmLiquid;
    @Nullable
    private final CMAlloy cmAlloy;
    @Nullable
    private final CMTraits cmTraits;
    private final Map<TraitEventType, Map<TraitPartType, Consumer<EventFriend>>> CMEventMap = new EnumMap<>(TraitEventType.class);

    public ComponentMaterial(String id,
                             String colorHex,
                             CMToolMakeup cmToolMakeup,
                             CMForms cmForms,
                             @Nullable CMLiquid cmLiquid,
                             @Nullable CMAlloy cmAlloy,
                             @Nullable CMTraits cmTraits)
    {
        this.id = id;
        this.colorHex = colorHex;
        this.cmToolMakeup = cmToolMakeup;
        this.cmForms = cmForms;
        this.cmLiquid = cmLiquid;
        this.cmAlloy = cmAlloy;
        this.cmTraits = cmTraits;
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
     * @param type "The type of event that will be triggered. Different CMEventMap can fire based on the listener (tick event) raising
     * @param part "The tool part to be tested against this material type"
     * @param friend "The EventFriend to be carried through the CMEventMap to the settle phase"
     */
    public void runEvent(TraitEventType type, TraitPartType part, EventFriend friend) {
        if(!CMEventMap.containsKey(type)) {
            return;
        }
        Map<TraitPartType, Consumer<EventFriend>> map = CMEventMap.get(type);
        if (!map.containsKey(part)) {
            return;
        }
        map.get(part).accept(friend);
    }

    public void addEvent(TraitEventType eventType, TraitPartType partType, Consumer<EventFriend> consumer) {
        Map<TraitPartType, Consumer<EventFriend>> map;
        if (CMEventMap.containsKey(eventType)) {
            map = CMEventMap.get(eventType);
        } else {
            map = new EnumMap<>(TraitPartType.class);
        }
        map.put(partType, consumer);
        CMEventMap.put(eventType, map);
    }

}
