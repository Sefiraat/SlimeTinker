package io.github.sefiraat.slimetinker.items.recipes;

import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import lombok.Getter;

public class MoltenResult {

    @Getter
    private final ComponentMaterial componentMaterial;

    @Getter
    private final int amount;


    public MoltenResult(ComponentMaterial componentMaterial, int amount) {
        this.componentMaterial = componentMaterial;
        this.amount = amount;
    }
}
