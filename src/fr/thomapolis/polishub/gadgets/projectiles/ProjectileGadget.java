package fr.thomapolis.polishub.gadgets.projectiles;

import org.bukkit.entity.Projectile;

import fr.thomapolis.polishub.gadgets.Gadget;

public abstract class ProjectileGadget {

	public abstract String getName();
	
	public abstract Gadget getGadget();
	
	
	public void setup(Projectile entity) {
		
		entity.setCustomName(getName());
		
	}
}
