package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class IETenuesRank extends ItemEffect {

	@Override
	public String getName() {

		return ChatColor.YELLOW+""+ChatColor.BOLD+"Tenues des grades";
	}

	@Override
	public Material getType() {
		
		return Material.LEATHER_CHESTPLATE;
	}

	@Override
	public int getAmount() {
		// XXX Auto-generated method stub
		return 0;
	}

	@Override
	public int getData() {
		// XXX Auto-generated method stub
		return 0;
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
		// XXX Auto-generated method stub

	}

}
