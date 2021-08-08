package me.scottstorey.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

public class DSStart {

    private Plugin plugin;
    public DSStart (Main plugin){
        this.plugin = plugin;
    }

    public void titleSequence() {
        BukkitTask s = new BukkitRunnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    switch (i){
                        case 0:
                            //announce deathswap
                            Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "Deathswap starting in...");
                        case 1:
                            //countdown 3
                            Bukkit.broadcastMessage(ChatColor.GOLD + "3");
                        case 2:
                            //countdown 2
                            Bukkit.broadcastMessage(ChatColor.GOLD + "2");
                        case 3:
                            //countdown 1
                            Bukkit.broadcastMessage(ChatColor.GOLD + "1");
                        case 4:
                            //teleport players
                            for(Player p : Bukkit.getOnlinePlayers()){
                                p.teleport(newLocation(p, p.getWorld()));
                            }
                            //say started
                            Bukkit.broadcastMessage(ChatColor.GREEN + "DeathSwap has started");
                            break;
                        default:
                            break;
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 20);
    }

    public Location newLocation(Player p, World world){
        int x = new Main().random.nextInt(1000) + 1;
        int z = new Main().random.nextInt(1000) + 1;

        return new Location(world, x, world.getHighestBlockAt(x, z).getY() + 1, z);
    }

}
