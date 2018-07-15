package fr.thomapolis.polishub.gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
import fr.thomapolis.poliscore.polisclass.PolisPlayer;
import fr.thomapolis.polishub.gadgets.projectiles.ProjectileGadget;

public abstract class Gadget {

	public abstract String getName();
	   
    public abstract ItemStack getItem();
   
    public abstract int getCooldown();
   
    public abstract void onInteract(Player player);
   
    public void give(Player player){
        ItemStack it = getItem();
        ItemMeta iM = it.getItemMeta();
        iM.setDisplayName(getName());
        it.setItemMeta(iM);
        player.getInventory().setItem(6, it);
        player.closeInventory();
    }
    
    public abstract String getCosmeticId();
    public abstract CosmeticRank getCosmeticRank();
	public abstract ProjectileGadget getProjectile();
	
	public boolean hasProjectile() {
		
		if(getProjectile() != null) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean isLock(PolisPlayer polisPlayer) {
		
		if(!polisPlayer.getCosmeticRank().getCosmetics().contains(getCosmeticId())) {
			
			return true;
		}
		
		return false;
	}
	
	public ItemStack getItemGadget(PolisPlayer polisPlayer) {
		
		if(isLock(polisPlayer)) {
			
			List<String> lores = new ArrayList<>();
			lores.add(ChatColor.DARK_AQUA+"Cette tenue requière le CosmeticRank : "+ChatColor.GOLD+getCosmeticRank().getName());
			
			ItemStack item = getItem();
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setLore(lores);
			item.setItemMeta(itemMeta);
			
			return item;
			
		}
		
		return getItem();
	}
}
