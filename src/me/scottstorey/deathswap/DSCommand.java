package me.scottstorey.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DSCommand implements CommandExecutor {

    private Plugin plugin;
    public DSCommand (Main plugin){
        this.plugin = plugin;
        Bukkit.getServer().getPluginCommand("deathswap").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.isOp()){
                if(cmd.getName().equalsIgnoreCase("deathswap")){
                    if(args.length != 1){
                        p.sendMessage("Insufficient Arguments");
                    } else {
                        if(args[0].equalsIgnoreCase("start")){
                            new DSStart(new Main()).titleSequence();
                        }
                    }
                }
            }
        }

        return false;
    }
}
