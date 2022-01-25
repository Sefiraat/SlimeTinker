package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.Keys;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RepairkitTemplate extends UnplaceableBlock {

    private final String name;
    private String materialType;

    public RepairkitTemplate(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, String name) {
        super(itemGroup, item, recipeType, recipe);
        this.name = name;
    }

    public static boolean isRepairKit(ItemStack itemStack) {
        NamespacedKey key = Keys.PART_CLASS;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "Meta is null, wrong wrong wrong.");
        String value = PersistentDataAPI.getString(im, key);
        return value != null && value.equals(IDStrings.REPAIR);
    }

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
        PersistentDataAPI.setString(im, Keys.PART_MATERIAL, material);
        PersistentDataAPI.setString(im, Keys.PART_CLASS, partClass);

        itemStack.setItemMeta(im);
        return itemStack;
    }

    public String getName() {
        return name;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}

