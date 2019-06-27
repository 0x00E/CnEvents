package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.moshigenggai;

public class PlayerGameModeChange implements Listener {
	CnEvents c;

	public PlayerGameModeChange(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerGameModeChangeEvent event) {
		moshigenggai aee = new moshigenggai(event.getPlayer());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
