package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.Nebula111.nations.nations;


public class CmdReloadConfig implements CommandExecutor {
	nations plugin;

	public CmdReloadConfig(nations plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String alias, String[] args) {
		Player p = (Player) sender;
		if (!p.hasPermission("nations.reload")) {
			p.sendMessage(ChatColor.RED
					+ "You don't have permission to do this!");
			return true;
		}else{
			plugin.reloadConfig();
			p.sendMessage(ChatColor.GREEN + "Configuration Successfully Reloaded");
		}
		return true;
	}

}
