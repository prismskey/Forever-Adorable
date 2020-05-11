package me.prismskey.foreveradorable.foreveradorable.listeners;

import me.prismskey.foreveradorable.foreveradorable.ForeverAdorable;
import me.prismskey.foreveradorable.foreveradorable.events.PlayerUseNameTagEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

	public PlayerInteractListener() {
		Bukkit.getServer().getPluginManager().registerEvents(this, ForeverAdorable.instance);
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent event) {
		ItemStack heldItem = event.getPlayer().getInventory().getItemInMainHand();
		if(heldItem.getType() == Material.NAME_TAG) {
			PlayerUseNameTagEvent nameTagEvent = new PlayerUseNameTagEvent(event.getPlayer(), event.getRightClicked(), heldItem);
			Bukkit.getPluginManager().callEvent(nameTagEvent);
		}
	}
}
