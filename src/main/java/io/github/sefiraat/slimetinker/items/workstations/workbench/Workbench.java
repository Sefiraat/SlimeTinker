package io.github.sefiraat.slimetinker.items.workstations.workbench;

import io.github.mooy1.infinitylib.recipes.RecipeMap;
import io.github.mooy1.infinitylib.recipes.RecipeOutput;
import io.github.mooy1.infinitylib.recipes.ShapedRecipe;
import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.items.gui.GUIItems;
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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class Workbench extends AbstractContainer {

    private static final RecipeMap<ItemStack> RECIPES = new RecipeMap<>(ShapedRecipe::new);
    public static final RecipeType TYPE = new RecipeType(SlimeTinker.inst().getKey("tinkers-workbench"), Workstations.TINKERS_WORKBENCH, RECIPES::put);

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,13,14,15,16,17,18,22,24,26,27,31,32,33,34,35,36,37,38,39,40,41,42,43,44};
    private static final int[] INPUT_SLOTS = {10,11,12,19,20,21,28,29,30};
    protected static final int OUTPUT_SLOT = 25;
    protected static final int CRAFT_BUTTON = 23;

    private final RecipeMap<ItemStack> craftingRecipes;

    public Workbench(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.craftingRecipes = RECIPES;
    }

    protected boolean craft(BlockMenu blockMenu, Player player) {

        ItemStack[] inputs = new ItemStack[9];
        for (int i = 0 ; i < 9 ; i++) {
            inputs[i] = blockMenu.getItemInSlot(INPUT_SLOTS[i]);
        }

        RecipeOutput<ItemStack> matchedOutput = craftingRecipes.get(inputs);

        if (matchedOutput == null) {
            player.sendMessage(ThemeUtils.ERROR + "Not a valid crafting recipe");
            return false;
        }

        ItemStack itemStack = matchedOutput.getOutput().clone();

        if (!blockMenu.fits(itemStack, OUTPUT_SLOT)) {
            player.sendMessage(ThemeUtils.WARNING + "Tidy up your workbench, you have no room!");
            return false;
        }

        matchedOutput.consumeInput();
        blockMenu.pushItem(itemStack, OUTPUT_SLOT);

        return false;

    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftWorkbench());
        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);

    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        return new int[0];
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu, @Nonnull Location location) {
        super.onBreak(event, blockMenu, location);
        blockMenu.dropItems(location, INPUT_SLOTS);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
        super.onNewInstance(menu, b);
        menu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> craft(menu, player));
    }

}
