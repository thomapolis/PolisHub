package fr.thomapolis.polishub.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class ListenerPlayer implements Listener {

	public PolisHub polisHub;
	
	public ListenerPlayer(PolisHub polisHub) {
		this.polisHub = polisHub;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		PolisPlayer polisPlayer = polisHub.getAPI().getPolisPlayer(player);
		
		TextComponent tc = new TextComponent();
		tc.setText(polisPlayer.getCosmeticRank().getSymbole());
		tc.setColor(net.md_5.bungee.api.ChatColor.valueOf(polisPlayer.getCosmeticRank().getColor().name()));
		tc.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ComponentBuilder(ChatColor.DARK_AQUA+"Le joueur possède le grade "+polisPlayer.getCosmeticRank().getName()).create()));

		
		String name = polisPlayer.getRank().getPrefix()+tc+" "+polisPlayer.getRank().getColorName()+player.getName();
		
		event.setJoinMessage(polisHub.getPrefix()+name+ChatColor.GOLD+" a rejoint le hub !");
		player.setDisplayName(name);
		player.setPlayerListName(name);
	}

}
