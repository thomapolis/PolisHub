package fr.thomapolis.polishub.gadgets;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;

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
        player.getInventory().setItem(8, it);
    }
    
    public abstract int getCosmeticId();
    public abstract CosmeticRank getCosmeticRank();
	
}
