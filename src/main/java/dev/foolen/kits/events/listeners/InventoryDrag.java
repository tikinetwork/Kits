package dev.foolen.kits.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryDrag implements Listener {

	@EventHandler
	public void onInventoryDrag(InventoryDragEvent e) {
		if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getHolder() == null) {
			e.setCancelled(true);
		}
	}
	
}
