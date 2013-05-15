package com.github.Nebula111.nations;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerPositionEvent implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent event){
		Player p = event.getPlayer();
		if(event.isCancelled()){
			return;
		} else {
		double locx = (double) p.getLocation().getX();
		double locz = (double) p.getLocation().getZ();
		
		
		}
		
	}

}
