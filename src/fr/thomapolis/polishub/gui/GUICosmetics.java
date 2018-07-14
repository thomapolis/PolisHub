package fr.thomapolis.polishub.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
		int[] g1S = new int[] {0,1,2,6,7,8,9,17,18,26,27,35,36,37,38,42,43,44};
		addItemInventory(inventory, g1, g1S);
		
		ItemStack g2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)4);
		ItemMeta gM2 = g2.getItemMeta();
		gM2.setDisplayName(" ");
		g2.setItemMeta(gM2);
		int[] g2S = new int[] {3,4,5,10,16, 19, 25, 28, 34, 39, 40, 41};
		addItemInventory(inventory, g2, g2S);
		
		
		
	}

}
