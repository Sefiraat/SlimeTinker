package io.github.sefiraat.slimetinker.items.componentmaterials;

import lombok.Data;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

@Data
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

}
