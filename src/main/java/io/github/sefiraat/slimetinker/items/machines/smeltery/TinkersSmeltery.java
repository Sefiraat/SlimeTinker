package io.github.sefiraat.slimetinker.items.machines.smeltery;

import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.items.gui.GUIItems;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class TinkersSmeltery extends AbstractContainer {

    private static final int[] BACKGROUND_SLOTS = {27,29,31,35};
    private static final int[] BACKGROUND_INPUT_SLOTS = {0,1,2,9,11,18,19,20};
    private static final int[] BACKGROUND_CAST_SLOTS = {3,4,5,12,14,21,22,23};
    private static final int[] BACKGROUND_OUTPUT_SLOTS = {6,7,8,15,17,24,25,26};
    private static final int[] CAST_STORE_SLOTS = {36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
    protected static final int INPUT_SLOT = 10;
    protected static final int CAST_SLOT = 13;
    protected static final int OUTPUT_SLOT = 16;

    protected static final int PURGE_BUTTON = 32;
    protected static final int ALLOY_BUTTON = 33;
    protected static final int POUR_BUTTON = 34;

    protected static final int LAVA_INFO = 28;
    protected static final int METAL_INFO = 30;

    private final Map<Location, TinkersSmelteryCache> caches = new HashMap<>();

    public TinkersSmeltery(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return true;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config data) {
                TinkersSmelteryCache cache = TinkersSmeltery.this.caches.get(block.getLocation());
                if (cache != null) {
                    cache.process(false);
                }
            }
        });

    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.setSize(54);

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundInput(), BACKGROUND_INPUT_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundOutput(), BACKGROUND_OUTPUT_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundCast(), BACKGROUND_CAST_SLOTS);

        blockMenuPreset.addItem(LAVA_INFO, GUIItems.menuLavaInfo(0, 0, TinkersSmelteryCache.LAVA_MAX));
        blockMenuPreset.addItem(METAL_INFO, GUIItems.menuMetalInfo(0, 0, TinkersSmelteryCache.METALS_MAX, null));

        blockMenuPreset.addItem(PURGE_BUTTON, GUIItems.menuPurge());
        blockMenuPreset.addMenuClickHandler(PURGE_BUTTON, (player, i, itemStack, clickAction) -> false);

        blockMenuPreset.addItem(ALLOY_BUTTON, GUIItems.menuAlloy());
        blockMenuPreset.addMenuClickHandler(ALLOY_BUTTON, (player, i, itemStack, clickAction) -> false);

        blockMenuPreset.addItem(POUR_BUTTON, GUIItems.menuPour());
        blockMenuPreset.addMenuClickHandler(POUR_BUTTON, (player, i, itemStack, clickAction) -> false);

    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        if (itemTransportFlow == ItemTransportFlow.INSERT) {
            return new int[] {INPUT_SLOT};
        } else if (itemTransportFlow == ItemTransportFlow.WITHDRAW) {
            return new int[] {OUTPUT_SLOT};
        } else {
            return new int[0];
        }
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu, @Nonnull Location location) {
        super.onBreak(event, blockMenu, location);
        TinkersSmelteryCache simpleInventoryCache = caches.remove(location);
        if (simpleInventoryCache != null) {
            simpleInventoryCache.kill(location);
        }
        blockMenu.dropItems(location, INPUT_SLOT);
        blockMenu.dropItems(location, CAST_STORE_SLOTS);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
        super.onNewInstance(menu, b);
        TinkersSmelteryCache cache = new TinkersSmelteryCache(menu);

        String lavaLevel = BlockStorage.getLocationInfo(menu.getLocation(), TinkersSmelteryCache.LAVA_LEVEL_BS);
        if (lavaLevel != null) { cache.setLevelLava(Integer.parseInt(lavaLevel)); }

        Config c = BlockStorage.getLocationInfo(menu.getLocation());

        for (String key : c.getKeys()) {
            if (key.startsWith(TinkersSmelteryCache.METAL_LEVEL_PREFIX)) {
                String id = key.replace(TinkersSmelteryCache.METAL_LEVEL_PREFIX, "");
                int amount = Integer.parseInt(c.getString(key));
                cache.getTankContent().put(id, amount);
            }
        }

        caches.put(b.getLocation(), cache);
        menu.addMenuOpeningHandler((player -> validateMultiblock()));
    }

    private void validateMultiblock() {
        // TODO Validate the shape of the multiblock and stop opening if invalid.
    }

}
