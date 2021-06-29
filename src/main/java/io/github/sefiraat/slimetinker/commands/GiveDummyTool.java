package io.github.sefiraat.slimetinker.commands;

import io.github.mooy1.infinitylib.commands.AbstractCommand;
import io.github.sefiraat.slimetinker.items.Tools;
import io.github.sefiraat.slimetinker.items.templates.CombinationDefinition;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GiveDummyTool extends AbstractCommand {

    public GiveDummyTool() {
        super("GiveTool", "gives tool set", true);
    }

    @Override
    public void onExecute(@NotNull CommandSender commandSender, String @NotNull [] strings) {

        Player player = (Player) commandSender;
        CombinationDefinition tool = new CombinationDefinition(IDStrings.HEAD, strings[1], strings[2], strings[3], strings[4]);
        if (tool.getHeadMaterial().equals(IDStrings.REINFORCED) || tool.getRodMaterial().equals(IDStrings.HARD) || tool.getHeadMaterial().equals(IDStrings.SINGINFINITY) || tool.getHeadMaterial().equals(IDStrings.OSMIUM)) { // Reinforced Head/ Hard Rod tools are explosive
            player.getInventory().addItem(Tools.EXP_SHOVEL.getStack(tool));
        } else {
            player.getInventory().addItem(Tools.SHOVEL.getStack(tool));
        }

    }

    @Override
    public void onTab(@NotNull CommandSender commandSender, String @NotNull [] strings, @NotNull List<String> list) {

    }
}
