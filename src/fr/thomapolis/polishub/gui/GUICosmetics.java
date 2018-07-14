package fr.thomapolis.polishub.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.polishub.itemseffect.IEGadgets;
import fr.thomapolis.polishub.itemseffect.leatherarmor.IETenuesRank;

public class GUICosmetics extends GUI {

	@Override
	public String getTitle() {

		return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Cosmetics";
	}

	@Override
	public int getSize() {
		
		return 54;
	}

	@Override
	public void setupInventory(Inventory inventory) {
		
		ItemStack g1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15);
		ItemMeta gM1 = g1.getItemMeta();
		gM1.setDisplayName(" ");
		g1.setItemMeta(gM1);
		int[] g1S = new int[] {0,1,2,6,7,8,9,17,18,26,27,35,36,44,45,46,47,51,52,53};
		addItemInventory(inventory, g1, g1S);
		
		ItemStack g2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
		ItemMeta gM2 = g2.getItemMeta();
		gM2.setDisplayName(" ");
		g2.setItemMeta(gM2);
		int[] g2S = new int[] {3,4,5,10,16, 19, 25, 28, 34, 37, 39, 40, 41, 48, 49, 50};
		addItemInventory(inventory, g2, g2S);
		
		ItemStack g3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)3);
		ItemMeta gM3 = g3.getItemMeta();
		gM3.setDisplayName(" ");
		g3.setItemMeta(gM3);
		int[] g3S = new int[] {12, 14, 20, 21, 22, 23, 24, 30, 32, 38,39,40,41,42};
		addItemInventory(inventory, g3, g3S);
		
		IETenuesRank tR = new IETenuesRank();
		inventory.setItem(29, tR.getItem());
		
		IEGadgets ieG = new IEGadgets();
		inventory.setItem(11, ieG.getItem());
		
	}

}
