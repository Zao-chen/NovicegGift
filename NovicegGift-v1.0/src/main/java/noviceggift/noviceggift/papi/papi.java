package noviceggift.noviceggift.papi;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;


public class papi extends PlaceholderExpansion {
    @Override
    public boolean canRegister(){
        return true;
    }
    @Override
    public String getAuthor(){
        return "someauthor";
    }
    @Override
    public String getIdentifier(){
        return "ng";
    }
    @Override
    public String getVersion(){
        return "1.0.0";
    }
    @Override
    public String onRequest(OfflinePlayer player, String identifier){
        Plugin plugin = noviceggift.noviceggift.NovicegGift.getProvidingPlugin(noviceggift.noviceggift.NovicegGift.class);
        String time = "%statistic_hours_played%";
        time = PlaceholderAPI.setPlaceholders(player,time);
        if(time.equals("0"))
        {
            return "[新萌]";
        }
        else
        {
            return "";
        }
    }
}