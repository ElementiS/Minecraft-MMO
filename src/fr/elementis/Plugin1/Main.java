package fr.elementis.Plugin1;
import fr.elementis.Plugin1.evenements.ClasseDebut;
import fr.elementis.Plugin1.evenements.ItemCustom;
import fr.elementis.Plugin1.evenements.JoueurRejointEvent;
import fr.elementis.Plugin1.evenements.UsageItem;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new JoueurRejointEvent(), this);
        getServer().getPluginManager().registerEvents(new ClasseDebut(), this);
        getServer().getPluginManager().registerEvents(new UsageItem(),this);
        ItemCustom.init();
        System.out.println("Plugin1 est lancé");
    }
    public void onDisable()
    {
        System.out.println("Plugin1 est éteint");
    }
}
