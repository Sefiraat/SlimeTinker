package io.github.sefiraat.slimetinker.categories;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.core.categories.MultiCategory;
import io.github.thebusybiscuit.slimefun4.core.categories.SubCategory;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class Categories {

    private Categories() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItem catMain() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_MAIN),
                ThemeUtils.MAIN + "SlimeTinker"
        );
    }

    public static CustomItem catMaterials() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_MATERIALS),
                ThemeUtils.MAIN + "Materials"
        );
    }

    public static CustomItem catCasts() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_CASTS),
                ThemeUtils.MAIN + "Casts"
        );
    }

    public static CustomItem catParts() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_PARTS),
                ThemeUtils.MAIN + "Parts"
        );
    }

    public static CustomItem catMachines() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.CAT_MAIN),
                ThemeUtils.MAIN + "Work Stations"
        );
    }

    public static CustomItem catDummy() {
        return new CustomItem(
                Material.BARRIER,
                ThemeUtils.MAIN + "SlimeTinker Dummy"
        );
    }

    public static final MultiCategory MAIN = new MultiCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker"), catMain());
    public static final SubCategory MATERIALS = new SubCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-materials"), MAIN, catMaterials());
    public static final SubCategory MACHINES = new SubCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-machines"), MAIN, catMachines());
    public static final SubCategory CASTS = new SubCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-casts"), MAIN, catCasts());
    public static final SubCategory PARTS = new SubCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-parts"), MAIN, catParts());
    public static final DummyCategory DUMMY = new DummyCategory(new NamespacedKey(SlimeTinker.inst(), "slime-tinker-dummy"), catDummy());

    public static void set(SlimeTinker p) {
        MAIN.register(p);
        MATERIALS.register(p);
        MACHINES.register(p);
        CASTS.register(p);
        PARTS.register(p);
    }

}
