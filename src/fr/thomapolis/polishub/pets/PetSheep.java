package fr.thomapolis.polishub.pets;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.api.IPet;
import fr.thomapolis.polishub.api.IPetEvolutive;
import fr.thomapolis.polishub.type.PetType;
import net.minecraft.server.v1_11_R1.Entity;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_11_R1.WorldServer;

public class PetSheep implements IPet, IPetEvolutive {

	private EntitySheep sheep;
	
	@Override
	public boolean baby() {
		
		return false;
	}

	@Override
	public String name(Player player) {
		
		return "§7Mouton de "+player.getName();
	}

	@Override
	public void spawn(Player player) {
		
		WorldServer worldServer = ((CraftWorld) player.getWorld()).getHandle();
		
		sheep = new EntitySheep(worldServer);
		sheep.setCustomName(name(player));
		sheep.setCustomNameVisible(true);
		sheep.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 0, 0);
		sheep.setAI(true);
		
		PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(sheep);
		
		for(Player active : PolisHub.getActiveCosmeticPlayer()) {
			
			((CraftPlayer) active).getHandle().playerConnection.sendPacket(packet);
			
		}
		
		PetType.Pets.put(player.getName(), sheep);
	}

	@Override
	public void followPlayer(Player player, Entity pet) {
		
		Location location = player.getLocation();
		
		EntitySheep petSheep = (EntitySheep) pet;
		
		Random rnd = new Random();
		int l = rnd.nextInt(6);
		
		switch(l) {
		
		case 0:
			location.add(1.5, 0, 1.5);
			break;
		
		case 1:
			location.add(0, 0, 1.5);
			break;
		
		case 2:
			location.add(1.5, 0, 0);
			break;
			
		case 3:
			location.subtract(1.5, 0, 1.5);
			break;
		
		case 4:
			location.subtract(0, 0, 1.5);
			break;
		
		case 5:
			location.subtract(1.5, 0, 0);
			break;
		}
		
		if(location.distanceSquared(petSheep.getBukkitEntity().getLocation()) > 100) {
			
			if(!player.isOnGround()) {
				
				return;
			}
			
			petSheep.getBukkitEntity().teleport(location);
		}
		else {
			
			petSheep.getNavigation().a(location.getX(), location.getY(), location.getZ(), 1.2);
		}
	}

}
