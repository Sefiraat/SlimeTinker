package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
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

    public CMTraits(String materialID, @Nullable CMTrait traitHead, @Nullable CMTrait traitBind, @Nullable CMTrait traitRod) {
        this.materialID = materialID;

        this.traitHead = traitHead;
        this.traitBind = traitBind;
        this.traitRod = traitRod;
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

    }

    public static final SlimefunItemStack PROP_HEAD =
            ThemeUtils.themedItemStack(
                    "PROP_HEAD",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Head",
                    ThemeUtils.PASSIVE + "Any 'Head' item (Sword Blade, Axe Head etc.)"
            );
    // Used to display the 'binding' item in Property explanation recipes only
    public static final SlimefunItemStack PROP_BINDING =
            ThemeUtils.themedItemStack(
                    "PROP_BINDING",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Binder",
                    ThemeUtils.PASSIVE + "Any 'Binder' item."
            );
    // Used to display the 'rod' item in Property explanation recipes only
    public static final SlimefunItemStack PROP_ROD =
            ThemeUtils.themedItemStack(
                    "PROP_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.PART,
                    "Part: Tool Rod",
                    ThemeUtils.PASSIVE + "Any 'Tool Rod' item."
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
            return SkullTextures.PROPERTIES_CORE;
        } else if (addedBy.equals(SupportedPluginsManager.INFINITY_EXPANSION_NOTE)) {
            return SkullTextures.PROPERTIES_INFINITY;
        } else if (addedBy.equals(SupportedPluginsManager.SLIMEFUN_WARFARE_NOTE)) {
            return SkullTextures.PROPERTIES_WARFARE;
        } else if (addedBy.equals(SupportedPluginsManager.DYNATECH_NOTE)) {
            return SkullTextures.PROPERTIES_DYNATECH;
        }
        return "error";
    }

}
