package io.github.sefiraat.slimetinker.items.parts;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Liquids;
import io.github.sefiraat.slimetinker.items.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.Getter;
import lombok.Setter;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ToolRod extends UnplaceableBlock {

    @Getter
    @Setter
    private String materialType;

    public static String getName(String material) {
        return
                ChatColor.of(Liquids.getById(material).getColorHex()) +
                ThemeUtils.toTitleCase(material) +
                ThemeUtils.ITEM_PART + " Tool Rod";
    }

    public static List<String> getLore(String material) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ThemeUtils.PASSIVE + "A tool rod. Useless by itself, can be");
        list.add(ThemeUtils.PASSIVE + "made into a tool at the Tinker's table.");
        list.add("");
        list.add(ThemeUtils.CLICK_INFO + "Material : " + ChatColor.of(Liquids.getById(material).getColorHex()) + ThemeUtils.toTitleCase(material));
        return list;
    }

    public ItemStack getStack(String material) {
        ItemStack itemStack = this.getItem().clone();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        im.setLore(getLore(material));
        im.setDisplayName(getName(material));
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Material"), PersistentDataType.STRING, material);
        itemStack.setItemMeta(im);
        return itemStack;
    }

    public static final SlimefunItemStack STACK =
            ThemeUtils.themedItemStack(
                    "PART_TOOL_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.PART,
                    "Error",
                    ThemeUtils.PASSIVE + "Error"
            );


    public ToolRod(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        register(SlimeTinker.inst());
    }

}
