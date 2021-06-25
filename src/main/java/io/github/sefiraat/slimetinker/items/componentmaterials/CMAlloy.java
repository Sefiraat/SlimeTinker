package io.github.sefiraat.slimetinker.items.componentmaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmelteryAlloy;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CMAlloy {

    @Getter
    private final String liquidID;
    @Getter
    private final SlimefunItemStack itemStack;
    @Getter
    private final SlimefunItem item;
    @Getter
    private final Map<String, Integer> alloyMap = new HashMap<>();

    public CMAlloy(String id, String texture, List<SlimefunItemStack> recipe) {
        this.liquidID = id;
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
        for (SlimefunItemStack i : recipe) {
            alloyMap.put(i.getItemId(), i.getAmount());
        }
    }

}
