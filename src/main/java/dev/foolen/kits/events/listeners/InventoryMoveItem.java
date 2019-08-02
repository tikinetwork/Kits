package dev.foolen.kits.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InventoryMoveItem implements Listener {

	@EventHandler
	public void onInventoryMoveItem(InventoryMoveItemEvent e) {
		if (e.getSource().getHolder() == null) {
			e.setCancelled(true);
		}
	}
	
}
