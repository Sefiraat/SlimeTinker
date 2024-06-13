package io.github.sefiraat.slimetinker.items.workstations.workbench;

import io.github.mooy1.infinitylib.machines.CraftingBlock;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.Keys;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class Workbench extends CraftingBlock {

    public static final RecipeType TYPE = new RecipeType(Keys.create("tinkers-workbench"), Workstations.TINKERS_WORKBENCH);
    protected static final int OUTPUT_SLOT = 25;
    protected static final int CRAFT_BUTTON = 23;
    private static final int[] BACKGROUND_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 14, 15, 16, 17, 18, 22, 24, 26, 27, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    private static final int[] INPUT_SLOTS = {10, 11, 12, 19, 20, 21, 28, 29, 30};

    public Workbench(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.MENU_CRAFT_WORKBENCH);
        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> false);
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu) {
        super.onBreak(event, blockMenu);
        Location location = blockMenu.getLocation();
        blockMenu.dropItems(location, INPUT_SLOTS);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
        super.onNewInstance(menu, b);
        menu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> {
            craft(b, menu, player);
            return false;
        });
    }

    public void setupRecipes() {
        for (SlimefunItem i : Slimefun.getRegistry().getEnabledSlimefunItems()) {
            RecipeType recipeType = i.getRecipeType();
            if ((recipeType == RecipeType.ENHANCED_CRAFTING_TABLE || recipeType == TYPE) && !ItemUtils.rejectCraftingRecipe(i)) {
                this.addRecipe(i.getRecipeOutput(), i.getRecipe());
            }
        }
    }

}
