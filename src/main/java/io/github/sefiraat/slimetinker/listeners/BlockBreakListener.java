package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BlockBreakListener implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (event.isCancelled()) {
            return;
        }

        ItemStack heldItem = event.getPlayer().getInventory().getItemInMainHand();
        Block block = event.getBlock();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        if (cancelIfBroken(heldItem)) {
            event.getPlayer().sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
            event.setCancelled(true);
            return;
        }

        if (BlockUtils.isPlaced(block)) {
            return;
        }

        // pre-flight, some tools stop block breaking



        // Property and Mod checks, carries around the additional and normal drops
        Collection<ItemStack> drops = block.getDrops(heldItem);
        Collection<ItemStack> addDrops = new ArrayList<>();
        Collection<ItemStack> removeDrops = new ArrayList<>();
        EventResult eventResult = new EventResult();

        propertyChecks(heldItem, block, drops, addDrops, removeDrops);
        modChecks(heldItem, block, addDrops);

        event.setDropItems(false);

        for (ItemStack i : addDrops) {
            block.getWorld().dropItemNaturally(block.getLocation().clone().add(0.5, 0.5, 0.5), i);
        }
        for (ItemStack i : drops) {
            if (!removeDrops.contains(i)) {
                block.getWorld().dropItemNaturally(block.getLocation().clone().add(0.5, 0.5, 0.5), i);
            }
        }
        if (shouldGrantExp(heldItem, event.getBlock())) { // Should grant exp (checks tool / material validity and the crop state)
            Experience.addToolExp(heldItem, (int) Math.ceil(1 * eventResult.getToolExpMod()), event.getPlayer(), true);
        }

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        // Tool is 'broken'
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    private boolean shouldGrantExp(ItemStack itemStack, Block block) {

        String toolType = itemStack.getItemMeta().getPersistentDataContainer().get(SlimeTinker.inst().getKeys().getToolInfoToolType(), PersistentDataType.STRING);

        // Hoe Stuff (Ageable and fully grown only)
        if (block.getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) block.getBlockData();
            if (ageable.getAge() == ageable.getMaximumAge()) {
                return toolType.equals(IDStrings.HOE);
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

    private void propertyChecks(ItemStack heldItem, Block block, Collection<ItemStack> drops, Collection<ItemStack> addDrops, Collection<ItemStack> removeDrops) {

        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        if (matPropertyHead.equals(IDStrings.CORBRONZE)) {
            propHeadCorbronze(drops, addDrops, removeDrops);
        }

    }

    private void propHeadCorbronze(Collection<ItemStack> drops, Collection<ItemStack> addDrops, Collection<ItemStack> removeDrops) {
        Collection<ItemStack> newAddDrops = new ArrayList<>();

        Iterator<Recipe> iter = Bukkit.recipeIterator();
        while (iter.hasNext()) {
            Recipe recipe = iter.next();
            if (!(recipe instanceof FurnaceRecipe)) continue;
            for (ItemStack i : drops) {
                if (i.isSimilar(((FurnaceRecipe) recipe).getInput())) {
                    ItemStack ni = recipe.getResult().clone();
                    ni.setAmount(i.getAmount());
                    newAddDrops.add(ni);
                    removeDrops.add(i);
                    break;
                }
            }
            if (!addDrops.isEmpty()) {
                for (ItemStack i : addDrops) {
                    if (i.isSimilar(((FurnaceRecipe) recipe).getInput())) {
                        ItemStack ni = recipe.getResult().clone();
                        ni.setAmount(i.getAmount());
                        newAddDrops.add(ni);
                        removeDrops.add(i);
                        break;
                    }
                }
            }
        }
        addDrops.clear();
        addDrops.addAll(newAddDrops);
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
