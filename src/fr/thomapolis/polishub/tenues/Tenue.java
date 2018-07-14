package fr.thomapolis.polishub.tenues;

import org.bukkit.inventory.ItemStack;

import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;

public abstract class Tenue {

	public abstract String getName();
	public abstract	String getCosmeticId();
	public abstract CosmeticRank getRank();
	public abstract ItemStack getChestplate();
	public abstract ItemStack getLeggings();
	public abstract ItemStack getBoots();
	public abstract ItemStack getIcon();

	public abstract ItemStack getChestplateLock();
	public abstract ItemStack getLeggingsLock();
	public abstract ItemStack getBootsLock();
	public abstract ItemStack getIconLock();
	
}
