package io.github.sefiraat.slimetinker.items.workstations.armourtable;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Guide;
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
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ToolTable extends AbstractContainer {

    private static final int[] BACKGROUND_SLOTS = {0,8,9,17,18,26,27,31,35,36,44,45,49,53};
    private static final int[] BACKGROUND_INPUTS = {1,3,5,7,10,12,14,16,19,20,21,22,23,24,25};
    private static final int[] BACKGROUND_PREVIEW = {28,29,30,37,39,46,47,48};
    private static final int[] BACKGROUND_OUTPUT = {32,33,34,41,43,50,51,52};
    private static final int MARKER_MAIL_LINK = 2;
    private static final int MARKER_GAMBESON = 4;
    private static final int MARKER_PLATES = 6;
    private static final int INPUT_MAIL_LINK = 11;
    private static final int INPUT_GAMBESON = 13;
    private static final int INPUT_PLATES = 15;
    protected static final int PREVIEW_SLOT = 38;
    protected static final int CRAFT_BUTTON = 40;
    protected static final int OUTPUT_SLOT = 42;

    private BlockMenu menu;

    public ToolTable(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
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
            ItemStack plates = menu.getItemInSlot(INPUT_PLATES);
            ItemStack gambeson = menu.getItemInSlot(INPUT_GAMBESON);
            ItemStack links = menu.getItemInSlot(INPUT_MAIL_LINK);
            if (plates == null || gambeson == null || links == null) { // Missing one or more items
                clearPreview();
                return;
            }
            if (!validateClass(plates, IDStrings.HEAD) || !validateBinder(gambeson) || !validateClass(links, IDStrings.ROD)) { // One or more items are not the correct part
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
        menu.replaceExistingItem(PREVIEW_SLOT, GUIItems.menuPreview());
    }

    protected ItemStack getTool() {

        ItemStack plates = menu.getItemInSlot(INPUT_PLATES);
        ItemStack gambeson = menu.getItemInSlot(INPUT_GAMBESON);
        ItemStack links = menu.getItemInSlot(INPUT_MAIL_LINK);

        ItemStack itemStack;

        ToolDefinition toolDefinition = new ToolDefinition(
                plates.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoClassType(), PersistentDataType.STRING),
                plates.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoType(), PersistentDataType.STRING),
                plates.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING),
                gambeson.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING),
                links.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING)
        );

        if (
                toolDefinition.getHeadMaterial().equals(IDStrings.REINFORCED) ||
                toolDefinition.getRodMaterial().equals(IDStrings.HARD) ||
                toolDefinition.getHeadMaterial().equals(IDStrings.SINGINFINITY) ||
                toolDefinition.getHeadMaterial().equals(IDStrings.OSMIUM)
        ) { // Reinforced Head/Hard Rod tools are explosive
            switch (toolDefinition.getPartType()) {
                case IDStrings.SHOVEL:
                    itemStack = Guide.EXP_SHOVEL.getStack(toolDefinition);
                    break;
                case IDStrings.PICKAXE:
                    itemStack = Guide.EXP_PICKAXE.getStack(toolDefinition);
                    break;
                case IDStrings.AXE:
                    itemStack = Guide.EXP_AXE.getStack(toolDefinition);
                    break;
                case IDStrings.HOE:
                    itemStack = Guide.EXP_HOE.getStack(toolDefinition);
                    break;
                case IDStrings.SWORD:
                    itemStack = Guide.EXP_SWORD.getStack(toolDefinition);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
            }
        } else {
            switch (toolDefinition.getPartType()) {
                case IDStrings.SHOVEL:
                    itemStack = Guide.SHOVEL.getStack(toolDefinition);
                    break;
                case IDStrings.PICKAXE:
                    itemStack = Guide.PICKAXE.getStack(toolDefinition);
                    break;
                case IDStrings.AXE:
                    itemStack = Guide.AXE.getStack(toolDefinition);
                    break;
                case IDStrings.HOE:
                    itemStack = Guide.HOE.getStack(toolDefinition);
                    break;
                case IDStrings.SWORD:
                    itemStack = Guide.SWORD.getStack(toolDefinition);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
            }

        }

        return itemStack;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
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

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean validateBinder(ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) { // No item
            return false;
        }
        return StackUtils.getIDorType(itemStack).startsWith("PART_BINDING_");
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack head = blockMenu.getItemInSlot(INPUT_PLATES);
        ItemStack binding = blockMenu.getItemInSlot(INPUT_GAMBESON);
        ItemStack rod = blockMenu.getItemInSlot(INPUT_MAIL_LINK);

        if (head == null || binding == null || rod == null) { // Missing one or more items
            player.sendMessage(ThemeUtils.ERROR + "Not all items present");
            return false;
        }
        if (!validateClass(head, IDStrings.HEAD) || !validateBinder(binding) || !validateClass(rod, IDStrings.ROD)) { // One or more items are not the correct part
            player.sendMessage(ThemeUtils.WARNING + "One or more items are either not Tinker's parts or in the wrong slot?");
            return false;
        }

        blockMenu.pushItem(getTool().clone(), OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_PLATES).setAmount(blockMenu.getItemInSlot(INPUT_PLATES).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_GAMBESON).setAmount(blockMenu.getItemInSlot(INPUT_GAMBESON).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_MAIL_LINK).setAmount(blockMenu.getItemInSlot(INPUT_MAIL_LINK).getAmount() - 1);

        return false;

    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundInput(), BACKGROUND_INPUTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundOutput(), BACKGROUND_OUTPUT);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundPreview(), BACKGROUND_PREVIEW);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftTable());
        blockMenuPreset.addItem(MARKER_MAIL_LINK, GUIItems.menuMarkerRod());
        blockMenuPreset.addItem(MARKER_GAMBESON, GUIItems.menuMarkerBinder());
        blockMenuPreset.addItem(MARKER_PLATES, GUIItems.menuMarkerHead());
        blockMenuPreset.addItem(PREVIEW_SLOT, GUIItems.menuPreview());

        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_MAIL_LINK, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_GAMBESON, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_PLATES, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(PREVIEW_SLOT, (player, i, itemStack, clickAction) -> false);

    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        return new int[0];
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu, @Nonnull Location location) {
        super.onBreak(event, blockMenu, location);
        blockMenu.dropItems(location, INPUT_PLATES);
        blockMenu.dropItems(location, INPUT_GAMBESON);
        blockMenu.dropItems(location, INPUT_MAIL_LINK);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        this.menu = blockMenu;
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(blockMenu, player));
    }

}
