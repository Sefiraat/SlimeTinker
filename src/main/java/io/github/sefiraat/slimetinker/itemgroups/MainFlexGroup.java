package io.github.sefiraat.slimetinker.itemgroups;

import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @noinspection deprecation
 */
public class MainFlexGroup extends FlexItemGroup {

    private static final ItemStack DOCS_ITEM_STACK = new CustomItemStack(
        Material.BOOK,
        ThemeUtils.GUIDE + "Documentation Wiki",
        ThemeUtils.PASSIVE + "Click to get the link to the",
        ThemeUtils.PASSIVE + "documentation Wiki for SlimeTinker",
        ThemeUtils.PASSIVE + "and other Sefiraat addons.",
        "",
        ThemeUtils.CLICK_INFO + "Guide"
    );

    private static final int GUIDE_BACK = 1;
    private static final int DOCS = 9;
    private static final int WORKSTATIONS = 10;
    private static final int MATERIALS = 11;
    private static final int MOLTEN_METALS = 12;
    private static final int ALLOYS = 13;
    private static final int CASTS = 14;
    private static final int PARTS = 15;
    private static final int TOOLS = 16;
    private static final int ARMOUR = 17;
    private static final int TRAITS = 18;
    private static final int MODIFICATIONS = 19;
    private static final int PART_DICT = 20;

    private static final int[] HEADER = new int[]{
        0, 1, 2, 3, 4, 5, 6, 7, 8
    };
    private static final int[] FOOTER = new int[]{
        45, 46, 47, 48, 49, 50, 51, 52, 53
    };

    public MainFlexGroup(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isVisible(Player player, PlayerProfile playerProfile, SlimefunGuideMode guideMode) {
        return true;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode) {
        final ChestMenu chestMenu = new ChestMenu(ThemeUtils.MAIN + "SlimeTinker");

        for (int slot : HEADER) {
            chestMenu.addItem(slot, ChestMenuUtils.getBackground(), (player1, i1, itemStack, clickAction) -> false);
        }

        for (int slot : FOOTER) {
            chestMenu.addItem(slot, ChestMenuUtils.getBackground(), (player1, i1, itemStack, clickAction) -> false);
        }

        chestMenu.setEmptySlotsClickable(false);
        setupPage(p, profile, mode, chestMenu);
        chestMenu.open(p);
    }

    @ParametersAreNonnullByDefault
    private void setupPage(Player player, PlayerProfile profile, SlimefunGuideMode mode, ChestMenu menu) {
        for (int slot : FOOTER) {
            menu.replaceExistingItem(slot, ChestMenuUtils.getBackground());
            menu.addMenuClickHandler(slot, ((player1, i, itemStack, clickAction) -> false));
        }

        // Back
        menu.replaceExistingItem(
            GUIDE_BACK,
            ChestMenuUtils.getBackButton(
                player,
                Slimefun.getLocalization().getMessage("guide.back.guide")
            )
        );
        menu.addMenuClickHandler(GUIDE_BACK, (player1, slot, itemStack, clickAction) -> {
            SlimefunGuide.openMainMenu(profile, mode, 1);
            return false;
        });

        // Docs
        menu.replaceExistingItem(DOCS, DOCS_ITEM_STACK);
        menu.addMenuClickHandler(DOCS, (player1, i1, itemStack1, clickAction) -> {
            final TextComponent link = new TextComponent("To access the documentation Wiki, please click here");
            link.setColor(ChatColor.YELLOW);
            link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://sefiraat.dev/"));
            player.spigot().sendMessage(link);
            return false;
        });

        // Workstations
        menu.replaceExistingItem(WORKSTATIONS, ItemGroups.WORKSTATIONS.getItem(player));
        menu.addMenuClickHandler(WORKSTATIONS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.WORKSTATIONS, mode, 1)
        );

        // Materials
        menu.replaceExistingItem(MATERIALS, ItemGroups.MATERIALS.getItem(player));
        menu.addMenuClickHandler(MATERIALS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.TOOLS, mode, 1)
        );

        // Molten Metals
        menu.replaceExistingItem(MOLTEN_METALS, ItemGroups.MOLTEN_METALS.getItem(player));
        menu.addMenuClickHandler(MOLTEN_METALS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.MOLTEN_METALS, mode, 1)
        );

        // Alloys
        menu.replaceExistingItem(ALLOYS, ItemGroups.ALLOYS.getItem(player));
        menu.addMenuClickHandler(ALLOYS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.ALLOYS, mode, 1)
        );

        // Casts
        menu.replaceExistingItem(CASTS, ItemGroups.CASTS.getItem(player));
        menu.addMenuClickHandler(CASTS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.CASTS, mode, 1)
        );

        // Parts
        menu.replaceExistingItem(PARTS, ItemGroups.PARTS.getItem(player));
        menu.addMenuClickHandler(PARTS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.PARTS, mode, 1)
        );

        // Tools
        menu.replaceExistingItem(TOOLS, ItemGroups.TOOLS.getItem(player));
        menu.addMenuClickHandler(TOOLS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.TOOLS, mode, 1)
        );

        // Armour
        menu.replaceExistingItem(ARMOUR, ItemGroups.ARMOUR.getItem(player));
        menu.addMenuClickHandler(ARMOUR, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.ARMOUR, mode, 1)
        );

        // Traits
        menu.replaceExistingItem(TRAITS, ItemGroups.TRAITS.getItem(player));
        menu.addMenuClickHandler(TRAITS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.TRAITS, mode, 1)
        );

        // Modifications
        menu.replaceExistingItem(MODIFICATIONS, ItemGroups.MODIFICATIONS.getItem(player));
        menu.addMenuClickHandler(MODIFICATIONS, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.MODIFICATIONS, mode, 1)
        );

        // Part Dict
        menu.replaceExistingItem(PART_DICT, ItemGroups.PART_DICT.getItem(player));
        menu.addMenuClickHandler(PART_DICT, (player1, i1, itemStack1, clickAction) ->
            openPage(profile, ItemGroups.PART_DICT, mode, 1)
        );
    }

    @ParametersAreNonnullByDefault
    public boolean openPage(PlayerProfile profile, ItemGroup itemGroup, SlimefunGuideMode mode, int page) {
        profile.getGuideHistory().add(this, 1);
        SlimefunGuide.openItemGroup(profile, itemGroup, mode, page);
        return false;
    }
}
