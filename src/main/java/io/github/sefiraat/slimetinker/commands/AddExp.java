package io.github.sefiraat.slimetinker.commands;

import io.github.mooy1.infinitylib.commands.AbstractCommand;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.utils.Experience;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// TODO REMOVE BEFORE LIVE

public class AddExp extends AbstractCommand {

    public AddExp() {
        super("addexp", "gives exp to tool in hand", true);
    }

    @Override
    public void onExecute(@NotNull CommandSender commandSender, @NotNull String[] strings) {

        Player player = (Player) commandSender;

        if (ToolTemplate.isTool(player.getInventory().getItemInMainHand())) {
            Experience.addToolExp(player.getInventory().getItemInMainHand(), 100, player);
        }

    }

    @Override
    public void onTab(@NotNull CommandSender commandSender, @NotNull String[] strings, @NotNull List<String> list) {

    }
}
