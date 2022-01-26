package io.github.sefiraat.slimetinker.items.tinkermaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.templates.PartTemplate;
import io.github.sefiraat.slimetinker.items.tinkermaterials.elements.Alloy;
import io.github.sefiraat.slimetinker.items.tinkermaterials.elements.Liquid;
import io.github.sefiraat.slimetinker.items.tinkermaterials.elements.MaterialTrait;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.managers.TraitManager;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.Keys;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.function.Consumer;

public class TinkerMaterial {

    // Constructor
    private final String id;
    private final ItemStack representativeStack;

    @Nullable
    private String liquidTexture;
    private final String colorHex;

    // Liquid
    @Nullable
    private Liquid liquid;

    // Traits
    @Nullable
    private MaterialTrait traitToolHead;
    @Nullable
    private MaterialTrait traitToolBinder;
    @Nullable
    private MaterialTrait traitToolRod;
    @Nullable
    private MaterialTrait traitArmorPlates;
    @Nullable
    private MaterialTrait traitArmorGambeson;
    @Nullable
    private MaterialTrait traitArmorLinks;

    //Forms
    @Nullable
    private String formNugget;
    @Nullable
    private String formIngot;
    @Nullable
    private String formBlock;
    @Nullable
    private String formOre;
    @Nullable
    private String formGem;
    @Nullable
    private String formDust;
    @Nullable
    private String formBoots;
    @Nullable
    private String formLeggings;
    @Nullable
    private String formChestplate;
    @Nullable
    private String formHelmet;

    @Nullable
    private Alloy alloy;
    @Nullable
    private SlimefunItemStack[] alloyRecipe;

    @ParametersAreNonnullByDefault
    public TinkerMaterial(String id, ItemStack representativeStack, String colorHex) {
        this.id = id;
        this.representativeStack = representativeStack;
        this.colorHex = colorHex;
    }

    public TinkerMaterial build() {
        if (this.liquid != null) {
            this.liquid.setupLiquid(this);
        }

        if (this.alloy != null) {
            this.alloy.setupAlloy(this);
        }

        setupTraits();
        registerParts();
        return this;
    }

    public void setupTraits() {
        final TraitManager manager = SlimeTinker.inst().getTraitManager();

        if (this.traitToolHead != null && manager.getEnabled(this.id, Ids.HEAD)) {
            this.traitToolHead.setupTrait(this);
        }
        if (this.traitToolBinder != null && manager.getEnabled(this.id, Ids.BINDING)) {
            this.traitToolBinder.setupTrait(this);
        }
        if (this.traitToolRod != null && manager.getEnabled(this.id, Ids.ROD)) {
            this.traitToolRod.setupTrait(this);
        }

        if (this.traitArmorPlates != null && manager.getEnabled(this.id, Ids.PLATE)) {
            this.traitArmorPlates.setupTrait(this);
        }
        if (this.traitArmorGambeson != null && manager.getEnabled(this.id, Ids.GAMBESON)) {
            this.traitArmorGambeson.setupTrait(this);
        }
        if (this.traitArmorLinks != null && manager.getEnabled(this.id, Ids.LINKS)) {
            this.traitArmorLinks.setupTrait(this);
        }
        manager.save();
    }

    public void registerParts() {
        TraitManager traitManager = SlimeTinker.inst().getTraitManager();

        // Heads (and repair kits)
        if (this.traitToolHead != null && traitManager.isEnabled(this.id, Ids.HEAD)) {
            new PartTemplate(
                ItemGroups.PART_DICT,
                headStack(this.id, "SWORD", SkullTextures.PART_SWORD_BLADE),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_SWORDBLADE, getLiquidItemStack(2)),
                this.id
            ).register(SlimeTinker.inst());

            new PartTemplate(
                ItemGroups.PART_DICT,
                headStack(this.id, "HOE", SkullTextures.PART_HOE_HEAD),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_HOEHEAD, getLiquidItemStack(1)),
                this.id
            ).register(SlimeTinker.inst());

            new PartTemplate(
                ItemGroups.PART_DICT,
                headStack(this.id, "AXE", SkullTextures.PART_AXE_HEAD),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_AXEHEAD, getLiquidItemStack(1)),
                this.id
            ).register(SlimeTinker.inst());

            new PartTemplate(
                ItemGroups.PART_DICT,
                headStack(this.id, "PICK", SkullTextures.PART_PICKAXE_HEAD),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_PICKAXEHEAD, getLiquidItemStack(1)),
                this.id).register(SlimeTinker.inst()
            );

            new PartTemplate(
                ItemGroups.PART_DICT,
                headStack(this.id, "SHOVEL", SkullTextures.PART_SHOVEL_HEAD),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_SHOVELHEAD, getLiquidItemStack(1)),
                this.id
            ).register(SlimeTinker.inst());
        }

        // Binders
        if (this.traitToolBinder != null && traitManager.isEnabled(this.id, Ids.BINDING)) {
            PartTemplate binder = new PartTemplate(
                ItemGroups.DUMMY,
                bindingStack(this.id),
                Workbench.TYPE,
                bindingRecipe(this.representativeStack),
                this.id
            );
            binder.setHidden(true);
            binder.register(SlimeTinker.inst());
        }

        // Tool Rods
        if (this.traitToolRod != null && traitManager.isEnabled(this.id, Ids.ROD)) {
            new PartTemplate(
                ItemGroups.PART_DICT,
                rodStack(this.id),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_TOOLROD, getLiquidItemStack(1)),
                this.id
            ).register(SlimeTinker.inst());
        }

        // Plates
        if (this.traitArmorPlates != null && traitManager.isEnabled(this.id, Ids.PLATE)) {
            new PartTemplate(
                ItemGroups.PART_DICT,
                platesStack(this.id, "HELMET", SkullTextures.PART_HELM_PLATES),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_HELM_PLATE, getLiquidItemStack(TinkerMaterialManager.AMOUNT_ARM_HELM)),
                this.id
            ).register(SlimeTinker.inst());

            new PartTemplate(
                ItemGroups.PART_DICT,
                platesStack(this.id, "CHESTPLATE", SkullTextures.PART_CHEST_PLATES),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_CHEST_PLATE, getLiquidItemStack(TinkerMaterialManager.AMOUNT_ARM_CHEST)),
                this.id
            ).register(SlimeTinker.inst());

            new PartTemplate(
                ItemGroups.PART_DICT,
                platesStack(this.id, "LEGGINGS", SkullTextures.PART_LEG_PLATES),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_LEG_PLATE, getLiquidItemStack(TinkerMaterialManager.AMOUNT_ARM_LEG)),
                this.id
            ).register(SlimeTinker.inst());

            new PartTemplate(
                ItemGroups.PART_DICT,
                platesStack(this.id, "BOOTS", SkullTextures.PART_BOOTS_PLATES),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_BOOT_PLATE, getLiquidItemStack(TinkerMaterialManager.AMOUNT_ARM_BOOT)),
                this.id
            ).register(SlimeTinker.inst());
        }

        // Gambeson
        if (this.traitArmorGambeson != null && traitManager.isEnabled(this.id, Ids.GAMBESON)) {
            PartTemplate gambeson = new PartTemplate(
                ItemGroups.DUMMY,
                gambesonStack(this.id),
                Workbench.TYPE,
                gambesonRecipe(this.representativeStack),
                this.id
            );
            gambeson.setHidden(true);
            gambeson.register(SlimeTinker.inst());
        }

        // Mail Links
        if (this.traitArmorLinks != null && traitManager.isEnabled(this.id, Ids.LINKS)) {
            new PartTemplate(
                ItemGroups.PART_DICT,
                linksStack(this.id),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_MAIL_LINK, getLiquidItemStack(TinkerMaterialManager.AMOUNT_ARM_LINKS)),
                this.id
            ).register(SlimeTinker.inst());
        }

        // Repair Kit
        if (this.traitToolHead != null || this.traitArmorPlates != null) {
            new PartTemplate(
                ItemGroups.PART_DICT,
                repairStack(this.id),
                DummySmeltery.TYPE,
                basicRecipe(Casts.CAST_REPAIRKIT, getLiquidItemStack(TinkerMaterialManager.AMOUNT_KIT)),
                this.id
            ).register(SlimeTinker.inst());
        }
    }

    public TinkerMaterial setLiquidTexture(@Nonnull String liquidTexture) {
        this.liquidTexture = liquidTexture;
        this.liquid = new Liquid(liquidTexture);
        return this;
    }

    public TinkerMaterial addAlloyRecipe(@Nonnull SlimefunItemStack... alloyRecipe) {
        this.alloyRecipe = alloyRecipe;
        this.alloy = new Alloy(alloyRecipe);
        return this;
    }

    @Nullable
    public MaterialTrait getTraitToolHead() {
        return traitToolHead;
    }

    public TinkerMaterial setTraitToolHead(@Nullable MaterialTrait traitToolHead) {
        this.traitToolHead = traitToolHead;
        return this;
    }

    @Nullable
    public MaterialTrait getTraitToolBinder() {
        return traitToolBinder;
    }

    public TinkerMaterial setTraitToolBinder(@Nullable MaterialTrait traitToolBinding) {
        this.traitToolBinder = traitToolBinding;
        return this;
    }

    @Nullable
    public MaterialTrait getTraitToolRod() {
        return traitToolRod;
    }

    public TinkerMaterial setTraitToolRod(@Nullable MaterialTrait traitToolRod) {
        this.traitToolRod = traitToolRod;
        return this;
    }

    @Nullable
    public MaterialTrait getTraitArmorPlates() {
        return traitArmorPlates;
    }

    public TinkerMaterial setTraitArmorPlates(@Nullable MaterialTrait traitArmorPlates) {
        this.traitArmorPlates = traitArmorPlates;
        return this;
    }

    @Nullable
    public MaterialTrait getTraitArmorGambeson() {
        return traitArmorGambeson;
    }

    public TinkerMaterial setTraitArmorGambeson(@Nullable MaterialTrait traitArmorGambeson) {
        this.traitArmorGambeson = traitArmorGambeson;
        return this;
    }

    @Nullable
    public MaterialTrait getTraitArmorLinks() {
        return traitArmorLinks;
    }

    public TinkerMaterial setTraitArmorLinks(@Nullable MaterialTrait traitArmorLinks) {
        this.traitArmorLinks = traitArmorLinks;
        return this;
    }

    @Nullable
    public String getFormNugget() {
        return formNugget;
    }

    public TinkerMaterial setFormNugget(@Nullable String formNugget) {
        this.formNugget = formNugget;
        return this;
    }

    @Nullable
    public String getFormIngot() {
        return formIngot;
    }

    public TinkerMaterial setFormIngot(@Nullable String formIngot) {
        this.formIngot = formIngot;
        return this;
    }

    @Nullable
    public String getFormBlock() {
        return formBlock;
    }

    public TinkerMaterial setFormBlock(@Nullable String formBlock) {
        this.formBlock = formBlock;
        return this;
    }

    @Nullable
    public String getFormOre() {
        return formOre;
    }

    public TinkerMaterial setFormOre(@Nullable String formOre) {
        this.formOre = formOre;
        return this;
    }

    @Nullable
    public String getFormGem() {
        return formGem;
    }

    public TinkerMaterial setFormGem(@Nullable String formGem) {
        this.formGem = formGem;
        return this;
    }

    @Nullable
    public String getFormDust() {
        return formDust;
    }

    public TinkerMaterial setFormDust(@Nullable String formDust) {
        this.formDust = formDust;
        return this;
    }

    @Nullable
    public String getFormBoots() {
        return formBoots;
    }

    public TinkerMaterial setFormBoots(@Nullable String formBoots) {
        this.formBoots = formBoots;
        return this;
    }

    @Nullable
    public String getFormLeggings() {
        return formLeggings;
    }

    public TinkerMaterial setFormLeggings(@Nullable String formLeggings) {
        this.formLeggings = formLeggings;
        return this;
    }

    @Nullable
    public String getFormChestplate() {
        return formChestplate;
    }

    public TinkerMaterial setFormChestplate(@Nullable String formChestplate) {
        this.formChestplate = formChestplate;
        return this;
    }

    @Nullable
    public String getFormHelmet() {
        return formHelmet;
    }

    public TinkerMaterial setFormHelmet(@Nullable String formHelmet) {
        this.formHelmet = formHelmet;
        return this;
    }

    public ChatColor getColor() {
        return ChatColor.of(this.colorHex);
    }

    public SlimefunItemStack getLiquidItemStack(int amount) {
        return new SlimefunItemStack(liquid.getItemStack(), amount);
    }

    public String getId() {
        return this.id;
    }

    public String getLiquidTexture() {
        return this.liquidTexture;
    }

    public ItemStack getRepresentativeStack() {
        return this.representativeStack;
    }

    @Nullable
    public SlimefunItemStack[] getAlloyRecipe() {
        return alloyRecipe;
    }

    @Nullable
    public Liquid getCmLiquid() {
        return liquid;
    }

    @Nullable
    public Alloy getCmAlloy() {
        return alloy;
    }

    @Nonnull
    private SlimefunItemStack headStack(String name, String type, String skullTexture) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_HEAD_" + type + name,
            skullTexture,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " " + ThemeUtils.toTitleCase(type) + " Head",
            ThemeUtils.PASSIVE + "A tool head made of " + titName + "."
        );
    }

    @Nonnull
    private SlimefunItemStack bindingStack(String name) {
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

        PersistentDataAPI.setString(im, Keys.PART_MATERIAL, name);
        PersistentDataAPI.setString(im, Keys.PART_CLASS, Ids.BINDING);

        i.setItemMeta(im);
        return i;
    }

    @Nonnull
    private SlimefunItemStack rodStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_ROD_" + name,
            SkullTextures.PART_TOOL_ROD,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Rod",
            ThemeUtils.PASSIVE + "A tool rod made of " + titName + "."
        );
    }

    @Nonnull
    private SlimefunItemStack platesStack(String name, String type, String skullTexture) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_PLATES_" + type + name,
            skullTexture,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " " + ThemeUtils.toTitleCase(type) + " Plates",
            ThemeUtils.PASSIVE + "A set of armour plates made of " + titName + "."
        );
    }

    @Nonnull
    private SlimefunItemStack gambesonStack(String name) {
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

        PersistentDataAPI.setString(im, Keys.PART_MATERIAL, name);
        PersistentDataAPI.setString(im, Keys.PART_CLASS, Ids.GAMBESON);
        i.setItemMeta(im);
        return i;
    }

    @Nonnull
    private SlimefunItemStack linksStack(String name) {
        String titName = ThemeUtils.toTitleCase(name);
        return ThemeUtils.themedItemStack(
            "PART_LINKS_" + name,
            SkullTextures.PART_LINKS,
            ThemeItemType.PART,
            getColor() + titName + ThemeUtils.ITEM_PART + " Mail Links",
            ThemeUtils.PASSIVE + "A set of mail links made of " + titName + "."
        );
    }

    @Nonnull
    private SlimefunItemStack repairStack(String name) {
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

    private ItemStack[] basicRecipe(ItemStack i, ItemStack i2) {
        return new ItemStack[]{
            null, null, null,
            i, null, i2,
            null, null, null
        };
    }

    private ItemStack[] bindingRecipe(ItemStack i) {
        return new ItemStack[]{
            i, null, i,
            null, i, null,
            i, null, i
        };
    }

    private ItemStack[] gambesonRecipe(ItemStack i) {
        return new ItemStack[]{
            null, i, i,
            i, null, i,
            i, i, null
        };
    }

    /**
     * Runs an event based on the type of event the listener is requesting and the tool part.
     * If an event does not exist, nothing happens.
     *
     * @param type   "The type of event that will be triggered. Different cmEventMap can fire based on the listener (tick event) raising
     * @param part   "The tool part to be tested against this material type"
     * @param friend "The EventFriend to be carried through the cmEventMap to the settle phase"
     */
    @ParametersAreNonnullByDefault
    public void runEvent(TraitEventType type, TraitPartType part, EventFriend friend) {
        switch (part) {
            case HEAD:
                if (this.traitToolHead != null) {
                    this.traitToolHead.run(type, friend);
                }
                break;
            case BINDER:
                if (this.traitToolBinder != null) {
                    this.traitToolBinder.run(type, friend);
                }
                break;
            case ROD:
                if (this.traitToolRod != null) {
                    this.traitToolRod.run(type, friend);
                }
                break;
            case PLATES:
                if (this.traitArmorPlates != null) {
                    this.traitArmorPlates.run(type, friend);
                }
                break;
            case GAMBESON:
                if (this.traitArmorGambeson != null) {
                    this.traitArmorGambeson.run(type, friend);
                }
                break;
            case LINKS:
                if (this.traitArmorLinks != null) {
                    this.traitArmorLinks.run(type, friend);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + part);
        }
    }
}
