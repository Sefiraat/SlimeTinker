package io.github.sefiraat.slimetinker.items.tinkermaterials.elements;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryAlloy;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.apache.commons.lang.Validate;

import java.util.HashMap;
import java.util.Map;

public class Alloy {

    private final Map<String, Integer> alloyMap = new HashMap<>();
    private final SlimefunItemStack[] recipe;
    private TinkerMaterial parent;
    private SlimefunItemStack itemStack;
    private SlimefunItem item;

    public Alloy(SlimefunItemStack[] recipe) {
        this.recipe = recipe;
    }

    public void setupAlloy(TinkerMaterial parent) {
        this.parent = parent;
        String titName = ThemeUtils.toTitleCase(parent.getId());
        this.itemStack =
            ThemeUtils.themedItemStack(
                parent.getId() + "_ALLOY",
                parent.getLiquidTexture(),
                ThemeItemType.MOLTEN_METAL,
                "Molten " + titName,
                ThemeUtils.PASSIVE + "A molten alloy metal of " + titName
            );
        SlimefunItemStack[] alloyRecipe = parent.getAlloyRecipe();
        Validate.notNull(alloyRecipe, "Alloy recipe is null. SefiDumb™");
        this.item = new SlimefunItem(ItemGroups.ALLOYS, itemStack, DummySmelteryAlloy.TYPE, alloyRecipe);
        item.register(SlimeTinker.getInstance());
        for (SlimefunItemStack i : parent.getAlloyRecipe()) {
            alloyMap.put(i.getItemId().replace("_LIQUID", ""), i.getAmount());
        }
    }

    public Map<String, Integer> getAlloyMap() {
        return alloyMap;
    }

    public SlimefunItemStack[] getRecipe() {
        return recipe;
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
}
