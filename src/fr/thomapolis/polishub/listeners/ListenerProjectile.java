package fr.thomapolis.polishub.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.gadgets.Gadget;

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
							
							Gadget gadget = polishub.getGadgetType().getGadget(item);
							
							if(gadget.hasProjectile()) {
								
								gadget.getProjectile().setup(event.getEntity());
							}
							
						}
						
					}
					
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		
		Location loc = event.getHitBlock().getLocation();
		
		if(polishub.getProjectileType().isProjectile(event.getEntity())) {
			
			polishub.getProjectileType().getProjectileGadet(event.getEntity()).getEffect(loc, polishub);
			
		}
		
	}

}
