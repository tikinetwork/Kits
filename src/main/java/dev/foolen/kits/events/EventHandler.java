package dev.foolen.kits.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import dev.foolen.kits.Kits;
import dev.foolen.kits.events.listeners.*;

public class EventHandler {

	public EventHandler(Kits plugin) {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new InventoryClick(plugin), plugin);
		pm.registerEvents(new InventoryDrag(), plugin);
		pm.registerEvents(new InventoryMoveItem(), plugin);
		pm.registerEvents(new InventoryPickUpItem(), plugin);
	}
}
