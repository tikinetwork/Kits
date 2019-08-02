package dev.foolen.kits.commands.kits;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
		ItemStack item = new ItemStack(Material.COOKED_BEEF);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Food");
		meta.setLore(Arrays.asList(ChatColor.GRAY + "Get a basic supply of food"));
		
		item.setItemMeta(meta);
		
		gui.setItem(0, item);
	}

}
