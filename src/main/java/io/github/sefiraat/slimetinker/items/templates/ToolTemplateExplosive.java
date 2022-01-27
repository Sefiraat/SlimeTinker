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
import io.github.thebusybiscuit.slimefun4.implementation.items.tools.ExplosiveTool;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.text.MessageFormat;

public class ToolTemplateExplosive extends ExplosiveTool {

    public ToolTemplateExplosive(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

    }

    public static boolean isTool(ItemStack itemStack) {
        return itemStack.hasItemMeta() &&
            itemStack.getItemMeta().getPersistentDataContainer().has(
                Keys.TOOL_INFO_IS_TOOL,
                PersistentDataType.STRING
            );
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
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        Experience.setupExpNew(im);
        c.set(Keys.TOOL_INFO_IS_TOOL, PersistentDataType.STRING, "Y");
        c.set(Keys.TOOL_INFO_HEAD_TYPE, PersistentDataType.STRING, toolDefinition.getClassType());
        c.set(Keys.TOOL_INFO_TOOL_TYPE, PersistentDataType.STRING, toolDefinition.getPartType());
        c.set(Keys.TOOL_INFO_HEAD_MATERIAL, PersistentDataType.STRING, toolDefinition.getHeadMaterial());
        c.set(Keys.TOOL_INFO_BINDER_MATERIAL, PersistentDataType.STRING, toolDefinition.getBinderMaterial());
        c.set(Keys.TOOL_INFO_ROD_MATERIAL, PersistentDataType.STRING, toolDefinition.getRodMaterial());
        im.setDisplayName(getName(toolDefinition));
        itemStack.setItemMeta(im);
        ItemUtils.rebuildTinkerLore(itemStack);
        return itemStack;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
}

