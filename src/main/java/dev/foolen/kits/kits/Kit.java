package dev.foolen.kits.kits;

import org.bukkit.Material;

public class Kit {

	private String name;
	private String description;
	private Material thumbnail_item;
	private String command;
	
	public Kit(String name, String description, Material thumbnail_item, String command) {
		this.name = name;
		this.description = description;
		this.thumbnail_item = thumbnail_item;
		this.command = command;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Material getThumbnailItem() {
		return thumbnail_item;
	}
	
	public String getCommand() {
		return command;
	}
	
}
