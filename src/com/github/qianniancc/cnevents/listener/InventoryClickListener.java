package com.github.qianniancc.cnevents.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import com.github.qianniancc.cnevents.CnEvents;
import com.github.qianniancc.cnevents.events.quxiaoxuanze;
import com.github.qianniancc.cnevents.events.shiyongwupin;
import com.github.qianniancc.cnevents.events.shuangjiwupin;
import com.github.qianniancc.cnevents.events.zhuangbeiyifu;

public class InventoryClickListener implements Listener {
	CnEvents c;

	public InventoryClickListener(CnEvents c) {
		this.c = c;
		c.getServer().getPluginManager().registerEvents(this, c);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEvent(InventoryClickEvent event) {
		if ((event.getAction() == InventoryAction.PICKUP_HALF) && (event.getClick() == ClickType.RIGHT)
				&& (event.getCurrentItem().getType() != Material.AIR)) {
			shuangjiwupin iue = new shuangjiwupin((Player) event.getWhoClicked(), event.getCurrentItem(), true, false);

			Bukkit.getPluginManager().callEvent(iue);
			if (iue.doesConsume()) {
				if (event.getCurrentItem().getAmount() > 1) {
					event.getCurrentItem().setAmount(event.getCurrentItem().getAmount() - 1);
				} else {
					event.setCurrentItem(new ItemStack(Material.AIR));
				}
			}
			if (iue.isCancelled()) {
				event.setCancelled(true);
			}
		} else if ((event.getAction() == InventoryAction.NOTHING) && (event.getClick() == ClickType.DOUBLE_CLICK)
				&& (event.getCursor().getType() != Material.AIR)) {
			shuangjiwupin iue = new shuangjiwupin((Player) event.getWhoClicked(), event.getCursor(), false, true);

			Bukkit.getPluginManager().callEvent(iue);
			if (iue.doesConsume()) {
				if (event.getCursor().getAmount() > 1) {
					event.getCursor().setAmount(event.getCursor().getAmount() - 1);
				} else {
					event.setCursor(new ItemStack(Material.AIR));
				}
			}
			if (iue.isCancelled()) {
				event.setCancelled(true);
			}
		} else if (((event.getAction() == InventoryAction.PLACE_ALL)
				|| (event.getAction() == InventoryAction.PLACE_SOME)
				|| (event.getAction() == InventoryAction.PLACE_ONE))
				&& (event.getSlotType() == InventoryType.SlotType.ARMOR)
				&& (event.getCurrentItem().getType() == Material.AIR)) {
			zhuangbeiyifu aee = new zhuangbeiyifu((Player) event.getWhoClicked(), event.getCursor());
			Bukkit.getPluginManager().callEvent(aee);
			if (aee.isCancelled()) {
				event.setCancelled(true);
			}
		} else if ((event.getAction() == InventoryAction.SWAP_WITH_CURSOR)
				&& (event.getSlotType() == InventoryType.SlotType.ARMOR)
				&& (event.getCurrentItem().getType() != Material.AIR)
				&& (event.getCursor().getType() != Material.AIR)) {
			quxiaoxuanze ade = new quxiaoxuanze((Player) event.getWhoClicked(), event.getCurrentItem());
			Bukkit.getPluginManager().callEvent(ade);

			zhuangbeiyifu aee = new zhuangbeiyifu((Player) event.getWhoClicked(), event.getCursor());
			Bukkit.getPluginManager().callEvent(aee);
			if ((aee.isCancelled()) || (ade.isCancelled())) {
				event.setCancelled(true);
			}
		} else if (((event.getAction() != InventoryAction.PICKUP_ALL)
				&& (event.getAction() != InventoryAction.PICKUP_HALF)
				&& (event.getAction() != InventoryAction.PICKUP_ONE)
				&& (event.getAction() != InventoryAction.PICKUP_SOME))
				|| ((event.getSlotType() == InventoryType.SlotType.ARMOR)
						&& (event.getCurrentItem().getType() != Material.AIR)
						&& (event.getCursor().getType() == Material.AIR))
				|| ((event.getWhoClicked().getGameMode() == GameMode.CREATIVE)
						&& (event.getAction() == InventoryAction.PLACE_ALL)
						&& (event.getSlotType() == InventoryType.SlotType.ARMOR))) {
			quxiaoxuanze ade = new quxiaoxuanze((Player) event.getWhoClicked(), event.getCurrentItem());
			Bukkit.getPluginManager().callEvent(ade);
			if (ade.isCancelled()) {
				event.setCancelled(true);
			}
		} else if ((event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY)
				&& (event.getSlotType() == InventoryType.SlotType.ARMOR) && (event.getResult() == Result.ALLOW)) {
			quxiaoxuanze ade = new quxiaoxuanze((Player) event.getWhoClicked(), event.getCurrentItem());
			Bukkit.getPluginManager().callEvent(ade);
			if (ade.isCancelled()) {
				event.setCancelled(true);
			}
		} else if ((event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY)
				&& (event.getSlotType() != InventoryType.SlotType.ARMOR)
				&& (event.getWhoClicked().getInventory() == event.getClickedInventory())
				&& (event.getWhoClicked().getOpenInventory().getType() == InventoryType.CRAFTING)) {
			Material mat = event.getCurrentItem().getType();

			zhuangbeiyifu aee = new zhuangbeiyifu((Player) event.getWhoClicked(), event.getCurrentItem());
			if (((mat == Material.DIAMOND_HELMET) || (mat == Material.GOLD_HELMET) || (mat == Material.CHAINMAIL_HELMET)
					|| (mat == Material.IRON_HELMET) || (mat == Material.LEATHER_HELMET) || (mat == Material.PUMPKIN))
					&& (event.getWhoClicked().getInventory().getHelmet() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else if ((mat == Material.DIAMOND_CHESTPLATE) || (mat == Material.GOLD_CHESTPLATE)
					|| (mat == Material.CHAINMAIL_CHESTPLATE) || (mat == Material.IRON_CHESTPLATE)
					|| ((mat == Material.LEATHER_CHESTPLATE)
							&& (event.getWhoClicked().getInventory().getChestplate() == null))) {
				Bukkit.getPluginManager().callEvent(aee);
			} else if (((mat == Material.DIAMOND_LEGGINGS) || (mat == Material.GOLD_LEGGINGS)
					|| (mat == Material.CHAINMAIL_LEGGINGS) || (mat == Material.IRON_LEGGINGS)
					|| (mat == Material.LEATHER_LEGGINGS))
					&& (event.getWhoClicked().getInventory().getLeggings() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else if (((mat == Material.DIAMOND_BOOTS) || (mat == Material.GOLD_BOOTS)
					|| (mat == Material.CHAINMAIL_BOOTS) || (mat == Material.IRON_BOOTS)
					|| (mat == Material.LEATHER_BOOTS)) && (event.getWhoClicked().getInventory().getBoots() == null)) {
				Bukkit.getPluginManager().callEvent(aee);
			} else {
				return;
			}
			if (aee.isCancelled()) {
				event.setCancelled(true);
			}
		} else if ((event.getAction() == InventoryAction.SWAP_WITH_CURSOR) && (event.getClick() == ClickType.LEFT)
				&& (event.getCursor().getType() != Material.AIR) && (event.getCurrentItem().getType() != Material.AIR)
				&& (event.getWhoClicked().getInventory() == event.getClickedInventory())
				&& (event.getWhoClicked().getOpenInventory().getType() == InventoryType.CRAFTING)) {
			shiyongwupin iuoe = new shiyongwupin((Player) event.getWhoClicked(), event.getCurrentItem(),
					event.getCursor());

			Bukkit.getPluginManager().callEvent(iuoe);
			if (iuoe.doesConsume()) {
				if (event.getCursor().getAmount() > 1) {
					event.getCursor().setAmount(event.getCursor().getAmount() - 1);
				} else {
					event.setCursor(new ItemStack(Material.AIR));
				}
				event.setCancelled(true);
			}
			if (iuoe.isCancelled()) {
				event.setCancelled(true);
			}
		}
	}
}
