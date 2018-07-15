package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.List;

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
	
}
