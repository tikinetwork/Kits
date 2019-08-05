package dev.foolen.kits.commands.executors;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import dev.foolen.kits.Kits;
import dev.foolen.kits.items.Item;
import dev.foolen.kits.kits.Kit;
import dev.foolen.kits.utils.messages.Messages;

public class KitsCommand implements CommandExecutor {

	private Inventory gui;

	public KitsCommand(Kits plugin) {
		ArrayList<Kit> kits = plugin.getKits();
		
		int inventorySize = (kits.size() > 9) ? (kits.size() > 18 ? 27 : 18) : 9; // Check if one, two or three rows.
		
		gui = Bukkit.createInventory(null, inventorySize, "Kits");
		
		loadKits(kits);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// Check if player
		if (!(sender instanceof Player)) {
			Messages.info("Only a player can run this command!");
			return true;
		}

		Player player = (Player) sender;

		// Show available kits
		player.openInventory(gui);

		Messages.debug(player.getName() + " executed the 'kits' command.");
		Messages.informPlayer(player, "Loading kits...");
		return true;
	}
	
	private void loadKits(ArrayList<Kit> kits) {		
		for (int i=0; i<kits.size(); i++) {
			Item item = new Item(kits.get(i).getThumbnailItem(), kits.get(i).getName(), kits.get(i).getDescription());
			
			gui.setItem(i, item.getItemStack());
		}
	}
}
