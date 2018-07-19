package fr.thomapolis.polishub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.pets.PetSheep;

public class CommandPet implements CommandExecutor {

	public CommandPet(PolisHub polisHub) {
		// XXX Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			PetSheep pet = new PetSheep(player);
			pet.spawn(player);
			
		}
		
		return false;
	}

}
