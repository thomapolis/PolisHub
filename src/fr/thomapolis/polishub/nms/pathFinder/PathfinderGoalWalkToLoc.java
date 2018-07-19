package fr.thomapolis.polishub.nms.pathFinder;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import net.minecraft.server.v1_11_R1.EntityInsentient;
import net.minecraft.server.v1_11_R1.PathEntity;
import net.minecraft.server.v1_11_R1.PathfinderGoal;

public class PathfinderGoalWalkToLoc extends PathfinderGoal {
	
	  private EntityInsentient creature;
	  private PathEntity path;
	  private UUID p;

	  public PathfinderGoalWalkToLoc(EntityInsentient creature, UUID p) {
		  
		 this.creature = creature;
		 this.p = p;
	  
	  }
	  
	  @Override
	  public boolean a() {
		  
		  if(Bukkit.getPlayer(p) == null) {
			  
			  return path != null;
		  }
		  
		  Location targetLocation = Bukkit.getPlayer(p).getLocation();
		  
		  boolean flag = this.creature.getNavigation().i();
		  
		  
		  return this.path != null;
		  
	  }
}