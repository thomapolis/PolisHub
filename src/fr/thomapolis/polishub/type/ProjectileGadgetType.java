package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Projectile;

import fr.thomapolis.polishub.gadgets.projectiles.PGPaintBall;
import fr.thomapolis.polishub.gadgets.projectiles.ProjectileGadget;

public class ProjectileGadgetType {

	public List<ProjectileGadget> projectiles = new ArrayList<>();
	
	public ProjectileGadgetType() {
		
		register();
		
	}
	
	public void register() {
		
		this.projectiles.add(new PGPaintBall());
		
	}
	
	public boolean isProjectile(Projectile entity) {
		
		for(ProjectileGadget pG : projectiles) {
			
			if(pG.getName().equals(entity.getName())) {
				
				return true;
			}
			
		}
		
		return false;
	}
	
	public ProjectileGadget getProjectileGadet(Projectile entity) {
		
		for(ProjectileGadget pG : projectiles) {
			
			if(pG.getName().equals(entity.getName())) {
				
				return pG;
			}
		}
		
		return null;
		
	}
	
}
