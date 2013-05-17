package com.github.Nebula111.nations;



public class mysql { 
	
	//Constructor for getting config values\\
	nations plugin; 
	public mysql(nations instance) {
		plugin = instance;
	}

	String sqlusername = plugin.getConfig().getString("username");
	String sqlpwd = plugin.getConfig().getString("password");
	String sqlurl = plugin.getConfig().getString("host");
}
