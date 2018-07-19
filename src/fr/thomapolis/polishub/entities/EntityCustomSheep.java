package fr.thomapolis.polishub.entities;

import java.lang.reflect.Field;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import net.minecraft.server.v1_11_R1.EntityPlayer;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.NBTTagCompound;

public class EntityCustomSheep extends EntitySheep {

	
	public EntityCustomSheep(World world, Player player) {
		super(((CraftWorld)world).getHandle());

        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        this.setGoalTarget(entityPlayer, TargetReason.CUSTOM, true);
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
}
