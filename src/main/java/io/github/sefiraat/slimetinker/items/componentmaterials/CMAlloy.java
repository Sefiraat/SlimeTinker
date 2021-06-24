package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryAlloy;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CMAlloy {

    private final SlimefunItemStack itemStack;
    private final SlimefunItem item;

    public CMAlloy(String id, String texture, List<SlimefunItemStack> recipe) {
        String titName = ThemeUtils.toTitleCase(id);
        this.itemStack =
                ThemeUtils.themedItemStack(
                        id + "_ALLOY",
                        texture,
                        ThemeUtils.ThemeItemType.MOLTEN_METAL,
                        "Molten " + titName,
                        ThemeUtils.PASSIVE + "A molten alloy metal of " + titName
                );
        this.item = new SlimefunItem(Categories.ALLOYS, itemStack, DummySmelteryAlloy.TYPE, recipe.toArray(new ItemStack[9]));
        item.register(SlimeTinker.inst());
    }

}
