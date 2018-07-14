package fr.thomapolis.polishub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;

public class CommandMoney implements CommandExecutor {

	public PolisHub polisHub;
	
	public CommandMoney(PolisHub polisHub) {
		
		this.polisHub = polisHub;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			PolisPlayer polisPlayer = polisHub.getAPI().getPolisPlayer(player);
			
			player.sendMessage(PolisHub.getPrefix()+"Vous avez "+polisPlayer.getMoney()+" PolisCoins");
			
		}
		
		return false;
	}

}
