package io.github.sefiraat.slimetinker.items.recipes;

import io.github.sefiraat.slimetinker.items.materials.Liquid;
import lombok.Getter;

public class MoltenResult {

    @Getter
    private final Liquid liquid;

    @Getter
    private final int amount;


    public MoltenResult(Liquid liquid, int amount) {
        this.liquid = liquid;
        this.amount = amount;
    }
}
