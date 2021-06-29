package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import lombok.experimental.UtilityClass;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.utils.EntityUtils.push;

@UtilityClass
public final class EntityDamageEvents {

    public static void headAluBrass(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1,4);
        if (rnd == 1) {
            int rndX = ThreadLocalRandom.current().nextInt(-25,26);
            int rndY = ThreadLocalRandom.current().nextInt(0,5);
            int rndZ = ThreadLocalRandom.current().nextInt(-25,26);
            Entity entity = friend.getDamagedEntity();
            Location location = entity.getLocation().clone().add(rndX, rndY, rndZ);
            if (entity.getWorld().getBlockAt(location).getType() == Material.AIR) {
                entity.teleport(location);
                entity.getWorld().playEffect(friend.getPlayer().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
            }
        }
    }

    public static void headCopper(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(friend.getToolExpMod() + 1);
    }

    public static void rodAluminum(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
    }

    public static void charged(EventFriend friend) {
        friend.setCharged(friend.getCharged() + 1);
    }

    public static void headDuralium(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(0);
        friend.setDuraliumCheck(true);
    }

    public static void headMagnesium(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 100);
        if (rnd < (friend.getToolLevel() * 5)) {
            e.setFireTicks(100);
        }
    }

    public static void headGold(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 1);
    }

    public static void headTin(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
    }

    public static void headLead(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 5);
        if (rnd == 1) {
            e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0, true, true, false));
        }
    }

    public static void headSteel(EventFriend friend) {
        Entity e = friend.getDamagedEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
    }

    public static void headBrass(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
    }

    public static void rodAlubrass(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
    }

    public static void headHard(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        push(e, friend.getPlayer().getLocation(), 3);
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 100,3);
        e.addPotionEffect(potionEffect);
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(90, 70, 30), 2);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 25, 1, 1, 1, 1, dustOptions);
    }

    public static void headDamsteel(EventFriend friend) {
        Player p = friend.getPlayer();
        if (GeneralUtils.day(p.getWorld())) {
            friend.setDamageMod(friend.getDamageMod() - 0.5);
        } else {
            friend.setDamageMod(friend.getDamageMod() + 0.5);
        }
        int rnd = ThreadLocalRandom.current().nextInt(1, 4);
        if (rnd == 1) {
            p.setHealth(Math.min(p.getHealth() + 1, p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }

    public static void headSingCopper(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(friend.getToolExpMod() + 2);
    }

    public static void headSingInfinity(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 2);
        friend.setToolExpMod(friend.getToolExpMod() + 2);
    }

    public static void headMetal(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 1);
    }

    public static void rodMetal(EventFriend friend) {
        friend.setMetalCheck(true);
    }

    public static void headEarth(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        push(e, friend.getPlayer().getLocation(), 7);
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 100,3);
        e.addPotionEffect(potionEffect);
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(20, 150, 30), 2);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 25, 1, 1, 1, 1, dustOptions);
    }

    public static void rodVoid(EventFriend friend) {
        if (friend.getPlayer().getWorld().getName().equalsIgnoreCase("world_the_end")) {
            friend.setDamageMod(friend.getDamageMod() + 2);
        } else {
            friend.setDamageMod(friend.getDamageMod() + 1);
        }
    }

    public static void headSingMagnesium(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 100);
        if (rnd < (friend.getToolLevel() * 10)) {
            e.setFireTicks(200);
            e.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, e.getLocation(), 25, 1, 1, 1, 1);
        }
    }

    public static void headSingGold(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
    }

    public static void headSingTin(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
    }

    public static void headAdamantite(EventFriend friend) {
        friend.setPlayerExpMod(friend.getPlayerExpMod() + 0.5);
    }

    public static void headSingLead(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 3);
        if (rnd == 1) {
            e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 2, true, true, false));
        }
    }

    public static void headMagSteel(EventFriend friend) {
        Entity e = friend.getDamagedEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(200,50,50), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 30, 3, 3, 3, 1, dustOptions);
        Particle.DustOptions dustOptions2 = new Particle.DustOptions(Color.fromRGB(220,20,75), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 30, 3, 3, 3, 1, dustOptions2);
        Particle.DustOptions dustOptions3 = new Particle.DustOptions(Color.fromRGB(250,75,10), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 30, 3, 3, 3, 1, dustOptions3);
    }

    public static void rodSingAluminum(EventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 1);
    }

    public static void headSegganesson(EventFriend friend) {
        friend.setSegganesson(friend.getSegganesson() + 1);
        friend.setSegganessonDamage(friend.getSegganessonDamage() + friend.getInitialDamage());
    }

    public static void headOsmiumSuperalloy(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1, 4);
        if (rnd == 1) {
            friend.setDamageMod(friend.getDamageMod() + 2);
        } else {
            friend.setDamageMod(friend.getDamageMod() + 1);
        }
    }

    public static void rodOsmium(EventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        e.getPersistentDataContainer().set(new NamespacedKey(SlimeTinker.inst(), "ST_STOP_TELEPORT"), PersistentDataType.STRING,"Y");
        e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 5, true, true));
    }

    public static void headUnpatentabilum(EventFriend friend) {
        if (GeneralUtils.day(friend.getPlayer().getWorld())) {
            friend.setPlayerExpMod(friend.getPlayerExpMod() + 1);
            friend.setToolExpMod(friend.getToolExpMod() + 1);
        }
    }

    public static void rodRedstoneAlloy(EventFriend friend) {
        int rnd = ThreadLocalRandom.current().nextInt(1, 3);
        if (rnd == 1) {
            friend.getDamagedEntity().getWorld().strikeLightning(friend.getDamagedEntity().getLocation());
        }
    }

    public static void headStarDust(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
        Entity e = friend.getDamagedEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(240,230,100), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 60, 3, 3, 3, 1, dustOptions);
    }

    public static void rodStainlessSteel(EventFriend friend) {
        if (friend.getDamagedEntity() instanceof Animals) {
            Player p = friend.getPlayer();
            p.setFoodLevel(Math.min(p.getFoodLevel() + 1, 20));
            p.setSaturation(Math.min(p.getSaturation() + 1, p.getFoodLevel()));
        }
    }

    public static void headStainlessSteel(EventFriend friend) {
        Entity e = friend.getDamagedEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(200,50,50), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 60, 3, 3, 3, 1, dustOptions);
        Particle.DustOptions dustOptions2 = new Particle.DustOptions(Color.fromRGB(220,20,75), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 60, 3, 3, 3, 1, dustOptions2);
        Particle.DustOptions dustOptions3 = new Particle.DustOptions(Color.fromRGB(250,75,10), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 60, 3, 3, 3, 1, dustOptions3);
    }

    public static void headAdvancedAlloy(EventFriend friend) {
        for (Entity e : friend.getPlayer().getNearbyEntities(3,3,3)) {
            if (e instanceof LivingEntity && e != friend.getDamagedEntity()) {
                ((LivingEntity) e).damage(friend.getInitialDamage());
                Particle.DustOptions dustOptions3 = new Particle.DustOptions(Color.fromRGB(250,75,10), 5);
                e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 20, 3, 3, 3, 1, dustOptions3);
            }
        }
    }

    public static void rodRefinedIron(EventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
        Entity e = friend.getDamagedEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(200,50,50), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 30, 3, 3, 3, 1, dustOptions);
        Particle.DustOptions dustOptions2 = new Particle.DustOptions(Color.fromRGB(50,200,50), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 30, 3, 3, 3, 1, dustOptions2);
        Particle.DustOptions dustOptions3 = new Particle.DustOptions(Color.fromRGB(50,50,200), 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 30, 3, 3, 3, 1, dustOptions3);
    }

    public static void headRefinedIron(EventFriend friend) {
        if (friend.getToolLevel() >= 10) {
            friend.setDamageMod(friend.getDamageMod() + (friend.getToolLevel() * 0.1));
        }
    }

    public static void headScrap(EventFriend friend) {
        friend.setToolExpMod(0);
    }

    public static void rodIridium(EventFriend friend) {

        ItemStack i = friend.getHeldItem();
        ItemMeta im = i.getItemMeta();
        NamespacedKey key = SlimeTinker.inst().getKeys().getTraitsCooldownWarp();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        long time = System.currentTimeMillis();

        if (c.has(key, PersistentDataType.LONG)) {
            Long cd = c.get(key, PersistentDataType.LONG);
            assert cd != null;
            if (cd > time) {
                return;
            }
        }

        friend.getDamagedEntity().teleport(friend.getDamagedEntity().getLocation().clone().setDirection(friend.getPlayer().getLocation().getDirection()));

        Instant cd = Instant.ofEpochMilli(time).plusSeconds(20);
        c.set(key, PersistentDataType.LONG, cd.toEpochMilli());
        i.setItemMeta(im);
    }
}
