package io.github.sefiraat.slimetinker.properties;

import io.github.sefiraat.slimetinker.utils.IDStrings;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class Properties {

    @Getter
    static final Map<String, String> PROP_MAP_HEAD = new HashMap<>();
    @Getter
    static final Map<String, String> PROP_MAP_BIND = new HashMap<>();
    @Getter
    static final Map<String, String> PROP_MAP_ROD = new HashMap<>();


    static {
        // Vanilla/Core SF
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

        PROP_MAP_BIND.put(IDStrings.STRING, "Works");
        PROP_MAP_BIND.put(IDStrings.VINE, "Growth");
        PROP_MAP_BIND.put(IDStrings.CRIMSONROOTS, "Decay");
        PROP_MAP_BIND.put(IDStrings.WARPEDROOTS, "Refreshing");
        PROP_MAP_BIND.put(IDStrings.WEEPINGVINES, "Doom");
        PROP_MAP_BIND.put(IDStrings.TWISTEDVINES, "Attraction");

        //Infinity Expac
        PROP_MAP_HEAD.put(IDStrings.VOID, "Void Miner");
        PROP_MAP_HEAD.put(IDStrings.INFINITY, "∞");
        PROP_MAP_HEAD.put(IDStrings.FORTUNE, "Fortunate");
        PROP_MAP_HEAD.put(IDStrings.MAGIC, "Tricks");
        PROP_MAP_HEAD.put(IDStrings.EARTH, "Earth Shaker");
        PROP_MAP_HEAD.put(IDStrings.METAL, "Clean Cut");
        PROP_MAP_HEAD.put(IDStrings.MAGSTEEL, "Really Stainless");
        PROP_MAP_HEAD.put(IDStrings.TITANIUM, "Reinforced");
        PROP_MAP_HEAD.put(IDStrings.MYTHRIL, "Elven Speed");
        PROP_MAP_HEAD.put(IDStrings.ADAMANTITE, "Mystic");
        PROP_MAP_HEAD.put(IDStrings.MAGNONIUM, "Magnanimous");
        PROP_MAP_HEAD.put(IDStrings.SINGCOPPER, "Brains Not Brawn I I");
        PROP_MAP_HEAD.put(IDStrings.SINGZINC, "Graceful I I");
        PROP_MAP_HEAD.put(IDStrings.SINGTIN, "Malleable I I");
        PROP_MAP_HEAD.put(IDStrings.SINGALUMINUM, "Recyclable I I");
        PROP_MAP_HEAD.put(IDStrings.SINGSILVER, "Enchanting I I");
        PROP_MAP_HEAD.put(IDStrings.SINGMAGNESIUM, "Flammable I I");
        PROP_MAP_HEAD.put(IDStrings.SINGLEAD, "Poisonous I I");
        PROP_MAP_HEAD.put(IDStrings.SINGGOLD, "Golden Veil I I");
        PROP_MAP_HEAD.put(IDStrings.SINGIRON, "Stability I I");
        PROP_MAP_HEAD.put(IDStrings.SINGINFINITY, "Breakpoint");

        PROP_MAP_ROD.put(IDStrings.VOID, "Fear The Void");
        PROP_MAP_ROD.put(IDStrings.INFINITY, "Conceptual Defence");
        PROP_MAP_ROD.put(IDStrings.FORTUNE, "Merchant's Veil");
        PROP_MAP_ROD.put(IDStrings.MAGIC, "Secrets Revealed");
        PROP_MAP_ROD.put(IDStrings.EARTH, "Grinder");
        PROP_MAP_ROD.put(IDStrings.METAL, "Conductor");
        PROP_MAP_ROD.put(IDStrings.MAGSTEEL, "Flammable");
        PROP_MAP_ROD.put(IDStrings.TITANIUM, "Durable");
        PROP_MAP_ROD.put(IDStrings.MYTHRIL, "Sting of Gondolin");
        PROP_MAP_ROD.put(IDStrings.ADAMANTITE, "Adamant");
        PROP_MAP_ROD.put(IDStrings.MAGNONIUM, "Flaming Hot");
        PROP_MAP_ROD.put(IDStrings.SINGCOPPER, "Conductive I I");
        PROP_MAP_ROD.put(IDStrings.SINGZINC, "Super Lightweight I I");
        PROP_MAP_ROD.put(IDStrings.SINGTIN, "Can I I");
        PROP_MAP_ROD.put(IDStrings.SINGALUMINUM, "Soft I I");
        PROP_MAP_ROD.put(IDStrings.SINGSILVER, "Soft Touch I I");
        PROP_MAP_ROD.put(IDStrings.SINGMAGNESIUM, "Magnetesium I I");
        PROP_MAP_ROD.put(IDStrings.SINGLEAD, "Leech I I");
        PROP_MAP_ROD.put(IDStrings.SINGGOLD, "All That Glitters I I");
        PROP_MAP_ROD.put(IDStrings.SINGIRON, "Sharper I I");

    }

}
