package io.github.sefiraat.slimetinker.properties;

import io.github.sefiraat.slimetinker.utils.IDStrings;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Properties {

    private Properties() {
        throw new IllegalStateException("Utility class");
    }

    public static final Map<String, String> PROP_MAP_HEAD = new HashMap<>();
    public static final Map<String, String> PROP_MAP_BIND = new HashMap<>();
    public static final Map<String, String> PROP_MAP_ROD = new HashMap<>();


    static {

        PROP_MAP_HEAD.put(IDStrings.IRON, "Stability");
        PROP_MAP_HEAD.put(IDStrings.GOLD, "Golden Veil");
        PROP_MAP_HEAD.put(IDStrings.COPPER, "Brains, Not Brawn");
        PROP_MAP_HEAD.put(IDStrings.LEAD, "Poisonous");
        PROP_MAP_HEAD.put(IDStrings.SILVER, "Enchanting");
        PROP_MAP_HEAD.put(IDStrings.ALUMINUM, "Recyclable");
        PROP_MAP_HEAD.put(IDStrings.TIN, "Malleable");
        PROP_MAP_HEAD.put(IDStrings.ZINC, "Graceful");
        PROP_MAP_HEAD.put(IDStrings.MAGNESIUM, "Flammable");
        PROP_MAP_HEAD.put(IDStrings.STEEL, "Stainless");
        PROP_MAP_HEAD.put(IDStrings.DAMSTEEL, "Vampirism");
        PROP_MAP_HEAD.put(IDStrings.DURALIUM, "Durable");
        PROP_MAP_HEAD.put(IDStrings.BRONZE, "Resistant");
        PROP_MAP_HEAD.put(IDStrings.ALUBRONZE, "Sharp II");
        PROP_MAP_HEAD.put(IDStrings.HARD, "Tuff Stuff");
        PROP_MAP_HEAD.put(IDStrings.CORBRONZE, "Flaming Hot");
        PROP_MAP_HEAD.put(IDStrings.SOLDER, "Hidden");
        PROP_MAP_HEAD.put(IDStrings.BILLON, "Fast");
        PROP_MAP_HEAD.put(IDStrings.BRASS, "Stiff");
        PROP_MAP_HEAD.put(IDStrings.ALUBRASS, "Abra");
        PROP_MAP_HEAD.put(IDStrings.NICKEL, "Charged (A)");
        PROP_MAP_HEAD.put(IDStrings.COBALT, "Charged (B)");
        PROP_MAP_HEAD.put(IDStrings.REINFORCED, "Bulky");

        PROP_MAP_ROD.put(IDStrings.IRON, "Sharp I");
        PROP_MAP_ROD.put(IDStrings.GOLD, "All That Glitters");
        PROP_MAP_ROD.put(IDStrings.COPPER, "Conductive");
        PROP_MAP_ROD.put(IDStrings.LEAD, "Leech");
        PROP_MAP_ROD.put(IDStrings.SILVER, "Soft Touch");
        PROP_MAP_ROD.put(IDStrings.ALUMINUM, "Soft");
        PROP_MAP_ROD.put(IDStrings.TIN, "Can");
        PROP_MAP_ROD.put(IDStrings.ZINC, "Super Lightweight");
        PROP_MAP_ROD.put(IDStrings.MAGNESIUM, "Magnetisium");
        PROP_MAP_ROD.put(IDStrings.STEEL, "Lightweight");
        PROP_MAP_ROD.put(IDStrings.DAMSTEEL, "Night Stalker");
        PROP_MAP_ROD.put(IDStrings.DURALIUM, "Easy Fix");
        PROP_MAP_ROD.put(IDStrings.BRONZE, "Ingheights");
        PROP_MAP_ROD.put(IDStrings.ALUBRONZE, "Brittle");
        PROP_MAP_ROD.put(IDStrings.HARD, "Heavy");
        PROP_MAP_ROD.put(IDStrings.CORBRONZE, "Too Hot To Handle");
        PROP_MAP_ROD.put(IDStrings.SOLDER, "Fused");
        PROP_MAP_ROD.put(IDStrings.BILLON, "Springs");
        PROP_MAP_ROD.put(IDStrings.BRASS, "Oxygenated");
        PROP_MAP_ROD.put(IDStrings.ALUBRASS, "Studious");
        PROP_MAP_ROD.put(IDStrings.NICKEL, "Charged (A)");
        PROP_MAP_ROD.put(IDStrings.COBALT, "Charged (B)");
        PROP_MAP_ROD.put(IDStrings.REINFORCED, "Reinforced");

        PROP_MAP_BIND.put(IDStrings.STRING, "Weak");
        PROP_MAP_BIND.put(IDStrings.VINE, "Growth");
        PROP_MAP_BIND.put(IDStrings.ROOTRED, "Decay");
        PROP_MAP_BIND.put(IDStrings.ROOTGREEN, "Refreshing");
        PROP_MAP_BIND.put(IDStrings.VINERED, "Doom");
        PROP_MAP_BIND.put(IDStrings.VINEGREEN, "Attraction");

    }

}
