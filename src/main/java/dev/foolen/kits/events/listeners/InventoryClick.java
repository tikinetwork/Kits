package dev.foolen.kits.events.listeners;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import dev.foolen.kits.Kits;
import dev.foolen.kits.kits.Kit;
import dev.foolen.kits.utils.messages.Messages;

public class InventoryClick implements Listener {
	
	private ArrayList<Kit> kits; 
	
	public InventoryClick(Kits plugin) {
		kits = plugin.getKits();
	}
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getHolder() == null) {
			e.setCancelled(true);

			// Set target player
			Player player = (Player) e.getWhoClicked();
			
			if (e.getCurrentItem() != null) {
				// Check which kit is selected
				kits.forEach(kit -> {
					if (kit.getThumbnailItem() == e.getCurrentItem().getType()) {
						kit.getItems().forEach((material, amount) -> {
							player.getInventory().addItem(new ItemStack(material, amount));
						});
						
						Messages.debug("Granted " + player.getName() + " the '" + kit.getName() + "' kit.");
						Messages.informPlayer(player, "You have been given the '" + kit.getName() + "' kit.");
						return;
					}
				});
			}
		}
	}
}
