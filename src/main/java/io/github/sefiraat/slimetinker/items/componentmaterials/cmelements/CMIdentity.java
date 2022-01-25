package io.github.sefiraat.slimetinker.items.componentmaterials.cmelements;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

public class CMIdentity {

    private final String id;
    private final ItemStack representativeStack;
    @Nullable
    private final String liquidTexture;
    private final String colorHex;

    public CMIdentity(String id, ItemStack representativeStack, @Nullable String liquidTexture, String colorHex) {
        this.id = id;
        this.representativeStack = representativeStack;
        this.liquidTexture = liquidTexture;
        this.colorHex = colorHex;
    }

    public String getId() {
        return id;
    }

    public ItemStack getRepresentativeStack() {
        return representativeStack;
    }

    @Nullable
    public String getLiquidTexture() {
        return liquidTexture;
    }

    public String getColorHex() {
        return colorHex;
    }
}
