package noviceggift.noviceggift;

import noviceggift.noviceggift.commands.maincommand;
import noviceggift.noviceggift.events.join;
import noviceggift.noviceggift.metrics.Metrics;
import noviceggift.noviceggift.papi.papi;
import org.bukkit.plugin.java.JavaPlugin;

public final class NovicegGift extends JavaPlugin {
    private PlaceholderHook placeholderHook;
    @Override
    public void onEnable() {
        // Plugin startup logic
        int pluginId = 10820; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        this.saveDefaultConfig();
        placeholderHook = new PlaceholderHook();
        new papi().register();
        getConfig().options().copyDefaults();
        getCommand("noviceggift").setExecutor(new maincommand());
        getServer().getPluginManager().registerEvents(new join(), this);
    }

    @Override
    public void onDisable() {
        saveConfig();
        // Plugin shutdown logic
    }
}
