package fr.thomapolis.polishub.tenues;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.type.TenueType;

public abstract class Tenue {
	
	private TenueType type;

	public abstract String getName();
	public abstract	String getCosmeticId();
	public abstract CosmeticRank getRank();
	public abstract ItemStack getChestplate(Player player);
	public abstract ItemStack getLeggings(Player player);
	public abstract ItemStack getBoots(Player player);
	public abstract ItemStack getIcon(Player player);
	
	public ItemStack getItemLock(ItemStack item, CosmeticRank rank) {
		
		List<String> lores = new ArrayList<>();
		lores.add(ChatColor.DARK_AQUA+"Cette tenue requière le CosmeticRank :"+ChatColor.GOLD+rank.getName());
		
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setLore(lores);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public boolean isLock(Player player) {
		
		PolisPlayer polisPlayer = PolisHub.getAPI().getPolisPlayer(player);
		
		if(!polisPlayer.getCosmeticRank().hasCosmetics(getCosmeticId())) {
			
			return true;
		}
		
		return false;
	}
}
