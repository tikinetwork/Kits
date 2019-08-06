package dev.foolen.kits;

import java.util.ArrayList;

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
			String name = kitName.substring(0, 1).toUpperCase() + kitName.substring(1);
		    String description = config.getString("kits." + kitName + ".description");
		    Material thumbnail_item = Material.matchMaterial(config.getString("kits." + kitName + ".thumbnail_item"));
		    String command = config.getString("kits." + kitName + ".command");
			
			// Create kit
			Kit kit = new Kit(name, description, thumbnail_item, command);
			
			Messages.debug("--");
			Messages.debug("name: " + kitName);
			Messages.debug("description: " + description);
			Messages.debug("thumbnail_item: " + thumbnail_item);
			Messages.debug("command: " + command);
			
		    // Add kit to list of kits
		    kits.add(kit);
		}
		
		Messages.debug("Import completed!");
	}
	
	public ArrayList<Kit> getKits() {
		return kits;
	}
}
