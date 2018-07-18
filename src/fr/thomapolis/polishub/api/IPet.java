package fr.thomapolis.polishub.api;

import org.bukkit.entity.Player;

import net.minecraft.server.v1_11_R1.Entity;

public interface IPet {

	public String name(Player player);
	
	public void spawn(Player player);
	public void followPlayer(Player player, Entity pet);	
}
