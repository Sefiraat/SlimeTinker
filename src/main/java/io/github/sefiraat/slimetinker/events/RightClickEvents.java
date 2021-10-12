package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.runnables.event.KingsmanSpam;
import io.github.sefiraat.slimetinker.utils.BlockUtils;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang.Validate;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class RightClickEvents {

    public static void headTessMat(EventFriend friend) {
        friend.setHypercube(friend.getHypercube() + 1);

        if (friend.getHypercube() >= 2) {

            Player p = friend.getPlayer();
            ItemStack i = friend.getActiveStack();
            ItemMeta im = i.getItemMeta();
            String cooldownName = "hypercube";

            NamespacedKey keyLoc = SlimeTinker.inst().getKeys().getTraitsHypercubeLocation();

            if (p.isSneaking()) {
                // Setting location
                PersistentDataAPI.setString(im, keyLoc, GeneralUtils.serializeLocation(p.getLocation()));
                p.sendMessage(ThemeUtils.SUCCESS + "Location set!");
                i.setItemMeta(im);
            } else {
                // Actioning location
                if (ItemUtils.onCooldown(i, cooldownName)) {
                    p.sendMessage(ThemeUtils.WARNING + "Recall is on cooldown!");
                    return;
                } else if (!PersistentDataAPI.hasString(im, keyLoc)) {
                    p.sendMessage(ThemeUtils.WARNING + "You have not yet set a location to recall to!");
                    return;
                }
                String sl = PersistentDataAPI.getString(im, keyLoc);
                Location l = GeneralUtils.deserializeLocation(sl);
                p.teleport(l);
                p.sendMessage(ThemeUtils.SUCCESS + "Whoosh!");
                ItemUtils.setCooldown(i, cooldownName, 300000);
            }

        }

    }

    public static void rodGhostly(EventFriend friend) {
        friend.setHypercube(friend.getHypercube() + 1);
    }

    public static void bindVex(EventFriend friend) {
        Player p = friend.getPlayer();
        ItemStack i = friend.getTool();

        if (!ItemUtils.onCooldown(i, "NOCLIP")) {
            int rndX = ThreadLocalRandom.current().nextInt(-25, 26);
            int rndY = ThreadLocalRandom.current().nextInt(0, 5);
            int rndZ = ThreadLocalRandom.current().nextInt(-25, 26);
            Location location = p.getLocation().clone().add(rndX, rndY, rndZ);
            if (p.getWorld().getBlockAt(location).getType() == Material.AIR) {
                p.teleport(location);
                p.getWorld().playEffect(friend.getPlayer().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
                ItemUtils.setCooldown(i, "NOCLIP", 300000);
            } else {
                p.sendMessage(ThemeUtils.WARNING + "Couldn't teleport! Try again.");
            }
        }
    }

    public static void plateInfinity(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        ItemMeta im = i.getItemMeta();
        NamespacedKey k = SlimeTinker.inst().getKeys().getArmourInfiniteCapacityStored();
        Validate.notNull(im, "Meta is null, nope!");
        double d = PersistentDataAPI.getDouble(im, k, 0);
        if (d > 1) {
            List<Entity> entityList = friend.getPlayer().getNearbyEntities(3, 3, 3);
            for (Entity e : entityList) {
                if (e instanceof LivingEntity) {
                    LivingEntity l = (LivingEntity) e;
                    if (l instanceof Player && l.getUniqueId() == friend.getPlayer().getUniqueId()) {
                        continue;
                    }
                    l.damage(Math.floor(d));
                    l.getWorld().spawnParticle(Particle.CLOUD, l.getLocation(), 4, 0, 0, 0);
                }
            }
        }
        PersistentDataAPI.setDouble(im, k, 0);
        i.setItemMeta(im);
    }

    public static void linksEarth(EventFriend friend) {
        String cdName = "natural";
        Player p = friend.getPlayer();
        ItemStack i = friend.getActiveStack();
        int cdMinutes = 2;
        if (ItemUtils.onCooldown(i, cdName)) {
            p.sendMessage(ThemeUtils.WARNING + "It's Natural is on cooldown");
        } else {
            List<Animals> animals = EntityUtils.getNearbyEntitiesByType(Animals.class, p, 3, 3, 3);
            if (animals.size() >= 2) {
                int first = GeneralUtils.roll(animals.size(), false);
                int second = first == animals.size() ? 0 : first + 1;
                EntityUtils.makeBreed(animals.get(first));
                EntityUtils.makeBreed(animals.get(second));
            }
            ItemUtils.setCooldown(i, cdName, cdMinutes * 60000L);
        }
    }

    public static void rodRefinedIron(EventFriend friend) {
        friend.setManners(1);
    }

    public static void plateRefinedIron(EventFriend friend) {
        friend.setKingsman(friend.getKingsman() + 1);
        if (friend.getManners() > 0 && friend.getKingsman() >= 4) {
            // We use helmet to control CD. You HAVE to have all four so using one stops 4 triggers
            Player p = friend.getPlayer();
            ItemStack i = friend.getHelmet();
            Validate.notNull(i, "Helmet doesn't exist but has 4 stacks? I call hax");
            String cdName = "kingsman";
            if (!ItemUtils.onCooldown(i, cdName)) {
                KingsmanSpam task = new KingsmanSpam(p, 10);
                task.runTaskTimer(SlimeTinker.inst(), 0, 20);
                ItemUtils.setCooldown(i, cdName, 20 * 60000L);
            } else {
                p.sendMessage(ThemeUtils.WARNING + "This ability is on cooldown.");
            }
        }
    }

    public static void linksIridium(EventFriend friend) {

        ItemStack i = friend.getActiveStack();
        ItemMeta im = i.getItemMeta();
        Validate.notNull(im, "Meta is null, herp derp derp");
        NamespacedKey k = SlimeTinker.inst().getKeys().getArmourUnconventionalStored();
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

    public static void headBoomerite(EventFriend friend) {
        Player player = friend.getPlayer();
        BlockFace blockFace = BlockUtils.getTargetedBlockFace(player);
        if (blockFace != null && blockFace != BlockFace.UP && blockFace != BlockFace.DOWN) {
            Block target = player.getTargetBlock(null, 5);
            if (target.getType() != Material.AIR) {
                Block place = target.getRelative(blockFace);
                if (place.getType() == Material.AIR && Slimefun.getProtectionManager().hasPermission(player, place, Interaction.PLACE_BLOCK)) {
                    place.setType(Material.LADDER);
                    Directional directional = (Directional) place.getBlockData();
                    directional.setFacing(blockFace);
                    place.setBlockData(directional);
                }
            }
        }

    }

    public static void headSefirite(EventFriend friend) {
        final ItemStack tool = friend.getActiveStack();
        final Player player = friend.getPlayer();
        if (!ItemUtils.onCooldown(tool, "celebrate")) {
            Block potential = player.getTargetBlock(null, 5).getRelative(BlockFace.UP);
            if (potential.getType() == Material.AIR && Slimefun.getProtectionManager().hasPermission(player, potential, Interaction.PLACE_BLOCK)) {
                MinecraftVersion minecraftVersion = Slimefun.getMinecraftVersion();
                potential.setType(minecraftVersion.isAtLeast(MinecraftVersion.MINECRAFT_1_17) ? Material.BLACK_CANDLE_CAKE : Material.CAKE);
                ItemUtils.setCooldown(tool, "celebrate", 3600000);
            }
        } else {
            player.sendMessage(ThemeUtils.WARNING + "This ability is on cooldown.");
        }
    }
}
