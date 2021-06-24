package io.github.sefiraat.slimetinker.items.recipes;

import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class MoltenResult {

    private final ComponentMaterial componentMaterial;
    private final int amount;

}
