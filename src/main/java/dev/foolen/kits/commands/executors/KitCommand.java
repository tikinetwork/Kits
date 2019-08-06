package dev.foolen.kits.commands.executors;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import dev.foolen.kits.Kits;
import dev.foolen.kits.kits.Kit;
import dev.foolen.kits.utils.messages.Messages;

public class KitCommand implements CommandExecutor {

	private ArrayList<Kit> kits;
	private boolean kitFound;
	
	public KitCommand(Kits plugin) {
		kits = plugin.getKits();
		
		kitFound = false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// Check if player
		if (!(sender instanceof Player)) {
			Messages.info("Only a player can run this command!");
			return true;
		}
		
		Player player = (Player) sender;
		
		// Check if kit-name has been specified
		if (args.length == 0) {
			Messages.informPlayer(player, "Please specify a kit.");
			Messages.informPlayer(player, "Command usage: /kit [name]");
			return true;
		}
		
		// Loop over kits
		kits.forEach(kit -> {
			if (kit.getName().equalsIgnoreCase(args[0])) {
				kit.getItems().forEach((material, amount) -> {
					player.getInventory().addItem(new ItemStack(material, amount));
				});
				Messages.debug("Granted " + player.getName() + " the '" + kit.getName() + "' kit.");
				Messages.informPlayer(player, "You have been given the '" + kit.getName() + "' kit.");
				
				kitFound = true;
				return;
			}
		});
		
		// Check if kit found
		if (!kitFound) {
			Messages.informPlayer(player, "Specified kit does not exist.");
		}
		
		kitFound = false;
		return true;
	}
}
