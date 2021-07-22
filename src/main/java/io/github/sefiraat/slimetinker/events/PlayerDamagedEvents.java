package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.experimental.UtilityClass;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.time.Instant;

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
        if (!ItemUtils.isToolBroken(friend.getHeldItem())) {
            ItemUtils.damageTool(friend.getHeldItem(), (int) friend.getInitialDamage());
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
            ItemStack i = friend.getHeldItem();
            ItemMeta im = i.getItemMeta();
            NamespacedKey key = SlimeTinker.inst().getKeys().getTraitsCooldownProtective();
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
            p.setHealth(1);
            friend.setDamageMod(0);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(20,20,20), 2);
            p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), 30, 3, 3, 3, 1, dustOptions);
            Particle.DustOptions dustOptions2 = new Particle.DustOptions(Color.fromRGB(1,1,1), 2);
            p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), 30, 3, 3, 3, 1, dustOptions2);
            Particle.DustOptions dustOptions3 = new Particle.DustOptions(Color.fromRGB(40,40,40), 2);
            p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), 30, 3, 3, 3, 1, dustOptions3);
            Instant cd = Instant.ofEpochMilli(time).plusSeconds(1200);
            c.set(key, PersistentDataType.LONG, cd.toEpochMilli());
            p.sendMessage(ThemeUtils.WARNING + "Protective has saved you from death. It's now on cooldown - take care!");
            i.setItemMeta(im);
        }
    }
}
