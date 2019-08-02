package dev.foolen.kits;

import org.bukkit.plugin.java.JavaPlugin;

import dev.foolen.kits.commands.CommandHandler;
import dev.foolen.kits.utils.messages.Messages;

public class Kits extends JavaPlugin {
	
	@Override
	public void onEnable() {
		// Enable debug
		Messages.debug(true);
		
		// Load modules
		new Messages();
		new CommandHandler(this);
	}
}
