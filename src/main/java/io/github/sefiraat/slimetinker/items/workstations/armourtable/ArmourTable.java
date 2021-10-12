package io.github.sefiraat.slimetinker.items.workstations.armourtable;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.items.templates.ArmourDefinition;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.Keys;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

public class ArmourTable extends MenuBlock {

    protected static final int PREVIEW_SLOT = 38;
    protected static final int CRAFT_BUTTON = 40;
    protected static final int OUTPUT_SLOT = 42;
    private static final int[] BACKGROUND_SLOTS = {0, 8, 9, 17, 18, 26, 27, 31, 35, 36, 44, 45, 49, 53};
    private static final int[] BACKGROUND_INPUTS = {1, 3, 5, 7, 10, 12, 14, 16, 19, 20, 21, 22, 23, 24, 25};
    private static final int[] BACKGROUND_PREVIEW = {28, 29, 30, 37, 39, 46, 47, 48};
    private static final int[] BACKGROUND_OUTPUT = {32, 33, 34, 41, 43, 50, 51, 52};
    private static final int MARKER_PLATES = 2;
    private static final int MARKER_GAMBESON = 4;
    private static final int MARKER_MAIL_LINK = 6;
    private static final int INPUT_PLATES = 11;
    private static final int INPUT_GAMBESON = 13;
    private static final int INPUT_MAIL_LINK = 15;
    private BlockMenu menu;

    public ArmourTable(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

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

            if (!validate(plates, gambeson, links)) { // One or more items are not the correct part
                clearPreview();
                return;
            }

            // All items are valid, lets preview the item!
            menu.replaceExistingItem(PREVIEW_SLOT, getTool(plates, gambeson, links));
            return;

        }
        clearPreview();
    }

    protected void clearPreview() {
        menu.replaceExistingItem(PREVIEW_SLOT, GUIItems.menuPreview());
    }

    protected ItemStack getTool(ItemStack p, ItemStack g, ItemStack l) {

        ItemMeta pm = p.getItemMeta();
        ItemMeta gm = g.getItemMeta();
        ItemMeta lm = l.getItemMeta();

        Keys keys = SlimeTinker.inst().getKeys();

        ItemStack armour;

        ArmourDefinition armourDefinition = new ArmourDefinition(
            PersistentDataAPI.getString(pm, keys.getPartClass()),
            PersistentDataAPI.getString(pm, keys.getPartType()),
            PersistentDataAPI.getString(pm, keys.getPartMaterial()),
            PersistentDataAPI.getString(gm, keys.getPartMaterial()),
            PersistentDataAPI.getString(lm, keys.getPartMaterial())
        );

        switch (armourDefinition.getPartType()) {
            case IDStrings.HELMET:
                armour = Guide.HELM.getStack(armourDefinition);
                break;
            case IDStrings.CHESTPLATE:
                armour = Guide.CHEST.getStack(armourDefinition);
                break;
            case IDStrings.LEGGINGS:
                armour = Guide.LEG.getStack(armourDefinition);
                break;
            case IDStrings.BOOTS:
                armour = Guide.BOOT.getStack(armourDefinition);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + armourDefinition.getClassType());
        }

        return armour;
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
    protected boolean validateGambeson(ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) { // No item
            return false;
        }
        return ItemUtils.getIdOrType(itemStack).startsWith("PART_GAMBESON_");
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack plates = blockMenu.getItemInSlot(INPUT_PLATES);
        ItemStack gambeson = blockMenu.getItemInSlot(INPUT_GAMBESON);
        ItemStack links = blockMenu.getItemInSlot(INPUT_MAIL_LINK);

        if (plates == null || gambeson == null || links == null) { // Missing one or more items
            player.sendMessage(ThemeUtils.ERROR + "Not all items present");
            return false;
        }
        if (!validate(plates, gambeson, links)) { // One or more items are not the correct part
            player.sendMessage(ThemeUtils.WARNING + "One or more items are either not Tinker's parts or in the wrong slot?");
            return false;
        }

        blockMenu.pushItem(getTool(plates, gambeson, links).clone(), OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_PLATES).setAmount(blockMenu.getItemInSlot(INPUT_PLATES).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_GAMBESON).setAmount(blockMenu.getItemInSlot(INPUT_GAMBESON).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_MAIL_LINK).setAmount(blockMenu.getItemInSlot(INPUT_MAIL_LINK).getAmount() - 1);

        return false;

    }

    private boolean validate(ItemStack plates, ItemStack gambeson, ItemStack links) {
        return validateClass(plates, IDStrings.PLATE) && validateGambeson(gambeson) && validateClass(links, IDStrings.LINKS);
    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundInput(), BACKGROUND_INPUTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundOutput(), BACKGROUND_OUTPUT);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundPreview(), BACKGROUND_PREVIEW);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftTable());
        blockMenuPreset.addItem(MARKER_MAIL_LINK, GUIItems.menuMarkerLinks());
        blockMenuPreset.addItem(MARKER_GAMBESON, GUIItems.menuMarkerGambeson());
        blockMenuPreset.addItem(MARKER_PLATES, GUIItems.menuMarkerPlates());
        blockMenuPreset.addItem(PREVIEW_SLOT, GUIItems.menuPreview());

        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_MAIL_LINK, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_GAMBESON, (player, i, itemStack, clickAction) -> false);
        blockMenuPreset.addMenuClickHandler(MARKER_PLATES, (player, i, itemStack, clickAction) -> false);
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
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu) {
        super.onBreak(event, blockMenu);
        Location location = blockMenu.getLocation();
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
