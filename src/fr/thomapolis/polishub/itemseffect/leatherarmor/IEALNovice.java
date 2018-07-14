package fr.thomapolis.polishub.itemseffect.leatherarmor;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import fr.thomapolis.polishub.itemseffect.ItemEffectLeatherArmor;
import fr.thomapolis.polishub.type.ItemEffectArmorType;

public class IEALNovice extends ItemEffectLeatherArmor {

	@Override
	public String getName() {

		return ChatColor.GOLD+"Pantalon du Novice";
	}

	@Override
	public Material getType() {
		// XXX Auto-generated method stub
		return Material.LEATHER_LEGGINGS;
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
		
		equip(player);

	}

	@Override
	public Color getArmorColor() {
		// XXX Auto-generated method stub
		return Color.MAROON;
	}

	@Override
	public ItemEffectArmorType getArmorType() {
		// XXX Auto-generated method stub
		return ItemEffectArmorType.LEGGINGS;
	}

}
