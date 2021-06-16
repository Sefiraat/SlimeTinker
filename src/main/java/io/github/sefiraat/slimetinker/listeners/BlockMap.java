package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.utils.IDStrings;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class BlockMap {

    protected static final Map<Material, String> materialMap = new HashMap<>();

    static {
        for (Material m : Material.values()) {
            switch (m) {
                case STONE:
                case END_STONE:
                case TERRACOTTA:
                case PRISMARINE:
                case CRYING_OBSIDIAN:
                case BLACKSTONE:
                case BASALT:
                case MOSSY_COBBLESTONE:
                case COAL_ORE:
                case DEEPSLATE_COAL_ORE:
                case IRON_ORE:
                case DEEPSLATE_IRON_ORE:
                case COPPER_ORE:
                case DEEPSLATE_COPPER_ORE:
                case GOLD_ORE:
                case DEEPSLATE_GOLD_ORE:
                case REDSTONE_ORE:
                case DEEPSLATE_REDSTONE_ORE:
                case EMERALD_ORE:
                case DEEPSLATE_EMERALD_ORE:
                case LAPIS_ORE:
                case DEEPSLATE_LAPIS_ORE:
                case DIAMOND_ORE:
                case DEEPSLATE_DIAMOND_ORE:
                case NETHER_GOLD_ORE:
                case NETHER_QUARTZ_ORE:
                case GRANITE:
                case POLISHED_GRANITE:
                case DIORITE:
                case POLISHED_DIORITE:
                case ANDESITE:
                case POLISHED_ANDESITE:
                case DEEPSLATE:
                case COBBLED_DEEPSLATE:
                case POLISHED_DEEPSLATE:
                case CALCITE:
                case TUFF:
                case DRIPSTONE_BLOCK:
                case OBSIDIAN:
                case ANCIENT_DEBRIS:
                case COBBLESTONE:
                case AMETHYST_CLUSTER:
                case GLOWSTONE:
                case NETHERRACK:
                    materialMap.put(m, IDStrings.ID_PICKAXE);
                    break;
                case GRASS_BLOCK:
                case DIRT:
                case COARSE_DIRT:
                case PODZOL:
                case ROOTED_DIRT:
                case CRIMSON_NYLIUM:
                case WARPED_NYLIUM:
                case SAND:
                case RED_SAND:
                case GRAVEL:
                case CLAY:
                case SOUL_SAND:
                case SOUL_SOIL:
                case MYCELIUM:
                case MOSS_BLOCK:
                    materialMap.put(m, IDStrings.ID_SHOVEL);
                    break;
                case OAK_LOG:
                case SPRUCE_LOG:
                case BIRCH_LOG:
                case JUNGLE_LOG:
                case ACACIA_LOG:
                case DARK_OAK_LOG:
                case CRIMSON_STEM:
                case WARPED_STEM:
                case STRIPPED_OAK_LOG:
                case STRIPPED_SPRUCE_LOG:
                case STRIPPED_BIRCH_LOG:
                case STRIPPED_JUNGLE_LOG:
                case STRIPPED_ACACIA_LOG:
                case STRIPPED_DARK_OAK_LOG:
                case STRIPPED_CRIMSON_STEM:
                case STRIPPED_WARPED_STEM:
                case STRIPPED_OAK_WOOD:
                case STRIPPED_SPRUCE_WOOD:
                case STRIPPED_BIRCH_WOOD:
                case STRIPPED_JUNGLE_WOOD:
                case STRIPPED_ACACIA_WOOD:
                case STRIPPED_DARK_OAK_WOOD:
                case STRIPPED_CRIMSON_HYPHAE:
                case STRIPPED_WARPED_HYPHAE:
                case OAK_WOOD:
                case SPRUCE_WOOD:
                case BIRCH_WOOD:
                case JUNGLE_WOOD:
                case ACACIA_WOOD:
                case DARK_OAK_WOOD:
                case CRIMSON_HYPHAE:
                case WARPED_HYPHAE:
                case CACTUS:
                case BROWN_MUSHROOM_BLOCK:
                case RED_MUSHROOM_BLOCK:
                case MUSHROOM_STEM:
                case PUMPKIN:
                case MELON:
                    materialMap.put(m, IDStrings.ID_AXE);
                    break;
                case SEA_PICKLE:
                case VINE:
                case GLOW_LICHEN:
                case LILY_PAD:
                    materialMap.put(m, IDStrings.ID_HOE);
                    break;
            }
        }
    }

}
