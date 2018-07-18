package fr.thomapolis.polishub.pets;

import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.api.IPet;
import fr.thomapolis.polishub.api.IPetEvolutive;
import fr.thomapolis.polishub.type.PetType;
import net.minecraft.server.v1_11_R1.EntitySheep;
import net.minecraft.server.v1_11_R1.PacketPlayOutSpawnEntity;
import net.minecraft.server.v1_11_R1.WorldServer;

public class PetSheep implements IPet, IPetEvolutive {

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
		
		EntitySheep sheep = new EntitySheep(worldServer);
		sheep.setCustomName(name(player));
		sheep.setCustomNameVisible(true);
		sheep.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 0, 0);
		
		PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity(sheep, 1);
		
		for(Player active : PolisHub.getActiveCosmeticPlayer()) {
			
			((CraftPlayer) active).getHandle().playerConnection.sendPacket(packet);
			
		}
		
		PetType.Pets.put(player.getName(), sheep.getBukkitEntity());
	}

	@Override
	public void followPlayer(Player player) {
		// XXX Auto-generated method stub
		
	}

}
