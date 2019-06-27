package com.github.qianniancc.cnevents;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.qianniancc.cnevents.events.SyncLoginEvent;
import com.github.qianniancc.cnevents.events.SyncPlayerChatEvent;
import com.github.qianniancc.cnevents.events.shuangchi;
import com.github.qianniancc.cnevents.events.xiulitiezhen;
import com.github.qianniancc.cnevents.listener.InventoryClick;
import com.github.qianniancc.cnevents.listener.InventoryClickListener;
import com.github.qianniancc.cnevents.listener.PlayerChangedWorld;
import com.github.qianniancc.cnevents.listener.PlayerCommandPreprocess;
import com.github.qianniancc.cnevents.listener.PlayerGameModeChange;
import com.github.qianniancc.cnevents.listener.PlayerInteract;
import com.github.qianniancc.cnevents.listener.PlayerInteractListener;
import com.github.qianniancc.cnevents.listener.PlayerItemConsume;
import com.github.qianniancc.cnevents.listener.PlayerJoinListener;

public class CnEvents extends JavaPlugin implements Listener {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		new PlayerJoinListener(this);
		new PlayerCommandPreprocess(this);
		new PlayerInteract(this);
		new PlayerItemConsume(this);
		new InventoryClick(this);
		new PlayerChangedWorld(this);
		new PlayerGameModeChange(this);
		new InventoryClickListener(this);
		new PlayerInteractListener(this);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if ((event.getAction().name().startsWith("PICKUP")) && (event.getRawSlot() == 2)
				&& (event.getView().getType().equals(InventoryType.ANVIL))) {
			Bukkit.getServer().getPluginManager().callEvent(new xiulitiezhen(event.getView()));
		}
		if (((event.getAction().name().startsWith("PLACE_"))
				|| (event.getAction().equals(InventoryAction.SWAP_WITH_CURSOR))) && (event.getRawSlot() == 45)
				&& (event.getView().getType().equals(InventoryType.CRAFTING))) {
			ItemStack offHand = event.getView().getItem(45);
			offHand = (offHand == null) || (offHand.getType().equals(Material.AIR)) ? event.getCursor() : offHand;

			shuangchi wieldEvent = new shuangchi((Player) event.getView().getPlayer(), offHand);

			Bukkit.getServer().getPluginManager().callEvent(wieldEvent);
			if (wieldEvent.isCancelled()) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onAsyncChat(final AsyncPlayerChatEvent e) {
		Bukkit.getScheduler().runTask(this, new Runnable() {
			public void run() {
				Bukkit.getPluginManager().callEvent(new SyncPlayerChatEvent(e));
			}
		});
	}

	@EventHandler
	public void onAsyncLogin(final AsyncPlayerPreLoginEvent e) {
		Bukkit.getScheduler().runTask(this, new Runnable() {
			public void run() {
				Bukkit.getPluginManager().callEvent(new SyncLoginEvent(e));
			}
		});
	}
}
