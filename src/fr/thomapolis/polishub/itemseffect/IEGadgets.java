package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.thomapolis.polishub.gui.GUIGadget;

public class IEGadgets extends ItemEffect {

	@Override
	public String getName() {

		return ChatColor.AQUA+""+ChatColor.BOLD+"Gadgets";
	}

	@Override
	public Material getType() {
		
		return Material.DIAMOND_BARDING;
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
		
		GUIGadget gui = new GUIGadget();
		Inventory inv = gui.getInventory();
		gui.setupGadget(inv, player);
		player.openInventory(inv);

	}

}
