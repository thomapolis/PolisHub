package fr.thomapolis.polishub.itemseffect.leatherarmor;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.thomapolis.polishub.gui.GUITenues;
import fr.thomapolis.polishub.itemseffect.ItemEffectLeatherArmor;
import fr.thomapolis.polishub.type.ItemEffectArmorType;

public class IETenuesRank extends ItemEffectLeatherArmor {

	@Override
	public String getName() {
		
		return ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Tenues des grades";
	}

	@Override
	public Material getType() {

		return Material.LEATHER_LEGGINGS;
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
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void onInteract(Player player) {
		// XXX Auto-generated method stub

	}

	@Override
	public void onClickInventory(Player player) {
		
		GUITenues gui = new GUITenues();
		Inventory inv = gui.getInventory();
		gui.setTenueInInv(inv, player);
		player.openInventory(inv);

	}

	@Override
	public Color getArmorColor() {
		// XXX Auto-generated method stub
		return Color.YELLOW;
	}

	@Override
	public ItemEffectArmorType getArmorType() {
		// XXX Auto-generated method stub
		return ItemEffectArmorType.LEGGINGS;
	}

}
