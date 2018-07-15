package fr.thomapolis.polishub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

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
			
			
			
		}
		
	}

}
