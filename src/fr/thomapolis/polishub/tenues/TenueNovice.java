package fr.thomapolis.polishub.tenues;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import fr.thomapolis.poliscore.cosmeticranks.CRNovice;
import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
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
	public ItemStack getChestplate() {
		
		IEACNovice item = new IEACNovice();
		
		return item.getItem();
	}

	@Override
	public ItemStack getLeggings() {
		
		IEALNovice item = new IEALNovice();
		
		return item.getItem();
	}

	@Override
	public ItemStack getBoots() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getIcon() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getChestplateLock() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getLeggingsLock() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getBootsLock() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getIconLock() {
		// XXX Auto-generated method stub
		return null;
	}

}
