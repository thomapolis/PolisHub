package fr.thomapolis.polishub.itemseffect;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class IEINovice extends ItemEffect {

	@Override
	public String getName() {

		return ChatColor.GOLD+"Tenue du novice";
	}

	@Override
	public Material getType() {
		// XXX Auto-generated method stub
		return Material.LEATHER;
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
		// XXX Auto-generated method stub

	}

}
