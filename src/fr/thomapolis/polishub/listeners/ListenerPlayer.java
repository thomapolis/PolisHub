package fr.thomapolis.polishub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.entities.EntityCustomSheep;
import fr.thomapolis.polishub.itemseffect.IECosmetics;
import fr.thomapolis.polishub.itemseffect.ItemEffect;
import fr.thomapolis.polishub.pets.PetSheep;
import fr.thomapolis.polishub.type.PetType;

public class ListenerPlayer implements Listener {

	public PolisHub polisHub;
	
	public ListenerPlayer(PolisHub polisHub) {
		this.polisHub = polisHub;
	}
	
	@EventHandler (priority = EventPriority.LOW)
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(PolisHub.getAPI().getSQL().hasAccount(player)) {
			
			PolisPlayer polisPlayer = PolisHub.getAPI().getPolisPlayer(player);
			String name = polisPlayer.getRank().getPrefix()+polisPlayer.getCosmeticRank().getPrefix()+" "+polisPlayer.getRank().getColorName()+player.getName();
			
			//ItemsHub
			IECosmetics ieC = new IECosmetics();
			
			
			event.setJoinMessage(PolisHub.getPrefix()+name+ChatColor.GOLD+" a rejoint le hub !");
			player.setDisplayName(name);
			player.setPlayerListName(name);
			
			//Set inv
			player.getInventory().setItem(8, ieC.getItem());
			
		}
		
		
		
		
	}

	@EventHandler (priority = EventPriority.HIGH)
	public void onClickInventory(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		
		if(event.getInventory() == null) {
			return;
		}
		
		if(event.getCurrentItem() != null && event.getCurrentItem().getType() != null) {
			
			if(!event.getCurrentItem().hasItemMeta()) {
				return;
			}
			if(!event.getCurrentItem().getItemMeta().hasDisplayName()) {
				return;
			}
			
			if(polisHub.getItemEffectType().isItemEffect(event.getCurrentItem())) {
				
				ItemEffect itemEffect = polisHub.getItemEffectType().getItemEffect(event.getCurrentItem());
				itemEffect.onClickInventory(player);
				
				event.setCancelled(true);
			}
			
			if(event.getInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA+""+ChatColor.BOLD+"Gadgets")) {
				
				if(polisHub.getGadgetType().isGadget(event.getCurrentItem())) {
					
					if(!polisHub.getGadgetType().getGadget(event.getCurrentItem()).isLock(PolisHub.getAPI().getPolisPlayer(player))) {
						
						polisHub.getGadgetType().getGadget(event.getCurrentItem()).give(player);
					}
				}
			}
			
		}
		
		if(event.getInventory().getType() == InventoryType.CHEST
			|| event.getInventory().getType() == InventoryType.PLAYER
			|| event.getInventory().getType() == InventoryType.CREATIVE) {
			
			PolisPlayer polisPlayer = PolisHub.getAPI().getPolisPlayer(player);
			if(polisPlayer.getRank().getPerms().contains("hub.inventory")) {
				
				if(!player.getGameMode().equals(GameMode.CREATIVE)) {
					
					event.setCancelled(true);
				}
			} else {event.setCancelled(true);}
		}
		
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(event.getItem() != null && event.getItem().getType() != null) {
				
				if(!event.getItem().hasItemMeta()) {
					
					return;
				}
				
				if(!event.getItem().getItemMeta().hasDisplayName()) {
					
					return;
				}
				
				if(polisHub.getItemEffectType().isItemEffect(event.getItem())) {
					
					ItemEffect itemEffect = polisHub.getItemEffectType().getItemEffect(event.getItem());
					itemEffect.onInteract(event.getPlayer());
					
					event.setCancelled(true);
				}
				
				if(polisHub.getGadgetType().isGadget(event.getItem())) {
					
					polisHub.getGadgetType().useGadget(event.getItem(), event.getPlayer());
					
				}
			}
			
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		
		if(PetType.Pets.containsKey(event.getPlayer().getName())) {
			
			Entity pet = PetType.Pets.get(event.getPlayer().getName());
			PetSheep sheep = new PetSheep((EntityCustomSheep) pet);
			sheep.followPlayer(event.getPlayer(), pet);
			
		}
		
	}
}
