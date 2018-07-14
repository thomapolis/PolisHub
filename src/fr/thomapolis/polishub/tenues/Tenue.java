package fr.thomapolis.polishub.tenues;

import org.bukkit.inventory.ItemStack;

public abstract class Tenue {

	public abstract String getName();
	public abstract	String getCosmeticId();
	public abstract ItemStack getChestplate();
	public abstract ItemStack getLeggings();
	public abstract ItemStack getBoots();
	public abstract ItemStack getIcon();
}
