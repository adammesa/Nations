package com.github.Nebula111.nations.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.github.Nebula111.nations.nations;


public class MySQL_api extends Database_api
{
	nations plugin;

	public MySQL_api(nations instance) {
		plugin = instance;
	}
	String user = plugin.getConfig().getString("username");
	String database = plugin.getConfig().getString("database");
	String password = plugin.getConfig().getString("password");
	String port = plugin.getConfig().getString("port");
	String hostname = plugin.getConfig().getString("host");
	Connection c = null;


	public MySQL_api(String hostname, String portnmbr, String database, String username, String password) {
		this.hostname = hostname;
		this.port = portnmbr;
		this.database = database;
		this.user = username;
		this.password = password;
	}
	public Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.c = DriverManager.getConnection("jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database, this.user, this.password);
			return c;
		} catch (SQLException e) {
			System.out.println("Could not connect to MySQL server! because: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found!");
		}
		return this.c;
	}
	public boolean checkConnection() {
		if (this.c != null) {
			return true;
		}
		return false;
	}
	public Connection getConn() {
		return this.c;
	}
	public void closeConnection(Connection c) {
		c = null;
	}
}
