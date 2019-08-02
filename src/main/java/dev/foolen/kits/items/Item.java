package dev.foolen.kits.items;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
	
	private ItemStack item;
	
	public Item(Material material, String name, String description) {
		item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(Color.RED + "" + ChatColor.BOLD + name);
		meta.setLore(Arrays.asList(Color.GRAY + description));
		
		item.setItemMeta(meta);
	}
	
	public ItemStack getItemStack() {
		return item;
	}
	
}
