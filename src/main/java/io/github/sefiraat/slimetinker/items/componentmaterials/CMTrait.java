package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryAlloy;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Getter
public class CMTrait {

    private CMTraits parent;
    private ComponentMaterial parentCM;

    private final String traitName;
    private final String[] lore;
    private final String addedBy;
    private final SlimefunItemStack partType;
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
                        traitName.toUpperCase(Locale.ROOT).replace(" ","_") + "_TRAIT_" + StackUtils.getIDorType(parentCM.getRepresentativeStack()),
                        CMTraits.getTraitTexture(addedBy),
                        ThemeUtils.ThemeItemType.PROP,
                        "Trait : " + traitName,
                        newLore
                );
        this.item = new SlimefunItem(Categories.TRAITS, itemStack, DummySmelteryAlloy.TYPE, CMTraits.propRecipe(partType, parentCM.getRepresentativeStack()));
        item.register(SlimeTinker.inst());

    }

}
