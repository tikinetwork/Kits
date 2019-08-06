package dev.foolen.kits.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryPickUpItem implements Listener {
	
	@EventHandler
	public void onInventoryPickUpItem(InventoryPickupItemEvent e) {
		if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getHolder() == null) {
			e.setCancelled(true);
		}
	}
}
