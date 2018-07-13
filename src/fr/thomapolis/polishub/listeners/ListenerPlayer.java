package fr.thomapolis.polishub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;

public class ListenerPlayer implements Listener {

	public PolisHub polisHub;
	
	public ListenerPlayer(PolisHub polisHub) {
		this.polisHub = polisHub;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		PolisPlayer polisPlayer = polisHub.getAPI().getPolisPlayer(player);
		
	}

}
