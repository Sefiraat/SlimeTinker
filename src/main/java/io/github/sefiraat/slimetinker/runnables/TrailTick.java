package io.github.sefiraat.slimetinker.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class TrailTick extends BukkitRunnable {

    private static final Set<UUID> PLAYERS = new HashSet<>();

    @Override
    public void run() {
        // TODO Expand to further/previous trails
        for (UUID uuid : PLAYERS) {
            Player player = Bukkit.getPlayer(uuid);

            if (player == null) {
                PLAYERS.remove(uuid);
                continue;
            }

            Location location = player.getLocation();
            Vector back = player.getEyeLocation().getDirection().multiply(-1);
            Location backLocation = location.add(back);
            Particle.DustOptions dustOptionsG = new Particle.DustOptions(Color.fromRGB(50, 180, 30), 1);
            Particle.DustOptions dustOptionsW = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 1);
            for (int i = 0; i <= 10; i++) {
                boolean p = ThreadLocalRandom.current().nextBoolean();
                double y = ThreadLocalRandom.current().nextDouble(-1, 1);
                double x = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
                double z = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
                Location spawnLocation = backLocation.clone().add(x, y, z);
                location.getWorld().spawnParticle(Particle.REDSTONE, spawnLocation, 1, p ? dustOptionsG : dustOptionsW);
            }
        }
    }

    public static void addPlayer(@Nonnull Player player) {
        PLAYERS.add(player.getUniqueId());
    }

    public static void removePlayer(@Nonnull Player player) {
        PLAYERS.remove(player.getUniqueId());
    }

}
