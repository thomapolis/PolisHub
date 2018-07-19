package fr.thomapolis.polishub.entities;

import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.World;

public class EntityCustomSheep extends EntitySheep {

	
	public EntityCustomSheep(World world) {
		super(world);
	}
	
	@Override
	public void g(float sideMot, float forMot) {
		
		this.setSilent(true);
		this.setAI(true);
		
		super.g(sideMot, forMot);
	}
}
