package dev.foolen.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import dev.foolen.kits.commands.CommandHandler;
import dev.foolen.kits.events.EventHandler;
import dev.foolen.kits.kits.Kit;
import dev.foolen.kits.utils.messages.Messages;

public class Kits extends JavaPlugin {
	
	private ArrayList<Kit> kits;
	public static FileConfiguration config;
	
	@Override
	public void onEnable() {
		// Load configurations
		saveDefaultConfig();
		config = getConfig();
		
		// Enable debugs
		Messages.debug(config.getBoolean("debug"));
		
		// Import kits from configuration file
		importKits();
		
		// Load modules
		new CommandHandler(this);
		new EventHandler(this);
	}
	
	private void importKits() {
		Messages.debug("importing kits...");
		
		kits = new ArrayList<Kit>();
		
		for(String kitName : config.getConfigurationSection("kits").getKeys(false)) {
			String name = kitName.substring(0, 1).toUpperCase() + kitName.substring(1);
		    String description = config.getString("kits." + kitName + ".description");
		    Material thumbnail_item = Material.matchMaterial(config.getString("kits." + kitName + ".thumbnail_item"));
			
			// Create kit
			Kit kit = new Kit(name, description, thumbnail_item);
			
			Messages.debug("--");
			Messages.debug("name: " + kitName);
			Messages.debug("description: " + description);
			Messages.debug("thumbnail_item: " + thumbnail_item);
			Messages.debug("items: ");
			
			// Add items
			List<String> items  = config.getStringList("kits." + kitName + ".items");
		    items.forEach(itemStr -> {
		    	String[] splittedItemStr = itemStr.split(" ");
		    	Material item = Material.matchMaterial(splittedItemStr[0].toUpperCase());
		    	int amount = Integer.parseInt(splittedItemStr[1]);
		    	
		    	if (item != null && amount > 0) {
		    		kit.addItem(item, amount);
		    		Messages.debug("- " + splittedItemStr[0] + " (" + amount + ")");
		    	}
		    });
			
		    // Add kit to list of kits
		    kits.add(kit);
		}
		
		Messages.debug("Import completed!");
	}
	
	public ArrayList<Kit> getKits() {
		return kits;
	}
}
