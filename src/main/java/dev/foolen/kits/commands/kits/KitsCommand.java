package dev.foolen.kits.commands.kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import dev.foolen.kits.items.Item;
import dev.foolen.kits.utils.messages.Messages;

public class KitsCommand implements CommandExecutor {

	private Inventory gui;

	public KitsCommand() {
		gui = Bukkit.createInventory(null, 9, "Kits");

		loadItems();
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
		Messages.informPlayer(player, "Loading gui...");
		return true;
	}

	private void loadItems() {
		Item item = new Item(Material.COOKED_BEEF, "Food", "Get a basic supply of food");

		gui.setItem(0, item.getItemStack());
	}

}
