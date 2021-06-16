package io.github.sefiraat.slimetinker.commands;

import io.github.mooy1.infinitylib.commands.AbstractCommand;
import io.github.sefiraat.slimetinker.items.Tools;
import io.github.sefiraat.slimetinker.items.templates.ToolDefinition;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// TODO REMOVE BEFORE LIVE

public class GiveDummyTool extends AbstractCommand {

    public GiveDummyTool() {
        super("givetool", "gives tool set", true);
    }

    @Override
    public void onExecute(@NotNull CommandSender commandSender, @NotNull String[] strings) {

        Player player = (Player) commandSender;

        ToolDefinition toolDefinitionShovel = new ToolDefinition(IDStrings.ID_HEAD, IDStrings.ID_SHOVEL, IDStrings.ID_IRON, IDStrings.ID_VINE, IDStrings.ID_IRON);
        ToolDefinition toolDefinitionPickaxe = new ToolDefinition(IDStrings.ID_HEAD, IDStrings.ID_PICKAXE, IDStrings.ID_IRON, IDStrings.ID_VINE, IDStrings.ID_IRON);
        ToolDefinition toolDefinitionAxe = new ToolDefinition(IDStrings.ID_HEAD, IDStrings.ID_AXE, IDStrings.ID_IRON, IDStrings.ID_VINE, IDStrings.ID_IRON);
        ToolDefinition toolDefinitionHoe = new ToolDefinition(IDStrings.ID_HEAD, IDStrings.ID_HOE, IDStrings.ID_IRON, IDStrings.ID_VINE, IDStrings.ID_IRON);
        ToolDefinition toolDefinitionSword = new ToolDefinition(IDStrings.ID_HEAD, IDStrings.ID_SWORD, IDStrings.ID_IRON, IDStrings.ID_VINE, IDStrings.ID_IRON);

        player.getInventory().addItem(Tools.SHOVEL.getStack(toolDefinitionShovel));
        player.getInventory().addItem(Tools.SHOVEL.getStack(toolDefinitionPickaxe));
        player.getInventory().addItem(Tools.SHOVEL.getStack(toolDefinitionAxe));
        player.getInventory().addItem(Tools.SHOVEL.getStack(toolDefinitionHoe));
        player.getInventory().addItem(Tools.SHOVEL.getStack(toolDefinitionSword));

    }

    @Override
    public void onTab(@NotNull CommandSender commandSender, @NotNull String[] strings, @NotNull List<String> list) {

    }
}
