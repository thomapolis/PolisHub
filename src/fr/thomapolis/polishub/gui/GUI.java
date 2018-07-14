package fr.thomapolis.polishub.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class GUI {

	public abstract String getTitle();
	public abstract int getSize();
	public abstract void setupInventory(Inventory inventory);
	
	public Inventory getInventory() {
		
		Inventory inventory = Bukkit.createInventory(null, getSize(), getTitle());
		setupInventory(inventory);
		
		return inventory;
	}
	
	public void addItemInventory(Inventory inventory, ItemStack item, int[] slots) {
		
		for(int slot : slots) {
			
			inventory.setItem(slot, item);
			
		}
		
	}
}
