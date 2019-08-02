package dev.foolen.kits.events.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if (e.getInventory().getHolder() == null) {
			player.sendMessage("Grabbing items...");
			e.setCancelled(true);
		}
	}
}
