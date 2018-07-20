package fr.thomapolis.polishub.api;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public interface IPetEntity {

	public Creature getBukkitEntity();
	
	public void remove();
	
	public void setTarget(LivingEntity entity);
	
	public LivingEntity getTarget();
	
	public IPet getPet();
}
