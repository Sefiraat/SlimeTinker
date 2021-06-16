package io.github.sefiraat.slimetinker.modifiers;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Modifications {

    public static final LinkedList<Material> MODIFICAION_LIST = new LinkedList<>();

    static {
        MODIFICAION_LIST.add(Material.REDSTONE);
        MODIFICAION_LIST.add(Material.LAPIS_LAZULI);
        MODIFICAION_LIST.add(Material.QUARTZ);
        MODIFICAION_LIST.add(Material.DIAMOND);
        MODIFICAION_LIST.add(Material.EMERALD);
        MODIFICAION_LIST.add(Material.OBSIDIAN);
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
}
