package io.github.sefiraat.slimetinker.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import org.bukkit.Material;

import javax.annotation.Nonnull;

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

    @Nonnull
    @Override
    public String getId() {
        return id;
    }

}
