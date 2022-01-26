package io.github.sefiraat.slimetinker.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.commands.Commands;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterialManager;

import java.util.ArrayList;
import java.util.List;

public class DispatchManager {

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
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.isValidHead()) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_BINDER", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.isValidBinder()) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_ROD", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.isValidRod()) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_PLATE", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.isValidPlates()) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_GAMBESON", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.isValidGambeson()) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_LINKS", context -> {
            List<String> s = new ArrayList<>();
            for (TinkerMaterial tinkerMaterial : TinkerMaterialManager.getMap().values()) {
                if (tinkerMaterial.isValidLinks()) {
                    s.add(tinkerMaterial.getId());
                }
            }
            return s;
        });
    }
}
