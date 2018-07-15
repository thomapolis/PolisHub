package fr.thomapolis.polishub.gadgets.projectiles;

import org.bukkit.ChatColor;

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

}
