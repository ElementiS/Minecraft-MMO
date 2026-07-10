package fr.elementis.Plugin1.evenements;

import fr.elementis.Plugin1.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;


public class UsageItem implements Listener {
    @EventHandler
    public void WindChargeVagabond(PlayerInteractEvent event) {
        Player joueur = event.getPlayer();
        ItemStack it = event.getItem();
        if (it == null) return;

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getHand() != EquipmentSlot.HAND) return;
            if (it.isSimilar(ItemCustom.SAUT_SPIRITUEL)) {
                if (joueur.hasCooldown(Material.WIND_CHARGE)) {
                    joueur.sendMessage("§cPatientez avant de sauter à nouveau !");
                    return;
                }
                event.setCancelled(true);
                joueur.launchProjectile(org.bukkit.entity.WindCharge.class);
                joueur.setCooldown(Material.WIND_CHARGE, 15 * 3);
            }

        }
    }


    @EventHandler
    public void BaguetteMagiqueMage(PlayerInteractEvent event){
        Player joueur = event.getPlayer();
        ItemStack it = event.getItem();

        if (it == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            if (it.isSimilar(ItemCustom.BAGUETTE_MAGIQUE)) {
                if (joueur.hasCooldown(Material.STICK)) {
                    joueur.sendMessage("§cVotre baguette magique recharge !");
                    return;
                }
                Block targetBlock = joueur.getTargetBlockExact(200);
                if(targetBlock != null){
                    joueur.getWorld().strikeLightning(targetBlock.getLocation());
                    joueur.sendMessage("§bFOUDRE !");
                }
                event.setCancelled(true);
                joueur.setCooldown(Material.STICK, 20*2);
            }
        }
    }
    @EventHandler

    public void BouleDeFeuMage(PlayerInteractEvent event){
        Player joueur = event.getPlayer();
        ItemStack it = event.getItem();

        if(it == null) return;
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(it.isSimilar(ItemCustom.BOULE_FEU)){
                if(joueur.hasCooldown(Material.IRON_HORSE_ARMOR)){
                    joueur.sendMessage("§c Votre sort est en recharge !");
                    return;
                }
                Block targetBlock = joueur.getTargetBlockExact(100);
                if(targetBlock != null){
                    Fireball fireball = joueur.launchProjectile(Fireball.class);
                    fireball.setVelocity(joueur.getLocation().getDirection().multiply(1.5));
                    fireball.setYield(0F);
                    NamespacedKey key = new NamespacedKey(JavaPlugin.getPlugin(Main.class), "sort_de_feu");
                    fireball.getPersistentDataContainer().set(key, PersistentDataType.STRING, "kit_magicien");
                    joueur.setCooldown(Material.IRON_HORSE_ARMOR, 20 * 6);
                }
            }
        }
    }
}