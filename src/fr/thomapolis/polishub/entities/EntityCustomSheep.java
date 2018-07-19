package fr.thomapolis.polishub.entities;

import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.World;

public class EntityCustomSheep extends EntitySheep {

	
	public EntityCustomSheep(World world) {
		super(world);
	}
	
	@Override
	public void g(float sideMot, float forMot) {
		
		this.setSilent(true);
		this.setAI(true);
		float speed = 0.2F;
		this.l(speed);
		
		super.g(sideMot, forMot);
	}
	
	public void f(double x, double y, double z) {}
	
	public void a(NBTTagCompound nbttagcompound) {
    }

    public void b(NBTTagCompound nbttagcompound) {
    }

    public boolean c(NBTTagCompound nbttagcompound) {
        return false;
    }

    public boolean d(NBTTagCompound nbttagcompound) {
        return false;
    }

    public NBTTagCompound e(NBTTagCompound nbttagcompound) {
        return nbttagcompound;
    }
}
