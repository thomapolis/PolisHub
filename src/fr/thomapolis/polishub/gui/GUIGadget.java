package fr.thomapolis.polishub.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.gadgets.GadgetPaintBallGun;
import fr.thomapolis.polishub.itemseffect.IEBackGUI;
import fr.thomapolis.polishub.itemseffect.IEClearGadget;
import fr.thomapolis.polishub.itemseffect.IECloseGUI;

public class GUIGadget extends GUI {

	@Override
	public String getTitle() {
		// XXX Auto-generated method stub
		return ChatColor.AQUA+""+ChatColor.BOLD+"Gadgets";
	}

	@Override
	public int getSize() {
		// XXX Auto-generated method stub
		return 54;
	}

	@Override
	public void setupInventory(Inventory inventory) {
		
		ItemStack g1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15);
		ItemMeta gM1 = g1.getItemMeta();
		gM1.setDisplayName(" ");
		g1.setItemMeta(gM1);
		int[] g1S = new int[] {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,46,47,48,50,51,52};
		addItemInventory(inventory, g1, g1S);
		
		IECloseGUI ieCG = new IECloseGUI();
		inventory.setItem(45, ieCG.getItem());
		
		IEClearGadget ieCG2 = new IEClearGadget();
		inventory.setItem(49, ieCG2.getItem());
		
		IEBackGUI ieBG = new IEBackGUI();
		inventory.setItem(53, ieBG.getItem());
		
	}
	
	public void setupGadget(Inventory inventory, Player player) {
		
		GadgetPaintBallGun gPBG = new GadgetPaintBallGun();
		inventory.setItem(10, gPBG.getItemGadget(PolisHub.getAPI().getPolisPlayer(player)));
		
	}

}
