package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.runnables.event.RemoveMagmaBlock;
import io.github.sefiraat.slimetinker.runnables.event.RemovePoweredState;
import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.WorldUtils;
import io.github.sefiraat.slimetinker.utils.enums.Temperature;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import me.mrCookieSlime.Slimefun.cscorelib2.protection.ProtectableAction;
import org.apache.commons.lang.Validate;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wither;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.utils.EntityUtils.increaseEffect;

@UtilityClass
public final class TickEvents {

    public static void rodGold(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }

    public static void binderTwistingVine(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(WorldUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void rodTin(EventFriend friend) {
        increaseEffect(PotionEffectType.SATURATION, friend.getPotionEffects());
    }

    public static void binderCrimsonRoot(EventFriend friend) {
        if (!GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getTool());
            }
        }
    }

    public static void binderWeepingVine(EventFriend friend) {
        increaseEffect(PotionEffectType.BAD_OMEN, friend.getPotionEffects());
    }

    public static void headBillon(EventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects());
    }

    public static void headGold(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects());
    }

    public static void headZinc(EventFriend friend) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, friend.getPotionEffects());
    }

    public static void binderVine(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getTool());
            }
        }
    }

    public static void headSolder(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects());
    }

    public static void rodBronze(EventFriend friend) {
        increaseEffect(PotionEffectType.WITHER, friend.getPotionEffects());
    }

    public static void rodLead(EventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), 3);
        increaseEffect(PotionEffectType.HUNGER, friend.getPotionEffects());
    }

    public static void rodMagnesium(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof Item && ThreadLocalRandom.current().nextInt(1,3) == 1) {
                entity.teleport(friend.getPlayer().getLocation());
            }
        }
    }

    public static void headTin(EventFriend friend) {
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects());
    }

    public static void rodDamsteel(EventFriend friend) {
        increaseEffect(PotionEffectType.NIGHT_VISION, friend.getPotionEffects());
    }

    public static void rodBrass(EventFriend friend) {
        increaseEffect(PotionEffectType.WATER_BREATHING, friend.getPotionEffects());
    }

    public static void bindWarpedRoot(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1,5);
        if (rnd == 1) {
            friend.getPlayer().setHealth(Math.min(friend.getPlayer().getHealth() + 1, friend.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    public static void headBronze(EventFriend friend) {
        increaseEffect(PotionEffectType.FIRE_RESISTANCE, friend.getPotionEffects());
    }

    public static void rodIron(EventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects());
    }

    public static void headAlubronze(EventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects());
    }

    public static void rodSilver(EventFriend friend) {
        increaseEffect(PotionEffectType.SLOW_FALLING, friend.getPotionEffects(), 3);
    }

    public static void rodBillon(EventFriend friend) {
        increaseEffect(PotionEffectType.JUMP, friend.getPotionEffects(), 4);
    }

    public static void headBrass(EventFriend friend) {
        increaseEffect(PotionEffectType.UNLUCK, friend.getPotionEffects(), 3);
    }

    public static void rodZinc(EventFriend friend) {
        if (!friend.getPlayer().isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 2);
        }
    }

    public static void rodCorbronze(EventFriend friend) {
        increaseEffect(PotionEffectType.CONFUSION, friend.getPotionEffects());
    }

    public static void headDuralium(EventFriend friend) {
        if (ItemUtils.isTinkersBroken(friend.getTool())) {
            increaseEffect(PotionEffectType.SLOW_DIGGING, friend.getPotionEffects());
        }
    }

    public static void rodSingGold(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
    }

    public static void rodSingTin(EventFriend friend) {
        increaseEffect(PotionEffectType.SATURATION, friend.getPotionEffects(), 3);
    }

    public static void headMetal(EventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects(), 2);
    }

    public static void headMythril(EventFriend friend) {
        increaseEffect(PotionEffectType.FAST_DIGGING, friend.getPotionEffects(), 2);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void headSingGold(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects(), 2);
    }

    public static void headSingZinc(EventFriend friend) {
        increaseEffect(PotionEffectType.DOLPHINS_GRACE, friend.getPotionEffects(), 2);
    }

    public static void rodSingLead(EventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), 2);
    }

    public static void rodSingMagnesium(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(WorldUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void headSingTin(EventFriend friend) {
        increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects(), 2);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 2);
    }

    public static void rodFortune(EventFriend friend) {
        increaseEffect(PotionEffectType.INVISIBILITY, friend.getPotionEffects(), 3);
    }

    public static void rodMagic(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (entity instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) entity;
                l.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, SlimeTinker.RUNNABLE_TICK_RATE + 5, 0));
            }
        }
    }

    public static void rodSingIron(EventFriend friend) {
        increaseEffect(PotionEffectType.INCREASE_DAMAGE, friend.getPotionEffects(), 2);
    }

    public static void rodMythril(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Monster && (entity.getType() != EntityType.WITHER && entity.getType() != EntityType.ENDER_DRAGON)) {
                Monster l = (Monster) entity;
                EntityUtils.push(l, friend.getPlayer().getLocation(), 0.2);
            }
        }
    }

    public static void rodSingZinc(EventFriend friend) {
        if (friend.getPlayer().isSneaking()) {
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 2);
        }
    }

    public static void headMagic(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            int rnd = ThreadLocalRandom.current().nextInt(1, 10);
            if (entity instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) entity;
                switch (rnd) {
                    case 1:
                        EntityUtils.push(l, friend.getPlayer().getLocation(), 3);
                        break;
                    case 2:
                        l.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0, true, true, false));
                        break;
                    case 3:
                        int rndX = ThreadLocalRandom.current().nextInt(-25,26);
                        int rndY = ThreadLocalRandom.current().nextInt(0,5);
                        int rndZ = ThreadLocalRandom.current().nextInt(-25,26);
                        Location location = l.getLocation().clone().add(rndX, rndY, rndZ);
                        if (entity.getWorld().getBlockAt(location).getType() == Material.AIR) {
                            entity.teleport(location);
                            entity.getWorld().playEffect(friend.getPlayer().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
                        }
                        break;
                    case 4:
                        l.setFireTicks(40);
                        break;
                    case 5:
                        l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 4, true, true, false));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void rodSegganesson(EventFriend friend) {
        increaseEffect(PotionEffectType.BLINDNESS, friend.getPotionEffects(), 2);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 6);
    }

    public static void bindSlimesteel(EventFriend friend) {
        increaseEffect(PotionEffectType.JUMP, friend.getPotionEffects(), 2);
    }

    public static void headOsmiumSuperalloy(EventFriend friend) {
        increaseEffect(PotionEffectType.SLOW_DIGGING, friend.getPotionEffects());
    }

    // todo Find a way for 'real' following without NMS??
    public static void rodStarDust(EventFriend friend) {
        increaseEffect(PotionEffectType.GLOWING, friend.getPotionEffects());
        for (Entity e : friend.getPlayer().getNearbyEntities(10,10,10)) {
            if (e instanceof Villager) {
                Location eLoc = e.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                e.teleport(WorldUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void rodRefinedIron(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void headMixedMetal(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1, 4);
        if (rnd == 1) {
            increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
        } else if (rnd == 2) {
            increaseEffect(PotionEffectType.FIRE_RESISTANCE, friend.getPotionEffects());
        } else if (rnd == 3) {
            increaseEffect(PotionEffectType.LUCK, friend.getPotionEffects());
        }
    }

    public static void bindCarbonMesh(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void linksIron(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.1);
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 0.1);
    }

    public static void gambesonTwistingWines(EventFriend friend) {
        for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
            if (entity instanceof Item) {
                Location eLoc = entity.getLocation();
                Location pLoc = friend.getPlayer().getLocation();
                entity.teleport(WorldUtils.getMid(eLoc.getWorld(), eLoc.getX(), eLoc.getY(), eLoc.getZ(), pLoc.getX(), pLoc.getY(), pLoc.getZ()));
            }
        }
    }

    public static void linksGold(EventFriend friend) {
        List<Piglin> piglins = EntityUtils.getNearbyEntitiesByType(Piglin.class, friend.getPlayer(), 5, 5, 5);
        for (Piglin p : piglins) {
            PersistentDataAPI.setString(p, SlimeTinker.inst().getKeys().getArmourHappyPiglin(), friend.getPlayer().getUniqueId().toString());
            p.setTarget(null);
        }
    }

    public static void plateAluBronze(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(0,5);
        if (rnd == 0) {
            Player player = friend.getPlayer();
            Set<Block> blocks = new HashSet<>();
            for (int x = -3; x <= 3; x++) {
                for (int z = -3; z <= 3; z++) {
                    for (int y = -1; y <= 1; y++) {
                        blocks.add(player.getLocation().getBlock().getRelative(x, y, z));
                    }
                }
            }
            Optional<Block> oBlock = blocks.stream().filter(b -> b.getType() == Material.GRASS_BLOCK).findFirst();
            if (oBlock.isPresent()) {
                Block grass = oBlock.get();
                Block above = grass.getRelative(BlockFace.UP);
                if (above.getType() == Material.AIR && SlimefunPlugin.getProtectionManager().hasPermission(player, above, ProtectableAction.PLACE_BLOCK)) {
                    if (ThreadLocalRandom.current().nextInt(0, 101) == 0) {
                        above.setType(Material.WITHER_ROSE);
                        return;
                    }
                    List<Material> flowers = Arrays.asList(
                            Material.DANDELION,
                            Material.POPPY,
                            Material.BLUE_ORCHID,
                            Material.ALLIUM,
                            Material.AZURE_BLUET,
                            Material.WHITE_TULIP,
                            Material.ORANGE_TULIP,
                            Material.PINK_TULIP,
                            Material.RED_TULIP,
                            Material.OXEYE_DAISY,
                            Material.CORNFLOWER,
                            Material.LILY_OF_THE_VALLEY,
                            Material.SUNFLOWER
                    );
                    above.setType(flowers.get(ThreadLocalRandom.current().nextInt(0,flowers.size())));
                }
            }
        }
    }

    public static void brightBurn(EventFriend friend) {
        friend.setBrightBurn(friend.getBrightBurn() + 1);
        if (friend.getBrightBurn() >= 4) {
            for (Entity entity : friend.getPlayer().getNearbyEntities(5,5,5)) {
                if (entity instanceof Mob && (!(entity instanceof Wither) && !(entity instanceof EnderDragon))) {
                    EntityUtils.push((LivingEntity) entity, friend.getPlayer().getLocation(), 0.3);
                }
            }
        }
    }

    public static void plateDamSteel(EventFriend friend) {
        friend.setCompounding(friend.getCompounding() + 1);
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects(), friend.getCompounding());
    }

    public static void gambesonCrimsonRoots(EventFriend friend) {
        if (!GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getActiveStack());
            }
        }
    }

    public static void gambesonWeepingVines(EventFriend friend) {
        increaseEffect(PotionEffectType.BAD_OMEN, friend.getPotionEffects());
    }

    public static void plateAluminum(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void gambesonVine(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            int rnd = ThreadLocalRandom.current().nextInt(1,5);
            if (rnd == 1) {
                ItemUtils.incrementRepair(friend.getActiveStack());
            }
        }
    }

    public static void plateMagnesium(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 3);
    }

    public static void linksMagnesium(EventFriend friend) {
        increaseEffect(PotionEffectType.NIGHT_VISION, friend.getPotionEffects());
    }

    public static void plateCobalt(EventFriend friend) {
        friend.setNegativity(friend.getNegativity() + 1);
    }

    public static void linksCobalt(EventFriend friend) {
        friend.setNegativity(friend.getNegativity() + 1);
    }

    public static void plateNickel(EventFriend friend) {
        friend.setPositivity(friend.getPositivity() + 1);
    }

    public static void linksNickel(EventFriend friend) {
        friend.setPositivity(friend.getPositivity() + 1);
    }

    public static void magnetic(EventFriend friend) {
        int pos = friend.getPositivity();
        int neg = friend.getNegativity();
        int range = (pos + neg) - Math.abs(pos - neg);
        if (range > 0) {
            for (Entity entity : friend.getPlayer().getNearbyEntities(range,range,range)) {
                if (entity instanceof Item) {
                    Location pLoc = friend.getPlayer().getLocation();
                    entity.teleport(pLoc);
                }
            }
        }
    }

    public static void plateRedstoneAlloy(EventFriend friend) {
        Player player = friend.getPlayer();
        Block blockTarget = WorldUtils.getRandomBlockInRange(player.getLocation(), 5, 2, 5, false);
        if (blockTarget != null) {
            BlockUtils.fakePower(blockTarget);
            BlockUtils.fakePower(blockTarget.getRelative(BlockFace.NORTH));
            BlockUtils.fakePower(blockTarget.getRelative(BlockFace.SOUTH));
            BlockUtils.fakePower(blockTarget.getRelative(BlockFace.EAST));
            BlockUtils.fakePower(blockTarget.getRelative(BlockFace.WEST));
            BlockUtils.fakePower(blockTarget.getRelative(BlockFace.DOWN));
            BlockUtils.fakePower(blockTarget.getRelative(BlockFace.UP));
            RemovePoweredState task = new RemovePoweredState(blockTarget, friend.getPlayer());
            task.runTaskTimer(SlimeTinker.inst(), 100, 100);
        }
    }

    public static void gambesonWarpedRoots(EventFriend friend) {
        if (GeneralUtils.testChance(1, 4)) {
            Player p = friend.getPlayer();
            double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            friend.getPlayer().setHealth(Math.min(p.getHealth() + 1, maxHealth));
        }
    }

    public static void plateLead(EventFriend friend) {
        increaseEffect(PotionEffectType.POISON, friend.getPotionEffects(), 2);
    }

    public static void linksLead(EventFriend friend) {
        increaseEffect(PotionEffectType.POISON, friend.getPotionEffects(), 2);
    }

    public static void plateFerrosilicon(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            ItemUtils.incrementRepair(friend.getActiveStack());
        }
    }

    public static void linksSteel(EventFriend friend) {
        increaseEffect(PotionEffectType.HEALTH_BOOST, friend.getPotionEffects());
    }

    public static void plateCorBronze(EventFriend friend) {
        if (GeneralUtils.testChance(1,5)) {
            for (Entity entity : friend.getPlayer().getNearbyEntities(2,2,2)) {
                if (entity instanceof Mob) {
                    entity.setFireTicks(100);
                }
            }
        }
    }

    public static void linksCorBronze(EventFriend friend) {
        Temperature temp = WorldUtils.getBiomeTemperature(friend.getPlayer().getLocation().getBlock().getBiome());
        if (temp == Temperature.HOT) {
            increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 2);
        } else if (temp == Temperature.COLD) {
            increaseEffect(PotionEffectType.SLOW, friend.getPotionEffects());
        }
    }

    public static void linksRedstoneAlloy(EventFriend friend) {
        Player player = friend.getPlayer();
        Block blockTarget = player.getLocation().clone().subtract(0, 1, 0).getBlock();

        BlockUtils.fakePower(blockTarget);
        BlockUtils.fakePower(blockTarget.getRelative(BlockFace.NORTH));
        BlockUtils.fakePower(blockTarget.getRelative(BlockFace.SOUTH));
        BlockUtils.fakePower(blockTarget.getRelative(BlockFace.EAST));
        BlockUtils.fakePower(blockTarget.getRelative(BlockFace.WEST));
        BlockUtils.fakePower(blockTarget.getRelative(BlockFace.DOWN));
        BlockUtils.fakePower(blockTarget.getRelative(BlockFace.UP));

        RemovePoweredState task = new RemovePoweredState(blockTarget, friend.getPlayer());
        task.runTaskTimer(SlimeTinker.inst(), 100, 100);

    }

    public static void linksSingGold(EventFriend friend) {
        List<Piglin> piglins = EntityUtils.getNearbyEntitiesByType(Piglin.class, friend.getPlayer(), 5, 5, 5);
        for (Piglin p : piglins) {
            PersistentDataAPI.setString(p, SlimeTinker.inst().getKeys().getArmourHappyPiglin(), friend.getPlayer().getUniqueId().toString());
            p.setTarget(null);
        }
    }

    public static void plateSingAluminium(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 2);
    }

    public static void plateEarth(EventFriend friend) {
        Player p = friend.getPlayer();
        Block stoodBlock = p.getLocation().clone().subtract(0, 1, 0).getBlock();
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                Block b = stoodBlock.getRelative(x, 0 ,z);
                if (SlimefunPlugin.getProtectionManager().hasPermission(p, b, ProtectableAction.PLACE_BLOCK) && b.getType() == Material.LAVA) {
                    Levelled l = (Levelled) b.getBlockData();
                    if (l.getLevel() == 0) {
                        b.setType(Material.MAGMA_BLOCK);
                        RemoveMagmaBlock task = new RemoveMagmaBlock(b);
                        task.runTaskLater(SlimeTinker.inst(), 100);
                    }
                }
            }
        }
    }

    public static void plateSingMagnesium(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects(), 2);
    }

    public static void linksSingMagnesium(EventFriend friend) {
        increaseEffect(PotionEffectType.NIGHT_VISION, friend.getPotionEffects());
        List<Mob> mobs = EntityUtils.getNearbyEntitiesByType(Mob.class, friend.getPlayer(), 10, 10, 10);
        for (Mob m : mobs) {
            m.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0));
        }
    }

    public static void plateSingTin(EventFriend friend) {
        Player p = friend.getPlayer();
        if (p.hasPotionEffect(PotionEffectType.POISON)) p.removePotionEffect(PotionEffectType.POISON);
        if (p.hasPotionEffect(PotionEffectType.HUNGER)) p.removePotionEffect(PotionEffectType.HUNGER);
        if (p.hasPotionEffect(PotionEffectType.WEAKNESS)) p.removePotionEffect(PotionEffectType.WEAKNESS);
    }

    public static void linksSingLead(EventFriend friend) {
        increaseEffect(PotionEffectType.POISON, friend.getPotionEffects(), 5);
    }

    public static void plateSingLead(EventFriend friend) {
        increaseEffect(PotionEffectType.POISON, friend.getPotionEffects(), 5);
    }

    public static void gambesonVex(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        Player p = friend.getPlayer();
        if (!ItemUtils.onCooldown(i, "annoying")) {
            Location l = WorldUtils.getRandomLocationInRange(p, 3, 3, 3);
            Vex v = (Vex) p.getWorld().spawnEntity(l, EntityType.VEX);
            v.setTarget(p);
            ItemUtils.setCooldown(i, "annoying",600000);
        }
    }

    public static void gambesonGhostly(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        Player p = friend.getPlayer();
        if (!ItemUtils.isTinkersBroken(i)) {
            List<Mob> mobs = EntityUtils.getNearbyEntitiesByType(Mob.class, p, 3, 3, 3);
            for (Mob m : mobs) {
                m.damage(1, p);
                m.getWorld().spawnParticle(Particle.FLASH, m.getLocation(), 1, 0.5, 0.5, 0.5);
                ItemUtils.damageTinkersItem(i, 1);
            }
        }
    }

    public static void linksGhostly(EventFriend friend) {
        increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects());
    }

    public static void hyperbolic(EventFriend friend) {
        friend.setHyperbolic(friend.getHyperbolic() + 1);
        Player p = friend.getPlayer();
        if (friend.getHyperbolic() >= 8 && p.getWorld().getName().equals("dimensionalhome")) {
            ItemStack i = friend.getActiveStack();
            ItemMeta im = i.getItemMeta();
            Validate.notNull(im, "Meta is null, herp derp derp");
            NamespacedKey k = SlimeTinker.inst().getKeys().getArmourHyperbolicStored();
            int amount = PersistentDataAPI.getInt(im, k, 0);
            PersistentDataAPI.setInt(im, k, Math.min(amount + 1, 50));
            i.setItemMeta(im);
        }
    }

    public static void plateStardust(EventFriend friend) {
        Player p = friend.getPlayer();
        if (!GeneralUtils.day(p.getWorld()) && GeneralUtils.testChance(5,100)) {
            p.setHealth(Math.min(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue(), p.getHealth() + 1));
        }
    }

    public static void linksStainlessSteel(EventFriend friend) {
        increaseEffect(PotionEffectType.WATER_BREATHING, friend.getPotionEffects());
    }

    public static void linksSegganesson(EventFriend friend) {
        friend.setGravity(friend.getGravity() + 1);
        Player p = friend.getPlayer();
        if (GeneralUtils.testChance(friend.getGravity(), 4)) {
            Collection<Entity> entityList = p.getWorld().getNearbyEntities(p.getLocation(), 4, 4, 4);
            for (Entity e : entityList) {
                if (e.getUniqueId() != p.getUniqueId()) {
                    Location el = e.getLocation();
                    Location pl = p.getLocation();
                    e.teleport(WorldUtils.getMid(e.getWorld(), el.getX() + 0.5, el.getY(), el.getZ(), pl.getX() + 0.5, pl.getY(), pl.getZ()));
                }
            }
        }
    }

    public static void plateOsmium(EventFriend friend) {
        increaseEffect(PotionEffectType.SLOW, friend.getPotionEffects());
    }

    public static void plateUnpatentabilum(EventFriend friend) {
        Player p = friend.getPlayer();
        Entity e = EntityUtils.getEntityLookedAtByEntity(p);
        if (
                e != null
                && !(e instanceof Player)
                && !(e instanceof ArmorStand)
                && SlimefunPlugin.getProtectionManager().hasPermission(p, e.getLocation(), ProtectableAction.INTERACT_ENTITY)
        )
        {
            e.teleport(friend.getPlayer().getLocation());
        }
    }

    public static void linksOsmiumSuperalloy(EventFriend friend) {
        Player p = friend.getPlayer();
        List<Mob> mobs = EntityUtils.getNearbyEntitiesByType(Mob.class, p, 2, 2, 2);
        for (Mob m : mobs) {
            if (m.getHealth() > 1) {
                m.damage(1, p);
            }
        }
    }

    public static void plateReinforcedSlimesteel(EventFriend friend) {
        increaseEffect(PotionEffectType.JUMP, friend.getPotionEffects());
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void plateOsmiumSuperalloy(EventFriend friend) {
        if (GeneralUtils.testChance(1, 25)) {
            NamespacedKey key = SlimeTinker.inst().getKeys().getStopEvents();
            Player player = friend.getPlayer();
            if (!PersistentDataAPI.hasInt(player, key)) {
                PersistentDataAPI.setInt(player, key, 1);
                int rnd = ThreadLocalRandom.current().nextInt(7, 15);
                for (int i = 0; i <= rnd; i++) {
                    int rndX = ThreadLocalRandom.current().nextInt(-5, 6);
                    int rndZ = ThreadLocalRandom.current().nextInt(-5, 6);
                    player.getWorld().strikeLightningEffect(player.getLocation().clone().add(rndX, 0, rndZ));
                }
                PersistentDataAPI.remove(player, key);
            }
        }
    }

    public static void gambesonCarbonMesh(EventFriend friend) {
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

    public static void gambesonRubber(EventFriend friend) {
        friend.getPlayer().setFireTicks(SlimeTinker.RUNNABLE_TICK_RATE + 5);
    }

    public static void plateBoomerite(EventFriend friend) {
        Player p = friend.getPlayer();
        TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
        tnt.setSource(friend.getPlayer());
        tnt.setVelocity(new Vector(p.getLocation().getDirection().getX(), 1, p.getLocation().getDirection().getZ()));
    }

    public static void rodSteel(EventFriend friend) {
        friend.incrementItemExpMod(0.5);
        increaseEffect(PotionEffectType.SPEED, friend.getPotionEffects());
    }

}
