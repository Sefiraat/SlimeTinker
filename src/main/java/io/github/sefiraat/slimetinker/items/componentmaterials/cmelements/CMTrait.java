package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryTrait;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Getter
public class CMTrait {

    private final String traitName;
    private final String[] lore;
    private final String addedBy;
    private final SlimefunItemStack partType;
    private CMTraits parent;
    private ComponentMaterial parentCM;
    private SlimefunItemStack itemStack;
    private SlimefunItem item;

    public CMTrait(SlimefunItemStack partType, String addedBy, String traitName, String... lore) {
        this.traitName = traitName;
        this.addedBy = addedBy;
        this.partType = partType;
        this.lore = lore;
    }

    protected void setupTrait(CMTraits parent, ComponentMaterial parentCM) {
        this.parent = parent;
        this.parentCM = parentCM;

        List<String> newLore = new ArrayList<>(Arrays.asList(lore));
        newLore.add("");
        newLore.add(ThemeUtils.ITEM_TYPEDESC + "Added by: " + addedBy);
        this.itemStack =
            ThemeUtils.themedItemStack(
                traitName.toUpperCase(Locale.ROOT).replace(" ", "_") + "_TRAIT_" + partType.getItemId().toUpperCase(Locale.ROOT) + "_" + ItemUtils.getIdOrType(parentCM.getRepresentativeStack()),
                CMTraits.getTraitTexture(addedBy),
                ThemeItemType.PROP,
                "Trait : " + traitName,
                newLore
            );
        this.item = new SlimefunItem(ItemGroups.TRAITS, itemStack, DummySmelteryTrait.TYPE, CMTraits.propRecipe(partType, parentCM.getRepresentativeStack()));
        item.register(SlimeTinker.inst());

    }

}
