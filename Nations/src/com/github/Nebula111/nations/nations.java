package com.github.Nebula111.nations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class nations extends JavaPlugin {

	public final NewPlayerEvent NewPlayerEvent = new NewPlayerEvent(this);
	public final PlayerPositionEvent PlayerPositionEvent = new PlayerPositionEvent();

	@Override
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		this.getLogger().info("Nations version " + pdf.getVersion() + "has been Disabled!");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdf = this.getDescription();
		this.getLogger().info("Enabling Nations version " + pdf.getVersion());

		// ** Hook into Factions ** \\

		Plugin plugin = Bukkit.getPluginManager().getPlugin("Factions");
		if(plugin != null && plugin.isEnabled()){
			this.getLogger().info("Factions is on the server!");
			this.getLogger().info("hooking into factions...");
			this.getLogger().info("Nations Enabled");
		} else {
			this.getLogger().warning("Could not hook into factions!");
			Bukkit.getPluginManager().disablePlugin(this);
		}

		// ** Register Events ** \\

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new NewPlayerEvent(this), this);
		pm.registerEvents(new PlayerPositionEvent(), this);
		
		// ** Config Stuff ** \\

		FileConfiguration config = getConfig();
		
		config.addDefault("Book Title", "AC");
		config.options().copyDefaults();
		saveConfig();
		
		
	}
}
