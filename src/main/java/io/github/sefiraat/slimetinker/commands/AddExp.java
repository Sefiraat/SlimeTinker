package io.github.sefiraat.slimetinker.commands;

import io.github.mooy1.infinitylib.commands.AbstractCommand;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AddExp extends AbstractCommand {

    public AddExp() {
        super("AddExp", "gives exp to tool in hand", true);
    }

    @Override
    public void onExecute(@NotNull CommandSender commandSender, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;

        if (ItemUtils.isTool(player.getInventory().getItemInMainHand())) {
            Experience.addExp(player.getInventory().getItemInMainHand(), 100, player, false);
        }

    }

    @Override
    public void onTab(@NotNull CommandSender commandSender, @NotNull String @NotNull [] strings, @NotNull List<String> list) {

    }
}
