package io.github.sefiraat.slimetinker.items.componentmaterials.cmrecipes;

import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@Getter
@AllArgsConstructor
public class CastResult {

    private final String id;
    private final int amount;
    private final Map<ComponentMaterial, ItemStack> outputs;
    private final boolean inputBurns;

}
