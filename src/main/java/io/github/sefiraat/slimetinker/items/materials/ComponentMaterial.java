package io.github.sefiraat.slimetinker.items.materials;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;

public class ComponentMaterial {

    @Getter
    private final String id;

    @Getter
    private final String colorHex;

    public ChatColor getColor() {
        return ChatColor.of(colorHex);
    }

    public ComponentMaterial(String id, String colorHex) {
        this.id = id;
        this.colorHex = colorHex;
    }

}
