package fr.thomapolis.polishub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.itemseffect.ItemEffect;

public class ListenerPlayer implements Listener {

	public PolisHub polisHub;
	
	public ListenerPlayer(PolisHub polisHub) {
		this.polisHub = polisHub;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		PolisPlayer polisPlayer = polisHub.getAPI().getPolisPlayer(player);
		
		String name = polisPlayer.getRank().getPrefix()+polisPlayer.getCosmeticRank().getPrefix()+" "+polisPlayer.getRank().getColorName()+player.getName();
		
		event.setJoinMessage(polisHub.getPrefix()+name+ChatColor.GOLD+" a rejoint le hub !");
		player.setDisplayName(name);
		player.setPlayerListName(name);
		
		
	}

	@EventHandler
	public void onClickInventory(InventoryClickEvent event) {
		
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(event.getItem() != null && event.getItem().getType() != null) {
				
				if(polisHub.getItemEffectType().isItemEffect(event.getItem())) {
					
					ItemEffect itemEffect = polisHub.getItemEffectType().getItemEffect(event.getItem());
					itemEffect.onInteract(event.getPlayer());
					
				}
				
			}
			
		}
	}
	
}
