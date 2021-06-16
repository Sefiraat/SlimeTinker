package io.github.sefiraat.slimetinker.modifiers;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Modifications {

    public static final LinkedList<Material> MODIFICAION_LIST = new LinkedList<>();
    public static final Map<Material, Mod> MODIFICATION_DEFINITIONS = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_REDSTONE = new HashMap<>();

    static {

        // ALL NEW MODS MUST BE PLACED AFTER EXISTING ONES
        MODIFICAION_LIST.add(Material.REDSTONE);
        MODIFICAION_LIST.add(Material.LAPIS_LAZULI);
        MODIFICAION_LIST.add(Material.QUARTZ);
        MODIFICAION_LIST.add(Material.DIAMOND);
        MODIFICAION_LIST.add(Material.EMERALD);
        MODIFICAION_LIST.add(Material.OBSIDIAN);

        MOD_MAP_REDSTONE.put(1, 128);
        MOD_MAP_REDSTONE.put(2, 256);
        MOD_MAP_REDSTONE.put(3, 384);
        MOD_MAP_REDSTONE.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.REDSTONE, new Mod(MOD_MAP_REDSTONE, SlimeTinker.inst().getKeys().getToolModLevelRedstone()));

    }

    public static void setModificationMap(ItemStack itemStack, LinkedHashMap<Material, Integer> map) {
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        int[] mapArray = new int[MODIFICAION_LIST.size()];
        for (int i = 0; i < MODIFICAION_LIST.size(); i++) {
            mapArray[i] = map.get(MODIFICAION_LIST.get(i));
        }
        im.getPersistentDataContainer().set(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY, mapArray);
        itemStack.setItemMeta(im);
    }

    public static LinkedHashMap<Material, Integer> getModificationMap(ItemStack itemStack) {
        LinkedHashMap<Material, Integer> map = new LinkedHashMap<>();
        PersistentDataContainer c = itemStack.getItemMeta().getPersistentDataContainer();
        if (c.has(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (Material m : MODIFICAION_LIST) {
                if ((MODIFICAION_LIST.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICAION_LIST.indexOf(m)]);
                }
            }
        } else {
            for (Material m : MODIFICAION_LIST) {
                map.put(m, 0);
            }
            setModificationMap(itemStack, map);
        }
        return map;
    }

    public static int getModLevel(Mod mod, ItemStack itemStack) {
        if (itemStack.getItemMeta().getPersistentDataContainer().has(mod.getLevelKey(), PersistentDataType.INTEGER)) {
            return itemStack.getItemMeta().getPersistentDataContainer().get(mod.getLevelKey(), PersistentDataType.INTEGER);
        } else {
            return -1;
        }
    }

    public static void setModLevel(Mod mod, PersistentDataContainer c, int level) {
        c.set(mod.getLevelKey(), PersistentDataType.INTEGER, level);
    }

    public static Map<Material, Integer> getAllModLevels(ItemStack itemStack) {
        Map<Material, Integer> map = new HashMap<>();
        for (Material m : MODIFICAION_LIST) {
            int level = getModLevel(MODIFICATION_DEFINITIONS.get(m), itemStack);
            if (level > -1) {
                map.put(m, level);
            }
        }
        return map;
    }


}
