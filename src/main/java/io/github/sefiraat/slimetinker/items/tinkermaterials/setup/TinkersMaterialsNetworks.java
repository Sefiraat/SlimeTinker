package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsNetworks {

    private TinkersMaterialsNetworks() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial MOLTEN_PRESENCE = new TinkerMaterial(Ids.MOLTEN_PRESENCE, SlimefunItem.getById("NTW_INTERDIMENSIONAL_PRESENCE").getItem(), "#15ab26")
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setFormBlock("NTW_INTERDIMENSIONAL_PRESENCE")
        .build();

    private static final TinkerMaterial REMOTININIUM = new TinkerMaterial(Ids.REMOTININIUM, SlimefunItem.getById("NTW_REMOTE_PRISTINE").getItem(), "#acacac")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setFormBlock("NTW_REMOTE_PRISTINE")
        .build();

    private static final TinkerMaterial ULTIMANINIUM = new TinkerMaterial(Ids.ULTIMANINIUM, SlimefunItem.getById("NTW_REMOTE_ULTIMATE").getItem(), "#acacac")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .addAlloyRecipe(
            MOLTEN_PRESENCE.getLiquidItemStack(1),
            REMOTININIUM.getLiquidItemStack(2)
        )
        .setTraitArmorLinks(Traits.NTW_UTLIMANINIUM)
        .build();

    static {
        CM_MAP.put(Ids.MOLTEN_PRESENCE, MOLTEN_PRESENCE);
        CM_MAP.put(Ids.REMOTININIUM, REMOTININIUM);
        CM_MAP.put(Ids.ULTIMANINIUM, ULTIMANINIUM);
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
