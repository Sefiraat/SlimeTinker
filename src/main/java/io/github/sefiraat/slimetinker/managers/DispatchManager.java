package io.github.sefiraat.slimetinker.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.commands.Commands;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterialManager;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

import java.util.ArrayList;
import java.util.List;

public class DispatchManager {

    private final PaperCommandManager commandManager;

    public DispatchManager() {

        this.commandManager = new PaperCommandManager(SlimeTinker.getInstance());
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
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.getTraitToolHead() != null && SlimeTinker.getInstance().getTraitManager().isEnabled(tinkerMaterial.getId(), Ids.HEAD)) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_BINDER", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.getTraitToolBinder() != null && SlimeTinker.getInstance().getTraitManager().isEnabled(tinkerMaterial.getId(), Ids.BINDING)) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_ROD", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.getTraitToolRod() != null && SlimeTinker.getInstance().getTraitManager().isEnabled(tinkerMaterial.getId(), Ids.ROD)) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_PLATE", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.getTraitArmorPlates() != null && SlimeTinker.getInstance().getTraitManager().isEnabled(tinkerMaterial.getId(), Ids.PLATE)) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_GAMBESON", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.getTraitArmorGambeson() != null && SlimeTinker.getInstance().getTraitManager().isEnabled(tinkerMaterial.getId(), Ids.GAMBESON)) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_LINKS", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.getTraitArmorLinks() != null && SlimeTinker.getInstance().getTraitManager().isEnabled(tinkerMaterial.getId(), Ids.LINKS)) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });
    }
}
