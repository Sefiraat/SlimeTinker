package io.github.sefiraat.slimetinker.items.machines;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.gui.GUIItems;
import io.github.sefiraat.slimetinker.items.recipes.MoltenResult;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class TinkersSmelteryCache extends AbstractCache {

    private int levelLava = 0;

    private final Map<String, Integer> tankContent = new HashMap<>();

    protected static int LAVA_PER_MELT = 10;

    protected static final int LAVA_MAX = 5000;
    protected static final int LAVA_PER_BUCKET = 1000;
    protected static final int METALS_MAX = 10000;

    public TinkersSmelteryCache(BlockMenu blockMenu) {
        super(blockMenu);
        process();
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
                if (tankContent.containsKey(result.getLiquid().getId())) {
                    tankContent.put(result.getLiquid().getId(), tankContent.get(result.getLiquid().getId()) + result.getAmount());
                } else {
                    tankContent.put(result.getLiquid().getId(), result.getAmount());
                }
                for (Map.Entry<String, Integer> e : tankContent.entrySet()) {
                    SlimeTinker.inst().getLogger().info("Tank contains : " + e.getKey() + " | " + e.getValue());
                }
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

    public void process() {
        input();
        updateView();
    }

    public void kill(Location location) {
        dropItems(location);
        BlockStorage.clearBlockInfo(location);
    }

    public void dropItems(Location location) {
        if (blockMenu.getItemInSlot(TinkersSmeltery.INPUT_SLOT) != null) {
            location.getWorld().dropItemNaturally(location, blockMenu.getItemInSlot(TinkersSmeltery.INPUT_SLOT).clone());
        }
    }

    public void updateView() {
        if (blockMenu.hasViewer()) {
            int lavaPerc = (int) Math.ceil(((float) levelLava * 100) / LAVA_MAX);
            int metalPerc = (int) Math.ceil(((float) getMetalLevel() * 100) / METALS_MAX);

            blockMenu.replaceExistingItem(TinkersSmeltery.LAVA_INFO, GUIItems.menuLavaInfo(lavaPerc, levelLava));
            blockMenu.addMenuClickHandler(TinkersSmeltery.LAVA_INFO, (player, i, itemStack, clickAction) -> false);

            blockMenu.replaceExistingItem(TinkersSmeltery.METAL_INFO, GUIItems.menuMetalInfo(metalPerc, getMetalLevel(), tankContent));
            blockMenu.addMenuClickHandler(TinkersSmeltery.METAL_INFO, (player, i, itemStack, clickAction) -> false);



        }
    }


}
