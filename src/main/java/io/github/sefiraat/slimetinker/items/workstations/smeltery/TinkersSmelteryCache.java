package io.github.sefiraat.slimetinker.items.workstations.smeltery;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.items.materials.Alloy;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.recipes.Alloys;
import io.github.sefiraat.slimetinker.items.recipes.CastResult;
import io.github.sefiraat.slimetinker.items.recipes.MoltenResult;
import io.github.sefiraat.slimetinker.utils.GUIItems;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.Getter;
import lombok.Setter;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class TinkersSmelteryCache extends AbstractCache {

    @Getter @Setter
    private int levelLava;

    @Getter
    private final Map<String, Integer> tankContent = new LinkedHashMap<>();

    protected static final int LAVA_MAX = 1000;
    protected static final int LAVA_PER_BUCKET = 250;
    protected static final int METALS_MAX = 1000;

    protected static final String LAVA_LEVEL_BS = "tnk-lava-level";
    protected static final String METAL_LEVEL_PREFIX = "tnk-metal:";

    public TinkersSmelteryCache(BlockMenu blockMenu) {
        super(blockMenu);
        process(true);

        blockMenu.addItem(TinkersSmeltery.PURGE_BUTTON, GUIItems.menuPurge());
        blockMenu.addMenuClickHandler(TinkersSmeltery.PURGE_BUTTON, (player, i, itemStack, clickAction) -> clickPurge(clickAction));

        blockMenu.addItem(TinkersSmeltery.ALLOY_BUTTON, GUIItems.menuAlloy());
        blockMenu.addMenuClickHandler(TinkersSmeltery.ALLOY_BUTTON, (player, i, itemStack, clickAction) -> clickAlloy());

        blockMenu.addItem(TinkersSmeltery.POUR_BUTTON, GUIItems.menuPour());
        blockMenu.addMenuClickHandler(TinkersSmeltery.POUR_BUTTON, (player, i, itemStack, clickAction) -> clickPour(player));

    }

    public void input() {
        ItemStack input = blockMenu.getItemInSlot(TinkersSmeltery.INPUT_SLOT);
        if (input == null) { // Null, no item - moving on!
            return;
        }

        // Inputting Lava into the tank
        if (input.getType() == Material.LAVA_BUCKET) {
            if (levelLava <= (LAVA_MAX - LAVA_PER_BUCKET) && blockMenu.fits(new ItemStack(Material.BUCKET), TinkersSmeltery.OUTPUT_SLOT)) {
                input.setAmount(input.getAmount() - 1);
                blockMenu.pushItem(new ItemStack(Material.BUCKET), TinkersSmeltery.OUTPUT_SLOT);
                levelLava += LAVA_PER_BUCKET;
            } else if (blockMenu.fits(new ItemStack(Material.LAVA_BUCKET), TinkersSmeltery.OUTPUT_SLOT)) {
                input.setAmount(input.getAmount() - 1);
                blockMenu.pushItem(new ItemStack(Material.LAVA_BUCKET), TinkersSmeltery.OUTPUT_SLOT);
            }
        }

        MoltenResult result = ItemUtils.getMoltenResult(input);

        // Item doesn't melt OR not enough lava
        if (result == null || !canMelt(input, result)) {
            return;
        }

        if (canFit(result.getAmount())) {
            addMetal(result);
            input.setAmount(input.getAmount() - 1);
            levelLava -= result.getAmount();
        }
    }

    private boolean canMelt(ItemStack itemStack, MoltenResult result) {
        return ItemUtils.isMeltable(itemStack) && levelLava >= result.getAmount();
    }

    private boolean canFit(int incoming) {
        return (getMetalLevel() + incoming) <= METALS_MAX;
    }

    private Integer getMetalLevel() {
        return tankContent.values().stream().mapToInt(Integer::valueOf).sum();
    }

    public void process(boolean first) {
        input();
        updateView();
        if (!first) { syncBlock(); }
    }

    public void kill(Location location) {
        dropItems(location);
        BlockStorage.clearBlockInfo(location);
    }

    public void dropItems(Location location) {
        if (blockMenu.getItemInSlot(TinkersSmeltery.INPUT_SLOT) != null) {
            location.getWorld().dropItemNaturally(location, blockMenu.getItemInSlot(TinkersSmeltery.INPUT_SLOT).clone());
        }
        if (blockMenu.getItemInSlot(TinkersSmeltery.OUTPUT_SLOT) != null) {
            location.getWorld().dropItemNaturally(location, blockMenu.getItemInSlot(TinkersSmeltery.OUTPUT_SLOT).clone());
        }
        if (blockMenu.getItemInSlot(TinkersSmeltery.CAST_SLOT) != null) {
            location.getWorld().dropItemNaturally(location, blockMenu.getItemInSlot(TinkersSmeltery.CAST_SLOT).clone());
        }
    }

    public void updateView() {
        if (blockMenu.hasViewer()) {

            int metalLevel = getMetalLevel();

            int lavaPerc = (int) Math.ceil(((float) levelLava * 100) / LAVA_MAX);
            int metalPerc = (int) Math.ceil(((float) metalLevel * 100) / METALS_MAX);

            blockMenu.replaceExistingItem(TinkersSmeltery.LAVA_INFO, GUIItems.menuLavaInfo(lavaPerc, levelLava, LAVA_MAX));
            blockMenu.addMenuClickHandler(TinkersSmeltery.LAVA_INFO, (player, i, itemStack, clickAction) -> false);

            blockMenu.replaceExistingItem(TinkersSmeltery.METAL_INFO, GUIItems.menuMetalInfo(metalPerc, metalLevel, METALS_MAX, tankContent));
            blockMenu.addMenuClickHandler(TinkersSmeltery.METAL_INFO, (player, i, itemStack, clickAction) -> clickMetalTank());

        }
    }

    private void syncBlock() {
        BlockStorage.addBlockInfo(blockMenu.getBlock(), LAVA_LEVEL_BS, String.valueOf(levelLava));
        for (Map.Entry<String, Integer> e : tankContent.entrySet()) {
            BlockStorage.addBlockInfo(blockMenu.getBlock(), METAL_LEVEL_PREFIX + e.getKey(), String.valueOf(e.getValue()));
        }
    }

    private void addMetal(MoltenResult result) {
        if (tankContent.containsKey(result.getComponentMaterial().getId())) {
            tankContent.put(result.getComponentMaterial().getId(), tankContent.get(result.getComponentMaterial().getId()) + result.getAmount());
        } else {
            tankContent.put(result.getComponentMaterial().getId(), result.getAmount());
        }
    }

    private void addMetal(String metalName, int amount) {
        if (tankContent.containsKey(metalName)) {
            tankContent.put(metalName, tankContent.get(metalName) + amount);
        } else {
            tankContent.put(metalName, amount);
        }
    }

    private void removeMetal(String metalId, int amount) {
        int volume = tankContent.get(metalId);
        if (volume - amount <= 0) {
            tankContent.remove(metalId);
            BlockStorage.addBlockInfo(blockMenu.getLocation(), METAL_LEVEL_PREFIX + metalId, null);
        } else {
            tankContent.put(metalId, tankContent.get(metalId) - amount);
        }
    }

    private boolean clickPurge(ClickAction clickAction) {

        if (tankContent.isEmpty()) {
            return false;
        }

        if (clickAction.isRightClicked()) {
            tankContent.clear();
            Config c = BlockStorage.getLocationInfo(blockMenu.getLocation());
            List<String> keys = new ArrayList<>();
            for (String key : c.getKeys()) {
                if (key.startsWith(TinkersSmelteryCache.METAL_LEVEL_PREFIX)) {
                    keys.add(key);
                }
            }
            for (String key : keys) {
                BlockStorage.addBlockInfo(blockMenu.getLocation(), key, null);
            }
            return false;
        }

        Optional<String> first = tankContent.keySet().stream().findFirst();
        if (first.isPresent()) {
            String key = first.get();
            tankContent.remove(key);
            BlockStorage.addBlockInfo(blockMenu.getLocation(), METAL_LEVEL_PREFIX + key, null);
            return false;
        }

        return false;

    }

    private boolean clickAlloy() {

        for (Alloy alloy : Alloys.getALLOY_LIST()) {
            if (!alloy.getRecipe().keySet().equals(tankContent.keySet())) {
                continue;
            }
            int maxPossible = 0;
            for (Map.Entry<String, Integer> entry : alloy.getRecipe().entrySet()) {
                int tankAmount = tankContent.get(entry.getKey());
                int requiredAmount = entry.getValue();
                if (tankAmount < requiredAmount) {
                    return false;
                }
                int possible = Math.floorDiv(tankAmount, requiredAmount);
                if (maxPossible == 0 || maxPossible > possible) {
                    maxPossible = possible;
                }
            }
            for (Map.Entry<String, Integer> entry : alloy.getRecipe().entrySet()) {
                removeMetal(entry.getKey(), entry.getValue() * maxPossible);
            }
            addMetal(alloy.getName(), maxPossible);
        }
        return false;
    }

    private boolean clickPour(Player player) {

        ItemStack inputItem = blockMenu.getItemInSlot(TinkersSmeltery.CAST_SLOT);

        // Cast item is null or not a cast
        if (inputItem == null || !SlimeTinker.inst().getRecipeManager().castingRecipes.containsKey(StackUtils.getIDorType(inputItem))) {
            player.sendMessage(ThemeUtils.WARNING + "Please input a valid cast before trying to pour metals.");
            return false;
        }

        CastResult result = SlimeTinker.inst().getRecipeManager().castingRecipes.get(StackUtils.getIDorType(inputItem));
        Optional<String> first = tankContent.keySet().stream().findFirst();

        // No metals in the tank - cant pour
        if (!first.isPresent() ) {
            player.sendMessage(ThemeUtils.WARNING + "There isn't any metal to pour.");
            return false;
        }

        String metalID = first.get();
        ComponentMaterial componentMaterial = ComponentMaterials.getById(metalID);

        // Cast valid, but this cast and metal combination doesn't work
        if (!result.getOutputs().containsKey(componentMaterial)) {
            player.sendMessage(ThemeUtils.WARNING + "The selected metal cannot be shaped into the selected cast.");
            return false;
        }

        ItemStack outputItem = result.getOutputs().get(componentMaterial).clone();
        int metalAmount = result.getAmount();

        // Does not have enough metal to cats this specific item
        if (tankContent.get(metalID) < metalAmount) {
            player.sendMessage(ThemeUtils.WARNING + "You do not have enough metal to fill this cast");
            return false;
        }

        // Lastly, can we fit the output?
        if (!blockMenu.fits(outputItem, TinkersSmeltery.OUTPUT_SLOT)) {
            player.sendMessage(ThemeUtils.WARNING + "Please clear your casting table first");
            return false;
        }

        // Finally, let's actually pour
        removeMetal(metalID, result.getAmount());
        blockMenu.pushItem(outputItem, TinkersSmeltery.OUTPUT_SLOT);
        if (result.isInputBurns()) {
            inputItem.setAmount(inputItem.getAmount() - 1);
        }

        return false;

    }

    private boolean clickMetalTank() {
        // 0 or 1 metals, wont do anything
        Optional<String> first = tankContent.keySet().stream().findFirst();
        if (first.isPresent() && tankContent.size() > 1) {
            String string = first.get();
            int amount = tankContent.get(string);
            tankContent.remove(string);
            tankContent.put(string, amount);
            return false;
        }
        return false;
    }

}
