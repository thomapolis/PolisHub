package fr.thomapolis.polishub.gadgets.projectiles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.gadgets.Gadget;
import fr.thomapolis.polishub.gadgets.GadgetPaintBallGun;

public class PGPaintBall extends ProjectileGadget {

	@Override
	public String getName() {

		return ChatColor.BLUE+"PGPaintBall";
	}

	@Override
	public Gadget getGadget() {
		
		return new GadgetPaintBallGun();
	}

	@Override
	public void getEffect(Location location, PolisHub polishub) {
		
		if(location.getBlock().getType() != null) {
			
			Material type = location.getBlock().getType();
			location.getBlock().setType(Material.WOOL);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(polishub, new Runnable() {
				
				@Override
				public void run() {
					
					location.getBlock().setType(type);
					location.getBlock().setData((byte)14);
				}
			}, 40);
			
		}
		
	}

}
