package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.hudong;

public class PlayerInteract implements Listener {
	CnEvents c;

	public PlayerInteract(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerInteractEvent event) {
		hudong aee = new hudong(event.getPlayer());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
