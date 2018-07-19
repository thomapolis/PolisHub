package fr.thomapolis.polishub.nms.register;

import fr.thomapolis.polishub.entities.EntityCustomSheep;
import net.minecraft.server.v1_11_R1.Entity;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.EntityTypes;
import net.minecraft.server.v1_11_R1.MinecraftKey;

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
	
}
