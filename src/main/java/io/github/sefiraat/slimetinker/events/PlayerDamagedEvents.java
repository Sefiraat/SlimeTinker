package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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
        if (!ItemUtils.isTinkersBroken(friend.getHeldItem())) {
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

    public static void linksZinc(EventFriend friend) {
        if (friend.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
            friend.setDamageMod(0);
        }
    }

    public static void plateBrass(EventFriend friend) {
        Damageable damagable = (Damageable) friend.getHeldItem().getItemMeta();
        int dmgPerc = (damagable.getDamage() / friend.getHeldItem().getType().getMaxDurability()) * 100;
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
        friend.incrementExpMod(0.2);
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
}
