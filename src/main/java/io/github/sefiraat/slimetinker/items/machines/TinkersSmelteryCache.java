package io.github.sefiraat.slimetinker.items.machines;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.gui.GUIItems;
import io.github.sefiraat.slimetinker.items.recipes.MoltenResult;
import lombok.Getter;
import lombok.Setter;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class TinkersSmelteryCache extends AbstractCache {

    @Getter @Setter
    private int levelLava;

    @Getter
    private final Map<String, Integer> tankContent = new HashMap<>();

    protected static int LAVA_PER_MELT = 50;

    protected static final int LAVA_MAX = 5000;
    protected static final int LAVA_PER_BUCKET = 1000;
    protected static final int METALS_MAX = 10000;

    protected static final String LAVA_LEVEL_BS = "tnk-lava-level";
    protected static final String METAL_LEVEL_PREFIX = "tnk-metal:";

    public TinkersSmelteryCache(BlockMenu blockMenu) {
        super(blockMenu);
        process(true);
    }

    public void input() {
        ItemStack input = blockMenu.getItemInSlot(TinkersSmeltery.INPUT_SLOT);
        if (input == null) { // Null, no item - moving on!
            return;
        }
        if (input.getType() == Material.LAVA_BUCKET) { // Inputting Lava into the tank
            if (levelLava <= (LAVA_MAX - LAVA_PER_BUCKET) && blockMenu.fits(new ItemStack(Material.BUCKET), TinkersSmeltery.OUTPUT_SLOT)) {
                input.setAmount(input.getAmount() - 1);
                blockMenu.pushItem(new ItemStack(Material.BUCKET), TinkersSmeltery.OUTPUT_SLOT);
                levelLava += 1000;
            }
        }
        if (canMelt(input)) {
            MoltenResult result = SlimeTinker.inst().getRecipeManager().getResult(input);
            if (canFit(result.getAmount())) {
                addMetal(result);
                levelLava -= LAVA_PER_MELT;
            }
        }
        // Item doesn't melt

        //TODO Store metals and lava in blockstorage
    }

    private boolean canMelt(ItemStack itemStack) {
        return SlimeTinker.inst().getRecipeManager().isMeltable(itemStack) && levelLava > LAVA_PER_MELT;
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

            blockMenu.replaceExistingItem(TinkersSmeltery.LAVA_INFO, GUIItems.menuLavaInfo(lavaPerc, levelLava));
            blockMenu.addMenuClickHandler(TinkersSmeltery.LAVA_INFO, (player, i, itemStack, clickAction) -> false);

            blockMenu.replaceExistingItem(TinkersSmeltery.METAL_INFO, GUIItems.menuMetalInfo(metalPerc, metalLevel, tankContent));
            blockMenu.addMenuClickHandler(TinkersSmeltery.METAL_INFO, (player, i, itemStack, clickAction) -> false);

        }
    }

    private void syncBlock() {
        BlockStorage.addBlockInfo(blockMenu.getBlock(), LAVA_LEVEL_BS, String.valueOf(levelLava));
        for (Map.Entry<String, Integer> e : tankContent.entrySet()) {
            BlockStorage.addBlockInfo(blockMenu.getBlock(), METAL_LEVEL_PREFIX + e.getKey(), String.valueOf(e.getValue()));
        }
    }

    private void addMetal(MoltenResult result) {
        if (tankContent.containsKey(result.getLiquid().getId())) {
            tankContent.put(result.getLiquid().getId(), tankContent.get(result.getLiquid().getId()) + result.getAmount());
        } else {
            tankContent.put(result.getLiquid().getId(), result.getAmount());
        }
    }

    private void removeMetal(String metalId, int amount) {
        int volume = tankContent.get(metalId);
        if (volume - amount <= 0) {
            tankContent.put(metalId, null);
        } else {
            tankContent.put(metalId, tankContent.get(metalId) - amount);
        }
    }

}
