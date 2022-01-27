package io.github.sefiraat.slimetinker.utils;

import io.github.mooy1.infinitylib.common.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterialManager;
import io.github.sefiraat.slimetinker.items.tinkermaterials.recipes.MoltenResult;
import io.github.sefiraat.slimetinker.modifiers.Mod;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ItemUtils {

    private ItemUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void incrementRepair(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable damageable = (Damageable) im;
        assert damageable != null;
        damageable.setDamage(Math.max((damageable.getDamage() - 1), 0));
        itemStack.setItemMeta(im);
    }

    public static void incrementRepair(@Nonnull ItemStack itemStack, int amount) {
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
    public static String getToolMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(Keys.TOOL_INFO_HEAD_MATERIAL, PersistentDataType.STRING)) {
            return null;
        }
        return c.get(Keys.TOOL_INFO_HEAD_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(Keys.ARMOUR_INFO_PLATE_MATERIAL, PersistentDataType.STRING)) {
            return null;
        }
        return c.get(Keys.ARMOUR_INFO_PLATE_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getPartMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        if (im == null) {
            return null;
        }
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (!c.has(Keys.PART_MATERIAL, PersistentDataType.STRING)) {
            return null;
        }
        return c.get(Keys.PART_MATERIAL, PersistentDataType.STRING);
    }

    /**
     * Gets the part's class (Head, Rod, Binder or Plate, Link, Gambeson)
     *
     * @param itemStack The {@link ItemStack} part to check
     * @return Null if not found or the string class.
     */
    @Nullable
    public static String getPartClass(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        return im == null ? null : PersistentDataAPI.getString(im, Keys.PART_CLASS);
    }

    public static boolean partIsTool(@Nonnull String partClass) {
        return partClass.equals(Ids.HEAD)
            || partClass.equals(Ids.BINDING)
            || partClass.equals(Ids.ROD);
    }

    public static boolean partIsArmour(@Nonnull String partClass) {
        return partClass.equals(Ids.PLATE)
            || partClass.equals(Ids.GAMBESON)
            || partClass.equals(Ids.LINKS);
    }

    /**
     * Gets the part's type (Pick, Shovel // Helm, Chest) etc.)
     *
     * @param itemStack The {@link ItemStack} part to check
     * @return Null if not found or the string class.
     */
    @Nullable
    public static String getPartType(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        return im == null ? null : PersistentDataAPI.getString(im, Keys.PART_TYPE);
    }

    public static void rebuildTinkerLore(@Nonnull ItemStack itemStack) {
        if (isTool(itemStack)) {
            rebuildToolLore(itemStack);
        } else if (isArmour(itemStack)) {
            rebuildArmourLore(itemStack);
        }
    }

    private static void rebuildToolLore(@Nonnull ItemStack itemStack) {
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
        lore.add(formatPropertyName(matHead, TinkerMaterialManager.getTraitName(matHead, TraitPartType.HEAD)));
        lore.add(formatPropertyName(matBind, TinkerMaterialManager.getTraitName(matBind, TraitPartType.BINDER)));
        lore.add(formatPropertyName(matRod, TinkerMaterialManager.getTraitName(matRod, TraitPartType.ROD)));
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
            Mod mod = Modifications.getModificationDefinitionsTool().get(entry.getKey());
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

    public static void rebuildArmourLore(@Nonnull ItemStack itemStack) {
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
        lore.add(formatPropertyName(matPlate, TinkerMaterialManager.getTraitName(matPlate, TraitPartType.PLATES)));
        lore.add(formatPropertyName(matGambeson, TinkerMaterialManager.getTraitName(matGambeson, TraitPartType.GAMBESON)));
        lore.add(formatPropertyName(matLinks, TinkerMaterialManager.getTraitName(matLinks, TraitPartType.LINKS)));
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
            Mod mod = Modifications.getModificationDefinitionsArmour().get(entry.getKey());
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

    public static void rebuildTinkerName(@Nonnull ItemStack itemStack) {
        if (isTool(itemStack)) {
            rebuildToolName(itemStack);
        } else if (isArmour(itemStack)) {
            rebuildArmourName(itemStack);
        }
    }

    private static void rebuildToolName(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matHead = getToolHeadMaterial(c);
        String matBind = getToolBindingMaterial(c);
        String matRod = getToolRodMaterial(c);
        String toolType = getToolTypeName(c);

        setName(itemStack, matHead, matBind, matRod, toolType);
    }

    private static void rebuildArmourName(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matPlate = getArmourPlateMaterial(c);
        String matGambeson = getArmourGambesonMaterial(c);
        String matLinks = getArmourLinksMaterial(c);
        String armourType = getArmourTypeName(c);

        setName(itemStack, matPlate, matGambeson, matLinks, armourType);
    }

    private static void setName(@Nonnull ItemStack itemStack, String first, String second, String third, String type) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;

        String name =
            TinkerMaterialManager.getById(first).getColor() + ThemeUtils.toTitleCase(first) + "-" +
                TinkerMaterialManager.getById(second).getColor() + ThemeUtils.toTitleCase(second) + "-" +
                TinkerMaterialManager.getById(third).getColor() + ThemeUtils.toTitleCase(third) + " " +
                ChatColor.WHITE + ThemeUtils.toTitleCase(type);

        im.setDisplayName(name);
        itemStack.setItemMeta(im);
    }

    public static boolean isTinkersBroken(@Nonnull ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        Validate.notNull(damageable, "Damagable is null, this is some BULL YO'");
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    public static void damageTinkersItem(@Nonnull ItemStack itemStack, int amount) {
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

    public static void repairItem(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        Validate.notNull(d, "Damagable is null, this is some BULL YO'");
        d.setDamage(0);
        itemStack.setItemMeta(im);
    }

    public static void repairItem(@Nonnull ItemStack itemStack, int amount) {
        ItemMeta im = itemStack.getItemMeta();
        Damageable d = (Damageable) im;
        Validate.notNull(d, "Damagable is null, this is some BULL YO'");
        d.setDamage(Math.max(d.getDamage() - amount, 0));
        itemStack.setItemMeta(im);
    }

    @Nullable
    public static String getToolHeadMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolHeadMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolHeadMaterial(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.TOOL_INFO_HEAD_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getToolBindingMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolBindingMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolBindingMaterial(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.TOOL_INFO_BINDER_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getToolRodMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolRodMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolRodMaterial(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.TOOL_INFO_ROD_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getToolTypeName(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getToolTypeName(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getToolTypeName(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.TOOL_INFO_TOOL_TYPE, PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourPlateMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourPlateMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourPlateMaterial(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.ARMOUR_INFO_PLATE_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourGambesonMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourGambesonMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourGambesonMaterial(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.ARMOUR_INFO_GAMBESON_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourLinksMaterial(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourLinksMaterial(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourLinksMaterial(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.ARMOUR_INFO_LINKS_MATERIAL, PersistentDataType.STRING);
    }

    @Nullable
    public static String getArmourTypeName(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack with no meta provided.");
        return getArmourTypeName(im.getPersistentDataContainer());
    }

    @Nullable
    public static String getArmourTypeName(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.ARMOUR_INFO_ARMOUR_TYPE, PersistentDataType.STRING);
    }

    @Nonnull
    public static String formatMaterialName(String s) {
        return TinkerMaterialManager.getById(s).getColor() + ThemeUtils.toTitleCase(s);
    }

    @Nonnull
    public static String formatPropertyName(String s, String p) {
        return TinkerMaterialManager.getColorById(s) + p;
    }

    public static boolean isMeltable(ItemStack itemStack) {
        return SlimeTinker.getInstance().getCmManager().meltingRecipes.containsKey(StackUtils.getIdOrType(itemStack));
    }

    public static MoltenResult getMoltenResult(ItemStack itemStack) {
        return SlimeTinker.getInstance().getCmManager().meltingRecipes.get(StackUtils.getIdOrType(itemStack));
    }

    public static boolean doesUnequipWhenBroken(ItemStack itemStack) {
        return !getArmourPlateMaterial(itemStack).equals(Ids.DURALUMIN);
    }

    /**
     * Checks if the given stack is a Tinker's Tool
     *
     * @param itemStack Stack to check
     * @return true if Tinker's Tool
     */
    public static boolean isTool(@Nullable ItemStack itemStack) {
        return itemStack != null &&
            itemStack.getType() != Material.AIR &&
            itemStack.hasItemMeta() &&
            itemStack.getItemMeta().getPersistentDataContainer().has(
                Keys.TOOL_INFO_TOOL_TYPE,
                PersistentDataType.STRING
            );
    }

    /**
     * Checks if the given stack is a Tinker's Armour Piece
     *
     * @param itemStack Stack to check
     * @return true if Tinker's Armour Piece
     */
    public static boolean isArmour(@Nullable ItemStack itemStack) {
        return itemStack != null &&
            itemStack.getType() != Material.AIR &&
            itemStack.hasItemMeta() &&
            itemStack.getItemMeta().getPersistentDataContainer().has(
                Keys.ARMOUR_INFO_ARMOUR_TYPE,
                PersistentDataType.STRING
            );
    }

    public static boolean isTinkers(@Nullable ItemStack itemStack) {
        return isTool(itemStack) || isArmour(itemStack);
    }

    public static boolean doesNotWorkWhenBroken(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return
                !getToolHeadMaterial(itemStack).equals(Ids.DURALUMIN)
                    && !getToolRodMaterial(itemStack).equals(Ids.TITANIUM);

        }
        return true;
    }

    public static boolean repairBenchEasyFix(ItemStack itemStack) {
        return repairBenchEasyFix1(itemStack) || repairBenchEasyFix2(itemStack);
    }

    public static boolean repairBenchEasyFix1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(Ids.DURALUMIN);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(Ids.ALUMINUM);
        }
        return false;
    }

    public static boolean repairBenchEasyFix2(ItemStack itemStack) {
        if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(Ids.ALUMINUM_SINGULARITY);
        }
        return false;
    }

    public static boolean isEnchanting(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolHeadMaterial(itemStack).equals(Ids.SILVER)
                || getToolHeadMaterial(itemStack).equals(Ids.SILVER_SINGULARITY);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(Ids.SILVER)
                || getArmourLinksMaterial(itemStack).equals(Ids.SILVER_SINGULARITY);
        } else {
            return false;
        }
    }

    public static boolean isEnchanting1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolHeadMaterial(itemStack).equals(Ids.SILVER);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(Ids.SILVER);
        } else {
            return false;
        }
    }

    public static boolean isEnchanting2(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolHeadMaterial(itemStack).equals(Ids.SILVER_SINGULARITY);
        } else if (isArmour(itemStack)) {
            return getArmourLinksMaterial(itemStack).equals(Ids.SILVER_SINGULARITY);
        } else {
            return false;
        }
    }

    public static boolean isConductive(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(Ids.COPPER)
                || getToolRodMaterial(itemStack).equals(Ids.COPPER_SINGULARITY);
        } else {
            return false;
        }
    }

    public static boolean isConductive1(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(Ids.COPPER);
        } else {
            return false;
        }
    }

    public static boolean isConductive2(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(Ids.COPPER_SINGULARITY);
        } else {
            return false;
        }
    }

    public static boolean cannotDrop(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return
                getToolRodMaterial(itemStack).equals(Ids.SOLDER)
                    || getToolRodMaterial(itemStack).equals(Ids.UNPATENTABLIUM);
        } else if (isArmour(itemStack)) {
            return
                getArmourLinksMaterial(itemStack).equals(Ids.SOLDER);
        } else {
            return false;
        }

    }

    public static boolean isReinforced(ItemStack itemStack) {
        if (isTool(itemStack)) {
            return getToolRodMaterial(itemStack).equals(Ids.REINFORCED_ALLOY);
        } else if (isArmour(itemStack)) {
            return getArmourPlateMaterial(itemStack).equals(Ids.REINFORCED_ALLOY);
        } else {
            return false;
        }
    }

    public static boolean isExperienced(ItemStack itemStack) {
        return getArmourPlateMaterial(itemStack).equals(Ids.REINFORCED_ALLOY);
    }

    public static int getTinkerExp(@Nonnull PersistentDataContainer c) {
        Integer i = c.get(Keys.ST_EXP_CURRENT, PersistentDataType.INTEGER);
        return i != null ? i : 0;
    }

    public static int getTinkerExp(ItemStack itemStack) {
        if (itemStack == null) return 0;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        return getTinkerExp(c);
    }

    public static int getTinkerRequiredExp(@Nonnull PersistentDataContainer c) {
        return c.get(Keys.ST_EXP_REQUIRED, PersistentDataType.DOUBLE).intValue();
    }

    public static int getTinkerRequiredExp(ItemStack itemStack) {
        if (itemStack == null) return 0;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        return getTinkerRequiredExp(c);
    }

    public static int getTinkerLevel(@Nonnull PersistentDataContainer c) {
        Integer i = c.get(Keys.ST_LEVEL, PersistentDataType.INTEGER);
        return i != null ? i : 0;
    }

    public static int getTinkerLevel(ItemStack itemStack) {
        if (itemStack == null) return 0;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        return getTinkerLevel(c);
    }

    public static int getTinkerModifierSlots(@Nonnull PersistentDataContainer c) {
        Integer i = c.get(Keys.ST_MOD_SLOTS, PersistentDataType.INTEGER);
        return i != null ? i : 0;
    }

    public static int getTinkerModifierSlots(ItemStack itemStack) {
        if (itemStack == null) return 0;
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "ItemStack does not have meta");
        PersistentDataContainer c = im.getPersistentDataContainer();
        return getTinkerModifierSlots(c);
    }

    public static void setTinkerModifierSlots(@Nonnull PersistentDataContainer c, int amount) {
        c.set(Keys.ST_MOD_SLOTS, PersistentDataType.INTEGER, amount);
    }

    @Nonnull
    public static String getLoreExp(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Level: " +
            ChatColor.WHITE + getTinkerLevel(c) +
            ThemeUtils.PASSIVE + " (" + getTinkerExp(c) + " / " + getTinkerRequiredExp(c) + ")";
    }

    @Nonnull
    public static String getLoreModSlots(PersistentDataContainer c) {
        return ThemeUtils.ITEM_TOOL + "Modifier Slots: " +
            ChatColor.WHITE + getTinkerModifierSlots(c);
    }

    public static boolean rejectCraftingRecipe(@Nonnull SlimefunItemStack i) {
        return rejectCraftingRecipe(i.getItemId());
    }

    public static boolean rejectCraftingRecipe(@Nonnull SlimefunItem i) {
        return rejectCraftingRecipe(i.getId());
    }

    public static boolean rejectCraftingRecipe(String s) {
        return isBackpack(s);
    }

    public static boolean isBackpack(@Nonnull String s) {
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

    public static boolean onCooldown(@Nonnull ItemStack i, String name) {
        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, THIS PARTY BE POPPIN'");
        NamespacedKey key = new NamespacedKey(SlimeTinker.getInstance(), "cooldown_" + name);
        long time = System.currentTimeMillis();
        long cd = PersistentDataAPI.getLong(im, key, 0);
        return cd > time;
    }

    public static void setCooldown(@Nonnull ItemStack i, String name, long duration) {
        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, sigh");
        NamespacedKey key = new NamespacedKey(SlimeTinker.getInstance(), "cooldown_" + name);
        long time = System.currentTimeMillis();
        long cd = time + duration;
        PersistentDataAPI.setLong(im, key, cd);
        i.setItemMeta(im);
    }

    public static boolean isToolExplosive(@Nonnull ItemStack itemStack) {
        ItemMeta im = itemStack.getItemMeta();
        Validate.notNull(im, "Meta is null, nerd.");
        return isToolExplosive(im.getPersistentDataContainer());
    }

    public static boolean isToolExplosive(@Nonnull PersistentDataContainer c) {
        NamespacedKey sfIDKey = new NamespacedKey(Slimefun.instance(), "slimefun_item");
        String sID = c.get(sfIDKey, PersistentDataType.STRING);
        return sID.contains("_EXP");
    }

    public static boolean isToolExplosive(@Nonnull String headMaterial, String rodMaterial) {
        return headMaterial.equals(Ids.REINFORCED_ALLOY)
            || rodMaterial.equals(Ids.HARDENED_METAL)
            || headMaterial.equals(Ids.INFINITY_SINGULARITY)
            || headMaterial.equals(Ids.OSMIUM);
    }

    @Nullable
    public static ItemStack getItemByID(@Nonnull String id) {
        return getItemByID(id, 1);
    }

    @Nullable
    public static ItemStack getItemByID(@Nonnull String id, int amount) {
        SlimefunItem sfItem = SlimefunItem.getById(id);
        if (sfItem != null) {
            return new CustomItemStack(sfItem.getItem(), amount);
        } else {
            return null;
        }
    }

    @Nonnull
    public static ItemStack[] getMiddleOnlyRecipe(@Nonnull ItemStack item) {
        return new ItemStack[]{
            null, null, null,
            null, item, null,
            null, null, null
        };
    }
}
