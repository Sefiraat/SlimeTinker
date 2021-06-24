package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

@Getter
public class CMLiquid {

    private final SlimefunItemStack itemStack;
    private final SlimefunItem item;

    public CMLiquid(String id, String texture, ItemStack inputItem) {
        String titName = ThemeUtils.toTitleCase(id);
        this.itemStack = ThemeUtils.themedItemStack(
                id + "_LIQUID",
                texture,
                ThemeUtils.ThemeItemType.MOLTEN_METAL,
                "Molten " + titName,
                ThemeUtils.PASSIVE + "The molten form of " + titName
        );
        this.item = new SlimefunItem(Categories.MOLTEN_METALS, itemStack, DummySmeltery.TYPE, new ItemStack[] {
                null, null, null,
                null, inputItem, null,
                null, null, null
        });
        item.register(SlimeTinker.inst());
    }
}
