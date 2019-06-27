package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.genggaishijie;

public class PlayerChangedWorld implements Listener {
	CnEvents c;

	public PlayerChangedWorld(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerChangedWorldEvent event) {
		genggaishijie aee = new genggaishijie(event.getPlayer());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
