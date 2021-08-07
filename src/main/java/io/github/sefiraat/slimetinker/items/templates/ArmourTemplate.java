package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ArmourTemplate extends UnplaceableBlock {

    public String getName(ArmourDefinition armourDefinition) {
        return
                CMManager.getById(armourDefinition.getPlateMaterial()).getColor() + ThemeUtils.toTitleCase(armourDefinition.getPlateMaterial()) + "-" +
                CMManager.getById(armourDefinition.getGambesonMaterial()).getColor() + ThemeUtils.toTitleCase(armourDefinition.getGambesonMaterial()) + "-" +
                CMManager.getById(armourDefinition.getLinksMaterial()).getColor() + ThemeUtils.toTitleCase(armourDefinition.getLinksMaterial()) + " " +
                ChatColor.WHITE + ThemeUtils.toTitleCase(armourDefinition.getPartType());

    }

    public Material getMaterial(ArmourDefinition armourDefinition) {
        switch (armourDefinition.getPartType()) {
            case IDStrings.HELMET:
                return Material.LEATHER_HELMET;
            case IDStrings.CHESTPLATE:
                return Material.LEATHER_CHESTPLATE;
            case IDStrings.LEGGINGS:
                return Material.LEATHER_LEGGINGS;
            case IDStrings.BOOTS:
                return Material.LEATHER_BOOTS;
            default:
                throw new IllegalStateException("Unexpected value: " + armourDefinition.getClassType());
        }
    }

    public ItemStack getStack(ArmourDefinition armourDefinition) {

        ItemStack itemStack = this.getItem().clone();

        itemStack.setType(getMaterial(armourDefinition));
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "Meta is null, whoops!");
        Experience.setupExpNew(im);
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getArmourInfoIsArmour(), "Y");
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getArmourInfoPlateType(), armourDefinition.getClassType());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getArmourInfoArmourType(), armourDefinition.getPartType());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getArmourInfoPlateMaterial(), armourDefinition.getPlateMaterial());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getArmourInfoGambesonMaterial(), armourDefinition.getGambesonMaterial());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getArmourInfoLinksMaterial(), armourDefinition.getLinksMaterial());

        im.setDisplayName(getName(armourDefinition));
        itemStack.setItemMeta(im);
        ItemUtils.rebuildTinkerLore(itemStack);
        return itemStack;
    }

    public ArmourTemplate(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

}

