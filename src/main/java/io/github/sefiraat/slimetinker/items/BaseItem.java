package io.github.sefiraat.slimetinker.items;

import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class BaseItem extends SlimefunItemStack implements NotPlaceable {

    private final String id;

    public BaseItem(String id, Material type, String name, String... lore) {
        super(id, type, name, lore);
        this.id = id;
    }

    public BaseItem(String id, String texture, String name, String... lore) {
        super(id, texture, name, lore);
        this.id = id;
    }

    @Override
    public @NotNull String getId() {
        return id;
    }

}
