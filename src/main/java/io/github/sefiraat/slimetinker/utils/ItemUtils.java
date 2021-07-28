package io.github.sefiraat.slimetinker.utils;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmrecipes.MoltenResult;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UtilityClass
public final class ItemUtils {

    public static void incrementRepair(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        damageable.setDamage(Math.max((damageable.getDamage() - 1), 0));
        itemStack.setItemMeta(im);
    }

    public static void incrementRepair(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        damageable.setDamage(Math.max((damageable.getDamage() - amount), 0));
        itemStack.setItemMeta(im);
    }

    @Nullable
    public static String getItemName(ItemStack itemStack) {
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (slimefunItem == null) {
            if (!itemStack.hasItemMeta()) {
                return itemStack.getType().toString();
            }
        } else {
            return slimefunItem.getId();
        }
        return null;
    }

    @Nullable
    public static String getToolMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING)) {
            return null;
        }
        return c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(SlimeTinker.inst().getKeys().getArmourInfoPlateMaterial(), PersistentDataType.STRING)) {
            return null;
        }
        return c.get(SlimeTinker.inst().getKeys().getArmourInfoPlateMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getPartMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING)) {
            return null;
        }
        return c.get(SlimeTinker.inst().getKeys().getPartInfoMaterialType(), PersistentDataType.STRING);
    }

    public static void rebuildTinkerLore(ItemStack itemStack) {
        if (isTool(itemStack)) {
            rebuildToolLore(itemStack);
        } else if (isArmour(itemStack)) {
            rebuildArmourLore(itemStack);
        }
    }

    private static void rebuildToolLore(ItemStack itemStack) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        List<String> lore = new ArrayList<>();

        String matHead = getToolHeadMaterial(c);
        String matBind = getToolBindingMaterial(c);
        String matRod = getToolRodMaterial(c);

        // General Material information
        lore.add(ThemeUtils.getLine());
        lore.add(ThemeUtils.CLICK_INFO + "H: " + formatMaterialName(matHead));
        lore.add(ThemeUtils.CLICK_INFO + "B: " + formatMaterialName(matBind));
        lore.add(ThemeUtils.CLICK_INFO + "R: " + formatMaterialName(matRod));
        lore.add(ThemeUtils.getLine());

        // Material properties
        lore.add(formatPropertyName(matHead, CMManager.getTraitName(matHead, TraitPartType.HEAD)));
        lore.add(formatPropertyName(matBind, CMManager.getTraitName(matBind, TraitPartType.BINDER)));
        lore.add(formatPropertyName(matRod, CMManager.getTraitName(matRod, TraitPartType.ROD)));
        lore.add(ThemeUtils.getLine());

        // Exp / Leveling / Mod Slot information
        lore.add(getLoreExp(c));
        lore.add(getLoreModSlots(c));
        lore.add(ThemeUtils.getLine());

        // Active Mods
        Map<String, Integer> mapAmounts = Modifications.getModificationMap(itemStack);
        Map<String, Integer> mapLevels = Modifications.getAllModLevels(itemStack);

        for (Map.Entry<String, Integer> entry : mapLevels.entrySet()) {
            int level = entry.getValue();
            Mod mod = Modifications.getMODIFICATION_DEFINITIONS_TOOL().get(entry.getKey());
            if (mod.getRequirementMap().containsKey(level + 1)) {
                String amountRequired = String.valueOf(mod.getRequirementMap().get(level + 1));
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (" + mapAmounts.get(entry.getKey()) + "/" + amountRequired + ")");
            } else {
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (MAX)");
            }
        }
        if (!mapLevels.isEmpty()) {
            lore.add(ThemeUtils.getLine());
        }

        im.setLore(lore);
        itemStack.setItemMeta(im);

    }

    public static void rebuildArmourLore(ItemStack itemStack) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        List<String> lore = new ArrayList<>();

        String matPlate = getArmourPlateMaterial(c);
        String matGambeson = getArmourGambesonMaterial(c);
        String matLinks = getArmourLinksMaterial(c);

        // General Material information
        lore.add(ThemeUtils.getLine());
        lore.add(ThemeUtils.CLICK_INFO + "P: " + formatMaterialName(matPlate));
        lore.add(ThemeUtils.CLICK_INFO + "G: " + formatMaterialName(matGambeson));
        lore.add(ThemeUtils.CLICK_INFO + "L: " + formatMaterialName(matLinks));
        lore.add(ThemeUtils.getLine());

        // Material properties
        lore.add(formatPropertyName(matPlate, CMManager.getTraitName(matPlate, TraitPartType.PLATE)));
        lore.add(formatPropertyName(matGambeson, CMManager.getTraitName(matGambeson, TraitPartType.GAMBESON)));
        lore.add(formatPropertyName(matLinks, CMManager.getTraitName(matLinks, TraitPartType.LINKS)));
        lore.add(ThemeUtils.getLine());

        // Exp / Leveling / Mod Slot information
        lore.add(getLoreExp(c));
        lore.add(getLoreModSlots(c));
        lore.add(ThemeUtils.getLine());

        // Active Mods
        Map<String, Integer> mapAmounts = Modifications.getModificationMap(itemStack);
        Map<String, Integer> mapLevels = Modifications.getAllModLevels(itemStack);

        for (Map.Entry<String, Integer> entry : mapLevels.entrySet()) {
            int level = entry.getValue();
            Mod mod = Modifications.getMODIFICATION_DEFINITIONS_ARMOUR().get(entry.getKey());
            if (mod.getRequirementMap().containsKey(level + 1)) {
                String amountRequired = String.valueOf(mod.getRequirementMap().get(level + 1));
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (" + mapAmounts.get(entry.getKey()) + "/" + amountRequired + ")");
            } else {
                lore.add(ThemeUtils.CLICK_INFO + ThemeUtils.toTitleCase(entry.getKey()) + " Level " + entry.getValue() + ThemeUtils.PASSIVE + " - (MAX)");
            }
        }
        if (!mapLevels.isEmpty()) {
            lore.add(ThemeUtils.getLine());
        }

        im.setLore(lore);
        itemStack.setItemMeta(im);

    }

    public static void rebuildTinkerName(ItemStack itemStack) {
        if (isTool(itemStack)) {
            rebuildToolName(itemStack);
        } else if (isArmour(itemStack)) {
            rebuildArmourName(itemStack);
        }
    }

    private static void rebuildToolName(ItemStack itemStack) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matHead = getToolHeadMaterial(c);
        String matBind = getToolBindingMaterial(c);
        String matRod = getToolRodMaterial(c);
        String toolType = getToolTypeName(c);

        setName(itemStack, matHead, matBind, matRod, toolType);

    }

    private static void rebuildArmourName(ItemStack itemStack) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matPlate = getArmourPlateMaterial(c);
        String matGambeson = getArmourGambesonMaterial(c);
        String matLinks = getArmourLinksMaterial(c);
        String armourType = getArmourTypeName(c);

        setName(itemStack, matPlate, matGambeson, matLinks, armourType);

    }

    private static void setName(ItemStack itemStack, String first, String second, String third, String type) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;

        String name =
                CMManager.getById(first).getColor() + ThemeUtils.toTitleCase(first) + "-" +
                        CMManager.getById(second).getColor() + ThemeUtils.toTitleCase(second) + "-" +
                        CMManager.getById(third).getColor() + ThemeUtils.toTitleCase(third) + " " +
                        ChatColor.WHITE + ThemeUtils.toTitleCase(type);

        im.setDisplayName(name);
        itemStack.setItemMeta(im);
    }

    public static boolean isTinkersBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    public static void damageTool(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        if ((damageable.getDamage() + amount) >= itemStack.getType().getMaxDurability()) { // This will break the tool, lets stop that!
            damageable.setDamage(itemStack.getType().getMaxDurability() - 1);
        } else {
            damageable.setDamage(damageable.getDamage() + amount);
        }
        itemStack.setItemMeta(im);
    }

    public static void repairTool(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        assert d != null;
        d.setDamage(0);
        itemStack.setItemMeta(im);
    }

    public static void repairTool(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        assert d != null;
        d.setDamage(Math.max(d.getDamage() - amount, 0));
        itemStack.setItemMeta(im);
    }

    public static String getToolHeadMaterial(PersistentDataContainer c) {
        String s = c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getToolHeadMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getToolBindingMaterial(PersistentDataContainer c) {
        String s =  c.get(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getToolBindingMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getToolRodMaterial(PersistentDataContainer c) {
        String s =  c.get(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getToolRodMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getToolTypeName(PersistentDataContainer c) {
        String s = c.get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getToolTypeName(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getArmourPlateMaterial(PersistentDataContainer c) {
        String s = c.get(SlimeTinker.inst().getKeys().getArmourInfoPlateMaterial(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getArmourPlateMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getArmourGambesonMaterial(PersistentDataContainer c) {
        String s =  c.get(SlimeTinker.inst().getKeys().getArmourInfoGambesonMaterial(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getArmourGambesonMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getArmourLinksMaterial(PersistentDataContainer c) {
        String s =  c.get(SlimeTinker.inst().getKeys().getArmourInfoLinksMaterial(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getArmourLinksMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String getArmourTypeName(PersistentDataContainer c) {
        String s = c.get(SlimeTinker.inst().getKeys().getArmourInfoArmourType(), PersistentDataType.STRING);
        Validate.notNull(s, "No material found for ItemStack, not a Tinker's tool/armour?");
        return s;
    }

    public static String getArmourTypeName(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    public static String formatMaterialName(String s) {
        return CMManager.getById(s).getColor() + ThemeUtils.toTitleCase(s);
    }

    public static String formatPropertyName(String s, String p) {
        return CMManager.getColorById(s) + p;
    }

    public static boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.inst().getCmManager().meltingRecipes.containsKey(StackUtils.getIDorType(itemStack));
    }

    public static MoltenResult getMoltenResult(ItemStack itemStack) {
        return SlimeTinker.inst().getCmManager().meltingRecipes.get(StackUtils.getIDorType(itemStack));
    }

    public boolean doesNotUnequip(ItemStack itemStack) {
        String plateMat = getArmourPlateMaterial(itemStack);
        String gambesonMat = getArmourGambesonMaterial(itemStack);
        String linksMat = getArmourLinksMaterial(itemStack);
        return plateMat == IDStrings.DURALIUM;
    }

    /**
     * Checks if the given stack is a Tinker's Tool
     * @param itemStack Stack to check
     * @return true if Tinker's Tool
     */
    public static boolean isTool(ItemStack itemStack) {
        return  itemStack != null &&
                itemStack.getType() != Material.AIR &&
                itemStack.hasItemMeta() &&
                itemStack.getItemMeta().getPersistentDataContainer().has(
                        SlimeTinker.inst().getKeys().getToolInfoIsTool(),
                        PersistentDataType.STRING
                );
    }

    /**
     * Checks if the given stack is a Tinker's Armour Piece
     * @param itemStack Stack to check
     * @return true if Tinker's Armour Piece
     */
    public static boolean isArmour(@Nullable ItemStack itemStack) {
        return  itemStack != null &&
                itemStack.getType() != Material.AIR &&
                itemStack.hasItemMeta() &&
                itemStack.getItemMeta().getPersistentDataContainer().has(
                        SlimeTinker.inst().getKeys().getArmourInfoIsArmour(),
                        PersistentDataType.STRING
                );
    }

    public static boolean repairBenchEasyFix(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.DURALIUM);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.ALUMINUM);
        }
        return false;
    }

    public static boolean isEnchanting(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolHeadMaterial(itemStack).equals(IDStrings.SILVER)
                    || getToolHeadMaterial(itemStack).equals(IDStrings.SINGSILVER);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.SILVER)
                    || getArmourLinksMaterial(itemStack).equals(IDStrings.SINGSILVER);
        } else {
            return false;
        }
    }

    public static boolean isEnchanting1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolHeadMaterial(itemStack).equals(IDStrings.SILVER);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.SILVER);
        } else {
            return false;
        }
    }

    public static boolean isEnchanting2(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolHeadMaterial(itemStack).equals(IDStrings.SINGSILVER);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.SINGSILVER);
        } else {
            return false;
        }
    }

    public static boolean isConductive(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.COPPER)
                    || getToolRodMaterial(itemStack).equals(IDStrings.SINGCOPPER);
        } else if (isArmour(itemStack)) {
            return false;
        } else {
            return false;
        }
    }

    public static boolean isConductive1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.COPPER);
        } else if (isArmour(itemStack)) {
            return false;
        } else {
            return false;
        }
    }

    public static boolean isConductive2(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.SINGCOPPER);
        } else if (isArmour(itemStack)) {
            return false;
        } else {
            return false;
        }
    }

    public static boolean canBeDropped(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.SOLDER)
                    || getToolRodMaterial(itemStack).equals(IDStrings.UNPATENTABLIUM);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.SOLDER);
        } else {
            return false;
        }

    }

    public static boolean isReinforced(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.REINFORCED);
        } else if (isArmour(itemStack)) {
            return getArmourPlateMaterial(itemStack).equals(IDStrings.REINFORCED);
        } else {
            return false;
        }
    }

    @Nonnull
    public static Integer getTinkerExp(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getStExpCurrent(), PersistentDataType.INTEGER);
    }

    @Nullable
    public static Integer getTinkerExp(ItemStack itemStack) {
        if (itemStack == null) return null;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        Validate.notNull(c, "ItemStack does not have PDC");
        return getTinkerExp(c);
    }

    @Nonnull
    public static Integer getTinkerRequiredExp(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getStExpRequired(), PersistentDataType.DOUBLE).intValue();
    }

    @Nullable
    public static Integer getTinkerRequiredExp(ItemStack itemStack) {
        if (itemStack == null) return null;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        Validate.notNull(c, "ItemStack does not have PDC");
        return getTinkerRequiredExp(c);
    }

    @Nonnull
    public static Integer getTinkerLevel(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getStLevel(), PersistentDataType.INTEGER);
    }

    @Nullable
    public static Integer getTinkerLevel(ItemStack itemStack) {
        if (itemStack == null) return null;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        Validate.notNull(c, "ItemStack does not have PDC");
        return getTinkerLevel(c);
    }

    public static int getTinkerModifierSlots(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getStModSlots(), PersistentDataType.INTEGER);
    }

    @Nullable
    public static Integer getTinkerModifierSlots(ItemStack itemStack) {
        if (itemStack == null) return null;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        Validate.notNull(c, "ItemStack does not have PDC");
        return getTinkerModifierSlots(c);
    }

    public static void setTinkerModifierSlots(PersistentDataContainer c, int amount) {
        c.set(SlimeTinker.inst().getKeys().getStModSlots(), PersistentDataType.INTEGER, amount);
    }

    public static String getLoreExp(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Level: " +
                org.bukkit.ChatColor.WHITE + getTinkerLevel(c) +
                ThemeUtils.PASSIVE + " (" + getTinkerExp(c) + " / " + getTinkerRequiredExp(c) + ")";
    }

    public static String getLoreModSlots(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Modifier Slots: " +
                org.bukkit.ChatColor.WHITE + getTinkerModifierSlots(c);
    }
}
