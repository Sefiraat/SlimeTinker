package io.github.sefiraat.slimetinker.items.tinkermaterials.elements;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryMolten;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class Liquid {

    private final String texture;
    private TinkerMaterial parent;
    private SlimefunItemStack itemStack;
    private SlimefunItem item;

    public Liquid(String texture) {
        this.texture = texture;
    }

    public void setupLiquid(TinkerMaterial parent) {
        this.parent = parent;
        String titName = ThemeUtils.toTitleCase(parent.getId());
        this.itemStack = ThemeUtils.themedItemStack(
            parent.getId() + "_LIQUID",
            texture,
            ThemeItemType.MOLTEN_METAL,
            "Molten " + titName,
            ThemeUtils.PASSIVE + "The molten form of " + titName
        );

        this.item = new SlimefunItem(ItemGroups.MOLTEN_METALS, itemStack, DummySmelteryMolten.TYPE, new ItemStack[]{
            null, null, null,
            null, parent.getRepresentativeStack(), null,
            null, null, null
        });
        item.register(SlimeTinker.inst());
    }

    public String getTexture() {
        return texture;
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
