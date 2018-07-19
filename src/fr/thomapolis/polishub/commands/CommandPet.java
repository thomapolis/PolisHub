package fr.thomapolis.polishub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.entities.EntityCustomSheep;
import fr.thomapolis.polishub.nms.register.RegisterCustomEntity;

public class CommandPet implements CommandExecutor {

	public CommandPet(PolisHub polisHub) {
		// XXX Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			RegisterCustomEntity.spawnEntity(new EntityCustomSheep(player.getWorld(), player), player.getLocation(), player);
			
		}
		
		return false;
	}

}
