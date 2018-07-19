package fr.thomapolis.polishub.entities;

import java.lang.reflect.Field;
import java.util.List;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;

import net.minecraft.server.v1_11_R1.EntityHuman;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_11_R1.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_11_R1.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_11_R1.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_11_R1.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_11_R1.PathfinderGoalRandomStroll;
import net.minecraft.server.v1_11_R1.PathfinderGoalSelector;

public class EntityCustomSheep extends EntitySheep {

	
	public EntityCustomSheep(World world) {
		super(((CraftWorld)world).getHandle());
		
		List goalB = (List)getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
        List goalC = (List)getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
        List targetB = (List)getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
        List targetC = (List)getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
	
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
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
