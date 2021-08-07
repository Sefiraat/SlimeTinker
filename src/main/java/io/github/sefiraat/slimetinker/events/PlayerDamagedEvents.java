package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.runnables.event.RemoveWolf;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.sefiraat.slimetinker.utils.WorldUtils;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.Wolf;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.utils.EntityUtils.increaseEffect;

@UtilityClass
public final class PlayerDamagedEvents {

    public static void rodAdamantite(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || friend.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            friend.setDamageMod(0);
        }
    }

    public static void rodInfinity(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() / 2);
    }

    public static void rodSingSilver(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(0);
        }
    }

    public static void bindSlime(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(friend.getDamageMod() / 2);
        }
    }

    public static void bindSlimesteel(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(friend.getDamageMod() / 2);
        }
    }

    public static void headReinforcedSlimesteel(EventFriend friend) {
        if (!ItemUtils.isTinkersBroken(friend.getTool())) {
            ItemUtils.damageTinkersItem(friend.getTool(), (int) friend.getInitialDamage());
            friend.setDamageMod(friend.getDamageMod() / 2);
        }
    }

    public static void headFerrosilicon(EventFriend friend) {
        friend.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 40, 0, true));
    }

    public static void bindGhostly(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            friend.setDamageMod(0);
        }
    }

    public static void headMagThor(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.LAVA || friend.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
            friend.setDamageMod(0);
        }
    }

    public static void bindRubber(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            friend.setDamageMod(0);
        }
    }

    public static void bindCarbonMesh(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.3);
    }

    public static void headIridium(EventFriend friend) {

        Player p = friend.getPlayer();

        if (friend.getInitialDamage() >= p.getHealth()) {

            ItemStack i = friend.getTool();

            if (!ItemUtils.onCooldown(i, "PROTECTIVE")) {
                p.setHealth(1);
                friend.setDamageMod(0);
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(20,20,20), 2);
                p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), 30, 3, 3, 3, 1, dustOptions);
                Particle.DustOptions dustOptions2 = new Particle.DustOptions(Color.fromRGB(1,1,1), 2);
                p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), 30, 3, 3, 3, 1, dustOptions2);
                Particle.DustOptions dustOptions3 = new Particle.DustOptions(Color.fromRGB(40,40,40), 2);
                p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), 30, 3, 3, 3, 1, dustOptions3);
                p.sendMessage(ThemeUtils.WARNING + "Protective has saved you from death. It's now on cooldown - take care!");
                ItemUtils.setCooldown(i, "PROTECTIVE", 1200000);
            } else {
                p.sendMessage(ThemeUtils.WARNING + "Skill is on cooldown");
            }

        }
    }

    public static void linksZinc(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
            friend.setDamageMod(0);
        }
    }

    public static void plateBrass(EventFriend friend) {
        Damageable damagable = (Damageable) friend.getTool().getItemMeta();
        int dmgPerc = (damagable.getDamage() / friend.getTool().getType().getMaxDurability()) * 100;
        if (dmgPerc <= 0) {
            friend.setDamageMod(friend.getDamageMod() + 0.25);
        } else if (dmgPerc <= 10) {
            friend.setDamageMod(friend.getDamageMod() + 0.20);
        } else if (dmgPerc <= 20) {
            friend.setDamageMod(friend.getDamageMod() + 0.15);
        } else if (dmgPerc <= 30) {
            friend.setDamageMod(friend.getDamageMod() + 0.10);
        } else if (dmgPerc <= 40) {
            friend.setDamageMod(friend.getDamageMod() + 0.05);
        } else if (dmgPerc <= 50) {
            friend.setDamageMod(friend.getDamageMod() + 0.00);
        } else if (dmgPerc <= 60) {
            friend.setDamageMod(friend.getDamageMod() - 0.05);
        } else if (dmgPerc <= 70) {
            friend.setDamageMod(friend.getDamageMod() - 0.10);
        } else if (dmgPerc <= 80) {
            friend.setDamageMod(friend.getDamageMod() - 0.15);
        } else if (dmgPerc <= 90) {
            friend.setDamageMod(friend.getDamageMod() - 0.20);
        } else if (dmgPerc <= 100) {
            friend.setDamageMod(friend.getDamageMod() - 0.25);
        }
    }

    public static void plateCopper(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.25);
    }

    public static void linksTin(EventFriend friend) {
        increaseEffect(PotionEffectType.ABSORPTION, friend.getPotionEffects());
    }

    public static void gambesonSlime(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setDamageMod(friend.getDamageMod() - 0.25);
        }
    }

    public static void plateSilver(EventFriend friend) {
        NamespacedKey key = SlimeTinker.inst().getKeys().getStopEvents();
        Player player = friend.getPlayer();
        if (!PersistentDataAPI.hasInt(player, key) && friend.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            PersistentDataAPI.setInt(player, key, 1);
            friend.setCancelEvent(true);
            int rnd = ThreadLocalRandom.current().nextInt(3, 7);
            for (int i = 0; i <= rnd; i++) {
                int rndx = ThreadLocalRandom.current().nextInt(-3, 4);
                int rndz = ThreadLocalRandom.current().nextInt(-3, 4);
                player.getWorld().strikeLightningEffect(player.getLocation().clone().add(rndx, 0, rndz));
            }
            PersistentDataAPI.remove(player, key);
        }
    }

    public static void plateDuralium(EventFriend friend) {
        if (ItemUtils.isTinkersBroken(friend.getActiveStack())) {
            friend.setDamageMod(friend.getDamageMod() + 0.2);
        }
    }

    public static void linksAluBronze(EventFriend friend) {
        Player p = friend.getPlayer();
        if (p.getHealth() <= (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() / 2)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 2));
        }
    }

    public static void linksAluBrass(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(0,30);
        if (rnd == 0) {
            int rndX = ThreadLocalRandom.current().nextInt(-25,26);
            int rndY = ThreadLocalRandom.current().nextInt(0,5);
            int rndZ = ThreadLocalRandom.current().nextInt(-25,26);
            Player p = friend.getPlayer();
            Location location = p.getLocation().clone().add(rndX, rndY, rndZ);
            if (p.getWorld().getBlockAt(location).getType() == Material.AIR) {
                p.teleport(location);
                p.getWorld().playEffect(friend.getPlayer().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
            }
        }
    }

    public static void platesAluminum(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
    }

    public static void plateSteel(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION
         || friend.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            friend.setDamageMod(friend.getDamageMod() - 0.25);
        }
    }

    public static void linksBillon(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR) {
            friend.setCancelEvent(true);
        }
    }

    public static void linksBrass(EventFriend friend) {
        Player p = friend.getPlayer();
        if (p.getHealth() <= (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() / 2)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2));
        }
    }

    public static void plateMetal(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(0,30);
        if (rnd == 0) {
            Player p = friend.getPlayer();
            p.getWorld().spawnEntity(p.getLocation().clone().add(1, 0, 1), EntityType.IRON_GOLEM);
        }
    }

    public static void plateAluBrass(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.MAGIC) {
            friend.setDamageMod(friend.getDamageMod() - 0.25);
        }
    }

    public static void plateTin(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.POISON) {
            friend.setCancelEvent(true);
        }
    }

    public static void plateGold(EventFriend friend) {
        if (GeneralUtils.testChance(1, 100)) {
            Location l = friend.getPlayer().getLocation();
            l.getWorld().dropItemNaturally(l, new ItemStack(Material.GOLD_NUGGET));
        }
    }

    public static void linksDuralium(EventFriend friend) {
        if (GeneralUtils.testChance(1,10)) {
            friend.setCancelEvent(true);
        }
    }

    public static void linksDamSteel(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.THORNS) {
            Entity e = friend.getDamagingEntity();
            if (e instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) e;
                friend.setCancelEvent(true);
                l.damage(friend.getInitialDamage());
            }
        }
    }

    public static void plateSolder(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
            friend.setCancelEvent(true);
        }
    }

    public static void linksReinforced(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.WITHER) {
            friend.setCancelEvent(true);
        }
    }

    public static void linksSingZinc(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
            Player p = friend.getPlayer();
            friend.setDamageMod(0);
            p.setHealth(Math.max(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue(), p.getHealth() + friend.getInitialDamage()));
        }
    }

    public static void plateSingCopper(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
    }

    public static void linksSingTin(EventFriend friend) {
        increaseEffect(PotionEffectType.ABSORPTION, friend.getPotionEffects(), 1);
    }

    public static void linksMythril(EventFriend friend) {
        if (GeneralUtils.testChance(1, 20)) {
            Player p = friend.getPlayer();
            Wolf w = (Wolf) p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
            w.setOwner(p);
            if (friend.getDamagingEntity() != null) {
                w.setTarget((LivingEntity) friend.getDamagingEntity());
            }
            RemoveWolf task = new RemoveWolf(w);
            task.runTaskLater(SlimeTinker.inst(), 500);
        }
    }

    public static void linksMagSteel(EventFriend friend) {
        if (GeneralUtils.testChance(5,100)) {
            friend.setCancelEvent(true);
            increaseEffect(PotionEffectType.ABSORPTION, friend.getPotionEffects());
        }
    }

    public static void plateSingSilver(EventFriend friend) {
        NamespacedKey key = SlimeTinker.inst().getKeys().getStopEvents();
        Player player = friend.getPlayer();
        if (!PersistentDataAPI.hasInt(player, key) && friend.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            PersistentDataAPI.setInt(player, key, 1);
            friend.setCancelEvent(true);
            int rnd = ThreadLocalRandom.current().nextInt(7, 20);
            for (int i = 0; i <= rnd; i++) {
                int rndx = ThreadLocalRandom.current().nextInt(-5, 6);
                int rndz = ThreadLocalRandom.current().nextInt(-5, 6);
                player.getWorld().strikeLightningEffect(player.getLocation().clone().add(rndx, 0, rndz));
            }
            PersistentDataAPI.remove(player, key);
        }
    }

    public static void plateAdamantite(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            friend.setDamageMod(friend.getDamageMod() -0.25);
        }
    }

    public static void plateSingAluminium(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
    }

    public static void linksMetal(EventFriend friend) {
        if (GeneralUtils.testChance(1,5)) {
            if (friend.getDamagingEntity() instanceof LivingEntity) {
                LivingEntity l = (LivingEntity) friend.getDamagingEntity();
                l.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                l.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, l.getLocation(), 0, 0, 0,0);
            }
        }
    }

    public static void linksTitanium(EventFriend friend) {
        EntityDamageEvent.DamageCause c = friend.getCause();
        if (
                c == EntityDamageEvent.DamageCause.LAVA
                || c == EntityDamageEvent.DamageCause.FIRE
                || c == EntityDamageEvent.DamageCause.FIRE_TICK
                || c == EntityDamageEvent.DamageCause.HOT_FLOOR
        ) {
            friend.setCancelEvent(true);
        }
    }

    public static void plateFortune(EventFriend friend) {
        if (friend.getInitialDamage() >= 1 && GeneralUtils.testChance(1, 200)) {
            int roll = GeneralUtils.roll(100);
            ItemStack i;
            if (roll < 5) {
                i = Materials.NUGGET_CAST_ADAMANTITE.clone();
            } else if (roll < 10) {
                i = Materials.NUGGET_CAST_TITANIUM.clone();
            } else if (roll < 15) {
                i = Materials.NUGGET_CAST_MYTHRIL.clone();
            } else if (roll < 20) {
                i = Materials.NUGGET_CAST_MAGNONIUM.clone();
            } else if (roll < 25) {
                i = Materials.NUGGET_CAST_MAGSTEEL.clone();
            } else if (roll < 30) {
                i = Materials.NUGGET_CAST_REINFORCED.clone();
            } else if (roll < 35) {
                i = Materials.NUGGET_CAST_REDSTONE_ALLOY.clone();
            } else if (roll < 40) {
                i = Materials.NUGGET_CAST_ALU_BRASS.clone();
            } else if (roll < 50) {
                i = Materials.NUGGET_CAST_COR_BRONZE.clone();
            } else if (roll < 55) {
                i = Materials.NUGGET_CAST_HARD_METAL.clone();
            } else if (roll < 60) {
                i = Materials.NUGGET_CAST_ALU_BRONZE.clone();
            } else if (roll < 65) {
                i = Materials.NUGGET_CAST_DAMASCUS_STEEL.clone();
            } else if (roll < 70) {
                i = Materials.NUGGET_CAST_COBALT.clone();
            } else if (roll < 75) {
                i = Materials.NUGGET_CAST_NICKEL.clone();
            } else if (roll < 80) {
                i = Materials.NUGGET_CAST_BILLON.clone();
            } else if (roll < 85) {
                i = Materials.NUGGET_CAST_SOLDER.clone();
            } else if (roll < 90) {
                i = Materials.NUGGET_CAST_DURALIUM.clone();
            } else if (roll < 95) {
                i = Materials.NUGGET_CAST_STEEL.clone();
            } else {
                i = Materials.NUGGET_CAST_COAL.clone();
            }
            WorldUtils.dropItem(i, friend.getPlayer());
        }
    }

    public static void plateInfinity(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        ItemMeta im = i.getItemMeta();
        NamespacedKey k = SlimeTinker.inst().getKeys().getArmourInfiniteCapacityStored();
        Validate.notNull(im, "Meta is null, nope!");
        double d = PersistentDataAPI.getDouble(im, k, 0);
        if (d < 5) {
            d = Math.max(5, d + friend.getInitialDamage() / 10);
            PersistentDataAPI.setDouble(im, k, d);
            i.setItemMeta(im);
        }
    }

    public static void linksSingInfinity(EventFriend friend) {
        friend.setDamageMod(0);
    }

    public static void plateSingInfinity(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        ItemMeta im = i.getItemMeta();
        NamespacedKey k = SlimeTinker.inst().getKeys().getArmourInfinitlyPowerfulStored();
        Validate.notNull(im, "Meta is null, nope!");
        int d = PersistentDataAPI.getInt(im, k, 0);
        if (d < 2000) {
            d = (int) Math.max(2000, d + friend.getInitialDamage());
            if (d == 2000) {
                ItemUtils.incrementRandomEnchant(i);
                PersistentDataAPI.setInt(im, k, 0);
            } else {
                PersistentDataAPI.setInt(im, k, d);
            }
            i.setItemMeta(im);
        }
    }

    public static void linksMagic(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.DRAGON_BREATH) {
            friend.setCancelEvent(true);
        }
    }

    public static void linksInfinity(EventFriend friend) {
        if (friend.getDamagingEntity() != null && GeneralUtils.testChance(20, 100)) {
            friend.setDamageMod(0);
            LivingEntity e = (LivingEntity) friend.getDamagingEntity();
            e.damage(friend.getInitialDamage(), friend.getPlayer());
            e.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, e.getLocation(), 5, 0.5, 0.5, 0.5);
        }
    }

    public static void linksMagnonium(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
            friend.setCancelEvent(true);
        }
    }

    public static void plateVoid(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.VOID) {
            friend.setCancelEvent(true);
            increaseEffect(PotionEffectType.LEVITATION, friend.getPotionEffects(), 3);
        }
    }

    public static void plateSingGold(EventFriend friend) {
        if (friend.getInitialDamage() >= 1 && GeneralUtils.testChance(1, 100)) {
            WorldUtils.dropItem(new ItemStack(Material.GOLD_NUGGET, GeneralUtils.roll(4)), friend.getPlayer());
        }
    }


    public static void plateSingIron(EventFriend friend) {
        Player p = friend.getPlayer();
        friend.setCancelEvent(true);
        p.setHealth(Math.max(p.getHealth() + friend.getInitialDamage(), p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
    }

    public static void linksVoid(EventFriend friend) {
        Entity e = friend.getDamagedEntity();
        if (
                e instanceof EnderDragon
                || e instanceof Enderman
                || e instanceof Shulker
        ) {
            friend.setDamageMod(friend.getDamageMod() - 0.1);
        }
    }

    public static void hyperbolic(EventFriend friend) {
        friend.setHyperbolic(friend.getHyperbolic() + 1);
        Player p = friend.getPlayer();
        if (friend.getHyperbolic() >= 8) {
            ItemStack i = friend.getActiveStack();
            ItemMeta im = i.getItemMeta();
            Validate.notNull(im, "Meta is null, herp derp derp");
            NamespacedKey k = SlimeTinker.inst().getKeys().getArmourHyperbolicStored();
            int amount = PersistentDataAPI.getInt(im, k, 0);
            double dmg =  friend.getInitialDamage() * friend.getDamageMod();
            if (amount >= dmg) {
                friend.setCancelEvent(true);
                amount -= dmg;
            }
            PersistentDataAPI.setInt(im, k, amount);
            i.setItemMeta(im);
        }
    }

    public static void plateStainlessSteel(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.05);
    }


    public static void linksReinforcedSlimesteel(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.PROJECTILE && GeneralUtils.testChance(10, 100)) {
            friend.setCancelEvent(true);
        }
    }

    public static void linksOsmium(EventFriend friend) {
        if (GeneralUtils.testChance(5, 100)) {
            Player p = friend.getPlayer();
            friend.setCancelEvent(true);
            p.setHealth(Math.min(p.getHealth() + friend.getInitialDamage(), p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    public static void plateOsmium(EventFriend friend) {
        if (friend.getDamagingEntity() != null) {
            EntityUtils.push((LivingEntity) friend.getDamagingEntity(), friend.getPlayer().getLocation(), 0.2);
        }
    }

    public static void gambesonSlimeSteel(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.FALL) {
            friend.setCancelEvent(true);
        }
    }

    public static void plateReinforcedSlimesteel(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.1);
    }

    public static void linksMagThor(EventFriend friend) {
        if (GeneralUtils.testChance(1, 5)) {
            Player p = friend.getPlayer();
            PotionEffect speed = p.hasPotionEffect(PotionEffectType.SPEED) ? p.getPotionEffect(PotionEffectType.SPEED) : null;
            PotionEffect haste = p.hasPotionEffect(PotionEffectType.FAST_DIGGING) ? p.getPotionEffect(PotionEffectType.FAST_DIGGING) : null;
            if (speed == null) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
            } else {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, Math.max(speed.getAmplifier() + 1, 9)));
            }
            if (haste == null) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 1));
            } else {
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, Math.max(haste.getAmplifier() + 2, 19)));
            }
        }
    }

    public static void plateIridium(EventFriend friend) {
        Player p = friend.getPlayer();
        Entity e = friend.getDamagingEntity();
        if (e instanceof Mob) {
            ((Mob) e).damage(friend.getInitialDamage() * 0.1, p);
            friend.setDamageMod(friend.getDamageMod() - 0.1);
        }
    }

    public static void linksMixedMetal(EventFriend friend) {
        if (GeneralUtils.testChance(1,5)) {
            Entity e = friend.getDamagingEntity();
            if (e != null) {
                Player p = friend.getPlayer();
                Location pl = p.getLocation();
                Location el = e.getLocation();
                p.teleport(el);
                e.teleport(pl);
            }
        }
    }

    public static void linksRefinedIron(EventFriend friend) {
        Entity e = friend.getDamagingEntity();
        if (e instanceof LivingEntity) {
            LivingEntity l = (LivingEntity) e;
            l.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 9));
        }
    }

    public static void plateScrap(EventFriend friend) {
        if (GeneralUtils.testChance(5,100)) {
            friend.getPlayer().damage(100, friend.getPlayer());
        }
    }

    public static void plateMagThor(EventFriend friend) {
        Entity e = friend.getDamagingEntity();
        if (e instanceof LivingEntity) {
            LivingEntity l = (LivingEntity) e;
            int a = l.hasPotionEffect(PotionEffectType.POISON) ? l.getPotionEffect(PotionEffectType.POISON).getAmplifier() + 1 : 0;
            l.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, Math.max(a, 9)));
        }
    }

    public static void linksIridium(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, herp derp derp");
        NamespacedKey k = SlimeTinker.inst().getKeys().getArmourHyperbolicStored();
        int amount = PersistentDataAPI.getInt(im, k, 0);

        for (ItemStack i2 : friend.getPlayer().getInventory()) {
            SlimefunItem s = SlimefunItem.getByItem(i2);
            if (s instanceof Rechargeable) {
                Rechargeable r1 = (Rechargeable) s;
                float maxCharge = r1.getMaxItemCharge(i2);
                float charge = r1.getItemCharge(i2);
                float amountToCharge = maxCharge - charge;
                if (amount > amountToCharge) {
                    r1.setItemCharge(i2, maxCharge);
                    amount = (int) (amount - amountToCharge);
                } else {
                    r1.addItemCharge(i2, amount);
                    amount = 0;
                }
            }
        }

        PersistentDataAPI.setInt(im, k, amount);
        i.setItemMeta(im);
    }
}
