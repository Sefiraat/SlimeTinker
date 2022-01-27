package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterialManager;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.Keys;
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

import java.text.MessageFormat;

public class ToolTemplate extends SlimefunItem implements NotPlaceable {

    public ToolTemplate(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public String getName(ToolDefinition toolDefinition) {
        return MessageFormat.format(
            "{0}{1}-{2}{3}-{4}{5} {6}{7}",
            TinkerMaterialManager.getById(toolDefinition.getHeadMaterial()).getColor(),
            ThemeUtils.toTitleCase(toolDefinition.getHeadMaterial()),
            TinkerMaterialManager.getById(toolDefinition.getBinderMaterial()).getColor(),
            ThemeUtils.toTitleCase(toolDefinition.getBinderMaterial()),
            TinkerMaterialManager.getById(toolDefinition.getRodMaterial()).getColor(),
            ThemeUtils.toTitleCase(toolDefinition.getRodMaterial()),
            ChatColor.WHITE,
            ThemeUtils.toTitleCase(toolDefinition.getPartType())
        );
    }

    public Material getMaterial(ToolDefinition toolDefinition) {
        switch (toolDefinition.getPartType()) {
            case Ids.SHOVEL:
                return Material.STONE_SHOVEL;
            case Ids.PICKAXE:
                return Material.STONE_PICKAXE;
            case Ids.AXE:
                return Material.STONE_AXE;
            case Ids.HOE:
                return Material.STONE_HOE;
            case Ids.SWORD:
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
        PersistentDataAPI.setString(im, Keys.TOOL_INFO_IS_TOOL, "Y");
        PersistentDataAPI.setString(im, Keys.TOOL_INFO_HEAD_TYPE, toolDefinition.getClassType());
        PersistentDataAPI.setString(im, Keys.TOOL_INFO_TOOL_TYPE, toolDefinition.getPartType());
        PersistentDataAPI.setString(im, Keys.TOOL_INFO_HEAD_MATERIAL, toolDefinition.getHeadMaterial());
        PersistentDataAPI.setString(im, Keys.TOOL_INFO_BINDER_MATERIAL, toolDefinition.getBinderMaterial());
        PersistentDataAPI.setString(im, Keys.TOOL_INFO_ROD_MATERIAL, toolDefinition.getRodMaterial());
        im.setDisplayName(getName(toolDefinition));
        itemStack.setItemMeta(im);
        ItemUtils.rebuildTinkerLore(itemStack);
        return itemStack;
    }

}

