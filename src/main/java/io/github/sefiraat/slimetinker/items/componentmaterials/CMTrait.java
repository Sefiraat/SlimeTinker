package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryAlloy;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Getter
public class CMTrait {

    private CMTraits parent;

    private final String traitName;
    private final SlimefunItemStack itemStack;
    private final SlimefunItem item;

    public CMTrait(String traitName, String texture, String addedBy, SlimefunItemStack partType, ItemStack material,  String... lore) {
        this.traitName = traitName;
        List<String> newLore = new ArrayList<>(Arrays.asList(lore));
        newLore.add("");
        newLore.add(ThemeUtils.ITEM_TYPEDESC + "Added by: " + addedBy);
        this.itemStack =
                ThemeUtils.themedItemStack(
                        traitName.toUpperCase(Locale.ROOT).replace(" ","_") + "_TRAIT_" + StackUtils.getIDorType(material),
                        texture,
                        ThemeUtils.ThemeItemType.PROP,
                        "Trait : " + traitName,
                        newLore
                );
        this.item = new SlimefunItem(Categories.TRAITS, itemStack, DummySmelteryAlloy.TYPE, CMTraits.propRecipe(partType, material));
        item.register(SlimeTinker.inst());
    }

    protected void setParent(CMTraits parent) {
        this.parent = parent;
    }

}
