package me.prismskey.foreveradorable.foreveradorable.listeners;

import me.prismskey.foreveradorable.foreveradorable.ForeverAdorable;
import me.prismskey.foreveradorable.foreveradorable.events.PlayerUseNameTagEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerUseNameTagListener implements Listener {

	public PlayerUseNameTagListener() {
		Bukkit.getServer().getPluginManager().registerEvents(this, ForeverAdorable.instance);
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerUseNameTag(PlayerUseNameTagEvent event) {
		if(!event.getPlayer().hasPermission("foreveradorable.use")) {
			return;
		}

boolean isGrowUpTag = event.getNameTag().getItemMeta().getDisplayName().toLowerCase().contains("grow up");

if(!isGrowUpTag && !ageable.isAdult()) {
  ageable.setAgeLock(true);
  event.getPlayer().sendMessage(ForeverAdorable.MESSAGE_PREFIX + ChatColor.YELLOW + "Target Animal will remain a baby until name is changed.");

} else if(isGrowUpTag && ageable.getAgeLock()) {
  ageable.setAgeLock(false);
  event.getPlayer().sendMessage(ForeverAdorable.MESSAGE_PREFIX + ChatColor.YELLOW + "Target Animal will now age as normal.");
}
