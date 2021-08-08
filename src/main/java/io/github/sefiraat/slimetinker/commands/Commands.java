package io.github.sefiraat.slimetinker.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.items.templates.ArmourDefinition;
import io.github.sefiraat.slimetinker.items.templates.ToolDefinition;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import jdk.jfr.Description;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandAlias("SlimeTinker|st|tinker")
public class Commands extends BaseCommand {

    @Default
    public void onDefault(CommandSender sender) {
        if (sender instanceof Player) {
            sender.sendMessage(ThemeUtils.ERROR + "Please provide a valid subcommand.");
        }
    }

    @Subcommand("GenerateItem")
    @CommandPermission("SlimeTinker.Admin")
    @Description("Creates a new SlimeTinker item")
    public class GenerateItem extends BaseCommand {

        @Subcommand("Armour")
        @CommandCompletion("@ITEM_CLASS_ARMOUR @PART_MATERIALS_PLATE @PART_MATERIALS_GAMBESON @PART_MATERIALS_LINKS")
        public void armour(CommandSender sender, String type, String plateMat, String gambesonMat, String linksMat) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                ArmourDefinition armour = new ArmourDefinition(IDStrings.PLATE, type, plateMat, gambesonMat, linksMat);
                p.getInventory().addItem(Guide.HELM.getStack(armour));
            } else {
                sender.sendMessage(ThemeUtils.ERROR + "This can only be done as a player.");
            }
        }

        @Subcommand("Tool")
        @CommandCompletion("@ITEM_CLASS_TOOL @PART_MATERIALS_HEAD @PART_MATERIALS_BINDER @PART_MATERIALS_ROD")
        public void tool(CommandSender sender, String type, String headMat, String binderMat, String rodMat) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                ToolDefinition tool = new ToolDefinition(IDStrings.HEAD, type, headMat, binderMat, rodMat);
                if (ItemUtils.isToolExplosive(headMat, rodMat)) {
                    p.getInventory().addItem(Guide.EXP_SHOVEL.getStack(tool));
                } else {
                    p.getInventory().addItem(Guide.SHOVEL.getStack(tool));
                }
            } else {
                sender.sendMessage(ThemeUtils.ERROR + "This can only be done as a player.");
            }
        }

    }

}
