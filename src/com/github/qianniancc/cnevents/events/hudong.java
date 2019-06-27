package com.github.qianniancc.cnevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class hudong extends PlayerEvent implements Cancellable {
	private ItemStack equip;
	private boolean isCancelled = false;
	private String msg;

	public hudong(Player who) {
		super(who);
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public ItemStack getEquippedItem() {
		return this.equip;
	}

	public boolean isCancelled() {
		return this.isCancelled;
	}

	public void setCancelled(boolean newValue) {
		this.isCancelled = newValue;
	}

	public String getMessage() {
		return this.msg;
	}
}
