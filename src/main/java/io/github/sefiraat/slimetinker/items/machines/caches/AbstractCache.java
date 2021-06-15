package io.github.sefiraat.slimetinker.items.machines.caches;

import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

public abstract class AbstractCache {

    protected final BlockMenu blockMenu;

    protected AbstractCache(BlockMenu blockMenu) {

        this.blockMenu = blockMenu;

    }

}
