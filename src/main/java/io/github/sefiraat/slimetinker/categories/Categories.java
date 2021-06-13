package io.github.sefiraat.slimetinker.categories;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.core.categories.MultiCategory;
import io.github.thebusybiscuit.slimefun4.core.categories.SubCategory;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.NamespacedKey;

public final class Categories {

    private Categories() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItem catMain() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_MAIN),
                ThemeUtils.MAIN + "Slime Tinker"
        );
    }

    public static CustomItem catMaterials() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_METALS),
                ThemeUtils.MAIN + "Molten Metals"
        );
    }

    public static CustomItem catMachines() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_METALS),
                ThemeUtils.MAIN + "Slime Tinker Machinery"
        );
    }
    public static final MultiCategory MAIN = new MultiCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker"), catMain());
    public static final SubCategory METALS = new SubCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-metals"), MAIN, catMaterials());
    public static final SubCategory MACHINES = new SubCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-machines"), MAIN, catMachines());

    public static void set(SlimeTinker p) {
        MAIN.register(p);
        METALS.register(p);
        MACHINES.register(p);
    }

}
