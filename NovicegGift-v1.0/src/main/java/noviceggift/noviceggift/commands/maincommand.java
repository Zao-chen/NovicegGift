package noviceggift.noviceggift.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class maincommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label, String[] args) {
        Plugin plugin = noviceggift.noviceggift.NovicegGift.getProvidingPlugin(noviceggift.noviceggift.NovicegGift.class);
        String arg0=args[0];
        if(arg0.equals("reload"))
        {
            plugin.saveConfig();
            plugin.reloadConfig();
            sender.sendMessage("§e[NovicegGift] §a插件重载成功");
        }
        else if(arg0.equals("save"))
        {
            plugin.saveConfig();
            sender.sendMessage("§e[NovicegGift] §a插件保存成功");
        }
        else if(arg0.equals("load"))
        {
            plugin.reloadConfig();
            sender.sendMessage("§e[NovicegGift] §a插件保存成功");
        }
        else
        {
            sender.sendMessage("§e[NovicegGift] §c语法错误");
        }
        return false;
    }
}
