package fr.elementis.Plugin1.evenements;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import java.util.List;

public class ClasseDebut implements Listener
{
    @EventHandler
    public void InteractLivre(PlayerInteractEvent evenement)
    {
        Player joueur = evenement.getPlayer();
        ItemStack it = evenement.getItem();
        Inventory inv = Bukkit.createInventory(null,27, "§8Choisissez votre classe !");

        if(it == null) return;
        if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cChoisissez votre classe")){

            //EPEE GUI
            ItemStack classSword = new ItemStack(Material.MACE, 1);
            ItemMeta custom1 = classSword.getItemMeta();
            custom1.setDisplayName("§cVagabond");
            custom1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            custom1.setEnchantmentGlintOverride(true);
            custom1.setLore(List.of(
                    "§f Vieille Mace très usée",
                    "§f Armure moyenne",
                    "§e Saut Spirituel"
            ));
            classSword.setItemMeta(custom1);

            //BAGUETTE GUI
            ItemStack classStick = new ItemStack(Material.STICK, 1);
            ItemMeta custom2 = classStick.getItemMeta();
            custom2.setDisplayName("§cMagicien");
            custom2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            custom2.setEnchantmentGlintOverride(true);
            custom2.setLore(List.of(
                    "§f Baguette magique",
                    "§f Armure magique",
                    "§e Sort de feu"
            ));
            classStick.setItemMeta(custom2);

            //ARC GUI
            ItemStack classBow = new ItemStack(Material.BOW, 1);
            ItemMeta custom3 = classBow.getItemMeta();
            custom3.setDisplayName("§cÉclaireur");
            custom3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            custom3.setEnchantmentGlintOverride(true);
            custom3.setLore(List.of(
                    "§f Arc",
                    "§f dague en bois",
                    "§f Armure légère",
                    "§f Flèche de poison 20s x6",
                    "§f Flèche de lenteur 20s x6",
                    "§f Flèche de lévitation x3"
            ));
            classBow.setItemMeta(custom3);

            //SHIELD GUI
            ItemStack classShield = new ItemStack(Material.SHIELD,1);
            ItemMeta custom4 = classBow.getItemMeta();
            custom4.setDisplayName("§cTank");
            custom4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            custom4.setEnchantmentGlintOverride(true);
            custom4.setLore(List.of(
                    "§f Hache très usée",
                    "§f Bouclier",
                    "§f Armure lourde",
                    "§f Soupe de résistance IV (00:25) x6"
            ));
            classShield.setItemMeta(custom4);

            //placement item gui
            inv.setItem(10, classSword);
            inv.setItem(12, classStick);
            inv.setItem(14, classBow);
            inv.setItem(16, classShield);
            joueur.openInventory(inv);
        }
    }

    @EventHandler
    public void StuffClasse(InventoryClickEvent evenement)
    {
    Inventory inv = evenement.getInventory();
    Player joueur = (Player) evenement.getWhoClicked();
    ItemStack current = evenement.getCurrentItem();

    //STUFF COMMUN
    ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);

    ItemStack potion_de_vie = new ItemStack(Material.POTION, 3);
    PotionMeta metaPotion_De_Vie = (PotionMeta) potion_de_vie.getItemMeta();
    metaPotion_De_Vie.setBasePotionType(PotionType.HEALING);
    metaPotion_De_Vie.setDisplayName("§dPotion de vie");
    potion_de_vie.setItemMeta(metaPotion_De_Vie);

    if(current == null) return;
    if(evenement.getView().getTitle().equalsIgnoreCase("§8Choisissez votre classe !")){
        if (current.hasItemMeta() && current.getItemMeta().hasDisplayName()){
            String nomItem = current.getItemMeta().getDisplayName();

            if(nomItem.equals("§cVagabond")){
                //stuff vagabond
                ItemStack mace_Vagabond = new ItemStack(Material.MACE);
                ItemStack casqueVagabond = new ItemStack(Material.LEATHER_HELMET);
                ItemStack plastronVagabond = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack jambesVagabond = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack bottesVagabond = new ItemStack(Material.LEATHER_BOOTS);
                ItemStack sautspirituelVagabond = ItemCustom.SAUT_SPIRITUEL.clone();

                joueur.sendMessage("§aTu as choisi la classe Vagabond !");
                joueur.getInventory().clear();
                joueur.getInventory().addItem(mace_Vagabond,casqueVagabond,plastronVagabond,jambesVagabond,bottesVagabond, sautspirituelVagabond, potion_de_vie, steak);
                joueur.playSound(joueur.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                joueur.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 30*4, 1));
                joueur.closeInventory();
            }
            if(nomItem.equals("§cMagicien")){
                //stuff magicien
                ItemStack baguette_Magicien = ItemCustom.BAGUETTE_MAGIQUE.clone();
                ItemStack casque_Magicien = new ItemStack(Material.LEATHER_HELMET);
                ItemStack plastron_Magicien = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack jambes_Magicien = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack bottes_Magicien = new ItemStack(Material.LEATHER_BOOTS);
                ItemStack Fireball_Magicien = ItemCustom.BOULE_FEU.clone();

                joueur.sendMessage("§aTu as choisi la classe Magicien !");
                joueur.getInventory().clear();
                joueur.getInventory().addItem(baguette_Magicien,casque_Magicien, plastron_Magicien, jambes_Magicien, bottes_Magicien, Fireball_Magicien,potion_de_vie, steak);
                joueur.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 30*4, 1));
                joueur.playSound(joueur.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                joueur.closeInventory();
            }
            if(nomItem.equals("§cÉclaireur")){
                //stuff Éclaireur
                ItemStack arc_eclaireur = new ItemStack(Material.BOW);
                ItemStack casque_eclaireur = new ItemStack(Material.LEATHER_HELMET);
                ItemStack plastron_eclaireur = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack jambes_eclaireur = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack bottes_eclaireur = new ItemStack(Material.LEATHER_BOOTS);
                ItemStack fleches_eclaireur = new ItemStack(Material.ARROW,32);

                //flèche 1
                ItemStack flechespecial1 = new ItemStack(Material.TIPPED_ARROW, 6);
                PotionMeta metaPoison = (PotionMeta) flechespecial1.getItemMeta();
                metaPoison.setBasePotionType(PotionType.POISON);
                metaPoison.setDisplayName("§2Flèche de Poison");
                flechespecial1.setItemMeta(metaPoison);

                //flèche 2
                ItemStack flechespecial2 = new ItemStack(Material.TIPPED_ARROW, 6);
                PotionMeta metaLenteur = (PotionMeta) flechespecial2.getItemMeta();
                metaLenteur.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 20*2, 8), true);
                metaLenteur.setDisplayName("§8Flèche de Lenteur");
                flechespecial2.setItemMeta(metaLenteur);

                //flèche 3
                ItemStack flechespecial3 = new ItemStack(Material.TIPPED_ARROW, 3);
                PotionMeta metaLevitation = (PotionMeta) flechespecial3.getItemMeta();
                metaLevitation.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 20*2, 5), true);
                metaLevitation.setColor(Color.fromRGB(200, 150, 250));
                metaLevitation.setDisplayName("§5Flèche de Lévitation");
                metaLenteur.setLore(List.of(
                        "§4Lévitation (00:20)"
                ));
                flechespecial3.setItemMeta(metaLevitation);

                joueur.sendMessage("§aTu as choisi la classe Éclaireur !");
                joueur.getInventory().clear();
                joueur.getInventory().addItem(arc_eclaireur,casque_eclaireur, plastron_eclaireur, jambes_eclaireur, bottes_eclaireur, fleches_eclaireur, flechespecial1, flechespecial2, flechespecial3, potion_de_vie, steak);
                joueur.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 30*4, 1));
                joueur.playSound(joueur.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                joueur.closeInventory();
            }
            if(nomItem.equals("§cTank")){

                //stuff Tank
                ItemStack hache_tank = new ItemStack(Material.STONE_AXE);
                ItemStack casque_tank = new ItemStack(Material.LEATHER_HELMET);
                ItemStack pastron_tank = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemStack jambes_tank = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemStack bottes_tank = new ItemStack(Material.LEATHER_BOOTS);
                ItemStack bouclier_tank = new ItemStack(Material.SHIELD);
                //soupe résistance
                ItemStack soupe_tank = new ItemStack(Material.SUSPICIOUS_STEW, 6);
                SuspiciousStewMeta metaTankResistance = (SuspiciousStewMeta) soupe_tank.getItemMeta();
                metaTankResistance.addCustomEffect(new PotionEffect(PotionEffectType.RESISTANCE, 20*25, 3), true);
                metaTankResistance.setDisplayName("§eSoupe de résistance IV (00:40");
                soupe_tank.setItemMeta(metaTankResistance);

                joueur.sendMessage("§aTu as choisi la classe Tank !");
                joueur.getInventory().clear();
                joueur.getInventory().addItem(hache_tank, casque_tank,pastron_tank,jambes_tank, bottes_tank, bouclier_tank, soupe_tank, potion_de_vie, steak );
                joueur.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 30*4, 1));
                joueur.playSound(joueur.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                joueur.closeInventory();
            }
        }
    }
    }
}
