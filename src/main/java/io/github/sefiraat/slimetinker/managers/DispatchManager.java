package io.github.sefiraat.slimetinker.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.commands.Commands;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.componentmaterials.ComponentMaterial;

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
            for (ComponentMaterial componentMaterial : CMManager.getMap().values()) {
                if (componentMaterial.isValidToolHead()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_BINDER", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMap().values()) {
                if (componentMaterial.isValidToolBinder()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_ROD", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMap().values()) {
                if (componentMaterial.isValidToolRod()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_PLATE", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMap().values()) {
                if (componentMaterial.isValidPlates()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_GAMBESON", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMap().values()) {
                if (componentMaterial.isValidGambeson()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });

        commandManager.getCommandCompletions().registerCompletion("PART_MATERIALS_LINKS", context -> {
            List<String> s = new ArrayList<>();
            for (ComponentMaterial componentMaterial : CMManager.getMap().values()) {
                if (componentMaterial.isValidLinks()) {
                    s.add(componentMaterial.getCmIdentity().getId());
                }
            }
            return s;
        });
    }
}
