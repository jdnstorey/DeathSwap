package me.scottstorey.deathswap;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Main extends JavaPlugin {

    public Random random = new Random();

    public void onEnable() {new DSCommand(this); new DSEnd(this);}
    public void onDisable() {}

}
