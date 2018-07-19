package fr.thomapolis.polishub.entities;

import java.lang.reflect.Field;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import net.minecraft.server.v1_11_R1.EntityLiving;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.Navigation;

public class EntityCustomSheep extends EntitySheep {

	private Player owner;
	
	public EntityCustomSheep(World world, Player player) {
		super(((CraftWorld)world).getHandle());
		
	}
	
	@Override
	public void g(float sideMot, float forMot) {
		
		this.setGoalTarget((EntityLiving)getOwner(), TargetReason.CUSTOM, true);
		
		this.setCustomName("§7Mouton de "+getOwner().getName());
		this.setSilent(true);
		this.setAI(true);
		float speed = 0.2F;
		this.l(speed);
		
		this.getNavigation().a(getOwner().getLocation().getX(), getOwner().getLocation().getY(), getOwner().getLocation().getZ(), 1.2);
		
		
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
    
    public static Object getPrivateField(String fieldName, Class clazz, Object object)
    {
        Field field;
        Object o = null;

        try
        {
            field = clazz.getDeclaredField(fieldName);

            field.setAccessible(true);

            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return o;
    }
    
    public Player getOwner() {
    	
    	return this.owner;
    }
    
    public void setPath() {
    	
    	try {
    		//this.gets
    		getPathNavigation().b(true);
    		
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    }
    
    public Navigation getPathNavigation() {
    	
    	return (Navigation) this.getNavigation();
    }
}
