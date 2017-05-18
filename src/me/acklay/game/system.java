package me.acklay.game;

import static org.bukkit.ChatColor.BOLD;
import static org.bukkit.ChatColor.DARK_GRAY;
import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.RESET;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.acklay.game.listener.PlayerListener;

@SuppressWarnings("unused")
public class system extends JavaPlugin {
	
	public void onDisable() {
	}
 
	public void onEnable() {
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerListener(), system.this);
	}
}
