package dev.foolen.kits.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class InventoryPickUpItem implements Listener {
	
	@EventHandler
	public void onInventoryPickUpItem(InventoryPickupItemEvent e) {
		if (e.getInventory().getHolder() == null) {
			e.setCancelled(true);
		}
	}
}
