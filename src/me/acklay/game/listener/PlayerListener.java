package me.acklay.game.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@SuppressWarnings("unused")
public class PlayerListener implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage("");
		GameMode(p, GameMode.SURVIVAL);
		p.setLevel(0);
		p.setExp(0F);
		p.setHealth(20D);
		p.setFireTicks(0);
		p.setFoodLevel(23);
		ItemGeber(p);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		e.setQuitMessage("");
	}

	@EventHandler
	public void onMessage(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String msg = e.getMessage();	
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		p.setItemInHand(new ItemStack(Material.GOLD_BLOCK));
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		//Level für BlockPlace
		int i = 0;
		i++;
		p.setLevel(i);
		//Block wechseln
		Block b = e.getBlock();
		 
		int v = rand(1, 6);
		switch (v) {
		case 1:
			b.setType(Material.WATER);
			break;
		case 2:
			b.setType(Material.DIRT);
			break;
		case 3:
			b.setType(Material.GRAVEL);
			break;
		case 4:
			b.setType(Material.STONE);
			break;
		default:
			b.setType(Material.GRASS);
			break;
		}
		//b.setType(Material.);
		p.setItemInHand(new ItemStack(Material.GOLD_BLOCK));
	}
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		e.setCancelled(true);
	}
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		e.setCancelled(true);
	}
	
	
	@EventHandler
	public void onInvMove(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onDamageEntity(EntityDamageByEntityEvent e){
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onDamge(EntityDamageEvent e){
			e.setCancelled(true);
	}
	
	@EventHandler
	public void onFlame(BlockIgniteEvent e){
		e.setCancelled(true);
	}
	
	private void ItemGeber(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, new ItemStack(Material.GOLD_BLOCK));
	}
	
	private void GameMode(HumanEntity h, GameMode mode) {
		h.setGameMode(mode);
	}

	public int rand(int min, int max) {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}
