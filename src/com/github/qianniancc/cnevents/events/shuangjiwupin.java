package com.github.qianniancc.cnevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class shuangjiwupin extends PlayerEvent implements Cancellable {
	private ItemStack used;
	private boolean isRightClicked;
	private boolean isDoubleClicked;
	private boolean consumes;
	private boolean cancel;

	public shuangjiwupin(Player who, ItemStack used, boolean isRightClicked, boolean isDoubleClicked) {
		super(who);
		this.used = used;
		this.isRightClicked = isRightClicked;
		this.isDoubleClicked = isDoubleClicked;
		this.consumes = false;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public ItemStack getItemStack() {
		return this.used;
	}

	public boolean isRightClicked() {
		return this.isRightClicked;
	}

	public boolean isDoubleClicked() {
		return this.isDoubleClicked;
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
