package me.prismskey.foreveradorable.foreveradorable.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerUseNameTagEvent extends Event implements Cancellable {
	private static final HandlerList HANDLERS = new HandlerList();
	private boolean isCancelled;

	private Player player;
	private Entity target;
	private ItemStack nameTag;


	public PlayerUseNameTagEvent(Player player, Entity target, ItemStack nameTag) {
		this.player = player;
		this.target = target;
		this.nameTag = nameTag;
		this.isCancelled = false;
	}

	public HandlerList getHandlers() {
		return HANDLERS;
	}

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	public Player getPlayer() {
		return player;
	}

	public Entity getTarget() {
		return target;
	}

	public ItemStack getNameTag() {
		return nameTag;
	}

	@Override
	public boolean isCancelled() {
		return this.isCancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.isCancelled = cancelled;
	}
}
