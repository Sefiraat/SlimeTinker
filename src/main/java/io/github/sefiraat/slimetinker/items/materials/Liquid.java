package io.github.sefiraat.slimetinker.items.materials;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;

public class Liquid {

    @Getter
    private final String id;

    @Getter
    private final String colorHex;

    public ChatColor getColor() {
        return ChatColor.of(colorHex);
    }

    public Liquid(String id, String colorHex) {
        this.id = id;
        this.colorHex = colorHex;
    }

}
