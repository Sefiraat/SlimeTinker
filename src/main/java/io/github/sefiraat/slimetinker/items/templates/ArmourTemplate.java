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
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ArmourTemplate extends UnplaceableBlock {

    public String getName(CombinationDefinition combinationDefinition) {
        return
                CMManager.getById(combinationDefinition.getHeadMaterial()).getColor() + ThemeUtils.toTitleCase(combinationDefinition.getHeadMaterial()) + "-" +
                CMManager.getById(combinationDefinition.getBinderMaterial()).getColor() + ThemeUtils.toTitleCase(combinationDefinition.getBinderMaterial()) + "-" +
                CMManager.getById(combinationDefinition.getRodMaterial()).getColor() + ThemeUtils.toTitleCase(combinationDefinition.getRodMaterial()) + " " +
                ChatColor.WHITE + ThemeUtils.toTitleCase(combinationDefinition.getPartType());

    }

    public Material getMaterial(CombinationDefinition combinationDefinition) {
        switch (combinationDefinition.getPartType()) {
            case IDStrings.HELMET:
                return Material.LEATHER_HELMET;
            case IDStrings.CHESTPLATE:
                return Material.LEATHER_CHESTPLATE;
            case IDStrings.LEGGINGS:
                return Material.LEATHER_LEGGINGS;
            case IDStrings.BOOTS:
                return Material.LEATHER_BOOTS;
            default:
                throw new IllegalStateException("Unexpected value: " + combinationDefinition.getClassType());
        }
    }

    public ItemStack getStack(CombinationDefinition combinationDefinition) {

        ItemStack itemStack = this.getItem().clone();

        itemStack.setType(getMaterial(combinationDefinition));
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        Experience.setupExpNewTool(c);
        c.set(SlimeTinker.inst().getKeys().getToolInfoIsTool(), PersistentDataType.STRING, "Y");
        c.set(SlimeTinker.inst().getKeys().getToolInfoHeadType(), PersistentDataType.STRING, combinationDefinition.getClassType());
        c.set(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING, combinationDefinition.getPartType());
        c.set(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING, combinationDefinition.getHeadMaterial());
        c.set(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING, combinationDefinition.getBinderMaterial());
        c.set(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING, combinationDefinition.getRodMaterial());
        im.setDisplayName(getName(combinationDefinition));
        itemStack.setItemMeta(im);
        ItemUtils.rebuildToolLore(itemStack);
        return itemStack;
    }

    public ArmourTemplate(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    public static boolean isTool(ItemStack itemStack) {
        return itemStack.hasItemMeta() &&
                itemStack.getItemMeta().getPersistentDataContainer().has(
                        SlimeTinker.inst().getKeys().getToolInfoIsTool(),
                        PersistentDataType.STRING
                );
    }

}

