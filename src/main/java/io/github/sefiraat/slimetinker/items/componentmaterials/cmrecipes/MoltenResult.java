package io.github.sefiraat.slimetinker.items.componentmaterials.cmrecipes;

import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;

public class MoltenResult {

    private final ComponentMaterial componentMaterial;
    private final int amount;

    public MoltenResult(ComponentMaterial componentMaterial, int amount) {
        this.componentMaterial = componentMaterial;
        this.amount = amount;
    }

    public ComponentMaterial getComponentMaterial() {
        return componentMaterial;
    }

    public int getAmount() {
        return amount;
    }
}
