package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.items.templates.PartTemplate;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import lombok.Data;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class ComponentMaterial {

    private final CMIdentity cmIdentity;
    @Nullable
    private final List<SlimefunItemStack> alloyRecipe;
    private final CMToolMakeup cmToolMakeup;
    private final CMForms cmForms;
    @Nullable
    private final CMLiquid cmLiquid;
    @Nullable
    private final CMAlloy cmAlloy;
    @Nullable
    private final CMTraits cmTraits;
    private final Map<TraitEventType, Map<TraitPartType, Consumer<EventFriend>>> cmEventMap = new EnumMap<>(TraitEventType.class);

    public ComponentMaterial(CMIdentity cmIdentity,
                             @Nullable List<SlimefunItemStack> alloyRecipe,
                             CMToolMakeup cmToolMakeup,
                             CMForms cmForms,
                             @Nullable CMTraits cmTraits) {

        this.cmIdentity = cmIdentity;
        this.alloyRecipe = alloyRecipe;
        this.cmToolMakeup = cmToolMakeup;
        this.cmForms = cmForms;

        if (cmIdentity.getLiquidTexture()  != null) {
            this.cmLiquid = new CMLiquid(cmIdentity.getLiquidTexture());
            cmLiquid.setupLiquid(this);
        } else {
            this.cmLiquid = null;
        }

        if (alloyRecipe != null) {
            this.cmAlloy = new CMAlloy(alloyRecipe);
            cmAlloy.setupAlloy(this);
        } else {
            this.cmAlloy = null;
        }

        if (cmTraits != null) {
            this.cmTraits = cmTraits;
            cmTraits.setupTraits(this);
        } else {
            this.cmTraits = null;
        }

        if (this.cmToolMakeup.isValidBinder()) {
            PartTemplate binder = new PartTemplate(Categories.DUMMY, bindingStack(cmIdentity.getId()), Workbench.TYPE, bindingRecipe(cmIdentity.getRepresentativeStack()), cmIdentity.getId());
            binder.setHidden(true);
            binder.register(SlimeTinker.inst());
        }
    }

    public static SlimefunItemStack bindingStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        SlimefunItemStack i = ThemeUtils.themedItemStack(
                "PART_BINDING_" + name,
                SkullTextures.PART_BINDING,
                ThemeUtils.ThemeItemType.PART,
                titName + " Binding",
        ThemeUtils.PASSIVE + "A binding made of " + titName + "."
        );
        ItemMeta im = i.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        c.set(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING, name);
        i.setItemMeta(im);
        return i;
    }

    public static ItemStack[] bindingRecipe(ItemStack i) {
        return new ItemStack[] {
            i,      null,   i,
            null,   i,      null,
            i,      null,   i
        };
    }

    public ChatColor getColor() {
        return ChatColor.of(cmIdentity.getColorHex());
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

    public String getId() {
        return cmIdentity.getId();
    }

    public String getLiquidTexture() {
        return cmIdentity.getLiquidTexture();
    }

    public ItemStack getRepresentativeStack() {
        return cmIdentity.getRepresentativeStack();
    }

    /**
     *
     * Runs an event based on the type of event the listener is requesting and the tool part.
     * If an event does not exist, nothing happens.
     *
     * @param type "The type of event that will be triggered. Different cmEventMap can fire based on the listener (tick event) raising
     * @param part "The tool part to be tested against this material type"
     * @param friend "The EventFriend to be carried through the cmEventMap to the settle phase"
     */
    public void runEvent(TraitEventType type, TraitPartType part, EventFriend friend) {
        if(!cmEventMap.containsKey(type)) {
            return;
        }
        Map<TraitPartType, Consumer<EventFriend>> map = cmEventMap.get(type);
        if (!map.containsKey(part)) {
            return;
        }
        map.get(part).accept(friend);
    }

    public void addEvent(TraitEventType eventType, TraitPartType partType, Consumer<EventFriend> consumer) {
        Map<TraitPartType, Consumer<EventFriend>> map;
        if (cmEventMap.containsKey(eventType)) {
            map = cmEventMap.get(eventType);
        } else {
            map = new EnumMap<>(TraitPartType.class);
        }
        map.put(partType, consumer);
        cmEventMap.put(eventType, map);
    }

}
