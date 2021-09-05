package io.github.sefiraat.slimetinker.items.workstations.swappingstation;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
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

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,11,13,15,17,18,19,20,21,22,23,24,25,26};
    private static final int INPUT_ITEM = 10;
    private static final int INPUT_PART = 12;
    protected static final int CRAFT_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;

    public SwappingStation(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack item = blockMenu.getItemInSlot(INPUT_ITEM);
        ItemStack part = blockMenu.getItemInSlot(INPUT_PART);

        // No tool dummy!
        if (item == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a tool into the first slot.");
            return false;
        }

        if (part == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a replacement part into the second slot.");
            return false;
        }

        String partClass = ItemUtils.getPartClass(part);
        String partType = ItemUtils.getPartType(part);
        String partMaterial = ItemUtils.getPartMaterial(part);

        if (ItemUtils.isTool(item)) {
            if (partClass != null && ItemUtils.partIsTool(partClass)) {
                return swapTool(blockMenu, player, item, partClass, partType, partMaterial);
            } else {
                player.sendMessage(ThemeUtils.WARNING + "This part cannot be swapped onto this tool.");
            }
        } else if (ItemUtils.isArmour(item)) {
            if (partClass != null && ItemUtils.partIsArmour(partClass)) {
                return swapArmour(blockMenu, player, item, partClass, partType, partMaterial);
            } else {
                player.sendMessage(ThemeUtils.WARNING + "This part cannot be swapped onto this tool.");
            }
        } else {
            player.sendMessage(ThemeUtils.WARNING + "The item in the first slot isn't a Tinker's item.");
        }

        return false;

    }

    private boolean swapTool(BlockMenu blockMenu, Player player, ItemStack item, String partClass, String partType, String partMaterial) {

        // The part is a head part but the type is either null or not matching the tool (Axe head part for shovel etc.)
        if (partClass.equals(IDStrings.HEAD) && (partType != null && !partType.equals(ItemUtils.getToolTypeName(item)))) {
            player.sendMessage(ThemeUtils.WARNING + "This head type cannot be swapped onto this tool.");
            return false;
        }

        ItemStack newTool = item.clone();
        ItemMeta newToolMeta = newTool.getItemMeta();

        String swappedMaterial;

        switch (partClass) {
            case IDStrings.HEAD:
                swappedMaterial = ItemUtils.getToolHeadMaterial(newTool);
                break;
            case IDStrings.BINDING:
                swappedMaterial = ItemUtils.getToolBindingMaterial(newTool);
                break;
            case IDStrings.ROD:
                swappedMaterial = ItemUtils.getToolRodMaterial(newTool);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + partClass);
        }

        checkAndChangeExplosiveness(newTool, newToolMeta, partMaterial, partClass);

        switch (partClass) {
            case IDStrings.HEAD:
                PersistentDataAPI.setString(newToolMeta, SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), partMaterial);
                break;
            case IDStrings.BINDING:
                PersistentDataAPI.setString(newToolMeta, SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), partMaterial);
                break;
            case IDStrings.ROD:
                PersistentDataAPI.setString(newToolMeta, SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), partMaterial);
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

        return false;

    }

    private boolean swapArmour(BlockMenu blockMenu, Player player, ItemStack item, String partClass, String partType, String partMaterial) {

        // The part is a plate part but the type is either null or not matching the armour (Helm plates for boots etc..)
        if (partClass.equals(IDStrings.PLATE) && (partType != null && !partType.equals(ItemUtils.getArmourTypeName(item)))) {
            player.sendMessage(ThemeUtils.WARNING + "This plate type cannot be swapped onto this armour.");
            return false;
        }

        ItemStack newArmour = item.clone();
        ItemMeta newArmourMeta = newArmour.getItemMeta();

        switch (partClass) {
            case IDStrings.PLATE:
                PersistentDataAPI.setString(newArmourMeta, SlimeTinker.inst().getKeys().getArmourInfoPlateMaterial(), partMaterial);
                break;
            case IDStrings.GAMBESON:
                PersistentDataAPI.setString(newArmourMeta, SlimeTinker.inst().getKeys().getArmourInfoGambesonMaterial(), partMaterial);
                break;
            case IDStrings.LINKS:
                PersistentDataAPI.setString(newArmourMeta, SlimeTinker.inst().getKeys().getArmourInfoLinksMaterial(), partMaterial);
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

        return false;

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
            sID = sID.replace("_EXP","");
            PersistentDataAPI.setString(im, sfIDKey, sID);
        }

    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftSwap());
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
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(blockMenu, player));
    }

    private boolean isExplosivePart(String material, String part) {
        return (
                (material.equals(IDStrings.REINFORCED) && part.equals(IDStrings.HEAD)) ||
                (material.equals(IDStrings.HARD) && part.equals(IDStrings.ROD)) ||
                (material.equals(IDStrings.SINGINFINITY) && part.equals(IDStrings.HEAD)) ||
                (material.equals(IDStrings.OSMIUM) && part.equals(IDStrings.HEAD))
        );
    }

}
