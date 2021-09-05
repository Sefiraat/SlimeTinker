package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ToolTemplate extends SlimefunItem implements NotPlaceable {

    public String getName(ToolDefinition toolDefinition) {
        return
                CMManager.getById(toolDefinition.getHeadMaterial()).getColor() + ThemeUtils.toTitleCase(toolDefinition.getHeadMaterial()) + "-" +
                CMManager.getById(toolDefinition.getBinderMaterial()).getColor() + ThemeUtils.toTitleCase(toolDefinition.getBinderMaterial()) + "-" +
                CMManager.getById(toolDefinition.getRodMaterial()).getColor() + ThemeUtils.toTitleCase(toolDefinition.getRodMaterial()) + " " +
                ChatColor.WHITE + ThemeUtils.toTitleCase(toolDefinition.getPartType());

    }

    public Material getMaterial(ToolDefinition toolDefinition) {
        switch (toolDefinition.getPartType()) {
            case IDStrings.SHOVEL:
                return Material.STONE_SHOVEL;
            case IDStrings.PICKAXE:
                return Material.STONE_PICKAXE;
            case IDStrings.AXE:
                return Material.STONE_AXE;
            case IDStrings.HOE:
                return Material.STONE_HOE;
            case IDStrings.SWORD:
                return Material.STONE_SWORD;
            default:
                throw new IllegalStateException("Unexpected value: " + toolDefinition.getClassType());
        }
    }

    public ItemStack getStack(ToolDefinition toolDefinition) {

        ItemStack itemStack = this.getItem().clone();

        itemStack.setType(getMaterial(toolDefinition));
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "This meta, it be null!");
        Experience.setupExpNew(im);
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getToolInfoIsTool(), "Y");
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getToolInfoHeadType(), toolDefinition.getClassType());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getToolInfoToolType(), toolDefinition.getPartType());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), toolDefinition.getHeadMaterial());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), toolDefinition.getBinderMaterial());
        PersistentDataAPI.setString(im, SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), toolDefinition.getRodMaterial());
        im.setDisplayName(getName(toolDefinition));
        itemStack.setItemMeta(im);
        ItemUtils.rebuildTinkerLore(itemStack);
        return itemStack;
    }

    public ToolTemplate(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

}

