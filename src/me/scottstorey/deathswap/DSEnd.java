package me.scottstorey.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class DSEnd implements Listener {

    private Plugin plugin;
    private Main main;
    public DSEnd(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    @SuppressWarnings("deprecated")
    public void onDeath(PlayerDeathEvent e){
        Player loser = e.getEntity();

        new DSRun(main).teleports.cancel();

        e.setDeathMessage("");
        for(Player p : Bukkit.getOnlinePlayers()){
            Bukkit.broadcastMessage(ChatColor.RED + "Game is over because " + loser + " died.");

            p.teleport(p.getWorld().getSpawnLocation());
            p.getInventory().clear();

            p.setTotalExperience(0);
            p.setHealth(20);
            p.setFoodLevel(20);
            p.setSaturation(20);
        }
    }

}
