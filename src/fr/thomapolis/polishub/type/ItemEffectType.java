package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

import fr.thomapolis.polishub.itemseffect.IEBackGUI;
import fr.thomapolis.polishub.itemseffect.IECloseGUI;
import fr.thomapolis.polishub.itemseffect.IECosmetics;
import fr.thomapolis.polishub.itemseffect.ItemEffect;
import fr.thomapolis.polishub.itemseffect.leatherarmor.IETenuesRank;

public class ItemEffectType	{

	public List<ItemEffect> items = new ArrayList<>();
	
	public ItemEffectType() {
		
		register();
		
	}
	
	public void register() {
		
		this.items.add(new IECosmetics());
		this.items.add(new IETenuesRank());
		this.items.add(new IECloseGUI());
		this.items.add(new IEBackGUI());
		
	}
	
	public boolean isItemEffect(ItemStack item) {
		
		for(ItemEffect itemEffect : items) {
			
			if(itemEffect.getItem().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
	public ItemEffect getItemEffect(ItemStack item) {
		
		for(ItemEffect itemEffect : items) {
			
			if(itemEffect.getItem().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
				
				return itemEffect;
				
			}
			
		}
		
		return null;
		
	}
	
}