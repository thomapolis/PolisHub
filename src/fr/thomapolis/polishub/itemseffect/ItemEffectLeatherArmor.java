package fr.thomapolis.polishub.itemseffect;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import fr.thomapolis.polishub.PolisHub;
import fr.thomapolis.polishub.type.ItemEffectArmorType;

public abstract class ItemEffectLeatherArmor extends ItemEffect {

	public abstract Color getArmorColor();
	public abstract ItemEffectArmorType getArmorType();
	
	public void equip(Player player) {
		
		if(getArmorType() == ItemEffectArmorType.HELMET) {
			
			player.getEquipment().setHelmet(getItem());
		}
		
		if(getArmorType() == ItemEffectArmorType.CHESTPLATE) {
			
			player.getEquipment().setChestplate(getItem());
		}
		
		if(getArmorType() == ItemEffectArmorType.LEGGINGS) {
			
			player.getEquipment().setLeggings(getItem());
			
		}
		
		if(getArmorType() == ItemEffectArmorType.BOOTS) {
			
			player.getEquipment().setBoots(getItem());
		}
		
		player.closeInventory();
		player.sendMessage(PolisHub.getPrefix()+ChatColor.GREEN+"Vous avez équipé "+getItem().getItemMeta().getDisplayName());
		
	}
	
	public ItemStack getItem() {
		
		ItemStack item = new ItemStack(getType(), getAmount(), (byte)getData());
		LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();
		itemMeta.setUnbreakable(true);
		if(getEnchantement() != null) {
			itemMeta.addEnchant(getEnchantement(), 1, true);
		}
		itemMeta.setDisplayName(getName());
		itemMeta.setLore(getLores());
		itemMeta.setColor(getArmorColor());
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
}
