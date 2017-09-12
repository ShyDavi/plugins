
package net.eduard.api.tutorial.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import net.eduard.api.API;
import net.eduard.api.manager.TimeManager;

public class EventosInventario extends TimeManager {

	@EventHandler
	public void InventoryCraft(CraftItemEvent e) {
		API.broadcast(e.getEventName());
	}
	@EventHandler
	public void InventoryAbre(InventoryOpenEvent e) {

	}

	@EventHandler
	public void InventoryArrasta(InventoryDragEvent e) {

	}

	@EventHandler
	public void InventoryClica(InventoryClickEvent e) {

	}

	@EventHandler
	public void InventoryConsomeItem(PlayerItemConsumeEvent e) {

	}

	@EventHandler
	public void InventoryCreativo(InventoryCreativeEvent e) {

	}

	@EventHandler
	public void InventoryFecha(InventoryCloseEvent e) {

	}

	@EventHandler
	public void InventoryMecherHotBar(InventoryEvent e) {

	}

	@EventHandler
	public void InventoryMoveItem(InventoryMoveItemEvent e) {

	}

	@EventHandler
	public void InventoryMoveItem(PlayerPickupItemEvent e) {

	}

	@EventHandler
	public void InventoryPegaItem(InventoryPickupItemEvent e) {

	}

	@EventHandler
	public void InventoryQuebraItem(PlayerItemBreakEvent e) {

	}

}
