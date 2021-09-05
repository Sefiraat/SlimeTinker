package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public final class Casts {

    public static final String CAST_DESC = "A cast for metals.";
    public static final String INPUT_DESC = "Input : ";
    public static final String OUTPUT_DESC = "Output : ";
    public static final String UNIT_DESC = " Units";

    protected static final ItemStack[] RECIPE_CAST_NUGGET = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.IRON_NUGGET),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_INGOT = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.BRICK),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_BLOCK = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.STONE),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_GEM = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   new ItemStack(Material.DIAMOND),   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_SHOVEL_HEAD = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_SHOVEL_HEAD,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_PICKAXE_HEAD = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_PICKAXE_HEAD,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_AXE_HEAD = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_AXE_HEAD,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_HOE_HEAD = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_HOE_HEAD,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_SWORD_BLADE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_SWORD_BLADE,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_TOOL_ROD = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_TOOL_ROD, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_CAST_HELM_PLATE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_HELM_PLATE,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_CHEST_PLATE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_CHEST_PLATE,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_LEG_PLATE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_LEG_PLATE,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_BOOT_PLATE = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_BOOT_PLATE,   null,
            null,                                           null,   null,
            null,                                           null,   null
    };

    protected static final ItemStack[] RECIPE_CAST_MAIL_LINK = new ItemStack[] {
            new SlimefunItemStack(SlimefunItems.BRASS_INGOT, 2),   Dies.DIE_MAIL_LINK, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    protected static final ItemStack[] RECIPE_CAST_REPAIR_KIT = new ItemStack[] {
            new ItemStack(Material.GOLD_INGOT, 2),   Dies.DIE_REPAIR_KIT, null,
            null,                                           null,               null,
            null,                                           null,               null
    };

    public static final SlimefunItemStack CAST_NUGGET =
            ThemeUtils.themedItemStack(
                    "CAST_NUGGET",
                    Material.YELLOW_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Metal Nugget",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_NUGGET + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Nugget"
            );

    public static final SlimefunItemStack CAST_BLOCK =
            ThemeUtils.themedItemStack(
                    "CAST_BLOCK",
                    Material.YELLOW_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Metal Block",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_BLOCK + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Block"
            );

    public static final SlimefunItemStack CAST_INGOT =
            ThemeUtils.themedItemStack(
                    "CAST_INGOT",
                    Material.YELLOW_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Metal Ingot",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_INGOT + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Block"
            );

    public static final SlimefunItemStack CAST_GEM =
            ThemeUtils.themedItemStack(
                    "CAST_GEM",
                    Material.YELLOW_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Gem",
                    ThemeUtils.PASSIVE + "A cast for non-metallic liquids.",
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_GEM + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Gem"
            );

    public static final SlimefunItemStack CAST_SHOVELHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_SHOVELHEAD",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Shovel Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_SHOVELHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Shovel Head"
            );

    public static final SlimefunItemStack CAST_PICKAXEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_PICKAXEHEAD",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Pickaxe Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_PICKAXEHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Pickaxe Head"
            );

    public static final SlimefunItemStack CAST_AXEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_AXE_HEAD",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Axe Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_AXEHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Axe Head"
            );

    public static final SlimefunItemStack CAST_HOEHEAD =
            ThemeUtils.themedItemStack(
                    "CAST_HOEHEAD",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Hoe Head",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_HOEHEAD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Hoe Head"
            );

    public static final SlimefunItemStack CAST_SWORDBLADE =
            ThemeUtils.themedItemStack(
                    "CAST_SWORDBLADE",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Sword Blade",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_SWORDBLADE + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Sword Blade"
            );

    public static final SlimefunItemStack CAST_TOOLROD =
            ThemeUtils.themedItemStack(
                    "CAST_TOOLROD",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Tool Rod",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_TOOLROD + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Tool Rod"
            );

    public static final SlimefunItemStack CAST_HELM_PLATE =
            ThemeUtils.themedItemStack(
                    "CAST_HELM_PLATE",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Helmet Plates",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_ARM_HELM + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Set of Helmet Plates"
            );

    public static final SlimefunItemStack CAST_CHEST_PLATE =
            ThemeUtils.themedItemStack(
                    "CAST_CHEST_PLATE",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Chestplate Plates",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_ARM_CHEST + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Set of Chestplate plates"
            );

    public static final SlimefunItemStack CAST_LEG_PLATE =
            ThemeUtils.themedItemStack(
                    "CAST_LEG_PLATE",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Legging Plates",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_ARM_LEG + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Set of Legging Plates"
            );

    public static final SlimefunItemStack CAST_BOOT_PLATE =
            ThemeUtils.themedItemStack(
                    "CAST_BOOT_PLATE",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Boot Plates",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_ARM_BOOT + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Set of Boot Plates"
            );

    public static final SlimefunItemStack CAST_MAIL_LINK =
            ThemeUtils.themedItemStack(
                    "CAST_MAIL_LINK",
                    Material.ORANGE_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Mail Links",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_ARM_LINKS + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 set of Mail Links"
            );

    public static final SlimefunItemStack CAST_REPAIRKIT =
            ThemeUtils.themedItemStack(
                    "CAST_REPAIRKIT",
                    Material.YELLOW_CARPET,
                    ThemeItemType.CAST,
                    "Cast: Repair Kit",
                    ThemeUtils.PASSIVE + CAST_DESC,
                    "",
                    ThemeUtils.CLICK_INFO + INPUT_DESC + ChatColor.WHITE + CMManager.AMOUNT_KIT + UNIT_DESC,
                    ThemeUtils.CLICK_INFO + OUTPUT_DESC + ChatColor.WHITE + "1 Repair Kit"
            );

    public static void set(SlimeTinker p) {

        new UnplaceableBlock(ItemGroups.CASTS, CAST_NUGGET, DummySmeltery.TYPE, RECIPE_CAST_NUGGET).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_INGOT, DummySmeltery.TYPE, RECIPE_CAST_INGOT).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_BLOCK, DummySmeltery.TYPE, RECIPE_CAST_BLOCK).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_GEM, DummySmeltery.TYPE, RECIPE_CAST_GEM).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_SHOVELHEAD, DummySmeltery.TYPE, RECIPE_CAST_SHOVEL_HEAD).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_PICKAXEHEAD, DummySmeltery.TYPE, RECIPE_CAST_PICKAXE_HEAD).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_AXEHEAD, DummySmeltery.TYPE, RECIPE_CAST_AXE_HEAD).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_HOEHEAD, DummySmeltery.TYPE, RECIPE_CAST_HOE_HEAD).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_SWORDBLADE, DummySmeltery.TYPE, RECIPE_CAST_SWORD_BLADE).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_TOOLROD, DummySmeltery.TYPE, RECIPE_CAST_TOOL_ROD).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_HELM_PLATE, DummySmeltery.TYPE, RECIPE_CAST_HELM_PLATE).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_CHEST_PLATE, DummySmeltery.TYPE, RECIPE_CAST_CHEST_PLATE).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_LEG_PLATE, DummySmeltery.TYPE, RECIPE_CAST_LEG_PLATE).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_BOOT_PLATE, DummySmeltery.TYPE, RECIPE_CAST_BOOT_PLATE).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_MAIL_LINK, DummySmeltery.TYPE, RECIPE_CAST_MAIL_LINK).register(p);
        new UnplaceableBlock(ItemGroups.CASTS, CAST_REPAIRKIT, DummySmeltery.TYPE, RECIPE_CAST_REPAIR_KIT).register(p);

    }
}
