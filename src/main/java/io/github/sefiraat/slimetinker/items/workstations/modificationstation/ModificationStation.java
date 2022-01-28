package io.github.sefiraat.slimetinker.items.workstations.modificationstation;

import io.github.mooy1.infinitylib.common.StackUtils;
import io.github.mooy1.infinitylib.machines.MenuBlock;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import javax.annotation.Nonnull;
import java.util.Map;

public class ModificationStation extends MenuBlock {

    protected static final int MOD_BUTTON = 14;
    protected static final int OUTPUT_SLOT = 16;
    private static final int[] BACKGROUND_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    private static final int INPUT_TOOL = 10;
    private static final int INPUT_MOD = 12;

    public ModificationStation(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    protected void craft(BlockMenu blockMenu, Player player) {
        ItemStack item = blockMenu.getItemInSlot(INPUT_TOOL);
        ItemStack modItem = blockMenu.getItemInSlot(INPUT_MOD);

        // No item dummy!
        if (item == null) {
            player.sendMessage(ThemeUtils.WARNING + "Input a tool/piece of armour into the first slot.");
            return;
        }

        if (item.getAmount() > 1) {
            player.sendMessage(ThemeUtils.WARNING + "Nope - nerd");
            return;
        }

        // Still no tool, nice try
        if (ItemUtils.isTool(item)) {
            modTool(blockMenu, player, item, modItem);
        } else if (ItemUtils.isArmour(item)) {
            modArmour(blockMenu, player, item, modItem);
        } else {
            player.sendMessage(ThemeUtils.WARNING + "The item in the first slot isn't a Tinker's tool/armour piece.");
        }
    }

    private void modTool(BlockMenu blockMenu, Player player, ItemStack item, ItemStack modItem) {
        // No modifier!
        if (modItem == null || !Modifications.getModificationListTool().contains(StackUtils.getIdOrType(modItem))) {
            player.sendMessage(ThemeUtils.WARNING + "Input a valid modifier into the second slot.");
            return;
        }

        ItemMeta im = item.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        Map<String, Integer> modMap = Modifications.getModificationMapTool(c);

        Mod mod = Modifications.getModificationDefinitionsTool().get(StackUtils.getIdOrType(modItem)); // The definition of the mod being created/updated
        int modSlots = ItemUtils.getTinkerModifierSlots(c); // Number of free modification slots on the tool
        int currentAmount = modMap.get(StackUtils.getIdOrType(modItem)); // The current value of that material loaded into the tool (not the level)
        int currentLevel = Modifications.getModLevel(mod, item); // The current level of this mod (or 0)

        if (!mod.getRequirementMap().containsKey(currentLevel + 1)) { // Max level
            player.sendMessage(ThemeUtils.WARNING + "You have already maxed out this modifier");
            return;
        }

        int requiredAmount = mod.getRequirementMap().get(currentLevel + 1) - currentAmount; // The amount needed for the next level less the amount currently on the tool
        int leftoverAmount = 0;

        if (currentAmount <= 0) {
            if (modSlots == 0) { // New mod and no slots
                player.sendMessage(ThemeUtils.WARNING + "You do not have enough free Modification slots for this");
                return;
            } else { // Remove mod slot
                ItemUtils.setTinkerModifierSlots(c, modSlots - 1);
            }
        }  // Or continuing on with a previous mod so we can continue without a free slot

        if (requiredAmount <= modItem.getAmount()) { // We don't need the full amount (or the full amount will level up the tool)
            leftoverAmount = modItem.getAmount() - requiredAmount; // Remove what we need
            Modifications.setModLevel(mod, c, currentLevel + 1);
            currentAmount = 0;
        } else {
            currentAmount = currentAmount + modItem.getAmount();
        }

        modMap.put(StackUtils.getIdOrType(modItem), currentAmount);
        Modifications.setModificationMapTool(c, modMap);

        item.setItemMeta(im);
        ItemStack newTool = item.clone();

        if (!blockMenu.fits(newTool, OUTPUT_SLOT)) {
            player.sendMessage(ThemeUtils.WARNING + "Clear the output slot first");
            return;
        }

        ItemUtils.rebuildTinkerLore(newTool);
        blockMenu.pushItem(newTool, OUTPUT_SLOT);
        item.setAmount(0);
        modItem.setAmount(leftoverAmount);
    }

    private void modArmour(BlockMenu blockMenu, Player player, ItemStack item, ItemStack modItem) {
        // No modifier!
        if (modItem == null || !Modifications.getModificationListArmour().contains(StackUtils.getIdOrType(modItem))) {
            player.sendMessage(ThemeUtils.WARNING + "Input a valid modifier into the second slot.");
            return;
        }

        ItemMeta im = item.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        Map<String, Integer> modMap = Modifications.getModificationMapArmour(c);

        Mod mod = Modifications.getModificationDefinitionsArmour().get(StackUtils.getIdOrType(modItem)); // The definition of the mod being created/updated
        int modSlots = ItemUtils.getTinkerModifierSlots(c); // Number of free modification slots on the tool
        int currentAmount = modMap.get(StackUtils.getIdOrType(modItem)); // The current value of that material loaded into the tool (not the level)
        int currentLevel = Modifications.getModLevel(mod, item); // The current level of this mod (or 0)

        if (!mod.getRequirementMap().containsKey(currentLevel + 1)) { // Max level
            player.sendMessage(ThemeUtils.WARNING + "You have already maxed out this modifier");
            return;
        }

        int requiredAmount = mod.getRequirementMap().get(currentLevel + 1) - currentAmount; // The amount needed for the next level less the amount currently on the tool
        int leftoverAmount = 0;

        if (currentAmount <= 0) {
            if (modSlots == 0) { // New mod and no slots
                player.sendMessage(ThemeUtils.WARNING + "You do not have enough free Modification slots for this");
                return;
            } else { // Remove mod slot
                ItemUtils.setTinkerModifierSlots(c, modSlots - 1);
            }
        }  // Or continuing on with a previous mod so we can continue without a free slot

        if (requiredAmount <= modItem.getAmount()) { // We don't need the full amount (or the full amount will level up the tool)
            leftoverAmount = modItem.getAmount() - requiredAmount; // Remove what we need
            Modifications.setModLevel(mod, c, currentLevel + 1);
            currentAmount = 0;
        } else {
            currentAmount = currentAmount + modItem.getAmount();
        }

        modMap.put(StackUtils.getIdOrType(modItem), currentAmount);
        Modifications.setModificationMapArmour(c, modMap);

        item.setItemMeta(im);
        ItemStack newArmour = item.clone();

        if (!blockMenu.fits(newArmour, OUTPUT_SLOT)) {
            player.sendMessage(ThemeUtils.WARNING + "Clear the output slot first");
            return;
        }

        ItemUtils.rebuildTinkerLore(newArmour);
        blockMenu.pushItem(newArmour, OUTPUT_SLOT);
        item.setAmount(0);
        modItem.setAmount(leftoverAmount);
    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {

        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND_SLOTS);

        blockMenuPreset.addItem(MOD_BUTTON, GUIItems.MENU_CRAFT_MOD);
        blockMenuPreset.addMenuClickHandler(MOD_BUTTON, (player, i, itemStack, clickAction) -> false);

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
        blockMenu.dropItems(location, INPUT_MOD);
        blockMenu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        blockMenu.addMenuClickHandler(MOD_BUTTON, (player, i, itemStack, clickAction) -> {
            craft(blockMenu, player);
            return false;
        });
    }

}
