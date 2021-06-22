package io.github.sefiraat.slimetinker.items.workstations.swappingstation;

import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class SwappingStation extends AbstractContainer {

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,11,13,15,17,18,19,20,21,22,23,24,25,26};
    private static final int INPUT_TOOL = 10;
    private static final int INPUT_PART = 12;
    protected static final int CRAFT_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;

    public SwappingStation(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack tool = blockMenu.getItemInSlot(INPUT_TOOL);
        ItemStack part = blockMenu.getItemInSlot(INPUT_PART);

        // No tool dummy!
        if (tool == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a tool into the first slot.");
            return false;
        }

        // Still no tool, nice try
        if (!ToolTemplate.isTool(tool)) {
            player.sendMessage(ThemeUtils.WARNING + "The item in the first slot isn't a Tinker's tool.");
            return false;
        }

        // No part!
        if (part == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a replacement part into the second slot.");
            return false;
        }

        ItemMeta partMeta = part.getItemMeta();
        assert partMeta != null;
        PersistentDataContainer partC = partMeta.getPersistentDataContainer();

        ItemMeta toolMeta = tool.getItemMeta();
        assert toolMeta != null;
        PersistentDataContainer toolC = toolMeta.getPersistentDataContainer();

        String partClass = partC.get(SlimeTinker.inst().getKeys().getPartInfoClassType(), PersistentDataType.STRING); // HEAD, BINDER or ROD
        String partType = partC.get(SlimeTinker.inst().getKeys().getPartInfoType(), PersistentDataType.STRING); // NULL OR HEAD TYPE
        String partMaterial = partC.get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING); // Material ID of part

        String toolPartType = toolC.get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING); // TOOL HEAD TYPE
        
        // Item in part slot is NOT a part
        if (partClass == null) {
            player.sendMessage(ThemeUtils.WARNING + "The item in the part slot is not a valid part.");
            return false;
        }

        assert partMaterial != null;

        // The part is a head part but the type is either null or not matching to tool (Axe head part for shovel etc.)
        if (partClass.equals(IDStrings.HEAD) && (partType != null && !partType.equals(toolPartType))) {
            player.sendMessage(ThemeUtils.WARNING + "This part cannot be swapped onto this tool.");
            return false;
        }

        ItemStack newTool = tool.clone(); // What will be the tool after crafting

        ItemMeta newToolMeta = newTool.getItemMeta();
        assert newToolMeta != null;
        PersistentDataContainer newToolC = newToolMeta.getPersistentDataContainer();

        String swappedMaterial = null;

        switch (partClass) {
            case IDStrings.HEAD:
                swappedMaterial = ItemUtils.getToolHeadMaterial(newToolC);
                break;
            case IDStrings.BINDING:
                swappedMaterial = ItemUtils.getToolBindingMaterial(newToolC);
                break;
            default:
                swappedMaterial = ItemUtils.getToolRodMaterial(newToolC);
        }

        if (isExplosivePart(partMaterial, partClass)) { // New part will be explosive
            if (!isToolExplosive(newToolC)) { // Current tool is NOT explosive - we have to add it
                assert SlimefunPlugin.instance() != null;
                NamespacedKey sfIDKey = new NamespacedKey(SlimefunPlugin.instance(), "slimefun_item");
                String sID = newToolC.get(sfIDKey, PersistentDataType.STRING);
                newToolC.set(sfIDKey, PersistentDataType.STRING, sID + "_EXP");
            }
        } else { // Incoming part is NOT explosive
            if (isExplosivePart(swappedMaterial, partClass)) { // But the tool is, needs to be removed
                assert SlimefunPlugin.instance() != null;
                NamespacedKey sfIDKey = new NamespacedKey(SlimefunPlugin.instance(), "slimefun_item");
                String sID = newToolC.get(sfIDKey, PersistentDataType.STRING);
                assert sID != null;
                sID = sID.replace("_EXP","");
                newToolC.set(sfIDKey, PersistentDataType.STRING, sID);
            }
        }

        switch (partClass) {
            case IDStrings.HEAD:
                newToolC.set(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING, partMaterial);
                break;
            case IDStrings.BINDING:
                newToolC.set(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING, partMaterial);
                break;
            case IDStrings.ROD:
                newToolC.set(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING, partMaterial);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + partClass);
        }

        newTool.setItemMeta(newToolMeta);

        ItemUtils.rebuildToolLore(newTool);
        ItemUtils.rebuildToolName(newTool);

        blockMenu.pushItem(newTool, OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_TOOL).setAmount(blockMenu.getItemInSlot(INPUT_TOOL).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_PART).setAmount(blockMenu.getItemInSlot(INPUT_PART).getAmount() - 1);

        return false;

    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftSwap());
        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);

    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        return new int[0];
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu, @Nonnull Location location) {
        super.onBreak(event, blockMenu, location);
        blockMenu.dropItems(location, INPUT_TOOL);
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
                (material.equals(IDStrings.SINGINFINITY) && part.equals(IDStrings.HEAD))
        );
    }

    private boolean isToolExplosive(PersistentDataContainer c) {
        assert SlimefunPlugin.instance() != null;
        NamespacedKey sfIDKey = new NamespacedKey(SlimefunPlugin.instance(), "slimefun_item");
        String sID = c.get(sfIDKey, PersistentDataType.STRING);
        assert sID != null;
        return sID.contains("_EXP");
    }

}
