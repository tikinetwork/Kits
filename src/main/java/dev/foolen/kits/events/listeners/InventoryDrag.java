package dev.foolen.kits.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class InventoryDrag implements Listener {

	@EventHandler
	public void onInventoryDrag(InventoryDragEvent e) {
		if (e.getInventory().getHolder() == null) {
			e.setCancelled(true);
		}
	}
	
}
