package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.machines.DummySmeltery;
import io.github.sefiraat.slimetinker.items.parts.AxeHead;
import io.github.sefiraat.slimetinker.items.parts.HoeHead;
import io.github.sefiraat.slimetinker.items.parts.PickaxeHead;
import io.github.sefiraat.slimetinker.items.parts.ShovelHead;
import io.github.sefiraat.slimetinker.items.parts.SwordBlade;
import io.github.sefiraat.slimetinker.items.parts.ToolRod;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class CastParts {

    private CastParts() {
        throw new IllegalStateException("Utility class");
    }

    public static final ShovelHead SHOVEL_HEAD = new ShovelHead(Categories.DUMMY, ShovelHead.STACK, DummySmeltery.TYPE, new ItemStack[9]);
    public static final PickaxeHead PICKAXE_HEAD = new PickaxeHead(Categories.DUMMY, PickaxeHead.STACK, DummySmeltery.TYPE, new ItemStack[9]);
    public static final AxeHead AXE_HEAD = new AxeHead(Categories.DUMMY, AxeHead.STACK, DummySmeltery.TYPE, new ItemStack[9]);
    public static final HoeHead HOE_HEAD = new HoeHead(Categories.DUMMY, HoeHead.STACK, DummySmeltery.TYPE, new ItemStack[9]);
    public static final SwordBlade SWORD_BLADE = new SwordBlade(Categories.DUMMY, SwordBlade.STACK, DummySmeltery.TYPE, new ItemStack[9]);
    public static final SwordBlade TOOL_ROD = new SwordBlade(Categories.DUMMY, ToolRod.STACK, DummySmeltery.TYPE, new ItemStack[9]);

    public static final SlimefunItemStack PART_SHOVEL_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_SHOVEL_HEAD_DUMMY",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Shovel Head",
                    ThemeUtils.PASSIVE + "A cast shovel head."
            );

    public static final SlimefunItemStack PART_PICKAXE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_PICKAXE_HEAD_DUMMY",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Pickaxe Head",
                    ThemeUtils.PASSIVE + "A cast pickaxe head."
            );

    public static final SlimefunItemStack PART_AXE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_AXE_HEAD_DUMMY",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Axe Head",
                    ThemeUtils.PASSIVE + "A cast axe head."
            );

    public static final SlimefunItemStack PART_HOE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_HOE_HEAD_DUMMY",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Hoe Head",
                    ThemeUtils.PASSIVE + "A cast hoe head."
            );

    public static final SlimefunItemStack PART_SWORD_BLADE_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_SWORD_BLADE_DUMMY",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Sword Blade",
                    ThemeUtils.PASSIVE + "A cast sword blade."
            );

    public static final SlimefunItemStack PART_TOOL_ROD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_TOOL_ROD_DUMMY",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Tool Rod",
                    ThemeUtils.PASSIVE + "A cast tool rod."
            );

    public static void set(SlimeTinker p) {
        new UnplaceableBlock(Categories.PARTS, PART_SHOVEL_HEAD_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_SHOVELHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_PICKAXE_HEAD_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_PICKAXEHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_AXE_HEAD_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_AXEHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_HOE_HEAD_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_HOEHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_SWORD_BLADE_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_SWORDBLADE)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_TOOL_ROD_DUMMY, DummySmeltery.TYPE, Recipes.getDummyCastRecipe(Casts.CAST_TOOLROD)).register(p);
    }

}
