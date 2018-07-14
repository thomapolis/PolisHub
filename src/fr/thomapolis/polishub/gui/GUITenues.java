package fr.thomapolis.polishub.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUITenues extends GUI {

	@Override
	public String getTitle() {

		return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Tenues des grades";
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
		int[] g1S = new int[] {0,1,2,6,7,8,46,47,48,50,51,52,53};
		addItemInventory(inventory, g1, g1S);
		
	}

}
