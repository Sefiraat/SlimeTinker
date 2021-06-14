package io.github.sefiraat.slimetinker.items.recipes;

import io.github.sefiraat.slimetinker.items.materials.Liquid;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class CastResult {

    @Getter
    private final String id;
    @Getter
    private final Map<Liquid, ItemStack> outputs;
    @Getter
    private final int amount;
    @Getter
    private final boolean inputBurns;

    public CastResult(String id, int amount, Map<Liquid, ItemStack> outputs, boolean inputBurns) {
        this.id = id;
        this.amount = amount;
        this.outputs = outputs;
        this.inputBurns = inputBurns;
    }

}
