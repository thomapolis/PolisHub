package fr.thomapolis.polishub.pets;

import java.util.UUID;

import org.bukkit.entity.Player;

import fr.thomapolis.polishub.api.IPet;

public abstract class Pet implements IPet{

	public Player owner;
	
	public Pet(Player owner) {
		
		this.owner = owner;
	}
	
	@Override
	public Player getOwner() {
		
		return this.owner;
	}
	
	@Override
	public String getNameOfOwner() {
		
		return getOwner().getName();
	}
	
	@Override
	public UUID getOwnerUUID() {
		
		return getOwner().getUniqueId();
	}
	
	
	
}
