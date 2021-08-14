package io.github.sefiraat.slimetinker.events.friend;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.items.componentmaterials.CMManager;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

@UtilityClass
public class EventChannels {

    public static void settlePotionEffects(EventFriend friend) {
        Player p = friend.getPlayer();
        for (Map.Entry<PotionEffectType, Integer> entry : friend.getPotionEffects().entrySet()) {
            boolean resetHealth = false;
            double health = 0;
            if (entry.getKey() == PotionEffectType.HEALTH_BOOST) {
                resetHealth = true;
                health = p.getHealth();
            }
            PotionEffectType potionEffectType = entry.getKey();
            int tickDuration = SlimeTinker.RUNNABLE_TICK_RATE + getBonusTicks(potionEffectType);
            int amplifier = entry.getValue() - 1;
            friend.getPlayer().addPotionEffect(new PotionEffect(potionEffectType, tickDuration, amplifier, false, false, true));
            if (resetHealth) {
                p.setHealth(health);
            }
        }
    }

    /**
     * We give 20 ticks bonus to traits so they stay active between applications.
     * We give more to confusion for the outro and much more to night vision for blinking
     * @param potionEffectType The PotionEffect being applied
     * @return int for number of bonus ticks required
     */
    private static int getBonusTicks(PotionEffectType potionEffectType) {
        if (potionEffectType.equals(PotionEffectType.CONFUSION)) {
            return 70;
        } else if (potionEffectType.equals(PotionEffectType.NIGHT_VISION)) {
            return 210;
        }
        return 20;
    }

    public static void checkTool(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getItemInMainHand();

        if (!ItemUtils.isTool(i)) {
            return;
        }

        if (eventShouldCancelIfBroken(i, friend.getEventType())) {
            friend.setCancelEvent(true);
            friend.getPlayer().sendMessage(ThemeUtils.WARNING + "Your tool is broken, you should really repair it!");
            return;
        }

        friend.setActionTaken(true);
        friend.setTool(i);
        friend.setActiveFriendElement(ActiveFriendElement.TOOL);

        String matPropertyHead = ItemUtils.getToolHeadMaterial(i);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(i);
        String matPropertyRod = ItemUtils.getToolRodMaterial(i);

        CMManager.getMAP().get(matPropertyHead).runEvent(friend.getEventType(), TraitPartType.HEAD, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(friend.getEventType(), TraitPartType.BINDER, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(friend.getEventType(), TraitPartType.ROD, friend);

    }

    private boolean eventShouldCancelIfBroken(ItemStack i, TraitEventType type) {
        return
                (ItemUtils.isTinkersBroken(i) && ItemUtils.doesNotWorkWhenBroken(i))
                && (type == TraitEventType.BLOCK_BREAK || type == TraitEventType.ENTITY_DAMAGED);
    }

    public static void checkArmour(EventFriend friend) {
        if (!friend.isCancelEvent()) {
            checkHelm(friend);
            checkChestplate(friend);
            checkLeggings(friend);
            checkBoots(friend);
        }
    }

    public static void checkHelm(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getHelmet();

        if (!ItemUtils.isArmour(i) || (ItemUtils.isTinkersBroken(i) && ItemUtils.doesNotWorkWhenBroken(i))) {
            return;
        }

        friend.setActionTaken(true);
        friend.setActiveFriendElement(ActiveFriendElement.HELMET);
        friend.setHelmet(i);
        checkArmourPiece(friend);

    }

    public static void checkChestplate(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getChestplate();

        if (!ItemUtils.isArmour(i) || (ItemUtils.isTinkersBroken(i) && ItemUtils.doesNotWorkWhenBroken(i))) {
            return;
        }

        friend.setActionTaken(true);
        friend.setActiveFriendElement(ActiveFriendElement.CHESTPLATE);
        friend.setChestplate(i);
        checkArmourPiece(friend);

    }

    public static void checkLeggings(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getLeggings();

        if (!ItemUtils.isArmour(i) || (ItemUtils.isTinkersBroken(i) && ItemUtils.doesNotWorkWhenBroken(i))) {
            return;
        }

        friend.setActionTaken(true);
        friend.setActiveFriendElement(ActiveFriendElement.LEGGINGS);
        friend.setLeggings(i);
        checkArmourPiece(friend);

    }

    public static void checkBoots(EventFriend friend) {

        ItemStack i = friend.getPlayer().getInventory().getBoots();

        if (!ItemUtils.isArmour(i) || (ItemUtils.isTinkersBroken(i) && ItemUtils.doesNotWorkWhenBroken(i))) {
            return;
        }

        friend.setActionTaken(true);
        friend.setActiveFriendElement(ActiveFriendElement.BOOTS);
        friend.setBoots(i);
        checkArmourPiece(friend);

    }

    public static void checkArmourPiece(EventFriend friend) {

        ItemStack i = friend.getActiveStack();

        String matPropertyHead = ItemUtils.getArmourPlateMaterial(i);
        String matPropertyBinding = ItemUtils.getArmourGambesonMaterial(i);
        String matPropertyRod = ItemUtils.getArmourLinksMaterial(i);

        CMManager.getMAP().get(matPropertyHead).runEvent(friend.getEventType(), TraitPartType.PLATE, friend);
        CMManager.getMAP().get(matPropertyBinding).runEvent(friend.getEventType(), TraitPartType.GAMBESON, friend);
        CMManager.getMAP().get(matPropertyRod).runEvent(friend.getEventType(), TraitPartType.LINKS, friend);
    }

    public static void provideKillExp(EventFriend friend, int baseAmount) {

        ItemStack tool = friend.getTool();
        ItemStack helm = friend.getHelmet();
        ItemStack chst = friend.getChestplate();
        ItemStack legg = friend.getLeggings();
        ItemStack boot = friend.getBoots();

        if (tool != null) {
            int amount = (int) (baseAmount * friend.getToolExpMod());
            Experience.addExp(tool, amount, friend.getPlayer(), false);
        }

        if (helm != null) {
            int amount = (int) (baseAmount * friend.getHelmExpMod());
            Experience.addExp(helm, amount, friend.getPlayer(), false);
        }

        if (chst != null) {
            int amount = (int) (baseAmount * friend.getChestExpMod());
            Experience.addExp(chst, amount, friend.getPlayer(), false);
        }

        if (legg != null) {
            int amount = (int) (baseAmount * friend.getLeggingsExpMod());
            Experience.addExp(legg, amount, friend.getPlayer(), false);
        }

        if (boot != null) {
            int amount = (int) (baseAmount * friend.getBootsExpMod());
            Experience.addExp(boot, amount, friend.getPlayer(), false);
        }

    }

}
