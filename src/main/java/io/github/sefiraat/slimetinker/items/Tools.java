package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplateExplosive;
import io.github.sefiraat.slimetinker.items.workstations.table.DummyTable;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@UtilityClass
public final class Tools {

    public static final String DESC_ERROR = "Error";
    public static final int LEVEL_NETHERITE = 10;
    public static final int LEVEL_DIAMOND = 8;
    public static final int LEVEL_IRON = 6;
    public static final int LEVEL_GOLD = 3;

    @Getter
    protected static final Map<String, Map<Integer, Material>> toolGrowthMap = new HashMap<>();

    protected static ItemStack[] getDummyToolRecipe(ItemStack i3) {
        return new ItemStack[]{
                null,                       null,                       null,
                Parts.PART_TOOL_ROD_DUMMY,  Parts.PART_BINDING_DUMMY,   i3,
                null,                       null,                       null
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

    public static final SlimefunItemStack TOOL_AXE_EXP =
            ThemeUtils.themedItemStack(
                    "TOOL_AXE_EXP",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_HOE_EXP =
            ThemeUtils.themedItemStack(
                    "TOOL_HOE_EXP",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_PICKAXE_EXP =
            ThemeUtils.themedItemStack(
                    "TOOL_PICKAXE_EXP",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_SHOVEL_EXP =
            ThemeUtils.themedItemStack(
                    "TOOL_SHOVEL_EXP",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_SWORD_EXP =
            ThemeUtils.themedItemStack(
                    "TOOL_SWORD_EXP",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack TOOL_INFO =
            ThemeUtils.themedItemStack(
                    "TOOL_INFO",
                    SkullTextures.INFO,
                    ThemeUtils.ThemeItemType.INFO,
                    "Tinker's Tools Info",
                    ThemeUtils.PASSIVE + "Tinker's tools start at Stone. As you",
                    ThemeUtils.PASSIVE + "level the tools up, they will promote",
                    ThemeUtils.PASSIVE + "through Gold > Iron > Diamond > Netherite."
            );

    public static final ToolTemplate SHOVEL = new ToolTemplate(Categories.DUMMY, TOOL_SHOVEL, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate PICKAXE = new ToolTemplate(Categories.DUMMY, TOOL_PICKAXE, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate AXE = new ToolTemplate(Categories.DUMMY, TOOL_AXE, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate HOE = new ToolTemplate(Categories.DUMMY, TOOL_HOE, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplate SWORD = new ToolTemplate(Categories.DUMMY, TOOL_SWORD, DummyTable.TYPE, new ItemStack[9]);

    public static final ToolTemplateExplosive EXP_SHOVEL = new ToolTemplateExplosive(Categories.DUMMY, TOOL_SHOVEL_EXP, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplateExplosive EXP_PICKAXE = new ToolTemplateExplosive(Categories.DUMMY, TOOL_PICKAXE_EXP, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplateExplosive EXP_AXE = new ToolTemplateExplosive(Categories.DUMMY, TOOL_AXE_EXP, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplateExplosive EXP_HOE = new ToolTemplateExplosive(Categories.DUMMY, TOOL_HOE_EXP, DummyTable.TYPE, new ItemStack[9]);
    public static final ToolTemplateExplosive EXP_SWORD = new ToolTemplateExplosive(Categories.DUMMY, TOOL_SWORD_EXP, DummyTable.TYPE, new ItemStack[9]);

    public static void set(SlimeTinker p) {
        
        new UnplaceableBlock(Categories.TOOLS, TOOL_INFO, DummyTable.TYPE, new ItemStack[9]).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_SHOVEL_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_SHOVEL_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_PICKAXE_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_PICKAXE_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_AXE_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_AXE_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_HOE_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_HOE_HEAD_DUMMY)).register(p);
        new UnplaceableBlock(Categories.TOOLS, TOOL_SWORD_DUMMY, DummyTable.TYPE, getDummyToolRecipe(Parts.PART_SWORD_BLADE_DUMMY)).register(p);

        SHOVEL.register(p);
        PICKAXE.register(p);
        AXE.register(p);
        HOE.register(p);
        SWORD.register(p);
        EXP_SHOVEL.register(p);
        EXP_PICKAXE.register(p);
        EXP_AXE.register(p);
        EXP_HOE.register(p);
        EXP_SWORD.register(p);

        toolGrowthMap.put(IDStrings.SHOVEL, getShovelMap());
        toolGrowthMap.put(IDStrings.PICKAXE, getPickaxeMap());
        toolGrowthMap.put(IDStrings.AXE, getAxeMap());
        toolGrowthMap.put(IDStrings.HOE, getHoeMap());
        toolGrowthMap.put(IDStrings.SWORD, getSwordMap());

    }
    
    private static Map<Integer, Material> getShovelMap() {
        Map<Integer, Material> map = new LinkedHashMap<>();
        map.put(LEVEL_NETHERITE, Material.NETHERITE_SHOVEL);
        map.put(LEVEL_DIAMOND, Material.DIAMOND_SHOVEL);
        map.put(LEVEL_IRON, Material.IRON_SHOVEL);
        map.put(LEVEL_GOLD, Material.GOLDEN_SHOVEL);
        return map;
    }

    private static Map<Integer, Material> getPickaxeMap() {
        Map<Integer, Material> map = new LinkedHashMap<>();
        map.put(LEVEL_NETHERITE, Material.NETHERITE_PICKAXE);
        map.put(LEVEL_DIAMOND, Material.DIAMOND_PICKAXE);
        map.put(LEVEL_IRON, Material.IRON_PICKAXE);
        map.put(LEVEL_GOLD, Material.GOLDEN_PICKAXE);
        return map;
    }

    private static Map<Integer, Material> getAxeMap() {
        Map<Integer, Material> map = new LinkedHashMap<>();
        map.put(LEVEL_NETHERITE, Material.NETHERITE_AXE);
        map.put(LEVEL_DIAMOND, Material.DIAMOND_AXE);
        map.put(LEVEL_IRON, Material.IRON_AXE);
        map.put(LEVEL_GOLD, Material.GOLDEN_AXE);
        return map;
    }

    private static Map<Integer, Material> getHoeMap() {
        Map<Integer, Material> map = new LinkedHashMap<>();
        map.put(LEVEL_NETHERITE, Material.NETHERITE_HOE);
        map.put(LEVEL_DIAMOND, Material.DIAMOND_HOE);
        map.put(LEVEL_IRON, Material.IRON_HOE);
        map.put(LEVEL_GOLD, Material.GOLDEN_HOE);
        return map;
    }

    private static Map<Integer, Material> getSwordMap() {
        Map<Integer, Material> map = new LinkedHashMap<>();
        map.put(LEVEL_NETHERITE, Material.NETHERITE_SWORD);
        map.put(LEVEL_DIAMOND, Material.DIAMOND_SWORD);
        map.put(LEVEL_IRON, Material.IRON_SWORD);
        map.put(LEVEL_GOLD, Material.GOLDEN_SWORD);
        return map;
    }

}
