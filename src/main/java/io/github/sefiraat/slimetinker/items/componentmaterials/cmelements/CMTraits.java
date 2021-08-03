package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

@Getter
public class CMTraits {

    private ComponentMaterial parent;

    private final String materialID;
    @Nullable
    private final CMTrait traitHead;
    @Nullable
    private final CMTrait traitBind;
    @Nullable
    private final CMTrait traitRod;
    @Nullable
    private final CMTrait traitPlates;
    @Nullable
    private final CMTrait traitGambeson;
    @Nullable
    private final CMTrait traitLinks;

    public CMTraits(String materialID, @Nullable CMTrait traitHead, @Nullable CMTrait traitBind, @Nullable CMTrait traitRod, @Nullable CMTrait traitPlates, @Nullable CMTrait traitGambeson, @Nullable CMTrait traitLinks) {
        this.materialID = materialID;

        this.traitHead = traitHead;
        this.traitBind = traitBind;
        this.traitRod = traitRod;
        this.traitPlates = traitPlates;
        this.traitGambeson = traitGambeson;
        this.traitLinks = traitLinks;
    }

    public void setupTraits(ComponentMaterial parent) {
        this.parent = parent;

        if (traitHead != null) {
            traitHead.setupTrait(this, parent);
        }
        if (traitBind != null) {
            traitBind.setupTrait(this, parent);
        }
        if (traitRod != null) {
            traitRod.setupTrait(this, parent);
        }

        if (traitPlates != null) {
            traitPlates.setupTrait(this, parent);
        }
        if (traitGambeson != null) {
            traitGambeson.setupTrait(this, parent);
        }
        if (traitLinks != null) {
            traitLinks.setupTrait(this, parent);
        }

    }

    public static final SlimefunItemStack PROP_HEAD =
            ThemeUtils.themedItemStack(
                    "PROP_HEAD",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeItemType.PART,
                    "Part: Head",
                    ThemeUtils.PASSIVE + "Any 'Head' item (Sword Blade, Axe Head etc.)"
            );

    public static final SlimefunItemStack PROP_BINDING =
            ThemeUtils.themedItemStack(
                    "PROP_BINDING",
                    SkullTextures.PART_BINDING,
                    ThemeItemType.PART,
                    "Part: Binder",
                    ThemeUtils.PASSIVE + "Any 'Binder' item."
            );

    public static final SlimefunItemStack PROP_ROD =
            ThemeUtils.themedItemStack(
                    "PROP_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeItemType.PART,
                    "Part: Tool Rod",
                    ThemeUtils.PASSIVE + "Any 'Tool Rod' item."
            );

    public static final SlimefunItemStack PROP_PLATES =
            ThemeUtils.themedItemStack(
                    "PROP_PLATES",
                    SkullTextures.PART_CHEST_PLATES,
                    ThemeItemType.PART,
                    "Part: Plates",
                    ThemeUtils.PASSIVE + "Any 'Plate' item (Helm Plates, Boot Plates etc.)"
            );

    public static final SlimefunItemStack PROP_GAMBESON =
            ThemeUtils.themedItemStack(
                    "PROP_GAMBESON",
                    SkullTextures.PART_GAMBESON,
                    ThemeItemType.PART,
                    "Part: Gambeson",
                    ThemeUtils.PASSIVE + "Any 'Gambeson' item."
            );

    public static final SlimefunItemStack PROP_LINKS =
            ThemeUtils.themedItemStack(
                    "PROP_LINKS",
                    SkullTextures.PART_LINKS,
                    ThemeItemType.PART,
                    "Part: Mail Links",
                    ThemeUtils.PASSIVE + "Any 'Mail Link' item."
            );

    protected static ItemStack[] propRecipe(SlimefunItemStack part, ItemStack stack) {
        return new ItemStack[]{
                null, null, null,
                part, null, stack,
                null, null, null
        };
    }

    protected static String getTraitTexture(String addedBy) {
        if (addedBy.equals(SupportedPluginsManager.CORE_NOTE)) {
            return SkullTextures.TRAITS_CORE;
        } else if (addedBy.equals(SupportedPluginsManager.INFINITY_EXPANSION_NOTE)) {
            return SkullTextures.TRAITS_INFINITY;
        } else if (addedBy.equals(SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE)) {
            return SkullTextures.TRAITS_WARFARE;
        } else if (addedBy.equals(SupportedPluginsManager.DYNATECH_NOTE)) {
            return SkullTextures.TRAITS_DYNATECH;
        } else if (addedBy.equals(SupportedPluginsManager.LITEXPANSION_NOTE)) {
            return SkullTextures.TRAITS_LITEXPANSION;
        }
        return "error";
    }

}
