package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import lombok.Getter;

@Getter
public class CMToolMakeup {

    private ComponentMaterial parent;

    private final boolean isValidHead;
    private final boolean isValidBinder;
    private final boolean isValidRod;

    public CMToolMakeup(boolean isValidHead, boolean isValidBinder, boolean isValidRod) {
        this.isValidHead = isValidHead;
        this.isValidBinder = isValidBinder;
        this.isValidRod = isValidRod;
    }

}
