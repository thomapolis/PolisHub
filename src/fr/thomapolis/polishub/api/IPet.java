package fr.thomapolis.polishub.api;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


public interface IPet {

	public String name(Player player);
	
	public void spawn(Player player);
	public void followPlayer(Player player, Entity pet);	
}
