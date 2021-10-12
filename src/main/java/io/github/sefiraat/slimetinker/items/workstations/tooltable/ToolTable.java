package io.github.sefiraat.slimetinker.items.workstations.tooltable;

import io.github.mooy1.infinitylib.machines.TickingMenuBlock;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.items.templates.ToolDefinition;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ToolTable extends TickingMenuBlock {

    protected static final int PREVIEW_SLOT = 38;
    protected static final int CRAFT_BUTTON = 40;
    protected static final int OUTPUT_SLOT = 42;
    private static final int[] BACKGROUND_SLOTS = {0, 8, 9, 17, 18, 26, 27, 31, 35, 36, 44, 45, 49, 53};
    private static final int[] BACKGROUND_INPUTS = {1, 3, 5, 7, 10, 12, 14, 16, 19, 20, 21, 22, 23, 24, 25};
    private static final int[] BACKGROUND_PREVIEW = {28, 29, 30, 37, 39, 46, 47, 48};
    private static final int[] BACKGROUND_OUTPUT = {32, 33, 34, 41, 43, 50, 51, 52};
    private static final int MARKER_ROD = 2;
    private static final int MARKER_BINDER = 4;
    private static final int MARKER_HEAD = 6;
    private static final int INPUT_ROD = 11;
    private static final int INPUT_BINDING = 13;
    private static final int INPUT_HEAD = 15;

    public ToolTable(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void tick(@NotNull Block block, @NotNull BlockMenu blockMenu) {
        previewCraft(blockMenu);
    }

    protected void previewCraft(@Nonnull BlockMenu blockMenu) {
        if (blockMenu.hasViewer()) {
            ItemStack head = blockMenu.getItemInSlot(INPUT_HEAD);
            ItemStack binding = blockMenu.getItemInSlot(INPUT_BINDING);
            ItemStack rod = blockMenu.getItemInSlot(INPUT_ROD);
            if (head == null || binding == null || rod == null) { // Missing one or more items
                clearPreview(blockMenu);
                return;
            }
            if (!validateClass(head, IDStrings.HEAD) || !validateBinder(binding) || !validateClass(rod, IDStrings.ROD)) { // One or more items are not the correct part
                clearPreview(blockMenu);
                return;
            }

            // All items are valid, lets preview the item!
            blockMenu.replaceExistingItem(PREVIEW_SLOT, getTool(head, binding, rod));
        }
    }

    protected void clearPreview(BlockMenu blockMenu) {
        blockMenu.replaceExistingItem(PREVIEW_SLOT, GUIItems.menuPreview());
    }

    protected ItemStack getTool(@Nonnull ItemStack head, @Nonnull ItemStack binding, @Nonnull ItemStack rod) {

        ItemMeta hm = head.getItemMeta();
        ItemMeta bm = binding.getItemMeta();
        ItemMeta rm = rod.getItemMeta();

        ItemStack tool;

        ToolDefinition toolDefinition = new ToolDefinition(
            hm.getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartClass(), PersistentDataType.STRING),
            hm.getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartType(), PersistentDataType.STRING),
            hm.getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartMaterial(), PersistentDataType.STRING),
            bm.getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartMaterial(), PersistentDataType.STRING),
            rm.getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartMaterial(), PersistentDataType.STRING)
        );

        if (
            toolDefinition.getHeadMaterial().equals(IDStrings.REINFORCED) ||
                toolDefinition.getRodMaterial().equals(IDStrings.HARD) ||
                toolDefinition.getHeadMaterial().equals(IDStrings.SINGINFINITY) ||
                toolDefinition.getHeadMaterial().equals(IDStrings.OSMIUM)
        ) { // Reinforced Head/Hard Rod tools are explosive
            switch (toolDefinition.getPartType()) {
                case IDStrings.SHOVEL:
                    tool = Guide.EXP_SHOVEL.getStack(toolDefinition);
                    break;
                case IDStrings.PICKAXE:
                    tool = Guide.EXP_PICKAXE.getStack(toolDefinition);
                    break;
                case IDStrings.AXE:
                    tool = Guide.EXP_AXE.getStack(toolDefinition);
                    break;
                case IDStrings.HOE:
                    tool = Guide.EXP_HOE.getStack(toolDefinition);
                    break;
                case IDStrings.SWORD:
                    tool = Guide.EXP_SWORD.getStack(toolDefinition);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
            }
        } else {
            switch (toolDefinition.getPartType()) {
                case IDStrings.SHOVEL:
                    tool = Guide.SHOVEL.getStack(toolDefinition);
                    break;
                case IDStrings.PICKAXE:
                    tool = Guide.PICKAXE.getStack(toolDefinition);
                    break;
                case IDStrings.AXE:
                    tool = Guide.AXE.getStack(toolDefinition);
                    break;
                case IDStrings.HOE:
                    tool = Guide.HOE.getStack(toolDefinition);
                    break;
                case IDStrings.SWORD:
                    tool = Guide.SWORD.getStack(toolDefinition);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
            }

        }

        return tool;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean validateClass(ItemStack itemStack, String classType) {
        if (itemStack == null || !itemStack.hasItemMeta()) { // No item
            return false;
        }
        if (!itemStack.getItemMeta().getPersistentDataContainer().has(SlimeTinker.inst().getKeys().getPartClass(), PersistentDataType.STRING)) { // Not a part
            return false;
        }
        String type = itemStack.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getPartClass(), PersistentDataType.STRING);
        assert type != null;
        return type.equals(classType);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean validateBinder(ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) { // No item
            return false;
        }
        return ItemUtils.getItemName(itemStack).startsWith("PART_BINDING_");
    }

    @SuppressWarnings("SameReturnValue")
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

        blockMenu.pushItem(getTool(head, binding, rod).clone(), OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_HEAD).setAmount(blockMenu.getItemInSlot(INPUT_HEAD).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_BINDING).setAmount(blockMenu.getItemInSlot(INPUT_BINDING).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_ROD).setAmount(blockMenu.getItemInSlot(INPUT_ROD).getAmount() - 1);

        return false;

    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundInput(), BACKGROUND_INPUTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundOutput(), BACKGROUND_OUTPUT);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundPreview(), BACKGROUND_PREVIEW);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftTable());
        blockMenuPreset.addItem(MARKER_ROD, GUIItems.menuMarkerRod());
        blockMenuPreset.addItem(MARKER_BINDER, GUIItems.menuMarkerBinder());
        blockMenuPreset.addItem(MARKER_HEAD, GUIItems.menuMarkerHead());
        blockMenuPreset.addItem(PREVIEW_SLOT, GUIItems.menuPreview());

        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_ROD, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_BINDER, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_HEAD, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(PREVIEW_SLOT, (player, i, itemStack, clickAction) -> false);

    }

    @Override
    protected int[] getInputSlots() {
        return new int[0];
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[0];
    }

    @Override
    protected void onBreak(@NotNull BlockBreakEvent e, @NotNull BlockMenu menu) {
        super.onBreak(e, menu);
        Location location = menu.getLocation();
        menu.dropItems(location, INPUT_HEAD);
        menu.dropItems(location, INPUT_BINDING);
        menu.dropItems(location, INPUT_ROD);
        menu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(blockMenu, player));
    }

}
