package io.github.sefiraat.slimetinker.items.workstations.armourtable;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;

public final class DummyArmourTable {

    private DummyArmourTable() {
        throw new IllegalStateException("Utility class");
    }

    public static final SlimefunItemStack STACK = ThemeUtils.themedItemStack(
            "DUMMY_TINKERS_ARMOUR_TABLE",
            Material.CHISELED_NETHER_BRICKS,
            ThemeItemType.MACHINE,
            "Tinker's Armour Table",
            ThemeUtils.PASSIVE + "This item is made on a Tinker's Armour Table."
    );

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKeys().getWsDummyArmourTable(), STACK);

}
