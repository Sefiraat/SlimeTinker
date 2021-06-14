package io.github.sefiraat.slimetinker.categories;

import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DummyCategory extends Category {

    public DummyCategory(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    public boolean isHidden(@NotNull Player p) {
        return true;
    }

}
