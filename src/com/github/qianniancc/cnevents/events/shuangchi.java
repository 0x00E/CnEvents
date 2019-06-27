package com.github.qianniancc.cnevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class shuangchi extends PlayerEvent implements Cancellable {
	private static HandlerList handlers = new HandlerList();
	private ItemStack offHandItem;
	private boolean cancelled = false;

	public shuangchi(Player who, ItemStack offHandItem) {
		super(who);
		this.offHandItem = offHandItem;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public ItemStack getOffHandItem() {
		return this.offHandItem;
	}

	public boolean isCancelled() {
		return this.cancelled;
	}

	public void setCancelled(boolean b) {
		this.cancelled = b;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
