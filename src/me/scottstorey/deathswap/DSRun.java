package me.scottstorey.deathswap;

import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class DSRun {

    private Plugin plugin;
    public DSRun(Main plugin){
        this.plugin = plugin;
    }
    public ArrayList<Player> players = new ArrayList<>();

    //integers
    int time;
    int max = 6000;
    int min = 4000;

    //counter
    public Integer timer() {
        BukkitTask r = new BukkitRunnable() {
            @Override
            public void run() {
                time++;
            }
        }.runTaskTimer(plugin, 0, 20);

        if(time == 4000){
            Bukkit.broadcastMessage(ChatColor.RED + "You are now unsafe");
        }

        return time;
    }

    //teleports
    public BukkitTask teleports = new BukkitRunnable() {
        //tpcountdown
        public BukkitTask tpcountdown = new BukkitRunnable() {
            @Override
            public void run() {
                for(int i = 3; i > 0; i--){
                    //do something
                    switch (i){
                        case 3:
                            Bukkit.broadcastMessage(ChatColor.BLUE + "Teleporting in " + i + " seconds");
                        case 2:
                            Bukkit.broadcastMessage(ChatColor.BLUE + "Teleporting in " + i + " seconds");
                        case 1:
                            Bukkit.broadcastMessage(ChatColor.BLUE + "Teleporting in " + i + " seconds");
                            break;
                        default:
                            break;
                    }
                }
            }
        }.runTaskLater(plugin, 20);

        @Override
        public void run() {
            players.addAll(Bukkit.getOnlinePlayers());

            Player player1 = players.get(0);
            Location p1loc = player1.getLocation();

            Player player2 = players.get(1);
            Location p2loc = player2.getLocation();

            player1.teleport(p2loc);
            player2.teleport(p1loc);
        }
    }.runTaskTimer(plugin, 6000, new Main().random.nextInt(max - min + 1) + min);

}
