package me.prismskey.foreveradorable.foreveradorable;

import me.prismskey.foreveradorable.foreveradorable.commands.ForeverAdorableCommand;
import me.prismskey.foreveradorable.foreveradorable.listeners.PlayerInteractListener;
import me.prismskey.foreveradorable.foreveradorable.listeners.PlayerUseNameTagListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class ForeverAdorable extends JavaPlugin {

	public static ForeverAdorable instance;
	public static final String MESSAGE_PREFIX = ChatColor.translateAlternateColorCodes('&', "&e[&6Forever &dAdorable&e]&f ");

	@Override
	public void onEnable() {
		instance = this;
		registerEventListeners();
		registerCommands();
	}

	private void registerEventListeners() {
		new PlayerInteractListener();
		new PlayerUseNameTagListener();
	}

	private void registerCommands() {
		try {
			final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

			bukkitCommandMap.setAccessible(true);
			CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

			commandMap.register("foreveradorable", new ForeverAdorableCommand("foreveradorable"));
		} catch(NoSuchFieldException | IllegalAccessException e) {
			getLogger().severe(MESSAGE_PREFIX + ChatColor.RED + "Error registering commands.");
			e.printStackTrace();
		}
	}

}
