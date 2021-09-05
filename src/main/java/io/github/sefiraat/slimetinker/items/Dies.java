package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.ThemeItemType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public final class Dies {

    public static final String DIE_DESC = "A die to create a cast from";

    protected static final ItemStack[] RECIPE_DIE_SHOVEL_HEAD = new ItemStack[] {
            null,    new ItemStack(Material.COBBLESTONE),    null,
            null,    null,                                   null,
            null,    null,                                   null
    };

    protected static final ItemStack[] RECIPE_DIE_PICKAXE_HEAD = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),
            null,                                   null,                                   null,
            null,                                   null,                                   null
    };

    protected static final ItemStack[] RECIPE_DIE_AXE_HEAD = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    null,
            new ItemStack(Material.COBBLESTONE),    null,                                   null,
            null,                                   null,                                   null
    };

    protected static final ItemStack[] RECIPE_DIE_HOE_HEAD = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    null,
            null,                                   null,                                   null,
            null,                                   null,                                   null
    };

    protected static final ItemStack[] RECIPE_DIE_SWORD_BLADE = new ItemStack[] {
            null,    new ItemStack(Material.COBBLESTONE),    null,
            null,    new ItemStack(Material.COBBLESTONE),    null,
            null,    null,                                   null
    };

    protected static final ItemStack[] RECIPE_DIE_TOOL_ROD = new ItemStack[] {
            null,    null,                          null,
            null,    new ItemStack(Material.STICK), null,
            null,    null,                          null
    };

    protected static final ItemStack[] RECIPE_DIE_HELM_PLATE = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),
            new ItemStack(Material.COBBLESTONE),    null,                                   new ItemStack(Material.COBBLESTONE),
            null,                                   null,                                   null
    };

    protected static final ItemStack[] RECIPE_DIE_CHEST_PLATE = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    null,                                   new ItemStack(Material.COBBLESTONE),
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE)
    };

    protected static final ItemStack[] RECIPE_DIE_LEG_PLATE = new ItemStack[] {
            new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),    new ItemStack(Material.COBBLESTONE),
            new ItemStack(Material.COBBLESTONE),    null,                                   new ItemStack(Material.COBBLESTONE),
            new ItemStack(Material.COBBLESTONE),    null,                                   new ItemStack(Material.COBBLESTONE)
    };

    protected static final ItemStack[] RECIPE_DIE_BOOT_PLATE = new ItemStack[] {
            null,                                   null,    null,
            new ItemStack(Material.COBBLESTONE),    null,    new ItemStack(Material.COBBLESTONE),
            new ItemStack(Material.COBBLESTONE),    null,    new ItemStack(Material.COBBLESTONE)
    };

    protected static final ItemStack[] RECIPE_DIE_MAIL_LINKS = new ItemStack[] {
            null,    null,                          null,
            null,    new ItemStack(Material.CHAIN), null,
            null,    null,                          null
    };

    protected static final ItemStack[] RECIPE_DIE_REPAIR_KIT = new ItemStack[] {
            null,    null,                              null,
            null,    new ItemStack(Material.OBSIDIAN),  null,
            null,    null,                              null
    };

    public static final SlimefunItemStack DIE_SHOVEL_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_SHOVEL_HEAD",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeItemType.CAST,
                    "Die: Stone Shovel Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_PICKAXE_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_PICKAXE_HEAD",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeItemType.CAST,
                    "Die: Stone Pickaxe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_AXE_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_AXE_HEAD",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeItemType.CAST,
                    "Die: Stone Axe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_HOE_HEAD =
            ThemeUtils.themedItemStack(
                    "DIE_HOE_HEAD",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeItemType.CAST,
                    "Die: Stone Hoe Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_SWORD_BLADE =
            ThemeUtils.themedItemStack(
                    "DIE_SWORD_BLADE",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeItemType.CAST,
                    "Die: Stone Sword Head",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_TOOL_ROD =
            ThemeUtils.themedItemStack(
                    "DIE_TOOL_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeItemType.CAST,
                    "Die: Tool Rod",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_HELM_PLATE =
            ThemeUtils.themedItemStack(
                    "DIE_HELM_PLATE",
                    SkullTextures.PART_HELM_PLATES,
                    ThemeItemType.CAST,
                    "Die: Stone Helmet Plates",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_CHEST_PLATE =
            ThemeUtils.themedItemStack(
                    "DIE_CHEST_PLATE",
                    SkullTextures.PART_CHEST_PLATES,
                    ThemeItemType.CAST,
                    "Die: Stone Chest Plates",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_LEG_PLATE =
            ThemeUtils.themedItemStack(
                    "DIE_LEG_PLATE",
                    SkullTextures.PART_LEG_PLATES,
                    ThemeItemType.CAST,
                    "Die: Stone Leg Plates",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_BOOT_PLATE =
            ThemeUtils.themedItemStack(
                    "DIE_BOOT_PLATE",
                    SkullTextures.PART_BOOTS_PLATES,
                    ThemeItemType.CAST,
                    "Die: Stone Boot Plates",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_MAIL_LINK =
            ThemeUtils.themedItemStack(
                    "DIE_MAIL_LINK",
                    SkullTextures.PART_LINKS,
                    ThemeItemType.CAST,
                    "Die: Mail Links",
                    ThemeUtils.PASSIVE + DIE_DESC
            );

    public static final SlimefunItemStack DIE_REPAIR_KIT =
            ThemeUtils.themedItemStack(
                    "DIE_REPAIR_KIT",
                    Material.MINECART,
                    ThemeItemType.CAST,
                    "Die: Repair Kit",
                    ThemeUtils.PASSIVE + DIE_DESC
            );


    public static void set(SlimeTinker p) {
        new UnplaceableBlock(Categories.CASTS, DIE_SHOVEL_HEAD, Workbench.TYPE, RECIPE_DIE_SHOVEL_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_PICKAXE_HEAD, Workbench.TYPE, RECIPE_DIE_PICKAXE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_AXE_HEAD, Workbench.TYPE, RECIPE_DIE_AXE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_HOE_HEAD, Workbench.TYPE, RECIPE_DIE_HOE_HEAD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_SWORD_BLADE, Workbench.TYPE, RECIPE_DIE_SWORD_BLADE).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_TOOL_ROD , Workbench.TYPE, RECIPE_DIE_TOOL_ROD).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_REPAIR_KIT , Workbench.TYPE, RECIPE_DIE_REPAIR_KIT).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_HELM_PLATE, Workbench.TYPE, RECIPE_DIE_HELM_PLATE).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_CHEST_PLATE, Workbench.TYPE, RECIPE_DIE_CHEST_PLATE).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_LEG_PLATE, Workbench.TYPE, RECIPE_DIE_LEG_PLATE).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_BOOT_PLATE , Workbench.TYPE, RECIPE_DIE_BOOT_PLATE).register(p);
        new UnplaceableBlock(Categories.CASTS, DIE_MAIL_LINK , Workbench.TYPE, RECIPE_DIE_MAIL_LINKS).register(p);
    }
}
