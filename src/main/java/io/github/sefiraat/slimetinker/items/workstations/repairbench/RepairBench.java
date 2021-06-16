package io.github.sefiraat.slimetinker.items.workstations.repairbench;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.items.gui.GUIItems;
import io.github.sefiraat.slimetinker.items.templates.RepairkitTemplate;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
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
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class RepairBench extends AbstractContainer {

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKey("tinkers-repair"), Workstations.TINKERS_TABLE, RECIPES::put);

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,11,13,15,17,18,19,20,21,22,23,24,25,26};
    private static final int INPUT_TOOL = 10;
    private static final int INPUT_KIT = 12;
    protected static final int CRAFT_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;

    private BlockMenu menu;

    public RepairBench(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
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
        return Parts.binderMap.containsKey(StackUtils.getIDorType(itemStack));
    }

    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack tool = blockMenu.getItemInSlot(INPUT_TOOL);
        ItemStack kit = blockMenu.getItemInSlot(INPUT_KIT);

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

        // No kit!
        if (kit == null || !RepairkitTemplate.isRepairKit(kit)) {
            player.sendMessage(ThemeUtils.WARNING + "Input a repair kit into the second slot.");
            return false;
        }

        //All items present, are they correct?
        String toolMaterial = ItemUtils.getToolMaterial(tool);
        String partMaterial = ItemUtils.getPartMaterial(kit);

        if (!toolMaterial.equals(partMaterial)) {
            player.sendMessage(ThemeUtils.WARNING + "The kit type does not match the tool material.");
            return false;
        }

        // All items are valid, lets preview the item!
        ItemStack newTool = tool.clone();
        repairItemStack(newTool);
        blockMenu.pushItem(newTool, OUTPUT_SLOT);
        blockMenu.getItemInSlot(INPUT_TOOL).setAmount(blockMenu.getItemInSlot(INPUT_TOOL).getAmount() - 1);
        blockMenu.getItemInSlot(INPUT_KIT).setAmount(blockMenu.getItemInSlot(INPUT_KIT).getAmount() - 1);

        return false;

    }

    protected void repairItemStack(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im instanceof Damageable) {
            Damageable damageable = (Damageable) im;
            int amountToRepair = Math.floorDiv(itemStack.getType().getMaxDurability(), 3);
            damageable.setDamage(Math.max(damageable.getDamage() - amountToRepair, 0));
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
        this.menu = blockMenu;
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(blockMenu, player));
    }

}
