package fr.thomapolis.polishub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;

public class CommandPet implements CommandExecutor {

	public CommandPet(PolisHub polisHub) {
		// XXX Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			for(Player p : PolisHub.getActiveCosmeticPlayer()) {
				
				p.sendMessage("test");
			}
			
		}
		
		return false;
	}

}
