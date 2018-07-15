package fr.thomapolis.polishub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import fr.thomapolis.polishub.PolisHub;

public class ListenerProjectile implements Listener {

	public PolisHub polishub;
	
	public ListenerProjectile(PolisHub polisHub) {
		
		this.polishub = polisHub;
		
	}
	
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent event) {
		
		if(event.getEntity().getShooter() instanceof Player) {
			
			Player player = (Player) event.getEntity().getShooter();
			
			if(polishub.getProjectileType().isProjectile(event.getEntity())) {
				
				if(player.getInventory().getItemInMainHand() != null
					&& player.getInventory().getItemInMainHand().getType() != null) {
					
					ItemStack item = player.getInventory().getItemInMainHand();
					
					if(item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
						
						if(polishub.getGadgetType().isGadget(item)) {
							
							if()
							
						}
						
					}
					
					
				}
				
			}
			
		}
		
	}

}
