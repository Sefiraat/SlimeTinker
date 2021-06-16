package io.github.sefiraat.slimetinker.items.templates;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ToolTemplate extends UnplaceableBlock {

    public String getName(ToolDefinition toolDefinition) {
        return
                ChatColor.of(ComponentMaterials.getById(toolDefinition.getHeadMaterial()).getColorHex()) + ThemeUtils.toTitleCase(toolDefinition.getHeadMaterial()) + "-" +
                ChatColor.of(ComponentMaterials.getById(toolDefinition.getBinderMaterial()).getColorHex()) + ThemeUtils.toTitleCase(toolDefinition.getBinderMaterial()) + "-" +
                ChatColor.of(ComponentMaterials.getById(toolDefinition.getRodMaterial()).getColorHex()) + ThemeUtils.toTitleCase(toolDefinition.getRodMaterial()) + " " +
                ChatColor.WHITE + ThemeUtils.toTitleCase(toolDefinition.getPartType());

    }

    public List<String> getLore(ToolDefinition toolDefinition) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(ThemeUtils.CLICK_INFO + "Head : " + ChatColor.of(ComponentMaterials.getById(toolDefinition.getHeadMaterial()).getColorHex()) + ThemeUtils.toTitleCase(toolDefinition.getHeadMaterial()));
        list.add(ThemeUtils.CLICK_INFO + "Binding : " + ChatColor.of(ComponentMaterials.getById(toolDefinition.getBinderMaterial()).getColorHex()) + ThemeUtils.toTitleCase(toolDefinition.getBinderMaterial()));
        list.add(ThemeUtils.CLICK_INFO + "Rod : " + ChatColor.of(ComponentMaterials.getById(toolDefinition.getRodMaterial()).getColorHex()) + ThemeUtils.toTitleCase(toolDefinition.getRodMaterial()));
        list.add("");
        // TODO Properties
        // TODO Exp
        return list;
    }

    public Material getMaterial(ToolDefinition toolDefinition) {
        switch (toolDefinition.getPartType()) {
            case IDStrings.ID_SHOVEL:
                return Material.STONE_SHOVEL;
            case IDStrings.ID_PICKAXE:
                return Material.STONE_PICKAXE;
            case IDStrings.ID_AXE:
                return Material.STONE_AXE;
            case IDStrings.ID_HOE:
                return Material.STONE_HOE;
            case IDStrings.ID_SWORD:
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
        im.setLore(getLore(toolDefinition));
        im.setDisplayName(getName(toolDefinition));
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Tool"), PersistentDataType.STRING, "Y");
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Type_Head"), PersistentDataType.STRING, toolDefinition.getClassType());
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Tool_Type"), PersistentDataType.STRING, toolDefinition.getPartType());
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Material_Head"), PersistentDataType.STRING, toolDefinition.getHeadMaterial());
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Material_Binder"), PersistentDataType.STRING, toolDefinition.getBinderMaterial());
        c.set(new NamespacedKey(SlimeTinker.inst(), "ST_Material_Rod"), PersistentDataType.STRING, toolDefinition.getRodMaterial());
        itemStack.setItemMeta(im);
        return itemStack;
    }

    public ToolTemplate(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    public static boolean isTool(ItemStack itemStack) {
        return itemStack.hasItemMeta() &&
                itemStack.getItemMeta().getPersistentDataContainer().has(
                        new NamespacedKey(SlimeTinker.inst(),"ST_Tool"),
                        PersistentDataType.STRING
                );
    }

}

