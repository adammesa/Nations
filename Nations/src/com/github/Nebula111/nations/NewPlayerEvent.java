package com.github.Nebula111.nations;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class NewPlayerEvent implements Listener {
	

	nations plugin; //Constructor for getting config values
	public NewPlayerEvent(nations instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		if(!p.hasPlayedBefore()){

			//** Instruction Book Creation **\\

			p.sendMessage(ChatColor.BLUE + "This book contains instructions on how to use Nations!");
			ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta bm = (BookMeta)book.getItemMeta();
			bm.setAuthor(plugin.getConfig().getString("Book Title"));
			bm.setTitle("Nations Instructions");
			ArrayList<String> pages = new ArrayList<String>();
			pages.add("Put some instructions here");
			pages.add("Put some instructions here");
			bm.setPages(pages);
			book.setItemMeta(bm);
			p.getInventory().addItem(book);
			

		}

	}

}
