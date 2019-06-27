package com.github.qianniancc.cnevents.events;

import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SyncPlayerChatEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	String _format;
	String _message;
	Player _player;
	Set<Player> _recipients;

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public SyncPlayerChatEvent(AsyncPlayerChatEvent e) {
		this._format = e.getFormat();
		this._message = e.getMessage();
		this._player = e.getPlayer();
		this._recipients = e.getRecipients();
	}

	public String getFormat() {
		return this._format;
	}

	public String getMessage() {
		return this._message;
	}

	public Player getPlayer() {
		return this._player;
	}

	public Set<Player> getRecipients() {
		return this._recipients;
	}
}
