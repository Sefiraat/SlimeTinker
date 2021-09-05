package io.github.sefiraat.slimetinker.items.workstations.repairbench;

import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.sefiraat.slimetinker.items.templates.RepairkitTemplate;
import io.github.sefiraat.slimetinker.utils.GUIItems;
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
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

public class RepairBench extends MenuBlock {

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,11,13,15,17,18,19,20,21,22,23,24,25,26};
    private static final int INPUT_TOOL = 10;
    private static final int INPUT_KIT = 12;
    protected static final int CRAFT_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;

    public RepairBench(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack item = blockMenu.getItemInSlot(INPUT_TOOL);
        ItemStack kit = blockMenu.getItemInSlot(INPUT_KIT);

        // No item dummy!
        if (item == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a item into the first slot.");
            return false;
        }

        // Still no item, nice try
        if (!ItemUtils.isTool(item) && !ItemUtils.isArmour(item)) {
            player.sendMessage(ThemeUtils.WARNING + "The item in the first slot isn't a Tinker's item.");
            return false;
        }

        // No kit!
        if (kit == null || !RepairkitTemplate.isRepairKit(kit)) {
            player.sendMessage(ThemeUtils.WARNING + "Input a repair kit into the second slot.");
            return false;
        }

        // All items present, are they correct?
        String toolMaterial = ItemUtils.getToolMaterial(item);
        String armourMaterial = ItemUtils.getArmourMaterial(item);
        String partMaterial = ItemUtils.getPartMaterial(kit);

        if (repairChecks(partMaterial, toolMaterial, armourMaterial, item)) {
            ItemStack newItem = item.clone();

            boolean fixAll = false;
            if (ItemUtils.repairBenchEasyFix(newItem)) { // EASY FIX
                fixAll = true;
            }

            repairItemStack(newItem, fixAll);
            blockMenu.pushItem(newItem, OUTPUT_SLOT);
            blockMenu.getItemInSlot(INPUT_TOOL).setAmount(blockMenu.getItemInSlot(INPUT_TOOL).getAmount() - 1);
            blockMenu.getItemInSlot(INPUT_KIT).setAmount(blockMenu.getItemInSlot(INPUT_KIT).getAmount() - 1);

        } else {
            player.sendMessage(ThemeUtils.WARNING + "The kit type does not match the item material.");
        }

        return false;

    }

    private boolean repairChecks(String partMaterial, String toolMaterial, String armourMaterial, ItemStack itemStack) {
        return checkKit(partMaterial) && (checkTool(partMaterial, toolMaterial) || checkArmour(partMaterial, armourMaterial, itemStack));
    }

    private boolean checkKit(String partMaterial) {
        return partMaterial != null;
    }

    private boolean checkTool(String partMaterial, String toolMaterial) {
        return toolMaterial != null && toolMaterial.equals(partMaterial);
    }

    private boolean checkArmour(String partMaterial, String armourMaterial, ItemStack itemStack) {
        return armourMaterial != null && (armourMaterial.equals(partMaterial) || ItemUtils.repairBenchEasyFix2(itemStack));
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
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftRepair());
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
