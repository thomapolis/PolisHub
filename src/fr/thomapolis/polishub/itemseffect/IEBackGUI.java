package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.gui.GUICosmetics;

public class IEBackGUI extends ItemEffect {

	@Override
	public String getName() {
		
		return ChatColor.YELLOW+"Retour au menu";
	}

	@Override
	public Material getType() {

		return Material.ARROW;
	}

	@Override
	public int getAmount() {
		// XXX Auto-generated method stub
		return 1;
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
		
		GUICosmetics gui = new GUICosmetics();
		player.openInventory(gui.getInventory());

	}

}
