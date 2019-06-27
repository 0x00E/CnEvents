package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.zhuangbeiyifu;

public class PlayerInteractListener implements Listener {
	CnEvents c;

	public PlayerInteractListener(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@EventHandler
	public void onEvent(PlayerInteractEvent event) {
		if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if ((event.getItem() == null) || (event.getItem().getType() == Material.AIR)) {
				return;
			}
			Material mat = event.getItem().getType();

			zhuangbeiyifu aee = new zhuangbeiyifu(event.getPlayer(), event.getItem());
			if (((mat == Material.DIAMOND_HELMET) || (mat == Material.GOLD_HELMET) || (mat == Material.CHAINMAIL_HELMET)
					|| (mat == Material.IRON_HELMET) || (mat == Material.LEATHER_HELMET))
					&& (event.getPlayer().getInventory().getHelmet() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else if (((mat == Material.DIAMOND_CHESTPLATE) || (mat == Material.GOLD_CHESTPLATE)
					|| (mat == Material.CHAINMAIL_CHESTPLATE) || (mat == Material.IRON_CHESTPLATE)
					|| (mat == Material.LEATHER_CHESTPLATE))
					&& (event.getPlayer().getInventory().getChestplate() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else if (((mat == Material.DIAMOND_LEGGINGS) || (mat == Material.GOLD_LEGGINGS)
					|| (mat == Material.CHAINMAIL_LEGGINGS) || (mat == Material.IRON_LEGGINGS)
					|| (mat == Material.LEATHER_LEGGINGS))
					&& (event.getPlayer().getInventory().getLeggings() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else if (((mat == Material.DIAMOND_BOOTS) || (mat == Material.GOLD_BOOTS)
					|| (mat == Material.CHAINMAIL_BOOTS) || (mat == Material.IRON_BOOTS)
					|| (mat == Material.LEATHER_BOOTS)) && (event.getPlayer().getInventory().getBoots() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else {
				return;
			}
			if (aee.isCancelled()) {
				event.setCancelled(true);
				event.setUseItemInHand(Result.DENY);
				event.getPlayer().updateInventory();
			}
		}
	}
}
