package io.github.sefiraat.slimetinker.managers;

import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemoryManager {
    private static MemoryManager instance;

    private final Map<UUID, Long> activeHasteBursts = new HashMap<>();

    public MemoryManager() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the ListenerManager");
        instance = this;
    }

    public long getHasteBurstEnd(@Nonnull UUID uuid) {
        return activeHasteBursts.getOrDefault(uuid, 0L);
    }

    public void setHasteBurstEnd(@Nonnull UUID uuid, long duration) {
        long timeNow = System.currentTimeMillis();
        long endTime = timeNow + duration;
        activeHasteBursts.put(uuid, endTime);
    }

    public void removeHasteBurst(@Nonnull UUID uuid) {
        activeHasteBursts.remove(uuid);
    }

    public static MemoryManager getInstance() {
        return instance;
    }
}
