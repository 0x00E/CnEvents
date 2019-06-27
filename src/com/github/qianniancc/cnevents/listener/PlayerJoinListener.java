package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.jiaru;

public class PlayerJoinListener implements Listener {
	CnEvents c;

	public PlayerJoinListener(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerJoinEvent event) {
		jiaru aee = new jiaru(event.getPlayer());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
