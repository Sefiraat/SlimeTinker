package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryAlloy;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.Getter;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CMAlloy {

    private ComponentMaterial parent;
    private SlimefunItemStack itemStack;
    private SlimefunItem item;
    private final Map<String, Integer> alloyMap = new HashMap<>();
    private final List<SlimefunItemStack> recipe;

    public CMAlloy(List<SlimefunItemStack> recipe) {
        this.recipe = recipe;
    }

    public void setupAlloy(ComponentMaterial parent) {
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
        List<SlimefunItemStack> alloyRecipe = parent.getAlloyRecipe();
        Validate.notNull(alloyRecipe, "Alloy recipe is null. SefiDumb™");
        this.item = new SlimefunItem(ItemGroups.ALLOYS, itemStack, DummySmelteryAlloy.TYPE, alloyRecipe.toArray(new ItemStack[9]));
        item.register(SlimeTinker.inst());
        for (SlimefunItemStack i : parent.getAlloyRecipe()) {
            alloyMap.put(i.getItemId().replace("_LIQUID",""), i.getAmount());
        }
    }

}
