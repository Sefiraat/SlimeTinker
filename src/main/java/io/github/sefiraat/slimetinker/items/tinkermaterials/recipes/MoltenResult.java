package io.github.sefiraat.slimetinker.items.tinkermaterials.recipes;

import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;

public class MoltenResult {

    private final TinkerMaterial tinkerMaterial;
    private final int amount;

    public MoltenResult(TinkerMaterial tinkerMaterial, int amount) {
        this.tinkerMaterial = tinkerMaterial;
        this.amount = amount;
    }

    public TinkerMaterial getComponentMaterial() {
        return tinkerMaterial;
    }

    public int getAmount() {
        return amount;
    }
}
