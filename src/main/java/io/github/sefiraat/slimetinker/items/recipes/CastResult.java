package io.github.sefiraat.slimetinker.items.recipes;

import io.github.sefiraat.slimetinker.items.materials.Liquid;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class CastResult {

    private final Map<Liquid, ItemStack> outputs;
    private final int amount;

    public CastResult(int amount, Map<Liquid, ItemStack> outputs) {
        this.amount = amount;
        this.outputs = outputs;
    }

}
