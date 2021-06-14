package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.DummySmeltery;
import io.github.sefiraat.slimetinker.items.parts.AxeHead;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class CastParts {

    private CastParts() {
        throw new IllegalStateException("Utility class");
    }

    public static final AxeHead AXE_HEAD = new AxeHead(Categories.DUMMY, AxeHead.STACK, DummySmeltery.TYPE, new ItemStack[9]);

    public static final SlimefunItemStack PART_AXE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_AXE_HEAD_DUMMY",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Axe Head",
                    ThemeUtils.PASSIVE + "A cast axe head."
            );

    public static void set(SlimeTinker p) {
        new UnplaceableBlock(Categories.PARTS, PART_AXE_HEAD_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_AXEHEAD)).register(p);
    }

}
