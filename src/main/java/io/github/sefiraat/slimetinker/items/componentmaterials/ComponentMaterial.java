package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMAlloy;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMForms;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMIdentity;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMLiquid;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMToolMakeup;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmelements.CMTraits;
import io.github.sefiraat.slimetinker.items.templates.PartTemplate;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import lombok.Data;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

    /**
     * @param cmIdentity   Defines the ID, Displayed ItemStack for recipes, SkullTexture for liquids and the Color for theming lore and names
     * @param alloyRecipe  List of material IDs that can be found in the CMMap used to build alloy recipes
     * @param cmToolMakeup Defines what parts this material can be formed into
     * @param cmForms      Defines the solid forms of metals that can be used for input
     * @param cmTraits     A collection of cmTraits for each potential part
     */
    public ComponentMaterial(CMIdentity cmIdentity,
                             @Nullable List<SlimefunItemStack> alloyRecipe,
                             CMToolMakeup cmToolMakeup,
                             CMForms cmForms,
                             @Nullable CMTraits cmTraits) {

        this.cmIdentity = cmIdentity;
        this.alloyRecipe = alloyRecipe;
        this.cmToolMakeup = cmToolMakeup;
        this.cmForms = cmForms;

        if (cmIdentity.getLiquidTexture() != null) {
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

        registerParts();


    }

    public void registerParts() {

        // Heads (and repair kits)
        if (cmToolMakeup.isValidHead()) {
            //CMManager.getMAP_CAST_SWORDBLADE().put(this, Parts.SWORD_BLADE.getStack(cmIdentity.getId(), HEAD, SWORD, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, headStack(cmIdentity.getId(), "SWORD", SkullTextures.PART_SWORD_BLADE), DummySmeltery.TYPE, basicRecipe(Casts.CAST_SWORDBLADE, getLiquidItemStack(2)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidHead()) {
            //CMManager.getMAP_CAST_HOEHEAD().put(this, Parts.HOE_HEAD.getStack(cmIdentity.getId(), HEAD, HOE, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, headStack(cmIdentity.getId(), "HOE", SkullTextures.PART_HOE_HEAD), DummySmeltery.TYPE, basicRecipe(Casts.CAST_HOEHEAD, getLiquidItemStack(1)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidHead()) {
            //CMManager.getMAP_CAST_AXEHEAD().put(this, Parts.AXE_HEAD.getStack(cmIdentity.getId(), HEAD, AXE, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, headStack(cmIdentity.getId(), "AXE", SkullTextures.PART_AXE_HEAD), DummySmeltery.TYPE, basicRecipe(Casts.CAST_AXEHEAD, getLiquidItemStack(1)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidHead()) {
            //CMManager.getMAP_CAST_PICKAXEHEAD().put(this, Parts.PICKAXE_HEAD.getStack(cmIdentity.getId(), HEAD, PICKAXE, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, headStack(cmIdentity.getId(), "PICK", SkullTextures.PART_PICKAXE_HEAD), DummySmeltery.TYPE, basicRecipe(Casts.CAST_PICKAXEHEAD, getLiquidItemStack(1)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidHead()) {
            //CMManager.getMAP_CAST_SHOVELHEAD().put(this, Parts.SHOVEL_HEAD.getStack(cmIdentity.getId(), HEAD, SHOVEL, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, headStack(cmIdentity.getId(), "SHOVEL", SkullTextures.PART_SHOVEL_HEAD), DummySmeltery.TYPE, basicRecipe(Casts.CAST_SHOVELHEAD, getLiquidItemStack(1)), cmIdentity.getId()).register(SlimeTinker.inst());
        }

        // Binders
        if (this.cmToolMakeup.isValidBinder()) {
            PartTemplate binder = new PartTemplate(ItemGroups.DUMMY, bindingStack(cmIdentity.getId()), Workbench.TYPE, bindingRecipe(cmIdentity.getRepresentativeStack()), cmIdentity.getId());
            binder.setHidden(true);
            binder.register(SlimeTinker.inst());
        }

        // Tool Rods
        if (cmToolMakeup.isValidRod()) {
            //CMManager.getMAP_CAST_TOOLROD().put(this, Parts.TOOL_ROD.getStack(cmIdentity.getId(), ROD, null, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, rodStack(cmIdentity.getId()), DummySmeltery.TYPE, basicRecipe(Casts.CAST_TOOLROD, getLiquidItemStack(1)), cmIdentity.getId()).register(SlimeTinker.inst());
        }

        // Plates
        if (cmToolMakeup.isValidPlates()) {
            //CMManager.MAP_CAST_ARMOUR_PLATES_HELM.put(this, Parts.HELM_PLATE.getStack(cmIdentity.getId(), PLATE, HELMET, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, platesStack(cmIdentity.getId(), "HELMET", SkullTextures.PART_HELM_PLATES), DummySmeltery.TYPE, basicRecipe(Casts.CAST_HELM_PLATE, getLiquidItemStack(CMManager.AMOUNT_ARM_HELM)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidPlates()) {
            //CMManager.MAP_CAST_ARMOUR_PLATES_CHEST.put(this, Parts.CHEST_PLATE.getStack(cmIdentity.getId(), PLATE, CHESTPLATE, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, platesStack(cmIdentity.getId(), "CHESTPLATE", SkullTextures.PART_CHEST_PLATES), DummySmeltery.TYPE, basicRecipe(Casts.CAST_CHEST_PLATE, getLiquidItemStack(CMManager.AMOUNT_ARM_CHEST)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidPlates()) {
            //CMManager.MAP_CAST_ARMOUR_PLATES_LEGGINGS.put(this, Parts.LEG_PLATE.getStack(cmIdentity.getId(), PLATE, LEGGINGS, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, platesStack(cmIdentity.getId(), "LEGGINGS", SkullTextures.PART_LEG_PLATES), DummySmeltery.TYPE, basicRecipe(Casts.CAST_LEG_PLATE, getLiquidItemStack(CMManager.AMOUNT_ARM_LEG)), cmIdentity.getId()).register(SlimeTinker.inst());
        }
        if (cmToolMakeup.isValidPlates()) {
            //CMManager.MAP_CAST_ARMOUR_PLATES_BOOTS.put(this, Parts.BOOT_PLATE.getStack(cmIdentity.getId(), PLATE, BOOTS, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, platesStack(cmIdentity.getId(), "BOOTS", SkullTextures.PART_BOOTS_PLATES), DummySmeltery.TYPE, basicRecipe(Casts.CAST_BOOT_PLATE, getLiquidItemStack(CMManager.AMOUNT_ARM_BOOT)), cmIdentity.getId()).register(SlimeTinker.inst());
        }

        // Gambeson
        if (this.cmToolMakeup.isValidGambeson()) {
            PartTemplate gambeson = new PartTemplate(ItemGroups.DUMMY, gambesonStack(cmIdentity.getId()), Workbench.TYPE, gambesonRecipe(cmIdentity.getRepresentativeStack()), cmIdentity.getId());
            gambeson.setHidden(true);
            gambeson.register(SlimeTinker.inst());
        }

        // Mail Links
        if (cmToolMakeup.isValidLinks()) {
            //CMManager.getMAP_CAST_ARMOUR_MAIL().put(this, Parts.MAIL_LINKS.getStack(cmIdentity.getId(), LINKS, null, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, linksStack(cmIdentity.getId()), DummySmeltery.TYPE, basicRecipe(Casts.CAST_MAIL_LINK, getLiquidItemStack(CMManager.AMOUNT_ARM_LINKS)), cmIdentity.getId()).register(SlimeTinker.inst());
        }

        // Repair Kit
        if (cmToolMakeup.isValidHead() || cmToolMakeup.isValidPlates()) {
            //CMManager.getMAP_CAST_REPAIRKIT().put(this, Parts.REPAIR_KIT.getStack(cmIdentity.getId(), REPAIR, getColor()));
            new PartTemplate(ItemGroups.PART_DICT, repairStack(cmIdentity.getId()), DummySmeltery.TYPE, basicRecipe(Casts.CAST_REPAIRKIT, getLiquidItemStack(CMManager.AMOUNT_KIT)), cmIdentity.getId()).register(SlimeTinker.inst());
        }

    }

    public SlimefunItemStack headStack(String name, String type, String skullTexture) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_HEAD_" + type + name,
            skullTexture,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " " + ThemeUtils.toTitleCase(type) + " Head",
            ThemeUtils.PASSIVE + "A tool head made of " + titName + "."
        );
    }

    // TODO This is now very disjointed. Needs all wrapping in - to resolve the this == this issue
    public SlimefunItemStack bindingStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        SlimefunItemStack i = ThemeUtils.themedItemStack(
            "PART_BINDING_" + name,
            SkullTextures.PART_BINDING,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Binding",
            ThemeUtils.PASSIVE + "A binding made of " + titName + "."
        );

        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, impossible but meh!");

        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getPartMaterial(), name);
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getPartClass(), IDStrings.BINDING);

        i.setItemMeta(im);
        return i;
    }

    public SlimefunItemStack rodStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_ROD_" + name,
            SkullTextures.PART_TOOL_ROD,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Rod",
            ThemeUtils.PASSIVE + "A tool rod made of " + titName + "."
        );
    }

    public SlimefunItemStack platesStack(String name, String type, String skullTexture) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_PLATES_" + type + name,
            skullTexture,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " " + ThemeUtils.toTitleCase(type) + " Plates",
            ThemeUtils.PASSIVE + "A set of armour plates made of " + titName + "."
        );
    }

    // TODO This is now very disjointed. Needs all wrapping in - to resolve the this == this issue
    public SlimefunItemStack gambesonStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        SlimefunItemStack i = ThemeUtils.themedItemStack(
            "PART_GAMBESON_" + name,
            SkullTextures.PART_GAMBESON,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Gambeson",
            ThemeUtils.PASSIVE + "A gambeson made of " + titName + "."
        );

        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, nope, not happening!");

        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getPartMaterial(), name);
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getPartClass(), IDStrings.GAMBESON);
        i.setItemMeta(im);
        return i;
    }

    public SlimefunItemStack linksStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_LINKS_" + name,
            SkullTextures.PART_LINKS,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Mail Links",
            ThemeUtils.PASSIVE + "A set of mail links made of " + titName + "."
        );
    }

    public SlimefunItemStack repairStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_REPAIR_KIT_" + name,
            Material.CHEST_MINECART,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Repair Kit",
            ThemeUtils.PASSIVE + "A kit that is able to repair items",
            "made out of " + titName + "."
        );
    }

    public ItemStack[] basicRecipe(ItemStack i, ItemStack i2) {
        return new ItemStack[]{
            null, null, null,
            i, null, i2,
            null, null, null
        };
    }

    public ItemStack[] bindingRecipe(ItemStack i) {
        return new ItemStack[]{
            i, null, i,
            null, i, null,
            i, null, i
        };
    }

    public ItemStack[] gambesonRecipe(ItemStack i) {
        return new ItemStack[]{
            null, i, i,
            i, null, i,
            i, i, null
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

    public boolean isValidPlates() {
        return cmToolMakeup.isValidPlates();
    }

    public boolean isValidGambeson() {
        return cmToolMakeup.isValidGambeson();
    }

    public boolean isValidLinks() {
        return cmToolMakeup.isValidLinks();
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
     * Runs an event based on the type of event the listener is requesting and the tool part.
     * If an event does not exist, nothing happens.
     *
     * @param type   "The type of event that will be triggered. Different cmEventMap can fire based on the listener (tick event) raising
     * @param part   "The tool part to be tested against this material type"
     * @param friend "The EventFriend to be carried through the cmEventMap to the settle phase"
     */
    public void runEvent(TraitEventType type, TraitPartType part, EventFriend friend) {
        if (!cmEventMap.containsKey(type)) {
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
