package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.gui.GUICosmetics;

public class IECosmetics extends ItemEffect {

	@Override
	public String getName() {

		return ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Cosmetics";
	}

	@Override
	public Material getType() {

		return Material.ENDER_CHEST;
	}

	@Override
	public int getAmount() {
		
		return 1;
	}

	@Override
	public int getData() {

		return 0;
	}

	@Override
	public List<String> getLores() {

		return null;
	}

	@Override
	public Enchantment getEnchantement() {

		return null;
	}

	@Override
	public void onInteract(Player player) {
		
		GUICosmetics gui = new GUICosmetics();
		player.openInventory(gui.getInventory());

	}

	@Override
	public void onClickInventory(Player player) {
		// XXX Auto-generated method stub

	}

}
