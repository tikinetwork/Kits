package dev.foolen.kits.kits;

import java.util.HashMap;

import org.bukkit.Material;

public class Kit {

	private String name;
	private String description;
	private HashMap<Material, Integer> items;
	
	public Kit(String name, String description) {
		this.name = name;
		this.description = description;
		items = new HashMap<Material, Integer>();
	}
	
	public void addItem(Material material, int amount) {
		items.put(material, amount);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public HashMap<Material, Integer> getItems() {
		return items;
	}
	
}
