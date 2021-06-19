package io.github.sefiraat.slimetinker.items.workstations.table;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.Tools;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.items.templates.ToolDefinition;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class Table extends AbstractContainer {

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKey("tinkers-table"), Workstations.TINKERS_TABLE, RECIPES::put);

    private static final int[] BACKGROUND_SLOTS = {0,8,9,17,18,26,27,31,35,36,44,45,49,53};
    private static final int[] BACKGROUND_INPUTS = {1,3,5,7,10,12,14,16,19,20,21,22,23,24,25};
    private static final int[] BACKGROUND_PREVIEW = {28,29,30,37,39,46,47,48};
    private static final int[] BACKGROUND_OUTPUT = {32,33,34,41,43,50,51,52};
    private static final int MARKER_ROD = 2;
    private static final int MARKER_BINDER = 4;
    private static final int MARKER_HEAD = 6;
    private static final int INPUT_ROD = 11;
    private static final int INPUT_BINDING = 13;
    private static final int INPUT_HEAD = 15;
    protected static final int PREVIEW_SLOT = 38;
    protected static final int CRAFT_BUTTON = 40;
    protected static final int OUTPUT_SLOT = 42;

    private BlockMenu menu;

    public Table(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return true;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config data) {
                previewCraft();
            }
        });
    }

    protected void previewCraft() {
        if (menu.hasViewer()) {
            ItemStack head = menu.getItemInSlot(INPUT_HEAD);
            ItemStack binding = menu.getItemInSlot(INPUT_BINDING);
            ItemStack rod = menu.getItemInSlot(INPUT_ROD);
            if (head == null || binding == null || rod == null) { // Missing one or more items
                clearPreview();
                return;
            }
            if (!validateClass(head, IDStrings.HEAD) || !validateBinder(binding) || !validateClass(rod, IDStrings.ROD)) { // One or more items are not the correct part
                clearPreview();
                return;
            }

            // All items are valid, lets preview the item!
            menu.replaceExistingItem(PREVIEW_SLOT, getTool());
            return;

        }
        clearPreview();
    }

    protected void clearPreview() {
        menu.replaceExistingItem(PREVIEW_SLOT, new ItemStack(Material.AIR));
    }

    protected ItemStack getTool() {

        ItemStack head = menu.getItemInSlot(INPUT_HEAD);
        ItemStack binding = menu.getItemInSlot(INPUT_BINDING);
        ItemStack rod = menu.getItemInSlot(INPUT_ROD);

        ItemStack itemStack;

        ToolDefinition toolDefinition = new ToolDefinition(
                head.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoClassType(), PersistentDataType.STRING),
                head.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoType(), PersistentDataType.STRING),
                head.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING),
                Parts.getBinderMap().get(StackUtils.getIDorType(binding)),
                rod.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING)
        );

        if (toolDefinition.getHeadMaterial().equals(IDStrings.REINFORCED) || toolDefinition.getRodMaterial().equals(IDStrings.HARD)) { // Reinforced Head/ Hard Rod tools are explosive
            switch (toolDefinition.getPartType()) {
                case IDStrings.SHOVEL:
                    itemStack = Tools.EXP_SHOVEL.getStack(toolDefinition);
                    break;
                case IDStrings.PICKAXE:
                    itemStack = Tools.EXP_PICKAXE.getStack(toolDefinition);
                    break;
                case IDStrings.AXE:
                    itemStack = Tools.EXP_AXE.getStack(toolDefinition);
                    break;
                case IDStrings.HOE:
                    itemStack = Tools.EXP_HOE.getStack(toolDefinition);
                    break;
                case IDStrings.SWORD:
                    itemStack = Tools.EXP_SWORD.getStack(toolDefinition);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
            }
        } else {
            switch (toolDefinition.getPartType()) {
                case IDStrings.SHOVEL:
                    itemStack = Tools.SHOVEL.getStack(toolDefinition);
                    break;
                case IDStrings.PICKAXE:
                    itemStack = Tools.PICKAXE.getStack(toolDefinition);
                    break;
                case IDStrings.AXE:
                    itemStack = Tools.AXE.getStack(toolDefinition);
                    break;
                case IDStrings.HOE:
                    itemStack = Tools.HOE.getStack(toolDefinition);
                    break;
                case IDStrings.SWORD:
                    itemStack = Tools.SWORD.getStack(toolDefinition);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
            }

        }

        return itemStack;
    }


    protected boolean validateClass(ItemStack itemStack, String classType) {
        if (itemStack == null || !itemStack.hasItemMeta()) { // No item
            return false;
        }
        if (!itemStack.getItemMeta().getPersistentDataContainer().has(SlimeTinker.inst().getKeys().getPartInfoClassType(), PersistentDataType.STRING)) { // Not a part
            return false;
        }
        String type = itemStack.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoClassType(), PersistentDataType.STRING);
        assert type != null;
        return type.equals(classType);
    }

    protected boolean validateBinder(ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) { // No item
            return false;
        }
        return Parts.getBinderMap().containsKey(StackUtils.getIDorType(itemStack));
    }

    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack head = blockMenu.getItemInSlot(INPUT_HEAD);
        ItemStack binding = blockMenu.getItemInSlot(INPUT_BINDING);
        ItemStack rod = blockMenu.getItemInSlot(INPUT_ROD);

        if (head == null || binding == null || rod == null) { // Missing one or more items
            player.sendMessage(ThemeUtils.ERROR + "Not all items present");
            return false;
        }
        if (!validateClass(head, IDStrings.HEAD) || !validateBinder(binding) || !validateClass(rod, IDStrings.ROD)) { // One or more items are not the correct part
            player.sendMessage(ThemeUtils.WARNING + "One or more items are either not Tinker's parts or in the wrong slot?");
            return false;
        }

        // All items are valid, lets preview the item!
        blockMenu.pushItem(getTool().clone(), OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_HEAD).setAmount(blockMenu.getItemInSlot(INPUT_HEAD).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_BINDING).setAmount(blockMenu.getItemInSlot(INPUT_BINDING).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_ROD).setAmount(blockMenu.getItemInSlot(INPUT_ROD).getAmount() - 1);

        return false;

    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundInput(), BACKGROUND_INPUTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundOutput(), BACKGROUND_OUTPUT);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundPreview(), BACKGROUND_PREVIEW);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftTable());
        blockMenuPreset.addItem(MARKER_ROD, GUIItems.menuMarkerRod());
        blockMenuPreset.addItem(MARKER_BINDER, GUIItems.menuMarkerBinder());
        blockMenuPreset.addItem(MARKER_HEAD, GUIItems.menuMarkerHead());

        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_ROD, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_BINDER, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_HEAD, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(PREVIEW_SLOT, (player, i, itemStack, clickAction) -> false);

    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        return new int[0];
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu, @Nonnull Location location) {
        super.onBreak(event, blockMenu, location);
        blockMenu.dropItems(location, INPUT_HEAD);
        blockMenu.dropItems(location, INPUT_BINDING);
        blockMenu.dropItems(location, INPUT_ROD);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        this.menu = blockMenu;
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(blockMenu, player));
    }

}
