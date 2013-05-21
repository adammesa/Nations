package com.github.Nebula111.nations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class mysql { 
	
	//Constructor for getting config values\\
	nations plugin; 
	public mysql(nations instance) {
		plugin = instance;
	}

	String sqlusername = plugin.getConfig().getString("username");
	String sqlpwd = plugin.getConfig().getString("password");
	String sqlurl = plugin.getConfig().getString("host");
	
	public void createTables() throws SQLException {
	try {	Connection conn = DriverManager.getConnection(plugin.getConfig().getString("host"), plugin.getConfig().getString("username"), plugin.getConfig().getString("password"));
		PreparedStatement QueryStatement = conn.prepareStatement("uwguifgiuwgfuigwuifgw");
		QueryStatement.executeUpdate();
		QueryStatement.close();
		conn.close(); 
		} catch(Exception err){}		//So confused guys...
	}
}
