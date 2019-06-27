package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.zhiling;

public class PlayerCommandPreprocess implements Listener {
	CnEvents c;

	public PlayerCommandPreprocess(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerCommandPreprocessEvent event) {
		zhiling aee = new zhiling(event.getPlayer(), event.getMessage());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
