package io.github.sefiraat.slimetinker.items.workstations.workbench;

import io.github.mooy1.infinitylib.machines.CraftingBlock;
import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import lombok.Getter;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class Workbench extends CraftingBlock {

    public static final RecipeType TYPE = new RecipeType(SlimeTinker.createKey("tinkers-workbench"), Workstations.TINKERS_WORKBENCH, "");

    private static final int[] BACKGROUND_SLOTS = {0,1,2,3,4,5,6,7,8,9,13,14,15,16,17,18,22,24,26,27,31,32,33,34,35,36,37,38,39,40,41,42,43,44};
    private static final int[] INPUT_SLOTS = {10,11,12,19,20,21,28,29,30};
    protected static final int OUTPUT_SLOT = 25;
    protected static final int CRAFT_BUTTON = 23;

    public Workbench(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void craft(Block b, BlockMenu menu, Player p) {
        super.craft(b, menu, p);
    }

    //    @SuppressWarnings("SameReturnValue")
//    protected boolean craft(BlockMenu blockMenu, Player player) {
//
//        ItemStack[] inputs = new ItemStack[9];
//        for (int i = 0 ; i < 9 ; i++) {
//            inputs[i] = blockMenu.getItemInSlot(INPUT_SLOTS[i]);
//        }
//
//        this.;
//
//        RecipeOutput<ItemStack> matchedOutput = craftingRecipes.get(inputs);
//
//        if (matchedOutput == null) {
//            player.sendMessage(ThemeUtils.ERROR + "Not a valid crafting recipe");
//            return false;
//        }
//
//        ItemStack itemStack = matchedOutput.getOutput().clone();
//
//        if (!blockMenu.fits(itemStack, OUTPUT_SLOT)) {
//            player.sendMessage(ThemeUtils.WARNING + "Tidy up your workbench, you have no room!");
//            return false;
//        }
//
//        matchedOutput.consumeInput();
//        blockMenu.pushItem(itemStack, OUTPUT_SLOT);
//
//        return false;
//
//    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);

        blockMenuPreset.addItem(CRAFT_BUTTON, GUIItems.menuCraftWorkbench());
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

    public void setupSFRecipes() {
        for (SlimefunItem i : Slimefun.getRegistry().getEnabledSlimefunItems()) {
            if (i.getRecipeType() == RecipeType.ENHANCED_CRAFTING_TABLE && !ItemUtils.rejectCraftingRecipe(i)) {
                this.addRecipe(i.getRecipeOutput(), i.getRecipe());
            }
        }
    }

}
