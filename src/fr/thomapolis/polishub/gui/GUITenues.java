package fr.thomapolis.polishub.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.itemseffect.IEBackGUI;
import fr.thomapolis.polishub.itemseffect.IEClearTenue;
import fr.thomapolis.polishub.itemseffect.IECloseGUI;
import fr.thomapolis.polishub.tenues.TenueNovice;

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
		int[] g1S = new int[] {0,1,2,6,7,8,46,47,48,50,51,52};
		addItemInventory(inventory, g1, g1S);
		
		IECloseGUI ieCG = new IECloseGUI();
		inventory.setItem(45, ieCG.getItem());
		
		IEClearTenue ieCT = new IEClearTenue();
		inventory.setItem(49, ieCT.getItem());
		
		IEBackGUI ieBG = new IEBackGUI();
		inventory.setItem(53, ieBG.getItem());
		
	}
	
	public void setTenueInInv(Inventory inv, Player player) {
		
		PolisPlayer polisPlayer = PolisHub.getAPI().getPolisPlayer(player);
		
		TenueNovice TN = new TenueNovice();
		
		inv.setItem(9, TN.getChestplate(player));
		inv.setItem(18, TN.getLeggings(player));
		inv.setItem(27, TN.getBoots(player));
		inv.setItem(36, TN.getIcon(player));
		
	}

}
