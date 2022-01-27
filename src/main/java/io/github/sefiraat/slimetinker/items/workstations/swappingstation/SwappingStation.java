package io.github.sefiraat.slimetinker.items.workstations.swappingstation;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.Keys;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

public class SwappingStation extends MenuBlock {

    protected static final int CRAFT_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;
    private static final int[] BACKGROUND_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    private static final int INPUT_ITEM = 10;
    private static final int INPUT_PART = 12;

    public SwappingStation(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    protected void craft(BlockMenu blockMenu, Player player) {
        ItemStack item = blockMenu.getItemInSlot(INPUT_ITEM);
        ItemStack part = blockMenu.getItemInSlot(INPUT_PART);

        // No tool dummy!
        if (item == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a tool into the first slot.");
            return;
        }

        if (item.getAmount() > 1) {
            player.sendMessage(ThemeUtils.WARNING + "Nope - nerd");
            return;
        }

        if (part == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a replacement part into the second slot.");
            return;
        }

        String partClass = ItemUtils.getPartClass(part);
        String partType = ItemUtils.getPartType(part);
        String partMaterial = ItemUtils.getPartMaterial(part);

        if (ItemUtils.isTool(item)) {
            if (partClass != null && ItemUtils.partIsTool(partClass)) {
                swapTool(blockMenu, player, item, partClass, partType, partMaterial);
            } else {
                player.sendMessage(ThemeUtils.WARNING + "This part cannot be swapped onto this tool.");
            }
        } else if (ItemUtils.isArmour(item)) {
            if (partClass != null && ItemUtils.partIsArmour(partClass)) {
                swapArmour(blockMenu, player, item, partClass, partType, partMaterial);
            } else {
                player.sendMessage(ThemeUtils.WARNING + "This part cannot be swapped onto this tool.");
            }
        } else {
            player.sendMessage(ThemeUtils.WARNING + "The item in the first slot isn't a Tinker's item.");
        }
    }

    private void swapTool(BlockMenu blockMenu, Player player, ItemStack item, String partClass, String partType, String partMaterial) {
        // The part is a head part but the type is either null or not matching the tool (Axe head part for shovel etc.)
        if (partClass.equals(Ids.HEAD) && (partType != null && !partType.equals(ItemUtils.getToolTypeName(item)))) {
            player.sendMessage(ThemeUtils.WARNING + "This head type cannot be swapped onto this tool.");
            return;
        }

        ItemStack newTool = item.clone();
        ItemMeta newToolMeta = newTool.getItemMeta();

        checkAndChangeExplosiveness(newTool, newToolMeta, partMaterial, partClass);

        switch (partClass) {
            case Ids.HEAD:
                PersistentDataAPI.setString(newToolMeta, Keys.TOOL_INFO_HEAD_MATERIAL, partMaterial);
                break;
            case Ids.BINDING:
                PersistentDataAPI.setString(newToolMeta, Keys.TOOL_INFO_BINDER_MATERIAL, partMaterial);
                break;
            case Ids.ROD:
                PersistentDataAPI.setString(newToolMeta, Keys.TOOL_INFO_ROD_MATERIAL, partMaterial);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + partClass);
        }

        newTool.setItemMeta(newToolMeta);

        ItemUtils.rebuildTinkerLore(newTool);
        ItemUtils.rebuildTinkerName(newTool);

        blockMenu.pushItem(newTool, OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_ITEM).setAmount(blockMenu.getItemInSlot(INPUT_ITEM).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_PART).setAmount(blockMenu.getItemInSlot(INPUT_PART).getAmount() - 1);
    }

    private void swapArmour(BlockMenu blockMenu, Player player, ItemStack item, String partClass, String partType, String partMaterial) {
        // The part is a plate part but the type is either null or not matching the armour (Helm plates for boots etc..)
        if (partClass.equals(Ids.PLATE) && (partType != null && !partType.equals(ItemUtils.getArmourTypeName(item)))) {
            player.sendMessage(ThemeUtils.WARNING + "This plate type cannot be swapped onto this armour.");
            return;
        }

        ItemStack newArmour = item.clone();
        ItemMeta newArmourMeta = newArmour.getItemMeta();

        switch (partClass) {
            case Ids.PLATE:
                PersistentDataAPI.setString(newArmourMeta, Keys.ARMOUR_INFO_PLATE_MATERIAL, partMaterial);
                break;
            case Ids.GAMBESON:
                PersistentDataAPI.setString(newArmourMeta, Keys.ARMOUR_INFO_GAMBESON_MATERIAL, partMaterial);
                break;
            case Ids.LINKS:
                PersistentDataAPI.setString(newArmourMeta, Keys.ARMOUR_INFO_LINKS_MATERIAL, partMaterial);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + partClass);
        }

        newArmour.setItemMeta(newArmourMeta);

        ItemUtils.rebuildTinkerLore(newArmour);
        ItemUtils.rebuildTinkerName(newArmour);

        blockMenu.pushItem(newArmour, OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_ITEM).setAmount(blockMenu.getItemInSlot(INPUT_ITEM).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_PART).setAmount(blockMenu.getItemInSlot(INPUT_PART).getAmount() - 1);

        return;

    }

    private void checkAndChangeExplosiveness(ItemStack newTool, ItemMeta im, String partMaterial, String partClass) {

        Validate.notNull(Slimefun.instance(), "Slimefun is null, that's... not great?");

        NamespacedKey sfIDKey = new NamespacedKey(Slimefun.instance(), "slimefun_item");
        String sID = PersistentDataAPI.getString(im, sfIDKey);

        if (isExplosivePart(partMaterial, partClass) && !ItemUtils.isToolExplosive(newTool)) {
            // Part IS explosive but the tool is NOT - we need to make it explosive!
            sID = sID + "_EXP";
            PersistentDataAPI.setString(im, sfIDKey, sID);
        } else if (!isExplosivePart(partMaterial, partClass) && ItemUtils.isToolExplosive(newTool)) {
            // Part is NOT explosive but the tool IS - we need to make it explosive!
            sID = sID.replace("_EXP", "");
            PersistentDataAPI.setString(im, sfIDKey, sID);
        }

    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.MENU_CRAFT_SWAP);
        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);

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
        blockMenu.dropItems(location, INPUT_ITEM);
        blockMenu.dropItems(location, INPUT_PART);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> {
            craft(blockMenu, player);
            return false;
        });
    }

    private boolean isExplosivePart(String material, String part) {
        return (
            (material.equals(Ids.REINFORCED_ALLOY) && part.equals(Ids.HEAD)) ||
                (material.equals(Ids.HARDENED_METAL) && part.equals(Ids.ROD)) ||
                (material.equals(Ids.INFINITY_SINGULARITY) && part.equals(Ids.HEAD)) ||
                (material.equals(Ids.OSMIUM) && part.equals(Ids.HEAD))
        );
    }

}
