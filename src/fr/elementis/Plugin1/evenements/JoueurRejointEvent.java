package fr.elementis.Plugin1.evenements;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class JoueurRejointEvent implements Listener
{
    @EventHandler
    public void JoueurRejoint(PlayerJoinEvent evenement)
    {
        Player joueur = evenement.getPlayer();

        joueur.sendMessage(ChatColor.WHITE + "Le joueur " + ChatColor.RED + joueur.getName() + ChatColor.WHITE + " !");

        evenement.setJoinMessage("Le joueur " + joueur.getName() + " a rejoint le serveur");
    }

    @EventHandler
    public void LivreDepart(PlayerJoinEvent evenement)
    {
        Player joueur = evenement.getPlayer();
        joueur.getInventory().clear();

        ItemStack livreDepart = new ItemStack(Material.BOOK, 1);
        ItemMeta CustomM = livreDepart.getItemMeta();
        CustomM.setDisplayName("§cChoisissez votre classe");
        CustomM.setLore(Arrays.asList("Faites le bon choix"));
        CustomM.setEnchantmentGlintOverride(true);
        livreDepart.setItemMeta(CustomM);

        joueur.getInventory().setItem(0, livreDepart);
        joueur.updateInventory();
    }
}
