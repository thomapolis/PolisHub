package fr.thomapolis.polishub.tenues;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.thomapolis.poliscore.cosmeticranks.CRNovice;
import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
import fr.thomapolis.polishub.itemseffect.IEINovice;
import fr.thomapolis.polishub.itemseffect.leatherarmor.IEABNovice;
import fr.thomapolis.polishub.itemseffect.leatherarmor.IEACNovice;
import fr.thomapolis.polishub.itemseffect.leatherarmor.IEALNovice;

public class TenueNovice extends Tenue {

	@Override
	public String getName() {
		
		return ChatColor.GOLD+"Tenue du novice";
	}

	@Override
	public String getCosmeticId() {
		
		return "1";
	}

	@Override
	public CosmeticRank getRank() {
		
		return new CRNovice();
	}
	
	@Override
	public ItemStack getChestplate(Player player) {
		
		IEACNovice item = new IEACNovice();
		
		if(isLock(player)) {
			
			return getItemLock(item.getItem(), getRank());
		}
		
		return item.getItem();
	}

	@Override
	public ItemStack getLeggings(Player player) {
		
		IEALNovice item = new IEALNovice();
		
		if(isLock(player)) {
			
			return getItemLock(item.getItem(), getRank());
		}
		
		return item.getItem();
	}

	@Override
	public ItemStack getBoots(Player player) {
		
		IEABNovice item = new IEABNovice();
		
		if(isLock(player)) {
			
			return getItemLock(item.getItem(), getRank());
		}
		
		return item.getItem();
	}

	@Override
	public ItemStack getIcon(Player player) {
		
		IEINovice item = new IEINovice();
		
		if(isLock(player)) {
			
			return getItemLock(item.getItem(), getRank());
		}
		
		return item.getItem();
	}
}
