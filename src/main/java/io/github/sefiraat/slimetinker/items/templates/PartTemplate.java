package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.factories.CMManager;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import lombok.Getter;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PartTemplate extends UnplaceableBlock {

    @Getter
    private String materialType;

    private final String name;

    public String getName(String material) { return CMManager.getById(material).getColor() + ThemeUtils.toTitleCase(material) + ThemeUtils.ITEM_PART + " " + name;
    }

    public List<String> getLore(String material) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ThemeUtils.PASSIVE + "A tool part. Useless on it's own but can");
        list.add(ThemeUtils.PASSIVE + "be made into something greater at the");
        list.add(ThemeUtils.PASSIVE + "Tinker's table.");
        list.add("");
        list.add(ThemeUtils.CLICK_INFO + "Material : " + CMManager.getById(material).getColor() + ThemeUtils.toTitleCase(material));
        return list;
    }

    public ItemStack getStack(String material, String partClass, @Nullable String partType) {
        ItemStack itemStack = this.getItem().clone();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        im.setLore(getLore(material));
        im.setDisplayName(getName(material));
        c.set(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING, material);
        c.set(SlimeTinker.inst().getKeys().getPartInfoClassType(), PersistentDataType.STRING, partClass); // Whether the part is HEAD, BINDER or ROD
        if (partType != null) {
            c.set(SlimeTinker.inst().getKeys().getPartInfoType(), PersistentDataType.STRING, partType); // If HEAD, What tool type is it for?
        }
        itemStack.setItemMeta(im);
        return itemStack;
    }

    public PartTemplate(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, String name) {
        super(category, item, recipeType, recipe);
        this.name = name;
    }

}

