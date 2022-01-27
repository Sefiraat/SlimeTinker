package io.github.sefiraat.slimetinker.items.tinkermaterials;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.tinkermaterials.elements.Alloy;
import io.github.sefiraat.slimetinker.items.tinkermaterials.recipes.CastResult;
import io.github.sefiraat.slimetinker.items.tinkermaterials.recipes.MoltenResult;
import io.github.sefiraat.slimetinker.items.tinkermaterials.setup.TinkersMaterialsCore;
import io.github.sefiraat.slimetinker.items.tinkermaterials.setup.TinkersMaterialsDynatech;
import io.github.sefiraat.slimetinker.items.tinkermaterials.setup.TinkersMaterialsInfinity;
import io.github.sefiraat.slimetinker.items.tinkermaterials.setup.TinkersMaterialsLiteXpansion;
import io.github.sefiraat.slimetinker.items.tinkermaterials.setup.TinkersMaterialsSlimefunWarfare;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.managers.TraitManager;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinkerMaterialManager {

    // Base
    public static final int AMOUNT_NUGGET = 1;

    // Calculated
    public static final int AMOUNT_INGOT = AMOUNT_NUGGET * 9;
    public static final int AMOUNT_ORE = AMOUNT_INGOT * 2;
    public static final int AMOUNT_BLOCK = AMOUNT_INGOT * 9;
    public static final int AMOUNT_BOOT = AMOUNT_INGOT * 4;
    public static final int AMOUNT_LEG = AMOUNT_INGOT * 7;
    public static final int AMOUNT_CHEST = AMOUNT_INGOT * 8;
    public static final int AMOUNT_HELM = AMOUNT_INGOT * 5;
    public static final int AMOUNT_DUST = AMOUNT_INGOT;
    public static final int AMOUNT_GEM = AMOUNT_INGOT;
    public static final int AMOUNT_CAST = AMOUNT_INGOT * 2;
    public static final int AMOUNT_KIT = AMOUNT_INGOT * 3;
    public static final int AMOUNT_BUCKET = AMOUNT_BLOCK * 9;
    public static final int AMOUNT_SHOVELHEAD = AMOUNT_INGOT;
    public static final int AMOUNT_PICKAXEHEAD = AMOUNT_INGOT * 3;
    public static final int AMOUNT_AXEHEAD = AMOUNT_INGOT * 3;
    public static final int AMOUNT_HOEHEAD = AMOUNT_INGOT * 2;
    public static final int AMOUNT_SWORDBLADE = AMOUNT_INGOT * 2;
    public static final int AMOUNT_TOOLROD = AMOUNT_INGOT;
    public static final int AMOUNT_ARM_HELM = AMOUNT_INGOT * 5;
    public static final int AMOUNT_ARM_CHEST = AMOUNT_INGOT * 8;
    public static final int AMOUNT_ARM_LEG = AMOUNT_INGOT * 7;
    public static final int AMOUNT_ARM_BOOT = AMOUNT_INGOT * 4;
    public static final int AMOUNT_ARM_LINKS = AMOUNT_INGOT * 2;

    // Dies (Items that makes casts and then burn away)
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_NUGGET = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_INGOT = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_BLOCK = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_GEM = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_SHOVELHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_PICKAXEHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_AXEHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_HOEHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_SWORDBLADE = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_TOOLROD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_ARMOUR_PLATES_HELM = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_ARMOUR_PLATES_CHEST = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_ARMOUR_PLATES_LEGGINGS = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_ARMOUR_PLATES_BOOTS = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_ARMOUR_MAIL = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_DIE_REPAIRKIT = new HashMap<>();

    // Casts (Items that cast metals and remain)
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_NUGGET = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_INGOT = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_BLOCK = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_GEM = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_SHOVELHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_PICKAXEHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_AXEHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_HOEHEAD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_SWORDBLADE = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_TOOLROD = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_ARMOUR_PLATES_HELM = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_ARMOUR_PLATES_CHEST = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_ARMOUR_PLATES_LEGGINGS = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_ARMOUR_PLATES_BOOTS = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_ARMOUR_MAIL = new HashMap<>();
    protected static final Map<TinkerMaterial, ItemStack> MAP_CAST_REPAIRKIT = new HashMap<>();

    private static final Map<String, TinkerMaterial> MAP = new HashMap<>();
    private static final String VALIDATE_TRAIT_MESSAGE = "The material {0} does not have a compatible trait type of {1}";

    public final Map<String, MoltenResult> meltingRecipes = new HashMap<>();
    public final Map<String, CastResult> castingRecipes = new HashMap<>();

    public TinkerMaterialManager() {

        // Adds all the Vanilla / Core slimefun ComponentMaterials into the map.
        MAP.putAll(TinkersMaterialsCore.getCmMap());

        // Adds expansion ComponentMaterials if they are on the server
        if (SupportedPluginsManager.INFINITY_EXPANSION) {
            MAP.putAll(TinkersMaterialsInfinity.getCmMap());
        }
        if (SupportedPluginsManager.SLIMEFUN_WARFARE) {
            MAP.putAll(TinkersMaterialsSlimefunWarfare.getCmMap());
        }
        if (SupportedPluginsManager.DYNATECH) {
            MAP.putAll(TinkersMaterialsDynatech.getCmMap());
        }
        if (SupportedPluginsManager.LITEXPANSION) {
            MAP.putAll(TinkersMaterialsLiteXpansion.getCmMap());
        }

        TraitManager traitManager = SlimeTinker.getInstance().getTraitManager();

        // Add melting recipes
        for (Map.Entry<String, TinkerMaterial> entry : MAP.entrySet()) {

            TinkerMaterial cm = entry.getValue();
            String id = entry.getKey();

            // Tools, armour and kits (referenced through dummy)
            if (cm.getTraitToolRod() != null && traitManager.isEnabled(id, Ids.ROD)) {
                MAP_CAST_TOOLROD.put(cm, Parts.TOOL_ROD.getStack(id, Ids.ROD, null, cm.getColor()));
            }
            if (cm.getTraitArmorLinks() != null && traitManager.isEnabled(id, Ids.LINKS)) {
                MAP_CAST_ARMOUR_MAIL.put(cm, Parts.MAIL_LINKS.getStack(id, Ids.LINKS, null, cm.getColor()));
            }

            if (cm.getTraitToolHead() != null && traitManager.isEnabled(id, Ids.HEAD)) {
                MAP_CAST_SWORDBLADE.put(cm, Parts.SWORD_BLADE.getStack(id, Ids.HEAD, Ids.SWORD, cm.getColor()));
                MAP_CAST_HOEHEAD.put(cm, Parts.HOE_HEAD.getStack(id, Ids.HEAD, Ids.HOE, cm.getColor()));
                MAP_CAST_AXEHEAD.put(cm, Parts.AXE_HEAD.getStack(id, Ids.HEAD, Ids.AXE, cm.getColor()));
                MAP_CAST_PICKAXEHEAD.put(cm, Parts.PICKAXE_HEAD.getStack(id, Ids.HEAD, Ids.PICKAXE, cm.getColor()));
                MAP_CAST_SHOVELHEAD.put(cm, Parts.SHOVEL_HEAD.getStack(id, Ids.HEAD, Ids.SHOVEL, cm.getColor()));
            }

            if (cm.getTraitArmorPlates() != null && traitManager.isEnabled(id, Ids.PLATE)) {
                MAP_CAST_ARMOUR_PLATES_HELM.put(cm, Parts.HELM_PLATE.getStack(id, Ids.PLATE, Ids.HELMET, cm.getColor()));
                MAP_CAST_ARMOUR_PLATES_CHEST.put(cm, Parts.CHEST_PLATE.getStack(id, Ids.PLATE, Ids.CHESTPLATE, cm.getColor()));
                MAP_CAST_ARMOUR_PLATES_LEGGINGS.put(cm, Parts.LEG_PLATE.getStack(id, Ids.PLATE, Ids.LEGGINGS, cm.getColor()));
                MAP_CAST_ARMOUR_PLATES_BOOTS.put(cm, Parts.BOOT_PLATE.getStack(id, Ids.PLATE, Ids.BOOTS, cm.getColor()));
            }

            if (cm.getTraitToolHead() != null || cm.getTraitArmorPlates() != null) {
                MAP_CAST_REPAIRKIT.put(cm, Parts.REPAIR_KIT.getStack(id, Ids.REPAIR, cm.getColor())); // We use HEAD here are repair always goes by head material
            }

            // Gems
            if (cm.getFormGem() != null) {
                ItemStack i = ItemUtils.getItemByID(cm.getFormGem());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(cm.getFormGem()));
                }
                MAP_CAST_GEM.put(cm, i);
                meltingRecipes.put(cm.getFormGem(), new MoltenResult(cm, AMOUNT_GEM));
            }

            // Blocks
            if (cm.getFormBlock() != null) {
                ItemStack i = ItemUtils.getItemByID(cm.getFormBlock());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(cm.getFormBlock()));
                }
                MAP_CAST_BLOCK.put(cm, i);
                meltingRecipes.put(cm.getFormBlock(), new MoltenResult(cm, AMOUNT_BLOCK));
            }

            // Ingots
            if (cm.getFormIngot() != null) {
                ItemStack i = ItemUtils.getItemByID(cm.getFormIngot());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(cm.getFormIngot()));
                }
                MAP_CAST_INGOT.put(cm, i);
                meltingRecipes.put(cm.getFormIngot(), new MoltenResult(cm, AMOUNT_INGOT));
            }

            // Nuggets
            if (cm.getFormNugget() != null) {
                ItemStack i = ItemUtils.getItemByID(cm.getFormNugget());
                if (i == null) {
                    i = new ItemStack(Material.valueOf(cm.getFormNugget()));
                }
                MAP_CAST_NUGGET.put(cm, i);
                meltingRecipes.put(cm.getFormNugget(), new MoltenResult(cm, AMOUNT_NUGGET));
            }

            // Ores
            if (cm.getFormOre() != null) {
                meltingRecipes.put(cm.getFormOre(), new MoltenResult(cm, AMOUNT_ORE));
            }

            // Dusts
            if (cm.getFormDust() != null) {
                meltingRecipes.put(cm.getFormDust(), new MoltenResult(cm, AMOUNT_DUST));
            }

            // Helm
            if (cm.getFormHelmet() != null) {
                meltingRecipes.put(cm.getFormHelmet(), new MoltenResult(cm, AMOUNT_HELM));
            }

            // Chest
            if (cm.getFormChestplate() != null) {
                meltingRecipes.put(cm.getFormChestplate(), new MoltenResult(cm, AMOUNT_CHEST));
            }

            // Leg
            if (cm.getFormLeggings() != null) {
                meltingRecipes.put(cm.getFormLeggings(), new MoltenResult(cm, AMOUNT_LEG));
            }

            // Boot
            if (cm.getFormBoots() != null) {
                meltingRecipes.put(cm.getFormBoots(), new MoltenResult(cm, AMOUNT_BOOT));
            }

        }

        fillDieMetals();
        fillCastingDies();
        fillCastingRecipes();

    }

    public static TinkerMaterial getById(String id) {
        return MAP.get(id);
    }

    public static ChatColor getColorById(String id) {
        return MAP.get(id).getColor();
    }

    public static String getTraitName(String id, TraitPartType partType) {
        TinkerMaterial tinkerMaterial = MAP.get(id);
        if (partType == TraitPartType.HEAD) {
            Validate.notNull(tinkerMaterial.getTraitToolHead(), MessageFormat.format(VALIDATE_TRAIT_MESSAGE, id, partType));
            return tinkerMaterial.getTraitToolHead().getTraitName();
        } else if (partType == TraitPartType.BINDER) {
            Validate.notNull(tinkerMaterial.getTraitToolBinder(), MessageFormat.format(VALIDATE_TRAIT_MESSAGE, id, partType));
            return tinkerMaterial.getTraitToolBinder().getTraitName();
        } else if (partType == TraitPartType.ROD) {
            Validate.notNull(tinkerMaterial.getTraitToolRod(), MessageFormat.format(VALIDATE_TRAIT_MESSAGE, id, partType));
            return tinkerMaterial.getTraitToolRod().getTraitName();
        } else if (partType == TraitPartType.PLATES) {
            Validate.notNull(tinkerMaterial.getTraitArmorPlates(), MessageFormat.format(VALIDATE_TRAIT_MESSAGE, id, partType));
            return tinkerMaterial.getTraitArmorPlates().getTraitName();
        } else if (partType == TraitPartType.GAMBESON) {
            Validate.notNull(tinkerMaterial.getTraitArmorGambeson(), MessageFormat.format(VALIDATE_TRAIT_MESSAGE, id, partType));
            return tinkerMaterial.getTraitArmorGambeson().getTraitName();
        } else if (partType == TraitPartType.LINKS) {
            Validate.notNull(tinkerMaterial.getTraitArmorLinks(), MessageFormat.format(VALIDATE_TRAIT_MESSAGE, id, partType));
            return tinkerMaterial.getTraitArmorLinks().getTraitName();
        }
        return "Error";
    }

    public static List<Alloy> getAlloys() {
        List<Alloy> list = new ArrayList<>();
        for (TinkerMaterial cm : MAP.values()) {
            if (cm.getCmAlloy() != null) {
                list.add(cm.getCmAlloy());
            }
        }
        return list;
    }

    private void fillDieMetals() {
        MAP_DIE_NUGGET.put(TinkerMaterialManager.getById(Ids.GOLD), Casts.CAST_NUGGET);
        MAP_DIE_INGOT.put(TinkerMaterialManager.getById(Ids.GOLD), Casts.CAST_INGOT);
        MAP_DIE_BLOCK.put(TinkerMaterialManager.getById(Ids.GOLD), Casts.CAST_BLOCK);
        MAP_DIE_GEM.put(TinkerMaterialManager.getById(Ids.GOLD), Casts.CAST_GEM);
        MAP_DIE_REPAIRKIT.put(TinkerMaterialManager.getById(Ids.GOLD), Casts.CAST_REPAIRKIT);
        MAP_DIE_SHOVELHEAD.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_SHOVELHEAD);
        MAP_DIE_PICKAXEHEAD.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_PICKAXEHEAD);
        MAP_DIE_AXEHEAD.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_AXEHEAD);
        MAP_DIE_HOEHEAD.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_HOEHEAD);
        MAP_DIE_SWORDBLADE.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_SWORDBLADE);
        MAP_DIE_TOOLROD.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_TOOLROD);
        MAP_DIE_ARMOUR_PLATES_HELM.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_HELM_PLATE);
        MAP_DIE_ARMOUR_PLATES_CHEST.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_CHEST_PLATE);
        MAP_DIE_ARMOUR_PLATES_LEGGINGS.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_LEG_PLATE);
        MAP_DIE_ARMOUR_PLATES_BOOTS.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_BOOT_PLATE);
        MAP_DIE_ARMOUR_MAIL.put(TinkerMaterialManager.getById(Ids.BRASS), Casts.CAST_MAIL_LINK);
    }

    private void fillCastingDies() {
        castingRecipes.put(Material.IRON_NUGGET.toString(), new CastResult(Material.IRON_NUGGET.toString(), AMOUNT_CAST, MAP_DIE_NUGGET, true));
        castingRecipes.put(Material.BRICK.toString(), new CastResult(Material.BRICK.toString(), AMOUNT_CAST, MAP_DIE_INGOT, true));
        castingRecipes.put(Material.STONE.toString(), new CastResult(Material.STONE.toString(), AMOUNT_CAST, MAP_DIE_BLOCK, true));
        castingRecipes.put(Material.DIAMOND.toString(), new CastResult(Material.DIAMOND.toString(), AMOUNT_CAST, MAP_DIE_GEM, true));
        castingRecipes.put(Dies.DIE_REPAIR_KIT.getItemId(), new CastResult(Dies.DIE_REPAIR_KIT.getItemId(), AMOUNT_CAST, MAP_DIE_REPAIRKIT, true));
        castingRecipes.put(Dies.DIE_SHOVEL_HEAD.getItemId(), new CastResult(Dies.DIE_SHOVEL_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_SHOVELHEAD, true));
        castingRecipes.put(Dies.DIE_PICKAXE_HEAD.getItemId(), new CastResult(Dies.DIE_PICKAXE_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_PICKAXEHEAD, true));
        castingRecipes.put(Dies.DIE_AXE_HEAD.getItemId(), new CastResult(Dies.DIE_AXE_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_AXEHEAD, true));
        castingRecipes.put(Dies.DIE_HOE_HEAD.getItemId(), new CastResult(Dies.DIE_HOE_HEAD.getItemId(), AMOUNT_CAST, MAP_DIE_HOEHEAD, true));
        castingRecipes.put(Dies.DIE_SWORD_BLADE.getItemId(), new CastResult(Dies.DIE_SWORD_BLADE.getItemId(), AMOUNT_CAST, MAP_DIE_SWORDBLADE, true));
        castingRecipes.put(Dies.DIE_TOOL_ROD.getItemId(), new CastResult(Dies.DIE_TOOL_ROD.getItemId(), AMOUNT_CAST, MAP_DIE_TOOLROD, true));
        castingRecipes.put(Dies.DIE_HELM_PLATE.getItemId(), new CastResult(Dies.DIE_HELM_PLATE.getItemId(), AMOUNT_CAST, MAP_DIE_ARMOUR_PLATES_HELM, true));
        castingRecipes.put(Dies.DIE_CHEST_PLATE.getItemId(), new CastResult(Dies.DIE_CHEST_PLATE.getItemId(), AMOUNT_CAST, MAP_DIE_ARMOUR_PLATES_CHEST, true));
        castingRecipes.put(Dies.DIE_LEG_PLATE.getItemId(), new CastResult(Dies.DIE_LEG_PLATE.getItemId(), AMOUNT_CAST, MAP_DIE_ARMOUR_PLATES_LEGGINGS, true));
        castingRecipes.put(Dies.DIE_BOOT_PLATE.getItemId(), new CastResult(Dies.DIE_BOOT_PLATE.getItemId(), AMOUNT_CAST, MAP_DIE_ARMOUR_PLATES_BOOTS, true));
        castingRecipes.put(Dies.DIE_MAIL_LINK.getItemId(), new CastResult(Dies.DIE_MAIL_LINK.getItemId(), AMOUNT_CAST, MAP_DIE_ARMOUR_MAIL, true));
    }

    private void fillCastingRecipes() {
        castingRecipes.put(Casts.CAST_NUGGET.getItemId(), new CastResult(Casts.CAST_NUGGET.getItemId(), AMOUNT_NUGGET, MAP_CAST_NUGGET, false));
        castingRecipes.put(Casts.CAST_INGOT.getItemId(), new CastResult(Casts.CAST_INGOT.getItemId(), AMOUNT_INGOT, MAP_CAST_INGOT, false));
        castingRecipes.put(Casts.CAST_BLOCK.getItemId(), new CastResult(Casts.CAST_BLOCK.getItemId(), AMOUNT_BLOCK, MAP_CAST_BLOCK, false));
        castingRecipes.put(Casts.CAST_GEM.getItemId(), new CastResult(Casts.CAST_GEM.getItemId(), AMOUNT_GEM, MAP_CAST_GEM, false));
        castingRecipes.put(Casts.CAST_REPAIRKIT.getItemId(), new CastResult(Casts.CAST_REPAIRKIT.getItemId(), AMOUNT_KIT, MAP_CAST_REPAIRKIT, false));
        castingRecipes.put(Casts.CAST_SHOVELHEAD.getItemId(), new CastResult(Casts.CAST_SHOVELHEAD.getItemId(), AMOUNT_SHOVELHEAD, MAP_CAST_SHOVELHEAD, false));
        castingRecipes.put(Casts.CAST_PICKAXEHEAD.getItemId(), new CastResult(Casts.CAST_PICKAXEHEAD.getItemId(), AMOUNT_PICKAXEHEAD, MAP_CAST_PICKAXEHEAD, false));
        castingRecipes.put(Casts.CAST_AXEHEAD.getItemId(), new CastResult(Casts.CAST_AXEHEAD.getItemId(), AMOUNT_AXEHEAD, MAP_CAST_AXEHEAD, false));
        castingRecipes.put(Casts.CAST_HOEHEAD.getItemId(), new CastResult(Casts.CAST_HOEHEAD.getItemId(), AMOUNT_HOEHEAD, MAP_CAST_HOEHEAD, false));
        castingRecipes.put(Casts.CAST_SWORDBLADE.getItemId(), new CastResult(Casts.CAST_SWORDBLADE.getItemId(), AMOUNT_SWORDBLADE, MAP_CAST_SWORDBLADE, false));
        castingRecipes.put(Casts.CAST_TOOLROD.getItemId(), new CastResult(Casts.CAST_TOOLROD.getItemId(), AMOUNT_TOOLROD, MAP_CAST_TOOLROD, false));
        castingRecipes.put(Casts.CAST_HELM_PLATE.getItemId(), new CastResult(Casts.CAST_HELM_PLATE.getItemId(), AMOUNT_ARM_HELM, MAP_CAST_ARMOUR_PLATES_HELM, false));
        castingRecipes.put(Casts.CAST_CHEST_PLATE.getItemId(), new CastResult(Casts.CAST_CHEST_PLATE.getItemId(), AMOUNT_ARM_CHEST, MAP_CAST_ARMOUR_PLATES_CHEST, false));
        castingRecipes.put(Casts.CAST_LEG_PLATE.getItemId(), new CastResult(Casts.CAST_LEG_PLATE.getItemId(), AMOUNT_ARM_LEG, MAP_CAST_ARMOUR_PLATES_LEGGINGS, false));
        castingRecipes.put(Casts.CAST_BOOT_PLATE.getItemId(), new CastResult(Casts.CAST_BOOT_PLATE.getItemId(), AMOUNT_ARM_BOOT, MAP_CAST_ARMOUR_PLATES_BOOTS, false));
        castingRecipes.put(Casts.CAST_MAIL_LINK.getItemId(), new CastResult(Casts.CAST_MAIL_LINK.getItemId(), AMOUNT_ARM_LINKS, MAP_CAST_ARMOUR_MAIL, false));
    }

    public static Map<String, TinkerMaterial> getMap() {
        return MAP;
    }
}
