package fr.thomapolis.polishub.api;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;


public interface IPet {

	public String getName();
	
	public Creature getCraftPet();
	
	public Location getLocaction();
	
	public Player getOwner();
	
	public String getNameOfOwner();
	
	public UUID getOwnerUUID();
	
	public boolean setPetName(String name);
	
	public boolean teleportToOwner();
	
	public boolean teleport(Location to);
	
	public boolean isOwnerRiding();
	
	public void removeRider();
	
	public void removePet();
	
	public boolean isHat();
	
	public void setAsHat();
	
	public void spawn(Player player);
	public void followPlayer(Player player, Creature creature);	
}
