package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.BlockBreakEvents;
import io.github.sefiraat.slimetinker.events.EventFriend;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.enums.TraitEventType;
import io.github.sefiraat.slimetinker.utils.enums.TraitPartType;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BlockBreakListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (event.isCancelled()) {
            return;
        }

        Player p = event.getPlayer();
        ItemStack heldItem = event.getPlayer().getInventory().getItemInMainHand();
        Block block = event.getBlock();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        if (BlockUtils.isPlaced(block)) {
            return;
        }

        // Property and Mod checks, carries around the additional and normal drops
        EventFriend friend = new EventFriend();
        friend.setHeldItem(heldItem);
        friend.setPlayer(p);
        friend.setBlock(block);
        friend.setDrops(block.getDrops(heldItem)); // Stores the event drops. All may not be dropped
        friend.setAddDrops(new ArrayList<>()); // Additional drops or substitutions for items from the main collection
        friend.setRemoveDrops(new ArrayList<>()); // Items to remove from the main collection if moved/reformed into the additional

        // Properties
        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        // Cancel if tool is broken (moved down here as we bypass if the duralium event fires)
        if (cancelIfBroken(heldItem)) {
            if (matPropertyHead.equals(IDStrings.DURALIUM) || matPropertyRod.equals(IDStrings.TITANIUM)) { // Run duralium as it will flag the duraliumCheck meaning we can bypass durability checks
                BlockBreakEvents.headDuralium(friend);
            } else {
                event.getPlayer().sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
                event.setCancelled(true);
                return;
            }
        }

        TraitEventType traitEventType = TraitEventType.BLOCK_BREAK;
        CMManager.getMAP().get(matPropertyHead).runEvent(traitEventType, TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(traitEventType, TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(traitEventType, TraitPartType.ROD, friend);

        // Mods
        modChecks(heldItem, block, friend.getAddDrops());

        // Settle
        event.setDropItems(false);

        for (ItemStack i : friend.getDrops()) { // Drop items in original collection not flagged for removal
            if (friend.getRemoveDrops().contains(i)) {
                continue;
            }
            if (friend.isBlocksIntoInv()) {
                Map<Integer, ItemStack> remainingItems = p.getInventory().addItem(i);
                for (ItemStack i2 : remainingItems.values()) {
                    block.getWorld().dropItem(block.getLocation().clone().add(0.5, 0.5, 0.5), i2);
                }
                continue;
            }
            block.getWorld().dropItem(block.getLocation().clone().add(0.5, 0.5, 0.5), i);
        }

        for (ItemStack i : friend.getAddDrops()) { // Then the additional items collection - no removals
            if (friend.isBlocksIntoInv()) {
                Map<Integer, ItemStack> remainingItems = p.getInventory().addItem(i);
                for (ItemStack i2 : remainingItems.values()) {
                    block.getWorld().dropItem(block.getLocation().clone().add(0.5, 0.5, 0.5), i2);
                }
                continue;
            }
            block.getWorld().dropItem(block.getLocation().clone().add(0.5, 0.5, 0.5), i);
        }

        if (shouldGrantExp(heldItem, event.getBlock())) { // Should grant exp (checks tool / material validity and the crop state)
            Experience.addToolExp(heldItem, (int) Math.ceil(1 * friend.getToolExpMod()), event.getPlayer(), true);
        }

        if (event.getExpToDrop() > 0 && friend.isMetalCheck()) { // todo Get outta dodge with this one
            Experience.addToolExp(heldItem, (int) Math.ceil(event.getExpToDrop() / 10D), event.getPlayer(), true);
            event.setExpToDrop(0);
        }

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1; // Tool is 'broken'
    }

    private boolean shouldGrantExp(ItemStack itemStack, Block block) {

        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String toolType = c.get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);
        assert toolType != null;

        // Hoe Stuff (Ageable and fully grown only)
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) block.getBlockData();
            if (ageable.getAge() == ageable.getMaximumAge()) {
                return toolType.equals(IDStrings.HOE);
            }
            return false;
        }

        // Block isn't in the block map, so no Exp
        if (!BlockMap.getMaterialMap().containsKey(block.getType())) {
            return false;
        }

        // Return toolType matches the stored one from the map
        return BlockMap.getMaterialMap().get(block.getType()).equals(toolType);

    }

    private void modChecks(ItemStack heldItem, Block block, Collection<ItemStack> addDrops) {
        modCheckLapis(heldItem, block, addDrops);
    }


    private void modCheckLapis(ItemStack heldItem, Block block, Collection<ItemStack> addDrops) {

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (block.getDrops().isEmpty() || !modLevels.containsKey(Material.LAPIS_LAZULI.toString()) || heldItem.containsEnchantment(Enchantment.SILK_TOUCH)) { // There must be drops, the tools must have the lapis mod and the tool cannot have silk
            return;
        }

        int lapisLevel = modLevels.get(Material.LAPIS_LAZULI.toString());
        ItemStack dummyFortune = new ItemStack(Material.DIAMOND_PICKAXE);
        dummyFortune.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);

        List<Material> materialList = new ArrayList<>();

        for (ItemStack drop : block.getDrops()) {
            for (ItemStack dropFort : block.getDrops(dummyFortune)) {
                if (dropFort.getType() == drop.getType() && dropFort.getAmount() > drop.getAmount()) {
                    materialList.add(drop.getType());
                }
            }
        }

        for (ItemStack drop : block.getDrops(heldItem)) {
            if (materialList.contains(drop.getType())) {
                int additionalAmount = (int) Math.floor(drop.getAmount() * (lapisLevel * 0.1));
                if (additionalAmount > 0) {
                    ItemStack additionalDrop = new ItemStack(drop.getType());
                    additionalDrop.setAmount(additionalAmount);
                    addDrops.add(additionalDrop);
                    Location location = block.getLocation().clone().add(0.5,0.5,0.5);
                    Particle.DustOptions dustOptions = new Particle.DustOptions(Color.BLUE, 2);
                    block.getWorld().spawnParticle(Particle.REDSTONE, location, 10, 0.2, 0.2, 0.2, 0.5, dustOptions);
                }
            }
        }
    }


}
