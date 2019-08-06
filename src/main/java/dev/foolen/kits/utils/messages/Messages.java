package dev.foolen.kits.utils.messages;

import dev.foolen.kits.Kits;

public class Messages {
	
	private static final String CONSOLE_PREFIX = Kits.config.getString("consoleprefix");
	
	private static boolean debug = false;

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
