package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
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

public class ToolTemplateExplosive extends ExplosiveTool {

    public ToolTemplateExplosive(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

    }

    public static boolean isTool(ItemStack itemStack) {
        return itemStack.hasItemMeta() &&
            itemStack.getItemMeta().getPersistentDataContainer().has(
                SlimeTinker.inst().getKeys().getToolInfoIsTool(),
                PersistentDataType.STRING
            );
    }

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
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        Experience.setupExpNew(im);
        c.set(SlimeTinker.inst().getKeys().getToolInfoIsTool(), PersistentDataType.STRING, "Y");
        c.set(SlimeTinker.inst().getKeys().getToolInfoHeadType(), PersistentDataType.STRING, toolDefinition.getClassType());
        c.set(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING, toolDefinition.getPartType());
        c.set(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING, toolDefinition.getHeadMaterial());
        c.set(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING, toolDefinition.getBinderMaterial());
        c.set(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING, toolDefinition.getRodMaterial());
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

