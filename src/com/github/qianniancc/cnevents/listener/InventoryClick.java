package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.beibaodianji;

public class InventoryClick implements Listener {
	CnEvents c;

	public InventoryClick(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(InventoryClickEvent event) {
		beibaodianji aee = new beibaodianji((Player) event.getWhoClicked());
		Bukkit.getPluginManager().callEvent(aee);
	}
}
