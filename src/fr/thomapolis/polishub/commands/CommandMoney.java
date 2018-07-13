package fr.thomapolis.polishub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;

public class CommandMoney implements CommandExecutor {

	
	
	public CommandMoney(PolisHub polisHub) {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
		}
		
		return false;
	}

}
