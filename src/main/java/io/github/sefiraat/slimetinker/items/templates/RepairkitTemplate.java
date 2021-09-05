package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RepairkitTemplate extends UnplaceableBlock {

    @Getter
    private String materialType;

    private final String name;

    public String getName(String material) {
        return ThemeUtils.toTitleCase(material) + ThemeUtils.ITEM_PART + " " + name;
    }

    public List<String> getLore(String material, ChatColor color) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ThemeUtils.PASSIVE + "A repair kit. Used in the Repair Bench");
        list.add(ThemeUtils.PASSIVE + "to mend tools with a matching head-metal.");
        list.add("");
        list.add(ThemeUtils.CLICK_INFO + "Material : " + color + ThemeUtils.toTitleCase(material));
        return list;
    }

    public ItemStack getStack(String material, String partClass, ChatColor color) {
        ItemStack itemStack = this.getItem().clone();
        itemStack.setType(Material.CHEST_MINECART);
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "Meta be null y'all!");
        im.setLore(getLore(material, color));
        im.setDisplayName(color + getName(material));
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getPartMaterial(), material);
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getPartClass(), partClass);

        itemStack.setItemMeta(im);
        return itemStack;
    }

    public RepairkitTemplate(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, String name) {
        super(category, item, recipeType, recipe);
        this.name = name;
    }

    public static boolean isRepairKit(ItemStack itemStack) {
        NamespacedKey key = SlimeTinker.inst().getKeys().getPartClass();
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "Meta is null, wrong wrong wrong.");
        return  PersistentDataAPI.getString(im, key).equals(IDStrings.REPAIR);
    }

}

