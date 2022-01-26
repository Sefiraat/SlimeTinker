package io.github.sefiraat.slimetinker.items.tinkermaterials.elements;

import io.github.mooy1.infinitylib.common.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryTrait;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MaterialTrait {

    private final String traitName;
    private final String[] lore;
    private final String addedBy;
    private final SlimefunItemStack partType;
    private TinkerMaterial parent;
    private SlimefunItemStack itemStack;
    private SlimefunItem item;

    public MaterialTrait(SlimefunItemStack partType, String addedBy, String traitName, String... lore) {
        this.traitName = traitName;
        this.addedBy = addedBy;
        this.partType = partType;
        this.lore = lore;
    }

    public void setupTrait(TinkerMaterial parentCM) {
        this.parent = parentCM;

        List<String> newLore = new ArrayList<>(Arrays.asList(lore));
        newLore.add("");
        newLore.add(ThemeUtils.ITEM_TYPEDESC + "Added by: " + addedBy);
        this.itemStack =
            ThemeUtils.themedItemStack(
                MessageFormat.format(
                    "{0}_TRAIT_{1}_{2}",
                    traitName.toUpperCase(Locale.ROOT).replace(" ", "_"),
                    partType.getItemId().toUpperCase(Locale.ROOT),
                    StackUtils.getIdOrType(parentCM.getRepresentativeStack())
                ),
                getTraitTexture(addedBy),
                ThemeItemType.PROP,
                "Trait : " + traitName,
                newLore
            );
        this.item = new SlimefunItem(ItemGroups.TRAITS, itemStack, DummySmelteryTrait.TYPE, propRecipe(partType, parentCM.getRepresentativeStack()));
        item.register(SlimeTinker.inst());

    }

    public String getTraitName() {
        return traitName;
    }

    public String[] getLore() {
        return lore;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public SlimefunItemStack getPartType() {
        return partType;
    }

    public TinkerMaterial getParent() {
        return parent;
    }

    public SlimefunItemStack getItemStack() {
        return itemStack;
    }

    public SlimefunItem getItem() {
        return item;
    }

    @Nonnull
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

    public static final SlimefunItemStack PROP_HEAD = ThemeUtils.themedItemStack(
        "PROP_HEAD",
        SkullTextures.PART_SWORD_BLADE,
        ThemeItemType.PART,
        "Part: Head",
        ThemeUtils.PASSIVE + "Any 'Head' item (Sword Blade, Axe Head etc.)"
    );

    public static final SlimefunItemStack PROP_BINDING = ThemeUtils.themedItemStack(
        "PROP_BINDING",
        SkullTextures.PART_BINDING,
        ThemeItemType.PART,
        "Part: Binder",
        ThemeUtils.PASSIVE + "Any 'Binder' item."
    );

    public static final SlimefunItemStack PROP_ROD = ThemeUtils.themedItemStack(
        "PROP_ROD",
        SkullTextures.PART_TOOL_ROD,
        ThemeItemType.PART,
        "Part: Tool Rod",
        ThemeUtils.PASSIVE + "Any 'Tool Rod' item."
    );

    public static final SlimefunItemStack PROP_PLATES = ThemeUtils.themedItemStack(
        "PROP_PLATES",
        SkullTextures.PART_CHEST_PLATES,
        ThemeItemType.PART,
        "Part: Plates",
        ThemeUtils.PASSIVE + "Any 'Plate' item (Helm Plates, Boot Plates etc.)"
    );

    public static final SlimefunItemStack PROP_GAMBESON = ThemeUtils.themedItemStack(
        "PROP_GAMBESON",
        SkullTextures.PART_GAMBESON,
        ThemeItemType.PART,
        "Part: Gambeson",
        ThemeUtils.PASSIVE + "Any 'Gambeson' item."
    );

    public static final SlimefunItemStack PROP_LINKS = ThemeUtils.themedItemStack(
        "PROP_LINKS",
        SkullTextures.PART_LINKS,
        ThemeItemType.PART,
        "Part: Mail Links",
        ThemeUtils.PASSIVE + "Any 'Mail Link' item."
    );

    @Nonnull
    protected static ItemStack[] propRecipe(SlimefunItemStack part, ItemStack stack) {
        return new ItemStack[]{
            null, null, null,
            part, null, stack,
            null, null, null
        };
    }
}
