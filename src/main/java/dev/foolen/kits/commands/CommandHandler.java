package dev.foolen.kits.commands;

import dev.foolen.kits.Kits;
import dev.foolen.kits.commands.kits.KitsCommand;

public class CommandHandler {
	
	public CommandHandler(Kits plugin) {
		
		// Set executors
		plugin.getCommand("kits").setExecutor(new KitsCommand(plugin));
	}
}
