package fr.thomapolis.polishub.nms.register;

import java.lang.reflect.Field;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.entities.EntityCustomSheep;
import fr.thomapolis.polishub.type.PetType;
import net.minecraft.server.v1_11_R1.Entity;
import net.minecraft.server.v1_11_R1.EntityLiving;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.EntityTypes;
import net.minecraft.server.v1_11_R1.MinecraftKey;
import net.minecraft.server.v1_11_R1.PacketPlayOutSpawnEntityLiving;

public enum RegisterCustomEntity {

	SHEEP("Sheep", 91, EntitySheep.class, EntityCustomSheep.class);
	
	private String name;
    private int id;
    private Class<? extends Entity> nmsClass;
    private Class<? extends Entity> customClass;
    private MinecraftKey key;
    private MinecraftKey oldKey;

    private RegisterCustomEntity(String name, int id, Class<? extends Entity> nmsClass, Class<? extends Entity> customClass) {
        this.name = name;
        this.id = id;
        this.nmsClass = nmsClass;
        this.customClass = customClass;
        this.key = new MinecraftKey(name);
        this.oldKey = EntityTypes.b.b(nmsClass);
        
        //addToMaps(customClass, name, id);
    }

    public static void registerEntities() { for (RegisterCustomEntity ce : RegisterCustomEntity.values()) ce.register(); }
    public static void unregisterEntities() { for (RegisterCustomEntity ce : RegisterCustomEntity.values()) ce.unregister(); }

    private void register() {
        EntityTypes.d.add(key);
        EntityTypes.b.a(id, key, customClass);
    }

    private void unregister() {
        EntityTypes.d.remove(key);
        EntityTypes.b.a(id, oldKey, nmsClass);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public Class<?> getCustomClass() {
        return customClass;
    }
	
    public static Object getPrivateField(String fieldName, Class clazz, Object object) {
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
    
    public static void spawnEntity(EntityLiving entity, Location loc, Player player) {
    	
    	PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(entity);
    	
    	for(Player active : PolisHub.getActiveCosmeticPlayer()) {
			
    		entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
			((CraftPlayer) active).getHandle().playerConnection.sendPacket(packet);
			
		}
		
		PetType.Pets.put(player.getName(), entity.getBukkitEntity());
    }
    
    private static void addToMaps(Class clazz, String name, int id) {
        //getPrivateField is the method from above.
        //Remove the lines with // in front of them if you want to override default entities (You'd have to remove the default entity from the map first though).
        //((Map)getPrivateField("c", net.minecraft.server.v1_11_R1.EntityTypes.class, null)).put(name, c);
        //((Map)getPrivateField("d", net.minecraft.server.v1_11_R1.EntityTypes.class, null)).put(clazz, name);
        //((Map)getPrivateField("e", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(Integer.valueOf(id), clazz);
        //((Map)getPrivateField("f", net.minecraft.server.v1_11_R1.EntityTypes.class, null)).put(clazz, Integer.valueOf(id));
        //((Map)getPrivateField("g", net.minecraft.server.v1_7_R4.EntityTypes.class, null)).put(name, Integer.valueOf(id));
    }
    
}
