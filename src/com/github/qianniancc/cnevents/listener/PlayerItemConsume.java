package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.xiaohao;

public class PlayerItemConsume implements Listener {
	CnEvents c;

	public PlayerItemConsume(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerItemConsumeEvent event) {
		xiaohao aee = new xiaohao(event.getPlayer());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
