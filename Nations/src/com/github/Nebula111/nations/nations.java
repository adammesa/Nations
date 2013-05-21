package com.github.Nebula111.nations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.Nebula111.nations.commands.CmdReloadConfig;



public class nations extends JavaPlugin {

	public final NewPlayerEvent NewPlayerEvent = new NewPlayerEvent(this);
	public final PlayerPositionEvent PlayerPositionEvent = new PlayerPositionEvent();

	@Override
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		this.getLogger().info("Nations version " + pdf.getVersion() + "has been Disabled!");
	}
	public void loadConfig(){
		// ** Config Stuff ** \\
		FileConfiguration config = getConfig();
		
		config.addDefault("Book Title", "AC");
		config.addDefault("username", "Mysql_Username");
		config.addDefault("password", "Mysql_Password");
		config.addDefault("host", "localhost");
		config.addDefault("port", "3306");
		config.options().copyDefaults();
		saveConfig();
	}
	
	@Override
	public void onEnable() {
		getCommand("nationsreload").setExecutor(new CmdReloadConfig(this));
		loadConfig();
		PluginDescriptionFile pdf = this.getDescription();
		this.getLogger().info("Enabling Nations version " + pdf.getVersion());

		// ** Hook into Factions ** \\

		Plugin plugin = Bukkit.getPluginManager().getPlugin("Factions");
		if(plugin != null){
			this.getLogger().info("Factions is on the server!");
			this.getLogger().info("hooking into factions...");
			this.getLogger().info("Nations Enabled");
		} else {
			this.getLogger().warning("Could not hook into factions!");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		// ** Register Events ** \\

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new NewPlayerEvent(this), this);
		pm.registerEvents(new PlayerPositionEvent(), this);
	//	pm.registerEvents(new mysql(), this);
	
		
		
		
	}
}
