package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.PolisHub;

public class IEClearTenue extends ItemEffect {

	@Override
	public String getName() {

		return ChatColor.DARK_RED+"Enlever votre tenue";
	}

	@Override
	public Material getType() {
		
		return Material.STAINED_GLASS;
	}

	@Override
	public int getAmount() {
		// XXX Auto-generated method stub
		return 1;
	}

	@Override
	public int getData() {
		// XXX Auto-generated method stub
		return 14;
	}

	@Override
	public List<String> getLores() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Enchantment getEnchantement() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void onInteract(Player player) {
		// XXX Auto-generated method stub

	}

	@Override
	public void onClickInventory(Player player) {
		
		player.getEquipment().setChestplate(null);
		player.getEquipment().setLeggings(null);
		player.getEquipment().setBoots(null);
		player.closeInventory();
		player.sendMessage(PolisHub.getPrefix()+ChatColor.RED+"Vous avez enlevé votre tenue !");

	}

}
