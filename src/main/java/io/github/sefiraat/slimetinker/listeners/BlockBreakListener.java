package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.experience.Experience;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;

public class BlockBreakListener implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        ItemStack heldItem = event.getPlayer().getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        if (cancelIfBroken(heldItem)) {
            event.getPlayer().sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
            event.setCancelled(true);
            return;
        }

        if (shouldGrantExp(heldItem, event.getBlock())) {
            Experience.addToolExp(heldItem, 1, event.getPlayer());
        }

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        if (damageable.getDamage() == itemStack.getType().getMaxDurability() - 1) { // Tool is 'broken'
            return true;
        }
        return false;
    }

    private boolean shouldGrantExp(ItemStack itemStack, Block block) {

        String toolType = itemStack.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getToolInfoHeadType(), PersistentDataType.STRING);

        // Hoe Stuff (Ageable and fully grown only)
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) block.getBlockData();
            if (ageable.getAge() == ageable.getMaximumAge()) {
                return toolType.equals(IDStrings.ID_HOE);
            }
            return false;
        }

        // Block isn't in the block map, so no Exp
        if (!BlockMap.materialMap.containsKey(block.getType())) {
            return false;
        }

        // Return toolType matches the stored one from the map
        return BlockMap.materialMap.get(block.getType()).equals(toolType);

    }

}
