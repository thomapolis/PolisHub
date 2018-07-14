package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import fr.thomapolis.poliscore.ranks.Rank;

public class ItemLockType {

	public List<String> items = new ArrayList<>();
	
	public ItemLockType() {
		
	}
	
	public void register() {
		
		
		
	}
	
	public ItemStack getItemLock(Rank rank, ItemStack item) {
		
		return item;
	}
	
}
