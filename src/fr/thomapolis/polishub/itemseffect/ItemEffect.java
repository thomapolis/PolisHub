package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class ItemEffect {
	
	public abstract String getName();
	public abstract Material getType();
	public abstract int getAmount();
	public abstract int getData();
	public abstract List<String> getLores();
	public abstract Enchantment getEnchantement();
	public abstract void onInteract(Player player);
	public abstract void onClickInventory(Player player);
	
	public ItemStack getItem() {
		
		ItemStack item = new ItemStack(getType(), getAmount(), (byte)getData());
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setUnbreakable(true);
		itemMeta.addEnchant(getEnchantement(), 1, true);
		itemMeta.setDisplayName(getName());
		itemMeta.setLore(getLores());
		item.setItemMeta(itemMeta);
		
		return item;
	}
}
