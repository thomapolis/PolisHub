package fr.thomapolis.polishub.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public abstract class GUI {

	public abstract String getTitle();
	public abstract int getSize();
	public abstract void setupInventory(Inventory inventory);
	
	public Inventory getInventory() {
		
		Inventory inventory = Bukkit.createInventory(null, getSize(), getTitle());
		setupInventory(inventory);
		
		return inventory;
	}
}
