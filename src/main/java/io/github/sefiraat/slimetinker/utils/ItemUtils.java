package io.github.sefiraat.slimetinker.utils;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.componentmaterials.cmrecipes.MoltenResult;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
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
        if (!c.has(SlimeTinker.inst().getKeys().getPartMaterial(), PersistentDataType.STRING)) {
            return null;
        }
        return c.get(SlimeTinker.inst().getKeys().getPartMaterial(), PersistentDataType.STRING);
    }

    /**
     * Gets the part's class (Head, Rod, Binder or Plate, Link, Gambeson)
     * @param itemStack The {@link ItemStack} part to check
     * @return Null if not found or the string class.
     */
    @Nullable
    public static String getPartClass(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        return im == null ? null : PersistentDataAPI.getString(im, SlimeTinker.inst().getKeys().getPartClass());
    }

    public static boolean partIsTool(String partClass) {
        return partClass.equals(IDStrings.HEAD)
                || partClass.equals(IDStrings.BINDING)
                || partClass.equals(IDStrings.ROD);
    }

    public static boolean partIsArmour(String partClass) {
        return partClass.equals(IDStrings.PLATE)
                || partClass.equals(IDStrings.GAMBESON)
                || partClass.equals(IDStrings.LINKS);
    }

    /**
     * Gets the part's type (Pick, Shovel // Helm, Chest) etc.)
     * @param itemStack The {@link ItemStack} part to check
     * @return Null if not found or the string class.
     */
    @Nullable
    public static String getPartType(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        return im == null ? null : PersistentDataAPI.getString(im, SlimeTinker.inst().getKeys().getPartType());
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
        Map<String, Integer> mapAmounts = Modifications.getModificationMapTool(itemStack);
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
        Map<String, Integer> mapAmounts = Modifications.getModificationMapArmour(itemStack);
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
        Validate.notNull(damageable, "Damagable is null, this is some BULL YO'");
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    public static void damageTinkersItem(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        Validate.notNull(damageable, "Damagable is null, this is some BULL YO'");
        if ((damageable.getDamage() + amount) >= itemStack.getType().getMaxDurability()) { // This will break the tool, lets stop that!
            damageable.setDamage(itemStack.getType().getMaxDurability() - 1);
        } else {
            damageable.setDamage(damageable.getDamage() + amount);
        }
        itemStack.setItemMeta(im);
    }

    public static void repairItem(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        Validate.notNull(d, "Damagable is null, this is some BULL YO'");
        d.setDamage(0);
        itemStack.setItemMeta(im);
    }

    public static void repairItem(ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        Validate.notNull(d, "Damagable is null, this is some BULL YO'");
        d.setDamage(Math.max(d.getDamage() - amount, 0));
        itemStack.setItemMeta(im);
    }

    @Nullable
    public static String getToolHeadMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolHeadMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoHeadMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getToolBindingMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolBindingMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolBindingMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoBinderMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getToolRodMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolRodMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolRodMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoRodMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getToolTypeName(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolTypeName(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolTypeName(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourPlateMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourPlateMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourPlateMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getArmourInfoPlateMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourGambesonMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourGambesonMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourGambesonMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getArmourInfoGambesonMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourLinksMaterial(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourLinksMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourLinksMaterial(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getArmourInfoLinksMaterial(), PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourTypeName(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourTypeName(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourTypeName(PersistentDataContainer c) {
        return c.get(SlimeTinker.inst().getKeys().getArmourInfoArmourType(), PersistentDataType.STRING);
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

    public boolean doesUnequipWhenBroken(ItemStack itemStack) {
        return !getArmourPlateMaterial(itemStack).equals(IDStrings.DURALIUM);
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

    public static boolean worksWhenBroken(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return
                    getToolHeadMaterial(itemStack).equals(IDStrings.DURALIUM)
                    || getToolRodMaterial(itemStack).equals(IDStrings.TITANIUM);

        }
        return false;
    }

    public static boolean repairBenchEasyFix(ItemStack itemStack) {
        return repairBenchEasyFix1(itemStack) || repairBenchEasyFix2(itemStack);
    }

    public static boolean repairBenchEasyFix1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.DURALIUM);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.ALUMINUM);
        }
        return false;
    }

    public static boolean repairBenchEasyFix2(ItemStack itemStack) {
        if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(IDStrings.SINGALUMINUM);
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
        } else {
            return false;
        }
    }

    public static boolean isConductive1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.COPPER);
        } else {
            return false;
        }
    }

    public static boolean isConductive2(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(IDStrings.SINGCOPPER);
        } else {
            return false;
        }
    }

    public static boolean cannotDrop(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return
                    getToolRodMaterial(itemStack).equals(IDStrings.SOLDER)
                    || getToolRodMaterial(itemStack).equals(IDStrings.UNPATENTABLIUM);
        } else if (isArmour(itemStack)) {
            return
                    getArmourLinksMaterial(itemStack).equals(IDStrings.SOLDER);
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

    public static boolean isExperienced(ItemStack itemStack) {
        return getArmourPlateMaterial(itemStack).equals(IDStrings.REINFORCED);
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
        return getTinkerModifierSlots(c);
    }

    public static void setTinkerModifierSlots(PersistentDataContainer c, int amount) {
        c.set(SlimeTinker.inst().getKeys().getStModSlots(), PersistentDataType.INTEGER, amount);
    }

    public static String getLoreExp(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Level: " +
                ChatColor.WHITE + getTinkerLevel(c) +
                ThemeUtils.PASSIVE + " (" + getTinkerExp(c) + " / " + getTinkerRequiredExp(c) + ")";
    }

    public static String getLoreModSlots(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Modifier Slots: " +
                ChatColor.WHITE + getTinkerModifierSlots(c);
    }

    public static boolean rejectCraftingRecipe(SlimefunItemStack i) {
        return rejectCraftingRecipe(i.getItemId());
    }

    public static boolean rejectCraftingRecipe(SlimefunItem i) {
        return rejectCraftingRecipe(i.getId());
    }

    public static boolean rejectCraftingRecipe(String s) {
        return isBackpack(s);
    }

    public static boolean isBackpack(String s) {
        return s.matches("(.*)BACKPACK(.*)");
    }

    public static void incrementRandomEnchant(ItemStack i, ItemMeta im) {
        Validate.notNull(im, "Mata is null, TIME TO GET GOT!");
        Enchantment randEnchant = Enchantment.values()[(GeneralUtils.roll(Enchantment.values().length, false))];
        if (im.hasEnchant(randEnchant)) {
            im.addEnchant(randEnchant, i.getEnchantmentLevel(randEnchant) + 1, true);
        } else {
            im.addEnchant(randEnchant, 1, true);
        }
    }

    public static boolean onCooldown(ItemStack i, String name) {
        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, THIS PARTY BE POPPIN'");
        NamespacedKey key = new NamespacedKey(SlimeTinker.inst(), "cooldown_" + name);
        long time = System.currentTimeMillis();
        long cd = PersistentDataAPI.getLong(im, key, 0);
        return cd > time;
    }

    public static void setCooldown(ItemStack i, String name, long duration) {
        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, sigh");
        NamespacedKey key = new NamespacedKey(SlimeTinker.inst(), "cooldown_" + name);
        long time = System.currentTimeMillis();
        long cd = time + duration;
        PersistentDataAPI.setLong(im, key, cd);
        i.setItemMeta(im);
    }

    public static boolean isToolExplosive(ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "Meta is null, nerd.");
        return isToolExplosive(im.getPersistentDataContainer());
    }

    public static boolean isToolExplosive(PersistentDataContainer c) {
        NamespacedKey sfIDKey = new NamespacedKey(SlimefunPlugin.instance(), "slimefun_item");
        String sID = c.get(sfIDKey, PersistentDataType.STRING);
        return sID.contains("_EXP");
    }

    public static boolean isToolExplosive(String headMaterial, String rodMaterial) {
        return headMaterial.equals(IDStrings.REINFORCED)
                || rodMaterial.equals(IDStrings.HARD)
                || headMaterial.equals(IDStrings.SINGINFINITY)
                || headMaterial.equals(IDStrings.OSMIUM);
    }

}
