package io.github.sefiraat.slimetinker.items.workstations.repairbench;

import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.items.templates.RepairkitTemplate;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
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
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class RepairBench extends AbstractContainer {

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,11,13,15,17,18,19,20,21,22,23,24,25,26};
    private static final int INPUT_TOOL = 10;
    private static final int INPUT_KIT = 12;
    protected static final int CRAFT_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;

    public RepairBench(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack tool = blockMenu.getItemInSlot(INPUT_TOOL);
        ItemStack kit = blockMenu.getItemInSlot(INPUT_KIT);

        // No tool dummy!
        if (tool == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a tool into the first slot.");
            return false;
        }

        // Still no tool, nice try
        if (!ItemUtils.isTool(tool)) {
            player.sendMessage(ThemeUtils.WARNING + "The item in the first slot isn't a Tinker's tool.");
            return false;
        }

        // No kit!
        if (kit == null || !RepairkitTemplate.isRepairKit(kit)) {
            player.sendMessage(ThemeUtils.WARNING + "Input a repair kit into the second slot.");
            return false;
        }

        // All items present, are they correct?
        String toolMaterial = ItemUtils.getToolMaterial(tool);
        String partMaterial = ItemUtils.getPartMaterial(kit);

        if (!toolMaterial.equals(partMaterial)) {
            player.sendMessage(ThemeUtils.WARNING + "The kit type does not match the tool material.");
            return false;
        }

        ItemStack newTool = tool.clone();

        boolean fixAll = false;
        if (ItemUtils.getToolRodMaterial(newTool.getItemMeta().getPersistentDataContainer()).equals(IDStrings.DURALIUM)) { // EASY FIX
            fixAll = true;
        }

        repairItemStack(newTool, fixAll);
        blockMenu.pushItem(newTool, OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_TOOL).setAmount(blockMenu.getItemInSlot(INPUT_TOOL).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_KIT).setAmount(blockMenu.getItemInSlot(INPUT_KIT).getAmount() - 1);

        return false;

    }


    protected void repairItemStack(ItemStack itemStack, boolean fixAll) {
        ItemMeta im = itemStack.getItemMeta();
        if (im instanceof Damageable) {
            Damageable damageable = (Damageable) im;
            int durability;
            if (fixAll) {
                durability = 0;
            } else {
                durability = (Math.max(damageable.getDamage() - Math.floorDiv(itemStack.getType().getMaxDurability(), 3), 0));
            }
            damageable.setDamage(durability);
        }
        itemStack.setItemMeta(im);
    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftRepair());
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
        blockMenu.dropItems(location, INPUT_KIT);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(blockMenu, player));
    }

}
