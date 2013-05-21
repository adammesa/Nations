package com.github.Nebula111.nations;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerPositionEvent implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (event.isCancelled()) {
			return;
		} else {
			int locx = (int) p.getLocation().getX();
			int locz = (int) p.getLocation().getZ();
			// TODO: get player biome position
			Biome biome = p.getWorld().getBiome(locx, locz);
		}

	}

}
