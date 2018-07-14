package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
import fr.thomapolis.polishub.tenues.Tenue;
import fr.thomapolis.polishub.tenues.TenueNovice;

public class TenueType {

	public List<Tenue> tenues = new ArrayList<>();
	
	public TenueType() {
		
		register();
		
	}
	
	public void register() {
		
		this.tenues.add(new TenueNovice());
		
	}
	
	public ItemStack getItemLock(ItemStack item, CosmeticRank rank) {
		
		List<String> lores = new ArrayList<>();
		lores.add(ChatColor.DARK_AQUA+"Cette tenue requière le CosmeticRank :"+ChatColor.GOLD+rank.getName());
		
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setLore(lores);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
}
