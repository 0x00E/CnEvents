package com.github.qianniancc.cnevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class quxiaoxuanze extends PlayerEvent implements Cancellable {
	private ItemStack dequip;
	private boolean isCancelled = false;

	public quxiaoxuanze(Player who, ItemStack dequip) {
		super(who);
		this.dequip = dequip;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public ItemStack getDequippedItem() {
		return this.dequip;
	}

	public boolean isCancelled() {
		return this.isCancelled;
	}

	public void setCancelled(boolean newValue) {
		this.isCancelled = newValue;
	}
}
