package com.github.qianniancc.cnevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;

public class xiulitiezhen extends InventoryEvent {
	private static final HandlerList handlers = new HandlerList();
	private Player who;

	public xiulitiezhen(InventoryView transaction) {
		super(transaction);
		this.who = ((Player) transaction.getPlayer());
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Player getPlayer() {
		return this.who;
	}
}
