package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EffectRunnable extends BukkitRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.inst().getServer().getOnlinePlayers()) {
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            if (!ToolTemplate.isTool(heldItem) || ItemUtils.isToolBroken(heldItem)) { // Either not a ST Tool or it is one, but broken
                return;
            }

            Map<PotionEffectType, Integer> potionEffects = new HashMap<>();
            checkProperties(heldItem, player, potionEffects);
            checkModifications(heldItem, player, potionEffects);

            for (Map.Entry<PotionEffectType, Integer> entry : potionEffects.entrySet()) {
                player.addPotionEffect(new PotionEffect(entry.getKey(), SlimeTinker.RUNNABLE_TICK_RATE + 5, entry.getValue(), false, true, true));
            }

        }
    }

    private void checkProperties(ItemStack heldItem, Player player, Map<PotionEffectType, Integer> potionEffects) {

        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);

        if (matPropertyRod.equals(IDStrings.GOLD)) { // ALL THE GLITTERS
            propRodGold(potionEffects);
        }

        if (matPropertyBinding.equals(IDStrings.VINEGREEN)) { // ATTRACTION
            propBindVinegreen(player);
        }

        if (matPropertyRod.equals(IDStrings.TIN)) { // CAN
            propRodTin(potionEffects);
        }

        if (matPropertyBinding.equals(IDStrings.ROOTRED)) { // DECAY
            propBindRootred(heldItem, player);
        }

        if (matPropertyBinding.equals(IDStrings.VINERED)) { // DOOM
            propBindVinered(potionEffects);
        }

        if (matPropertyHead.equals(IDStrings.BILLON)) { // FAST
            propHeadBillon(potionEffects);
        }

        if (matPropertyHead.equals(IDStrings.GOLD)) { // GOLDEN VEIL
            propHeadGold(potionEffects);
        }

        if (matPropertyHead.equals(IDStrings.ZINC)) { // GRACEFUL
            propHeadZinc(potionEffects);
        }

        if (matPropertyBinding.equals(IDStrings.VINE)) { // GROWTH
            propBindVine(heldItem, player);
        }

        if (matPropertyHead.equals(IDStrings.SOLDER)) { // HIDDEN
            propHeadSolder(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.BRONZE)) { // INGHEIGHTS
            propRodBronze(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.LEAD)) { // LEECH
            propRodLead(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.MAGNESIUM)) { // MAGNETESIUM
            propRodMagnesium(player);
        }

        if (matPropertyHead.equals(IDStrings.TIN)) { // MALLEABLE
            propHeadTin(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.DAMSTEEL)) { //NIGHTSTALKER
            propRodDamsteel(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.BRASS)) { // OXYGENATED
            propRodBrass(potionEffects);
        }

        if (matPropertyBinding.equals(IDStrings.ROOTGREEN)) { // REFRESHING
            propBindRootgreen(player);
        }

        if (matPropertyHead.equals(IDStrings.BRONZE)) { // RESISTANT
            propHeadBronze(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.IRON)) { // SHARP1
            propRodIron(potionEffects);
        }

        if (matPropertyHead.equals(IDStrings.ALUBRONZE)) { // SHARP2
            propHeadAlubronze(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.SILVER)) { // SOFTTOUCH
            propRodSilver(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.BILLON)) { // SPRINGS
            propRodBillon(potionEffects);
        }

        if (matPropertyHead.equals(IDStrings.BRASS)) { // STIFF
            propHeadBrass(potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.ZINC)) { // SUPERLIGHTWEIGHT
            propRodZinc(player, potionEffects);
        }

        if (matPropertyRod.equals(IDStrings.CORBRONZE)) { // TOOHOTTOHANDLE
            propRodCorbronze(potionEffects);
        }

        if (matPropertyBinding.equals(IDStrings.STRING)) { // WEAK
            propBindString(potionEffects);
        }

    }

    private void propRodGold(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.GLOWING, potionEffects);
    }

    private void propBindVinegreen(Player player) {
        for (Entity entity : player.getNearbyEntities(5,5,5)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = player.getLocation();
                entity.teleport(getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    private void propRodTin(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.SATURATION, potionEffects);
    }

    private void propBindRootred(ItemStack heldItem, Player player) {
        if (!GeneralUtils.day(player.getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(heldItem);
            }
        }
    }

    private void propBindVinered(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.BAD_OMEN, potionEffects);
    }

    private void propHeadBillon(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.FAST_DIGGING, potionEffects);
    }

    private void propHeadGold(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.INVISIBILITY, potionEffects);
    }

    private void propHeadZinc(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, potionEffects);
    }

    private void propBindVine(ItemStack heldItem, Player player) {
        if (GeneralUtils.day(player.getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(heldItem);
            }
        }
    }

    private void propHeadSolder(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.INVISIBILITY, potionEffects);
    }

    private void propRodBronze(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.WITHER, potionEffects);
    }

    private void propRodLead(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, potionEffects, 2);
        increaseEffect(PotionEffectType.HUNGER, potionEffects);
    }

    private void propRodMagnesium(Player player) {
        for (Entity entity : player.getNearbyEntities(10,10,10)) {
            if (entity instanceof Item && ThreadLocalRandom.current().nextInt(1,3) == 1) {
                entity.teleport(player.getLocation());
            }
        }
    }

    private void propHeadTin(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.LUCK, potionEffects, 2);
    }

    private void propRodDamsteel(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.NIGHT_VISION, potionEffects);
    }

    private void propRodBrass(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.WATER_BREATHING, potionEffects);
    }

    private void propBindRootgreen(Player player) {
        int rnd = ThreadLocalRandom.current().nextInt(1,5);
        if (rnd == 1) {
            player.setHealth(Math.min(player.getHealth() + 1, player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    private void propHeadBronze(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.FIRE_RESISTANCE, potionEffects);
    }

    private void propRodIron(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, potionEffects);
    }

    private void propHeadAlubronze(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, potionEffects);
    }

    private void propRodSilver(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.SLOW_FALLING, potionEffects, 2);
    }

    private void propRodBillon(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.JUMP, potionEffects, 3);
    }

    private void propHeadBrass(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.UNLUCK, potionEffects, 2);
    }

    private void propRodZinc(Player player, Map<PotionEffectType, Integer> potionEffects) {
        if (!player.isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, potionEffects, 1);
        }
    }

    private void propRodCorbronze(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.CONFUSION, potionEffects);
    }

    private void propBindString(Map<PotionEffectType, Integer> potionEffects) {
        increaseEffect(PotionEffectType.WEAKNESS, potionEffects);
    }








    private void checkModifications(ItemStack heldItem, Player player, Map<PotionEffectType, Integer> potionEffects) {

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);
        for (Map.Entry<String, Integer> entry : modLevels.entrySet()) {
            if (Material.REDSTONE.toString().equals(entry.getKey())) {
                modRedstone(entry.getValue(), potionEffects);
            }
        }

    }

    private void modRedstone(int level, Map<PotionEffectType, Integer> potionEffects) {
        if (potionEffects.containsKey(PotionEffectType.FAST_DIGGING)) {
            potionEffects.put(PotionEffectType.FAST_DIGGING, potionEffects.get(PotionEffectType.FAST_DIGGING) + level);
        } else {
            potionEffects.put(PotionEffectType.FAST_DIGGING, level);
        }
    }




    public static Location getMid(World world, double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Location(world,x1 + (x2 - x1) * 0.5, y1 + (y2 - y1) * 0.5, z1 + (z2 - z1) * 0.5);
    }

    private void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + 1);
        } else {
            potionEffects.put(potionEffectType, 0);
        }
    }

    private void increaseEffect(PotionEffectType potionEffectType, Map<PotionEffectType, Integer> potionEffects, int amount) {
        if (potionEffects.containsKey(potionEffectType)) {
            potionEffects.put(potionEffectType, potionEffects.get(potionEffectType) + amount);
        } else {
            potionEffects.put(potionEffectType, amount);
        }
    }

}
