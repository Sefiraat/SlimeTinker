package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

import static io.github.sefiraat.slimetinker.utils.EntityUtils.push;

public class EntityDamageEvents {

    public static void headAluBrass(EntityDamageEventFriend friend) {
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

    public static void headCopper(EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(friend.getToolExpMod() + 1);
    }

    public static void rodAluminum(EntityDamageEventFriend friend) {
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
    }

    public static void charged(EntityDamageEventFriend friend) {
        friend.setCharged(friend.getCharged() + 1);
    }

    public static void headDuralium(EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(0);
        friend.setDuraliumCheck(true);
    }

    public static void headMagnesium(EntityDamageEventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 100);
        if (rnd < (friend.getToolLevel() * 5)) {
            e.setFireTicks(100);
        }
    }

    public static void headGold(EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 1);
    }

    public static void headTin(EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
    }

    public static void headLead(EntityDamageEventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        int rnd = ThreadLocalRandom.current().nextInt(1, 5);
        if (rnd == 1) {
            e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0, true, true, false));
        }
    }

    public static void headSteel(EntityDamageEventFriend friend) {
        Entity e = friend.getDamagedEntity();
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 5);
        e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
    }

    public static void headBrass(EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + 0.5);
    }

    public static void rodAlubrass(EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() - 0.5);
        friend.setToolExpMod(friend.getToolExpMod() + 0.5);
    }

    public static void headHard(EntityDamageEventFriend friend) {
        LivingEntity e = (LivingEntity) friend.getDamagedEntity();
        push(e, e.getLocation());
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SLOW, 40,99);
        e.addPotionEffect(potionEffect);
    }

    public static void headDamsteel(EntityDamageEventFriend friend) {
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

}
