package fr.thomapolis.polishub.gadgets;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Gadget {

	public abstract String name();
	   
    public abstract ItemStack item();
   
    public abstract int cooldown();
   
    public abstract void onInteract(Player player);
   
    public void give(Player player){
        ItemStack it = item();
        ItemMeta iM = it.getItemMeta();
        iM.setDisplayName(name());
        it.setItemMeta(iM);
        player.getInventory().setItem(8, it);
    }
	
}
