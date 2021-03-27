package noviceggift.noviceggift.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class join implements Listener {
    @EventHandler
    public void Playerjoin(PlayerJoinEvent event)
    {
        Plugin plugin = noviceggift.noviceggift.NovicegGift.getProvidingPlugin(noviceggift.noviceggift.NovicegGift.class);
        List<String> record = plugin.getConfig().getStringList("join-record");
        for (String record_ : record)
        {
            if(event.getPlayer().getName().equals(record_))
            {
                return;
            }
        }
        record.add(event.getPlayer().getName());
        plugin.getConfig().set("join-record", record);
        plugin.saveConfig();
        String title = plugin.getConfig().getString("join-title");
        String subtitle = plugin.getConfig().getString("join-subtitle");
        event.getPlayer().sendTitle(title,subtitle);
        List<String> message = plugin.getConfig().getStringList("join-message");
        for (String message_ : message)
        {
            event.getPlayer().sendMessage(message_);
        }
        List<String> command = plugin.getConfig().getStringList("join-command");
        for (String command_ : command)
        {
            command_ = PlaceholderAPI.setPlaceholders(event.getPlayer(),command_);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command_);
        }
    }
}
