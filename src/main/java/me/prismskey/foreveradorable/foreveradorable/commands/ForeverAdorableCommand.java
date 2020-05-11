package me.prismskey.foreveradorable.foreveradorable.commands;

import me.prismskey.foreveradorable.foreveradorable.ForeverAdorable;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.Arrays;
import java.util.List;

public class ForeverAdorableCommand extends BukkitCommand {
	public ForeverAdorableCommand(String name) {
		super(name);
		this.description = "Provides information about the ForeverAdorable plugin.";
		this.usageMessage = "/foreveradorable";

		List<String> aliases = Arrays.asList(new String[] {"fa"});
		this.setAliases(aliases);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if(args.length < 1) {
			sender.sendMessage(ForeverAdorable.MESSAGE_PREFIX + ChatColor.translateAlternateColorCodes('&', "&eAbout:"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&eDeveloped by &9prismskey &eaka &9keys9&e."));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Usage: &6/fa help"));
		} else if(args[0].equalsIgnoreCase("help")){
			sender.sendMessage(ForeverAdorable.MESSAGE_PREFIX + ChatColor.YELLOW + "Help:");
			sender.sendMessage(ChatColor.YELLOW + "To force a mob to stop aging as a baby simply use a name tag on it with the word baby somewhere in the name.");
		} else {
			sender.sendMessage(ForeverAdorable.MESSAGE_PREFIX + ChatColor.translateAlternateColorCodes('&',   "&7Usage: &6/fa help"));
			return false;
		}
		return true;
	}
}
