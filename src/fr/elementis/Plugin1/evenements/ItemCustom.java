package fr.elementis.Plugin1.evenements;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemCustom implements Listener {
    public static ItemStack SAUT_SPIRITUEL;
    public static ItemStack BAGUETTE_MAGIQUE;
    public static ItemStack BOULE_FEU;

    public static void init() {

        //WINDCHARGE VAGABOND

        SAUT_SPIRITUEL = new ItemStack(Material.WIND_CHARGE);

        ItemMeta meta = SAUT_SPIRITUEL.getItemMeta();
        meta.setDisplayName("§eSaut Spirituel");
        meta.setLore(List.of(
                "§9Cooldown 3s"
        ));
        SAUT_SPIRITUEL.setItemMeta(meta);

        //BAGUETTE MAGE

        BAGUETTE_MAGIQUE = new ItemStack(Material.STICK);
        ItemMeta meta2 = BAGUETTE_MAGIQUE.getItemMeta();
        meta2.setDisplayName("§1Baguette de Foudre");
        meta2.setLore(List.of(
                "§fFait s'abattre la Foudre !"
        ));
        BAGUETTE_MAGIQUE.setItemMeta(meta2);

        //SORT FEU MAGE

        BOULE_FEU = new ItemStack(Material.IRON_HORSE_ARMOR);
        ItemMeta meta3 = BOULE_FEU.getItemMeta();
        meta3.setDisplayName("§4Boule de Feu");
        meta3.setLore(List.of(
                "§fLance une faible boule de feu"
        ));
        meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        BOULE_FEU.setItemMeta(meta3);
    }
}