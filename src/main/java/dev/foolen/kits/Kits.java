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
		// Load configuration
		getConfig().options().copyDefaults(true);
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
		    
			// Create kit
			Kit kit = new Kit(kitName, config.getString("kits." + kitName + ".description"));
			
			Messages.debug("kitName: " + kitName);
			Messages.debug("items: ");
			
			// Add items
			List<String> items  = config.getStringList("kits." + kitName + ".items");
		    items.forEach(itemStr -> {
		    	String[] splittedItemStr = itemStr.split(" ");
		    	Material item = Material.matchMaterial(splittedItemStr[0]);
		    	int amount = Integer.parseInt(splittedItemStr[1]);
		    	
		    	if (item != null && amount > 0) {
		    		kit.addItem(item, amount);
		    		Messages.debug("- " + splittedItemStr[0]);
		    	}
		    });
			
		    // Add kit to list of kits
		    kits.add(kit);
		}
		
		Messages.debug("Import completed!");
	}
}
