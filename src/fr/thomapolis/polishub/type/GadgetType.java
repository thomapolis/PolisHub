package fr.thomapolis.polishub.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.thomapolis.polishub.gadgets.Gadget;
import fr.thomapolis.polishub.gadgets.GadgetPaintBallGun;

public class GadgetType {

	public List<Gadget> gadgets = new ArrayList<>();
	private HashMap<String, Long> cooldowns = new HashMap<>();
	
	
	public GadgetType() {
		
		register();
		
	}
	
	public void register() {
		
		this.gadgets.add(new GadgetPaintBallGun());
		
	}
	
	public boolean isGadget(ItemStack it) {
		
		for(Gadget gadget : gadgets) {
			
			if(gadget.getName().equals(it.getItemMeta().getDisplayName())) {
				
				return true;
			}
			
		}
			
		return false;
	}
	
	public Gadget getGadget(ItemStack it) {
		
		for(Gadget gadget : gadgets) {
			
			if(gadget.getName().equals(it.getItemMeta().getDisplayName())) {
				
				return gadget;
			}
			
		}
			
		return null;
		
	}
	
	public void useGadget(ItemStack it, Player player) {
       
		gadgets.stream().filter(gadget -> it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(gadget.getName())).forEach(gadget -> {
           
            int cooldowntime = gadget.getCooldown();
            if(cooldowns.containsKey(player.getName())){
               
                long secondleft = ((cooldowns.get(player.getName()) / 1000) + cooldowntime) - (System.currentTimeMillis() / 1000);
               
                if(secondleft > 0){
                    player.sendMessage(secondleft +"s left");
                    return;
                }
       
            }
           
            cooldowns.put(player.getName(), System.currentTimeMillis());
           
            gadget.onInteract(player);
        });
	}
	
}
