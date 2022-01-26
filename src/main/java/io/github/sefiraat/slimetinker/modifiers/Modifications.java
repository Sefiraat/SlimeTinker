package io.github.sefiraat.slimetinker.modifiers;

import io.github.mooy1.infinitylib.common.StackUtils;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.Keys;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modifications {

    private static final List<String> MODIFICATION_LIST_TOOL = new LinkedList<>();
    private static final Map<String, Mod> MODIFICATION_DEFINITIONS_TOOL = new HashMap<>();
    private static final Map<Integer, Integer> MOD_MAP_REDSTONE_TOOL = new HashMap<>();
    private static final Map<Integer, Integer> MOD_MAP_LAPIS_TOOL = new HashMap<>();
    private static final Map<Integer, Integer> MOD_MAP_QUARTZ_TOOL = new HashMap<>();
    private static final Map<Integer, Integer> MOD_MAP_DIAMOND_TOOL = new HashMap<>();
    private static final Map<Integer, Integer> MOD_MAP_EMERALD_TOOL = new HashMap<>();
    private static final Map<Integer, Integer> MOD_MAP_PLATE = new HashMap<>();
    private static final List<String> MODIFICATION_LIST_ARMOUR = new LinkedList<>();
    private static final Map<String, Mod> MODIFICATION_DEFINITIONS_ARMOUR = new HashMap<>();

    static {

        // MOD MAPS
        MOD_MAP_REDSTONE_TOOL.put(1, 128);
        MOD_MAP_REDSTONE_TOOL.put(2, 256);
        MOD_MAP_REDSTONE_TOOL.put(3, 384);
        MOD_MAP_REDSTONE_TOOL.put(4, 512);
        MOD_MAP_REDSTONE_TOOL.put(5, 1024);

        MOD_MAP_LAPIS_TOOL.put(1, 128);
        MOD_MAP_LAPIS_TOOL.put(2, 256);
        MOD_MAP_LAPIS_TOOL.put(3, 384);
        MOD_MAP_LAPIS_TOOL.put(4, 512);
        MOD_MAP_LAPIS_TOOL.put(5, 1024);

        MOD_MAP_QUARTZ_TOOL.put(1, 128);
        MOD_MAP_QUARTZ_TOOL.put(2, 256);
        MOD_MAP_QUARTZ_TOOL.put(3, 384);
        MOD_MAP_QUARTZ_TOOL.put(4, 512);
        MOD_MAP_QUARTZ_TOOL.put(5, 1024);

        MOD_MAP_DIAMOND_TOOL.put(1, 64);
        MOD_MAP_DIAMOND_TOOL.put(2, 128);
        MOD_MAP_DIAMOND_TOOL.put(3, 256);
        MOD_MAP_DIAMOND_TOOL.put(4, 512);

        MOD_MAP_EMERALD_TOOL.put(1, 256);
        MOD_MAP_EMERALD_TOOL.put(2, 512);
        MOD_MAP_EMERALD_TOOL.put(3, 1024);
        MOD_MAP_EMERALD_TOOL.put(4, 2048);

        MOD_MAP_PLATE.put(1, 1);
        MOD_MAP_PLATE.put(2, 1);
        MOD_MAP_PLATE.put(3, 1);
        MOD_MAP_PLATE.put(4, 1);
        MOD_MAP_PLATE.put(5, 1);
        MOD_MAP_PLATE.put(6, 1);
        MOD_MAP_PLATE.put(7, 1);
        MOD_MAP_PLATE.put(8, 1);
        MOD_MAP_PLATE.put(9, 1);
        MOD_MAP_PLATE.put(10, 1);

        // ALL NEW MODS MUST BE PLACED AFTER EXISTING ONES

        // TOOLS

        MODIFICATION_LIST_TOOL.add(StackUtils.getIdOrType(new ItemStack(Material.REDSTONE)));
        MODIFICATION_LIST_TOOL.add(StackUtils.getIdOrType(new ItemStack(Material.LAPIS_LAZULI)));
        MODIFICATION_LIST_TOOL.add(StackUtils.getIdOrType(new ItemStack(Material.QUARTZ)));
        MODIFICATION_LIST_TOOL.add(StackUtils.getIdOrType(new ItemStack(Material.DIAMOND)));
        MODIFICATION_LIST_TOOL.add(StackUtils.getIdOrType(new ItemStack(Material.EMERALD)));
        MODIFICATION_LIST_TOOL.add(StackUtils.getIdOrType(Materials.MOD_PLATE));

        MODIFICATION_DEFINITIONS_TOOL.put(StackUtils.getIdOrType(new ItemStack(Material.REDSTONE)), new Mod(MOD_MAP_REDSTONE_TOOL, Keys.ST_MOD_LEVEL_REDSTONE));
        MODIFICATION_DEFINITIONS_TOOL.put(StackUtils.getIdOrType(new ItemStack(Material.LAPIS_LAZULI)), new Mod(MOD_MAP_LAPIS_TOOL, Keys.ST_MOD_LEVEL_LAPIS));
        MODIFICATION_DEFINITIONS_TOOL.put(StackUtils.getIdOrType(new ItemStack(Material.QUARTZ)), new Mod(MOD_MAP_QUARTZ_TOOL, Keys.ST_MOD_LEVEL_QUARTZ));
        MODIFICATION_DEFINITIONS_TOOL.put(StackUtils.getIdOrType(new ItemStack(Material.DIAMOND)), new Mod(MOD_MAP_DIAMOND_TOOL, Keys.ST_MOD_LEVEL_DIAMOND));
        MODIFICATION_DEFINITIONS_TOOL.put(StackUtils.getIdOrType(new ItemStack(Material.EMERALD)), new Mod(MOD_MAP_EMERALD_TOOL, Keys.ST_MOD_LEVEL_EMERALD));
        MODIFICATION_DEFINITIONS_TOOL.put(StackUtils.getIdOrType(Materials.MOD_PLATE), new Mod(MOD_MAP_PLATE, Keys.ST_MOD_LEVEL_OBSIDIAN));

        // ARMOUR

        MODIFICATION_LIST_ARMOUR.add(StackUtils.getIdOrType(Materials.MOD_PLATE));

        MODIFICATION_DEFINITIONS_ARMOUR.put(StackUtils.getIdOrType(Materials.MOD_PLATE), new Mod(MOD_MAP_PLATE, Keys.ST_MOD_LEVEL_OBSIDIAN));

    }

    private Modifications() {
        throw new IllegalStateException("Utility class");
    }

    public static void setModificationMapTool(PersistentDataContainer c, Map<String, Integer> map) {
        int[] mapArray = new int[MODIFICATION_LIST_TOOL.size()];
        for (int i = 0; i < MODIFICATION_LIST_TOOL.size(); i++) {
            mapArray[i] = map.get(MODIFICATION_LIST_TOOL.get(i));
        }
        c.set(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY, mapArray);
    }

    public static void setModificationMapArmour(PersistentDataContainer c, Map<String, Integer> map) {
        int[] mapArray = new int[MODIFICATION_LIST_ARMOUR.size()];
        for (int i = 0; i < MODIFICATION_LIST_ARMOUR.size(); i++) {
            mapArray[i] = map.get(MODIFICATION_LIST_ARMOUR.get(i));
        }
        c.set(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY, mapArray);
    }

    public static Map<String, Integer> getModificationMapTool(ItemStack itemStack) {
        Map<String, Integer> map = new LinkedHashMap<>();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (c.has(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (String m : MODIFICATION_LIST_TOOL) {
                if ((MODIFICATION_LIST_TOOL.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICATION_LIST_TOOL.indexOf(m)]);
                }
            }
        } else {
            for (String m : MODIFICATION_LIST_TOOL) {
                map.put(m, 0);
            }
            setModificationMapTool(c, map);
            itemStack.setItemMeta(im);
        }
        return map;
    }

    public static Map<String, Integer> getModificationMapArmour(ItemStack itemStack) {
        Map<String, Integer> map = new LinkedHashMap<>();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (c.has(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (String m : MODIFICATION_LIST_ARMOUR) {
                if ((MODIFICATION_LIST_ARMOUR.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICATION_LIST_ARMOUR.indexOf(m)]);
                }
            }
        } else {
            for (String m : MODIFICATION_LIST_ARMOUR) {
                map.put(m, 0);
            }
            setModificationMapArmour(c, map);
            itemStack.setItemMeta(im);
        }
        return map;
    }

    public static Map<String, Integer> getModificationMapTool(PersistentDataContainer c) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (c.has(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (String m : MODIFICATION_LIST_TOOL) {
                if ((MODIFICATION_LIST_TOOL.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICATION_LIST_TOOL.indexOf(m)]);
                }
            }
        } else {
            for (String m : MODIFICATION_LIST_TOOL) {
                map.put(m, 0);
            }
            setModificationMapTool(c, map);
        }
        return map;
    }

    public static Map<String, Integer> getModificationMapArmour(PersistentDataContainer c) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (c.has(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(Keys.ST_MODS, PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (String m : MODIFICATION_LIST_ARMOUR) {
                if ((MODIFICATION_LIST_ARMOUR.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICATION_LIST_ARMOUR.indexOf(m)]);
                }
            }
        } else {
            for (String m : MODIFICATION_LIST_ARMOUR) {
                map.put(m, 0);
            }
            setModificationMapArmour(c, map);
        }
        return map;
    }

    public static int getModLevel(Mod mod, ItemStack itemStack) {
        if (itemStack.getItemMeta().getPersistentDataContainer().has(mod.getLevelKey(), PersistentDataType.INTEGER)) {
            return itemStack.getItemMeta().getPersistentDataContainer().get(mod.getLevelKey(), PersistentDataType.INTEGER);
        } else {
            return 0;
        }
    }

    public static void setModLevel(Mod mod, PersistentDataContainer c, int level) {
        c.set(mod.getLevelKey(), PersistentDataType.INTEGER, level);
    }

    public static Map<String, Integer> getAllModLevels(ItemStack itemStack) {
        Map<String, Integer> map = new HashMap<>();
        if (ItemUtils.isTool(itemStack)) {
            for (String m : MODIFICATION_LIST_TOOL) {
                int level = getModLevel(MODIFICATION_DEFINITIONS_TOOL.get(m), itemStack);
                Integer progress = getModificationMapTool(itemStack).get(m);
                if (level > 0 || (progress != null && progress > 0)) { // Has level or progress towards level
                    map.put(m, level);
                }
            }
        } else if (ItemUtils.isArmour(itemStack)) {
            for (String m : MODIFICATION_LIST_ARMOUR) {
                int level = getModLevel(MODIFICATION_DEFINITIONS_ARMOUR.get(m), itemStack);
                Integer progress = getModificationMapArmour(itemStack).get(m);
                if (level > 0 || (progress != null && progress > 0)) { // Has level or progress towards level
                    map.put(m, level);
                }
            }
        }
        return map;
    }

    public static List<String> getModificationListTool() {
        return MODIFICATION_LIST_TOOL;
    }

    public static Map<String, Mod> getModificationDefinitionsTool() {
        return MODIFICATION_DEFINITIONS_TOOL;
    }

    public static Map<Integer, Integer> getModMapRedstoneTool() {
        return MOD_MAP_REDSTONE_TOOL;
    }

    public static Map<Integer, Integer> getModMapLapisTool() {
        return MOD_MAP_LAPIS_TOOL;
    }

    public static Map<Integer, Integer> getModMapQuartzTool() {
        return MOD_MAP_QUARTZ_TOOL;
    }

    public static Map<Integer, Integer> getModMapDiamondTool() {
        return MOD_MAP_DIAMOND_TOOL;
    }

    public static Map<Integer, Integer> getModMapEmeraldTool() {
        return MOD_MAP_EMERALD_TOOL;
    }

    public static Map<Integer, Integer> getModMapPlate() {
        return MOD_MAP_PLATE;
    }

    public static List<String> getModificationListArmour() {
        return MODIFICATION_LIST_ARMOUR;
    }

    public static Map<String, Mod> getModificationDefinitionsArmour() {
        return MODIFICATION_DEFINITIONS_ARMOUR;
    }
}
