package io.github.sefiraat.slimetinker.items.gui;

import io.github.sefiraat.slimetinker.items.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class GUIItems {

    public static CustomItem menuBackground() {
        return new CustomItem(
                Material.LIGHT_GRAY_STAINED_GLASS_PANE
        );
    }

    public static CustomItem menuBackgroundInput() {
        return new CustomItem(
                Material.LIGHT_BLUE_STAINED_GLASS_PANE
        );
    }

    public static CustomItem menuBackgroundOutput() {
        return new CustomItem(
                Material.ORANGE_STAINED_GLASS_PANE
        );
    }

    public static CustomItem menuBackgroundCast() {
        return new CustomItem(
                Material.LIME_STAINED_GLASS_PANE
        );
    }

    public static CustomItem menuDividerGui() {
        return new CustomItem(
                Material.BROWN_STAINED_GLASS_PANE
        );
    }

    public static CustomItem menuLavaInfo(int fillPerc, int fillAmt) {
        ItemStack skull;
        if (fillPerc >= 80) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_LAVA_5);
        } else if (fillPerc >= 60) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_LAVA_4);
        } else if (fillPerc >= 40) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_LAVA_3);
        } else if (fillPerc >= 20) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_LAVA_2);
        } else if (fillPerc > 0) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_LAVA_1);
        } else {
            skull = SkullItem.fromBase64(SkullTextures.TANK_EMPTY);
        }
        List<String> meta = new ArrayList<>();
        meta.add(ThemeUtils.GUI_HEAD + "Lava Tank");
        meta.add("");
        meta.add(ThemeUtils.CLICK_INFO + "Lava: " + ChatColor.WHITE + fillAmt);
        return new CustomItem(
                skull,
                meta
        );
    }

    public static CustomItem menuMetalInfo(int fillPerc, int fillAmt, @Nullable Map<String, Integer> map) {
        ItemStack skull;
        if (fillPerc >= 80) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_METAL_5);
        } else if (fillPerc >= 60) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_METAL_4);
        } else if (fillPerc >= 40) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_METAL_3);
        } else if (fillPerc >= 20) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_METAL_2);
        } else if (fillPerc > 0) {
            skull = SkullItem.fromBase64(SkullTextures.TANK_METAL_1);
        } else {
            skull = SkullItem.fromBase64(SkullTextures.TANK_EMPTY);
        }
        List<String> meta = new ArrayList<>();
        meta.add(ThemeUtils.GUI_HEAD + "Metals Tank");
        meta.add("");
        meta.add(ThemeUtils.CLICK_INFO + "Total Metal: " + ChatColor.WHITE + fillAmt);
        if (map != null) {
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                String name = ThemeUtils.toTitleCase(e.getKey());
                String amount = e.getValue().toString();
                meta.add(ThemeUtils.CLICK_INFO + name + ": " + ChatColor.WHITE + amount + " units.");
            }
        }
        return new CustomItem(
                skull,
                meta
        );
    }

    public static CustomItem menuPurge() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.BUTTON_PURGE),
                ThemeUtils.GUI_HEAD + "Purge Metals",
                "",
                ThemeUtils.PASSIVE + "Purge all the metal currently in the",
                ThemeUtils.PASSIVE + "metal tank."
        );
    }

    public static CustomItem menuAlloy() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.BUTTON_ALLOY),
                ThemeUtils.GUI_HEAD + "Alloy Metals",
                "",
                ThemeUtils.PASSIVE + "Mixes up the metals in the tank to",
                ThemeUtils.PASSIVE + "try to create an alloy."
        );
    }

    public static CustomItem menuPour() {
        return new CustomItem(
                SkullItem.fromBase64(SkullTextures.BUCKET_ORANGE),
                ThemeUtils.GUI_HEAD + "Pour content",
                "",
                ThemeUtils.PASSIVE + "Pours the first metal into the",
                ThemeUtils.PASSIVE + "cast. After cooling, outputs the",
                ThemeUtils.PASSIVE + "final product."
        );
    }

}
