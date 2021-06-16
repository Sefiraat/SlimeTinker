package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.items.workstations.table.DummyTable;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Tools {

    public static final String DESC_ERROR = "Error";

    protected static ItemStack[] getDummyToolRecipe(ItemStack i1, ItemStack i2, ItemStack i3) {
        return new ItemStack[]{
                null,   null,   null,
                i1,     i2,     i3,
                null,   null,   null
        };
    }

    public static final SlimefunItemStack TOOL_SHOVEL_DUMMY =
            ThemeUtils.themedItemStack(
                    "TOOL_SHOVEL_DUMMY",
                    Material.STONE_SHOVEL,
                    ThemeUtils.ThemeItemType.TOOL,
                    "Tinker's Shovel",
                    ThemeUtils.PASSIVE + "A shovel formed of three parts.",
                    ThemeUtils.PASSIVE + "Tinker's tools can level up and be",
                    ThemeUtils.PASSIVE + "given extra properties and modifiers."
            );

    public static final SlimefunItemStack TOOL_PICKAXE_DUMMY =
            ThemeUtils.themedItemStack(
                    "TOOL_PICKAXE_DUMMY",
                    Material.STONE_PICKAXE,
                    ThemeUtils.ThemeItemType.TOOL,
                    "Tinker's Pickaxe",
                    ThemeUtils.PASSIVE + "A pickaxe formed of three parts.",
                    ThemeUtils.PASSIVE + "Tinker's tools can level up and be",
                    ThemeUtils.PASSIVE + "given extra properties and modifiers."
            );

    public static final SlimefunItemStack TOOL_AXE_DUMMY =
            ThemeUtils.themedItemStack(
                    "TOOL_AXE_DUMMY",
                    Material.STONE_AXE,
                    ThemeUtils.ThemeItemType.TOOL,
                    "Tinker's Axe",
                    ThemeUtils.PASSIVE + "An axe formed of three parts.",
                    ThemeUtils.PASSIVE + "Tinker's tools can level up and be",
                    ThemeUtils.PASSIVE + "given extra properties and modifiers."
            );

    public static final SlimefunItemStack TOOL_HOE_DUMMY =
            ThemeUtils.themedItemStack(
                    "TOOL_HOE_DUMMY",
                    Material.STONE_HOE,
                    ThemeUtils.ThemeItemType.TOOL,
                    "Tinker's Hoe",
                    ThemeUtils.PASSIVE + "A hoe formed of three parts.",
                    ThemeUtils.PASSIVE + "Tinker's tools can level up and be",
                    ThemeUtils.PASSIVE + "given extra properties and modifiers."
            );

    public static final SlimefunItemStack TOOL_SWORD_DUMMY =
            ThemeUtils.themedItemStack(
                    "TOOL_SWORD_DUMMY",
                    Material.STONE_SWORD,
                    ThemeUtils.ThemeItemType.TOOL,
                    "Tinker's Sword",
                    ThemeUtils.PASSIVE + "A sword formed of three parts.",
                    ThemeUtils.PASSIVE + "Tinker's tools can level up and be",
                    ThemeUtils.PASSIVE + "given extra properties and modifiers."
            );

    public static final SlimefunItemStack TOOL_AXE =
            ThemeUtils.themedItemStack(
                    "TOOL_AXE",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_HOE =
            ThemeUtils.themedItemStack(
                    "TOOL_HOE",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_PICKAXE =
            ThemeUtils.themedItemStack(
                    "TOOL_PICKAXE",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_SHOVEL =
            ThemeUtils.themedItemStack(
                    "TOOL_SHOVEL",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_SWORD =
            ThemeUtils.themedItemStack(
                    "TOOL_SWORD",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final ToolTemplate SHOVEL = new ToolTemplate(Categories.DUMMY, TOOL_SHOVEL, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate PICKAXE = new ToolTemplate(Categories.DUMMY, TOOL_PICKAXE, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate AXE = new ToolTemplate(Categories.DUMMY, TOOL_AXE, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate HOE = new ToolTemplate(Categories.DUMMY, TOOL_HOE, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate SWORD = new ToolTemplate(Categories.DUMMY, TOOL_SWORD, DummyTable.TYPE, new ItemStack[9]);

    public static void set(SlimeTinker p) {
        new UnplaceableBlock(Categories.TOOLS, TOOL_SHOVEL_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_TOOL_ROD_DUMMY, Parts.PART_BINDING_DUMMY, Parts.PART_SHOVEL_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_PICKAXE_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_TOOL_ROD_DUMMY, Parts.PART_BINDING_DUMMY, Parts.PART_PICKAXE_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_AXE_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_TOOL_ROD_DUMMY, Parts.PART_BINDING_DUMMY, Parts.PART_AXE_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_HOE_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_TOOL_ROD_DUMMY, Parts.PART_BINDING_DUMMY, Parts.PART_HOE_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_SWORD_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_TOOL_ROD_DUMMY, Parts.PART_BINDING_DUMMY, Parts.PART_SWORD_BLADE_DUMMY)).register(p);
    }

}
