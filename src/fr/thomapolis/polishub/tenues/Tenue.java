package fr.thomapolis.polishub.tenues;

import org.bukkit.inventory.ItemStack;

import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
import fr.thomapolis.polishub.type.TenueType;

public abstract class Tenue {
	
	private TenueType type;

	public abstract String getName();
	public abstract	String getCosmeticId();
	public abstract CosmeticRank getRank();
	public abstract ItemStack getChestplate();
	public abstract ItemStack getLeggings();
	public abstract ItemStack getBoots();
	public abstract ItemStack getIcon();

	public ItemStack getChestplateLock() {
		
		type = new TenueType();
		
		return type.getItemLock(getChestplate(), getRank());
	}
	
	public ItemStack getLeggingsLock() {
		
		type = new TenueType();
		
		return type.getItemLock(getLeggings(), getRank());
		
	}
	public ItemStack getBootsLock() {
		
		type = new TenueType();
		
		return type.getItemLock(getBoots(), getRank());
	}
	
	public ItemStack getIconLock() {
		
		type = new TenueType();
		
		return type.getItemLock(getIcon(), getRank());
	}
	
}
