package com.github.qianniancc.cnevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class shiyongwupin extends PlayerEvent implements Cancellable {
	private ItemStack usedOn;
	private ItemStack useItem;
	private boolean consumes;
	private boolean cancel;

	public shiyongwupin(Player who, ItemStack usedOn, ItemStack useItem) {
		super(who);
		this.usedOn = usedOn;
		this.useItem = useItem;
		this.consumes = false;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public ItemStack getUsedOn() {
		return this.usedOn;
	}

	public ItemStack getUseItem() {
		return this.useItem;
	}

	public void setConsumes(boolean consumes) {
		this.consumes = consumes;
	}

	public boolean doesConsume() {
		return this.consumes;
	}

	public boolean isCancelled() {
		return this.cancel;
	}

	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
}
