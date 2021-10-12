package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public final class GUIItems {

    private GUIItems() {
        throw new IllegalStateException("Utility class");
    }

    public static CustomItemStack menuBackgroundInput() {
        return new CustomItemStack(
            Material.LIGHT_BLUE_STAINED_GLASS_PANE,
            ChatColor.BLUE + "Input",
            " "
        );
    }

    public static CustomItemStack menuBackgroundOutput() {
        return new CustomItemStack(
            Material.ORANGE_STAINED_GLASS_PANE,
            ChatColor.RED + "Output",
            " "
        );
    }

    public static CustomItemStack menuBackgroundCast() {
        return new CustomItemStack(
            Material.LIME_STAINED_GLASS_PANE,
            ChatColor.GREEN + "Cast/Die",
            " "
        );
    }

    public static CustomItemStack menuPreview() {
        return new CustomItemStack(
            Material.LIME_STAINED_GLASS_PANE,
            ChatColor.GREEN + "Preview",
            " "
        );
    }

    public static CustomItemStack menuBackgroundPreview() {
        return new CustomItemStack(
            Material.LIME_STAINED_GLASS_PANE,
            ChatColor.GREEN + "Preview",
            " "
        );
    }

    public static CustomItemStack menuMarkerRod() {
        return new CustomItemStack(
            Material.RED_STAINED_GLASS_PANE,
            ChatColor.RED + "Rod Input",
            " "
        );
    }

    public static CustomItemStack menuMarkerBinder() {
        return new CustomItemStack(
            Material.RED_STAINED_GLASS_PANE,
            ChatColor.RED + "Binder Input",
            " "
        );
    }

    public static CustomItemStack menuMarkerHead() {
        return new CustomItemStack(
            Material.RED_STAINED_GLASS_PANE,
            ChatColor.RED + "Head/Blade Input",
            " "
        );
    }

    public static CustomItemStack menuMarkerLinks() {
        return new CustomItemStack(
            Material.RED_STAINED_GLASS_PANE,
            ChatColor.RED + "Links Input",
            " "
        );
    }

    public static CustomItemStack menuMarkerGambeson() {
        return new CustomItemStack(
            Material.RED_STAINED_GLASS_PANE,
            ChatColor.RED + "Gambeson Input",
            " "
        );
    }

    public static CustomItemStack menuMarkerPlates() {
        return new CustomItemStack(
            Material.RED_STAINED_GLASS_PANE,
            ChatColor.RED + "Plates Input",
            " "
        );
    }

    public static CustomItemStack menuLavaInfo(int fillPercent, int fillAmt, int fillMax) {
        ItemStack skull;
        if (fillPercent >= 95) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_LAVA_5));
        } else if (fillPercent >= 75) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_LAVA_4));
        } else if (fillPercent >= 50) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_LAVA_3));
        } else if (fillPercent >= 25) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_LAVA_2));
        } else if (fillPercent > 0) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_LAVA_1));
        } else {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_EMPTY));
        }
        List<String> meta = new ArrayList<>();
        meta.add(ThemeUtils.GUI_HEAD + "Lava Tank");
        meta.add("");
        meta.add(ThemeUtils.CLICK_INFO + "Lava: " + ChatColor.WHITE + fillAmt + " / " + fillMax);
        return new CustomItemStack(
            skull,
            meta
        );
    }

    public static CustomItemStack menuMetalInfo(int fillPercent, int fillAmt, int fillMax, @Nullable Map<String, Integer> map) {
        ItemStack skull;
        if (fillPercent >= 95) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_METAL_5));
        } else if (fillPercent >= 75) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_METAL_4));
        } else if (fillPercent >= 50) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_METAL_3));
        } else if (fillPercent >= 25) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_METAL_2));
        } else if (fillPercent > 0) {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_METAL_1));
        } else {
            skull = PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.TANK_EMPTY));
        }
        List<String> meta = new ArrayList<>();
        meta.add(ThemeUtils.GUI_HEAD + "Metals Tank");
        meta.add("");
        meta.add(ThemeUtils.CLICK_INFO + "Total Metal: " + ChatColor.WHITE + fillAmt + " / " + fillMax);
        meta.add("");
        if (map != null) {
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                String name =
                    CMManager.getById(e.getKey()).getColor() +
                        ThemeUtils.toTitleCase(e.getKey());
                String amount = e.getValue().toString();
                meta.add(ThemeUtils.CLICK_INFO + name + ": " + ChatColor.WHITE + amount + " units.");
            }
        }
        meta.add("");
        meta.add(ThemeUtils.PASSIVE + "Metals pour out from the " + ChatColor.BOLD + "top" + ThemeUtils.PASSIVE + " first");
        meta.add("");
        meta.add(ThemeUtils.CLICK_INFO + "Click to cycle metal order.");
        return new CustomItemStack(
            skull,
            meta
        );
    }

    public static CustomItemStack menuPurge() {
        return new CustomItemStack(
            PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.BUTTON_PURGE)),
            ThemeUtils.GUI_HEAD + "Purge Metals",
            "",
            ThemeUtils.PASSIVE + "Purge unwanted metals from the tank.",
            "",
            ThemeUtils.CLICK_INFO + "Left Click: " + ChatColor.WHITE + "Remove the TOP MOST metal",
            ThemeUtils.CLICK_INFO + "Right Click: " + ChatColor.WHITE + "Remove ALL metals"
        );
    }

    public static CustomItemStack menuAlloy() {
        return new CustomItemStack(
            PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.BUTTON_ALLOY)),
            ThemeUtils.GUI_HEAD + "Alloy Metals",
            "",
            ThemeUtils.PASSIVE + "Mixes up the metals in the tank to",
            ThemeUtils.PASSIVE + "try to create an alloy."
        );
    }

    public static CustomItemStack menuPour() {
        return new CustomItemStack(
            PlayerHead.getItemStack(PlayerSkin.fromBase64(SkullTextures.BUCKET_ORANGE)),
            ThemeUtils.GUI_HEAD + "Pour content",
            "",
            ThemeUtils.PASSIVE + "Pours the first metal into the",
            ThemeUtils.PASSIVE + "cast. After cooling, outputs the",
            ThemeUtils.PASSIVE + "final product."
        );
    }

    public static CustomItemStack menuCraftWorkbench() {
        return new CustomItemStack(
            Material.FLETCHING_TABLE,
            ThemeUtils.GUI_HEAD + "Craft",
            "",
            ThemeUtils.PASSIVE + "Let's get crafting!"
        );
    }

    public static CustomItemStack menuCraftTable() {
        return new CustomItemStack(
            Material.SMITHING_TABLE,
            ThemeUtils.GUI_HEAD + "Form Tool",
            "",
            ThemeUtils.PASSIVE + "Forms a tool from the three given",
            ThemeUtils.PASSIVE + "parts (Rod, Binding and Head/Blade)"
        );
    }

    public static CustomItemStack menuCraftRepair() {
        return new CustomItemStack(
            Material.CARTOGRAPHY_TABLE,
            ThemeUtils.GUI_HEAD + "Repair",
            "",
            ThemeUtils.PASSIVE + "Repairs the tool in the first slot",
            ThemeUtils.PASSIVE + "using the repair kit in the second."
        );
    }

    public static CustomItemStack menuCraftMod() {
        return new CustomItemStack(
            Material.GRINDSTONE,
            ThemeUtils.GUI_HEAD + "Apply Modification",
            "",
            ThemeUtils.PASSIVE + "Apply the modification to the tool."
        );
    }

    public static CustomItemStack menuCraftSwap() {
        return new CustomItemStack(
            Material.LOOM,
            ThemeUtils.GUI_HEAD + "Swap out part",
            "",
            ThemeUtils.PASSIVE + "Swap tool parts."
        );
    }

}
