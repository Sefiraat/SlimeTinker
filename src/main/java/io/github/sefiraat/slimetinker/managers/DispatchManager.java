package io.github.sefiraat.slimetinker.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.commands.Commands;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DispatchManager {

    @Getter
    private final PaperCommandManager commandManager;

    public DispatchManager() {

        this.commandManager = new PaperCommandManager(SlimeTinker.inst());
        this.commandManager.registerCommand(new Commands());

        commandManager.getCommandCompletions().registerCompletion("ITEM_CLASS_TOOL", context -> ImmutableList.of(
            "PICK",
            "SHOVEL",
            "AXE",
            "HOE",
            "SWORD"
        ));

        commandManager.getCommandCompletions().registerCompletion("ITEM_CLASS_ARMOUR", context -> ImmutableList.of(
            "HELMET",
            "CHESTPLATE",
            "LEGGINGS",
            "BOOTS"
        ));

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_HEAD", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMAP().values()) {
                if (componentMaterial.isValidToolHead()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_BINDER", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMAP().values()) {
                if (componentMaterial.isValidToolBinder()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_ROD", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMAP().values()) {
                if (componentMaterial.isValidToolRod()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_PLATE", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMAP().values()) {
                if (componentMaterial.isValidPlates()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_GAMBESON", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMAP().values()) {
                if (componentMaterial.isValidGambeson()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_LINKS", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMAP().values()) {
                if (componentMaterial.isValidLinks()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

//            ImmutableList.of(
//                    "IRON",
//                    "GOLD",
//                    "COPPER",
//                    "SILVER",
//                    "TIN",
//                    "MAGNESIUM",
//                    "ALUMINUM",
//                    "LEAD",
//                    "ZINC",
//                    "STEEL",
//                    "DAMASCUS_STEEL",
//                    "DURALIUM",
//                    "BRONZE",
//                    "ALUMINUM_BRONZE",
//                    "HARDENED_METAL",
//                    "CORINTHIAN_BRONZE",
//                    "SOLDER",
//                    "BILLON",
//                    "BRASS",
//                    "ALUMINUM_BRASS",
//                    "NICKEL",
//                    "COBALT",
//                    "REINFORCED_ALLOY",
//                    "STRING",
//                    "VINE",
//                    "CRIMSON_ROOT",
//                    "WARPED_ROOT",
//                    "WEEPING_VINE",
//                    "TWISTED_VINE",
//                    "SLIME",
//                    "LEATHER",
//                    "REDSTONE_ALLOY",
//                    "SILICON",
//                    "FERROSILICON",
//                    "VOID",
//                    "INFINITE",
//                    "FORTUNE_SINGULARITY",
//                    "MAGIC_SINGULARITY",
//                    "EARTH_SINGULARITY",
//                    "METAL_SINGULARITY",
//                    "MAGSTEEL",
//                    "TITANIUM",
//                    "MYTHRIL",
//                    "ADAMANTITE",
//                    "MAGNONIUM",
//                    "COPPER_SINGULARITY",
//                    "ZINC_SINGULARITY",
//                    "TIN_SINGULARITY",
//                    "ALUMINUM_SINGULARITY",
//                    "SILVER_SINGULARITY",
//                    "MAGNESIUM_SINGULARITY",
//                    "LEAD_SINGULARITY",
//                    "GOLD_SINGULARITY",
//                    "IRON_SINGULARITY",
//                    "DIAMOND_SINGULARITY",
//                    "INFINITY_SINGULARITY",
//                    "SLIME_STEEL",
//                    "REINFORCED_SLIME_STEEL",
//                    "OSMIUM_SUPERALLOY",
//                    "OSMIUM",
//                    "SEGGANESSON",
//                    "UNPATENTABLIUM",
//                    "STAINLESS_STEEL",
//                    "VEX_GEM",
//                    "STAR_DUST",
//                    "GHOSTLY_ESSENCE",
//                    "TESSERACTING_MATERIAL",
//                    "RUBBER",
//                    "REFINED_IRON",
//                    "MIXED_METAL",
//                    "ADVANCED_ALLOY",
//                    "THORIUM",
//                    "MAG_THOR",
//                    "CARBON_MESH",
//                    "SCRAP",
//                    "IRIDIUM"
//            );

    }
}
