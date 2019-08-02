package dev.foolen.kits.utils.messages;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messages {
	
	private static final String CONSOLE_PREFIX = "[Kits]";
	private static final String PREFIX = ChatColor.RED + "[Kits]";
	private static final String SUFFIX = ChatColor.GRAY + " ";
	
	private static boolean debug = false;
	
	// Player messages
	public static void informPlayer(Player player, String message) {
		player.sendMessage(PREFIX + SUFFIX + message);
	}

	// Console messages
	public static void info(String message) {
		System.out.println(CONSOLE_PREFIX + "[Info] " + message);
	}
	
	public static void warning(String message) {
		System.out.println(CONSOLE_PREFIX + "[Warning] " + message);
	}
	
	public static void error(String message) {
		System.out.println(CONSOLE_PREFIX + "[Error] " + message);
	}
	
	// Debug
	public static void debug(boolean enable) {
		debug = enable;
	}
	
	public static void debug(String message) {
		if (debug) {
			System.out.println(CONSOLE_PREFIX + "[Debug] " + message);
		}
	}
	
}
