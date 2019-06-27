package com.github.qianniancc.cnevents.events;

import java.net.InetAddress;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;

@SuppressWarnings("deprecation")
public class SyncLoginEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	private PlayerPreLoginEvent.Result result;
	private String message;
	private String name;
	private InetAddress ipAddress;
	private UUID uniqueId;

	public SyncLoginEvent(AsyncPlayerPreLoginEvent e) {
		this.result = e.getResult();
		this.message = e.getKickMessage();
		this.name = e.getName();
		this.ipAddress = e.getAddress();
		this.uniqueId = e.getUniqueId();
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public PlayerPreLoginEvent.Result getResult() {
		return this.result;
	}

	public String getKickMessage() {
		return this.message;
	}

	public String getName() {
		return this.name;
	}

	public InetAddress getAddress() {
		return this.ipAddress;
	}

	public UUID getUniqueID() {
		return this.uniqueId;
	}
}
