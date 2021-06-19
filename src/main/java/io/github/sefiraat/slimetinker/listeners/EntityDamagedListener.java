package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EntityDamagedListener implements Listener {

    @EventHandler
    public void onPlayerDamaged(EntityDamageByEntityEvent event) { // When player is damaged, for Diamond mod

        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getEntity();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        modChecks(event, heldItem);

    }


    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player) || event.isCancelled() || !(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getDamager();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();

        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);
        int toolLevel = Experience.getToolLevel(c);

        EventResult eventResult = new EventResult();

        if (cancelIfBroken(heldItem) && !propHeadDuralium(eventResult, matPropertyHead)) {
            player.sendMessage(ThemeUtils.WARNING + "Your weapon is broken, you should really repair it!");
            event.setCancelled(true);
            return;
        }

        propertyChecks(event, eventResult, matPropertyHead, matPropertyBinding, matPropertyRod, toolLevel);
        modChecks(event, heldItem, eventResult);

        Experience.addToolExp(heldItem, (int) Math.ceil(event.getDamage() * eventResult.getToolExpMod()), player);

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    private void propertyChecks(EntityDamageByEntityEvent event, EventResult eventResult, String matPropertyHead, String matPropertyBinding, String matPropertyRod, int toolLevel) {

        if (matPropertyHead.equals(IDStrings.ALUBRASS)) { // ABRA
            propHeadAluBrass(event);
        }

        if (matPropertyHead.equals(IDStrings.COPPER)) { // BRAINS NOT BRAWN
            propHeadCopper(eventResult);
        }

        if ((matPropertyHead.equals(IDStrings.COBALT) && matPropertyRod.equals(IDStrings.NICKEL) || (matPropertyHead.equals(IDStrings.NICKEL) && matPropertyRod.equals(IDStrings.COBALT)))) { // CHARGED
            propCharged(event, eventResult);
        }

        if (matPropertyHead.equals(IDStrings.MAGNESIUM)) { // FLAMMABLE
            propHeadMagnesium(event, toolLevel);
        }

        if (matPropertyHead.equals(IDStrings.GOLD)) { // GOLDEN VEIL
            propHeadGold(eventResult);
        }

        if (matPropertyHead.equals(IDStrings.TIN)) { // MALLEABLE
            propHeadTin(eventResult);
        }

        if (matPropertyHead.equals(IDStrings.LEAD)) { // POISONOUS
            propHeadLead(event);
        }

        if (matPropertyHead.equals(IDStrings.STEEL)) { // STAINLESS
            propHeadSteel(event);
        }

        if (matPropertyHead.equals(IDStrings.BRASS)) { // STIFF
            propHeadBrass(eventResult);
        }

        if (matPropertyRod.equals(IDStrings.ALUBRASS)) { // STUDIOUS
            propRodAlubrass(eventResult);
        }

        if (matPropertyHead.equals(IDStrings.HARD)) { // TUFFSTUFF
            propHeadHard((LivingEntity) event.getEntity());
        }

        if (matPropertyHead.equals(IDStrings.DAMSTEEL)) { // VAMPIRISM
            propHeadDamsteel((Player) event.getDamager(), eventResult);
        }

    }

    private void propHeadAluBrass(EntityDamageByEntityEvent event) {
        int rnd = ThreadLocalRandom.current().nextInt(1,4);
        if (rnd == 1) {
            int rndX = ThreadLocalRandom.current().nextInt(-25,26);
            int rndY = ThreadLocalRandom.current().nextInt(0,5);
            int rndZ = ThreadLocalRandom.current().nextInt(-25,26);
            Entity entity = event.getEntity();
            Location location = entity.getLocation().clone().add(rndX, rndY, rndZ);
            if (entity.getWorld().getBlockAt(location).getType() == Material.AIR) {
                entity.teleport(location);
                entity.getWorld().playEffect(event.getDamager().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
            }
        }
    }

    private void propHeadCopper(EventResult eventResult) {
        eventResult.setDamageMod(eventResult.getDamageMod() - 0.5);
        eventResult.setToolExpMod(eventResult.getToolExpMod() + 1);
    }

    private void propCharged(EntityDamageByEntityEvent event, EventResult eventResult) {
        LivingEntity e = (LivingEntity) event.getEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1,6);
        if (rnd == 1) {
            eventResult.setDamageMod(eventResult.getDamageMod() * 3);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.YELLOW, 5);
            e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1, 1, 1, 0.5, dustOptions);
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 40,99);
            e.addPotionEffect(potionEffect);
        }
    }

    private boolean propHeadDuralium(EventResult eventResult, String matPropertyHead) {
        if (matPropertyHead.equals(IDStrings.DURALIUM)) {
            eventResult.setDamageMod(eventResult.getDamageMod() - 0.5);
            eventResult.setToolExpMod(0);
            return true;
        }
        return false;
    }

    private void propHeadMagnesium(EntityDamageByEntityEvent event, int toolLevel) {
        LivingEntity e = (LivingEntity) event.getEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 100);
        if (rnd < (toolLevel * 5)) {
            e.setFireTicks(100);
        }
    }

    private void propHeadGold(EventResult eventResult) {
        eventResult.setDamageMod(eventResult.getDamageMod() - 1);
    }

    private void propHeadTin(EventResult eventResult) {
        eventResult.setDamageMod(eventResult.getDamageMod() - 0.5);
    }

    private void propHeadLead(EntityDamageByEntityEvent event) {
        LivingEntity e = (LivingEntity) event.getEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 5);
        if (rnd == 1) {
            e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0, true, true, false));
        }
    }

    private void propHeadSteel(EntityDamageByEntityEvent event) {
        Entity e = event.getEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
    }

    private void propHeadBrass(EventResult eventResult) {
        eventResult.setDamageMod(eventResult.getDamageMod() + 0.5);
    }

    private void propRodAlubrass(EventResult eventResult) {
        eventResult.setDamageMod(eventResult.getDamageMod() - 0.5);
        eventResult.setToolExpMod(eventResult.getToolExpMod() + 0.5);
    }

    private void propHeadHard(LivingEntity e) {
        push(e, e.getLocation());
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 40,99);
        e.addPotionEffect(potionEffect);
    }

    private void propHeadDamsteel(Player player, EventResult eventResult) {
        if (GeneralUtils.day(player.getWorld())) {
            eventResult.setDamageMod(eventResult.getDamageMod() - 0.5);
        } else {
            eventResult.setDamageMod(eventResult.getDamageMod() + 0.5);
        }
        int rnd = ThreadLocalRandom.current().nextInt(1, 4);
        if (rnd == 1) {
            player.setHealth(Math.min(player.getHealth() + 1, player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    private void modChecks(EntityDamageByEntityEvent event, ItemStack heldItem, EventResult eventResult) { // Player damaging entity

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (modLevels.containsKey(Material.QUARTZ.toString())) { // QUARTZ
            modCheckQuartz(modLevels.get(Material.QUARTZ.toString()), eventResult);
        }

    }

    private void modChecks(EntityDamageByEntityEvent event, ItemStack heldItem) { // Entity Damaging player

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (modLevels.containsKey(Material.DIAMOND.toString())) { // DIAMOND
            modCheckDiamond(event, modLevels.get(Material.DIAMOND.toString()));
        }

    }

    private void modCheckQuartz(int level, EventResult eventResult) {
        eventResult.setDamageMod(eventResult.getDamageMod() + (level * 0.2));
    }

    private void modCheckDiamond(EntityDamageByEntityEvent event, int level) {
        int rnd = ThreadLocalRandom.current().nextInt(1,11);
        if (rnd <= (level)) {
            Entity e = event.getDamager();
            LivingEntity l = (LivingEntity) e;
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.TEAL, 1);
            e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
            l.damage(event.getDamage());
            event.setCancelled(true);
        }
    }

    private void push(LivingEntity pushed, Location loc) {
        pushed.setVelocity(loc.toVector().subtract(pushed.getLocation().toVector()).normalize().multiply(-1));
    }

}
