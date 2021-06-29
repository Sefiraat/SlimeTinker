package io.github.sefiraat.slimetinker.modifiers;

import io.github.mooy1.infinitylib.items.StackUtils;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.Materials;
import lombok.Getter;
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

    private Modifications() {
        throw new IllegalStateException("Utility class");
    }

    @Getter
    protected static final List<String> MODIFICATION_LIST = new LinkedList<>();
    @Getter
    protected static final Map<String, Mod> MODIFICATION_DEFINITIONS = new HashMap<>();
    @Getter
    protected static final Map<Integer, Integer> MOD_MAP_REDSTONE = new HashMap<>();
    @Getter
    protected static final Map<Integer, Integer> MOD_MAP_LAPIS = new HashMap<>();
    @Getter
    protected static final Map<Integer, Integer> MOD_MAP_QUARTZ = new HashMap<>();
    @Getter
    protected static final Map<Integer, Integer> MOD_MAP_DIAMOND = new HashMap<>();
    @Getter
    protected static final Map<Integer, Integer> MOD_MAP_EMERALD = new HashMap<>();
    @Getter
    protected static final Map<Integer, Integer> MOD_MAP_PLATE = new HashMap<>();

    static {

        // ALL NEW MODS MUST BE PLACED AFTER EXISTING ONES
        MODIFICATION_LIST.add(StackUtils.getIDorType(new ItemStack(Material.REDSTONE)));
        MODIFICATION_LIST.add(StackUtils.getIDorType(new ItemStack(Material.LAPIS_LAZULI)));
        MODIFICATION_LIST.add(StackUtils.getIDorType(new ItemStack(Material.QUARTZ)));
        MODIFICATION_LIST.add(StackUtils.getIDorType(new ItemStack(Material.DIAMOND)));
        MODIFICATION_LIST.add(StackUtils.getIDorType(new ItemStack(Material.EMERALD)));
        MODIFICATION_LIST.add(StackUtils.getIDorType(Materials.MOD_PLATE));

        MOD_MAP_REDSTONE.put(1, 128);
        MOD_MAP_REDSTONE.put(2, 256);
        MOD_MAP_REDSTONE.put(3, 384);
        MOD_MAP_REDSTONE.put(4, 512);
        MOD_MAP_REDSTONE.put(5, 1024);
        MODIFICATION_DEFINITIONS.put(StackUtils.getIDorType(new ItemStack(Material.REDSTONE)), new Mod(MOD_MAP_REDSTONE, SlimeTinker.inst().getKeys().getStModLevelRedstone()));
        MOD_MAP_LAPIS.put(1, 128);
        MOD_MAP_LAPIS.put(2, 256);
        MOD_MAP_LAPIS.put(3, 384);
        MOD_MAP_LAPIS.put(4, 512);
        MOD_MAP_LAPIS.put(5, 1024);
        MODIFICATION_DEFINITIONS.put(StackUtils.getIDorType(new ItemStack(Material.LAPIS_LAZULI)), new Mod(MOD_MAP_LAPIS, SlimeTinker.inst().getKeys().getStModLevelLapis()));
        MOD_MAP_QUARTZ.put(1, 128);
        MOD_MAP_QUARTZ.put(2, 256);
        MOD_MAP_QUARTZ.put(3, 384);
        MOD_MAP_QUARTZ.put(4, 512);
        MOD_MAP_QUARTZ.put(5, 1024);
        MODIFICATION_DEFINITIONS.put(StackUtils.getIDorType(new ItemStack(Material.QUARTZ)), new Mod(MOD_MAP_QUARTZ, SlimeTinker.inst().getKeys().getStModLevelQuartz()));
        MOD_MAP_DIAMOND.put(1, 64);
        MOD_MAP_DIAMOND.put(2, 128);
        MOD_MAP_DIAMOND.put(3, 256);
        MOD_MAP_DIAMOND.put(4, 512);
        MODIFICATION_DEFINITIONS.put(StackUtils.getIDorType(new ItemStack(Material.DIAMOND)), new Mod(MOD_MAP_DIAMOND, SlimeTinker.inst().getKeys().getStModLevelDiamond()));
        MOD_MAP_EMERALD.put(1, 256);
        MOD_MAP_EMERALD.put(2, 512);
        MOD_MAP_EMERALD.put(3, 1024);
        MOD_MAP_EMERALD.put(4, 2048);
        MODIFICATION_DEFINITIONS.put(StackUtils.getIDorType(new ItemStack(Material.EMERALD)), new Mod(MOD_MAP_EMERALD, SlimeTinker.inst().getKeys().getStModLevelEmerald()));
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
        MODIFICATION_DEFINITIONS.put(StackUtils.getIDorType(Materials.MOD_PLATE), new Mod(MOD_MAP_PLATE, SlimeTinker.inst().getKeys().getStModLevelObsidian()));

    }

    public static void setModificationMap(PersistentDataContainer c, Map<String, Integer> map) {
        int[] mapArray = new int[MODIFICATION_LIST.size()];
        for (int i = 0; i < MODIFICATION_LIST.size(); i++) {
            mapArray[i] = map.get(MODIFICATION_LIST.get(i));
        }
        c.set(SlimeTinker.inst().getKeys().getStMods(), PersistentDataType.INTEGER_ARRAY, mapArray);
    }

    public static Map<String, Integer> getModificationMap(ItemStack itemStack) {
        Map<String, Integer> map = new LinkedHashMap<>();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (c.has(SlimeTinker.inst().getKeys().getStMods(), PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(SlimeTinker.inst().getKeys().getStMods(), PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (String m : MODIFICATION_LIST) {
                if ((MODIFICATION_LIST.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICATION_LIST.indexOf(m)]);
                }
            }
        } else {
            for (String m : MODIFICATION_LIST) {
                map.put(m, 0);
            }
            setModificationMap(c, map);
            itemStack.setItemMeta(im);
        }
        return map;
    }

    public static Map<String, Integer> getModificationMap(PersistentDataContainer c) {
        Map<String, Integer> map = new LinkedHashMap<>();
        if (c.has(SlimeTinker.inst().getKeys().getStMods(), PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(SlimeTinker.inst().getKeys().getStMods(), PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (String m : MODIFICATION_LIST) {
                if ((MODIFICATION_LIST.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICATION_LIST.indexOf(m)]);
                }
            }
        } else {
            for (String m : MODIFICATION_LIST) {
                map.put(m, 0);
            }
            setModificationMap(c, map);
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
        for (String m : MODIFICATION_LIST) {
            int level = getModLevel(MODIFICATION_DEFINITIONS.get(m), itemStack);
            Integer progress = getModificationMap(itemStack).get(m);
            if (level > 0 || (progress != null && progress > 0)) { // Has level or progress towards level
                map.put(m, level);
            }
        }
        return map;
    }


}
