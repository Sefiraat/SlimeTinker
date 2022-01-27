package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterialManager;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.MessageFormat;

public class ArmourTemplate extends UnplaceableBlock {

    public ArmourTemplate(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public String getName(ArmourDefinition armourDefinition) {
        return MessageFormat.format(
            "{0}{1}-{2}{3}-{4}{5} {6}{7}",
            TinkerMaterialManager.getById(armourDefinition.getPlateMaterial()).getColor(),
            ThemeUtils.toTitleCase(armourDefinition.getPlateMaterial()),
            TinkerMaterialManager.getById(armourDefinition.getGambesonMaterial()).getColor(),
            ThemeUtils.toTitleCase(armourDefinition.getGambesonMaterial()),
            TinkerMaterialManager.getById(armourDefinition.getLinksMaterial()).getColor(),
            ThemeUtils.toTitleCase(armourDefinition.getLinksMaterial()),
            ChatColor.WHITE,
            ThemeUtils.toTitleCase(armourDefinition.getPartType())
        );
    }

    public Material getMaterial(ArmourDefinition armourDefinition) {
        switch (armourDefinition.getPartType()) {
            case Ids.HELMET:
                return Material.LEATHER_HELMET;
            case Ids.CHESTPLATE:
                return Material.LEATHER_CHESTPLATE;
            case Ids.LEGGINGS:
                return Material.LEATHER_LEGGINGS;
            case Ids.BOOTS:
                return Material.LEATHER_BOOTS;
            default:
                throw new IllegalStateException("Unexpected value: " + armourDefinition.getClassType());
        }
    }

    public ItemStack getStack(ArmourDefinition armourDefinition) {

        ItemStack itemStack = this.getItem().clone();

        itemStack.setType(getMaterial(armourDefinition));
        ItemMeta im = itemStack.getItemMeta();
        Experience.setupExpNew(im);
        PersistentDataAPI.setString(im, Keys.ARMOUR_INFO_IS_ARMOUR, "Y");
        PersistentDataAPI.setString(im, Keys.ARMOUR_INFO_PLATE_TYPE, armourDefinition.getClassType());
        PersistentDataAPI.setString(im, Keys.ARMOUR_INFO_ARMOUR_TYPE, armourDefinition.getPartType());
        PersistentDataAPI.setString(im, Keys.ARMOUR_INFO_PLATE_MATERIAL, armourDefinition.getPlateMaterial());
        PersistentDataAPI.setString(im, Keys.ARMOUR_INFO_GAMBESON_MATERIAL, armourDefinition.getGambesonMaterial());
        PersistentDataAPI.setString(im, Keys.ARMOUR_INFO_LINKS_MATERIAL, armourDefinition.getLinksMaterial());

        im.setDisplayName(getName(armourDefinition));
        itemStack.setItemMeta(im);
        ItemUtils.rebuildTinkerLore(itemStack);
        return itemStack;
    }

}

