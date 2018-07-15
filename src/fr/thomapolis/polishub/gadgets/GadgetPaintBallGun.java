package fr.thomapolis.polishub.gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.thomapolis.poliscore.cosmeticranks.CRNovice;
import fr.thomapolis.poliscore.cosmeticranks.CosmeticRank;
import fr.thomapolis.polishub.gadgets.projectiles.PGPaintBall;
import fr.thomapolis.polishub.gadgets.projectiles.ProjectileGadget;

public class GadgetPaintBallGun extends Gadget {

	@Override
	public String getName() {

		return ChatColor.GRAY+"PaintBallGun";
	}

	@Override
	public ItemStack getItem() {
		
		List<String> lores = new ArrayList<>();
		lores.add(ChatColor.GOLD+"Faites clic droit et envoyé une boule");
		lores.add(ChatColor.GOLD+"de neige qui repeint les blocs qu'elle");
		lores.add(ChatColor.GOLD+"touche");
		
		ItemStack item = new ItemStack(Material.IRON_BARDING, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(getName());
		itemMeta.setLore(lores);
		item.setItemMeta(itemMeta);
		
		return item;
	}

	@Override
	public int getCooldown() {

		return 10;
	}

	@Override
	public void onInteract(Player player) {
		
		player.launchProjectile(Snowball.class, player.getLocation().getDirection());

	}

	@Override
	public int getCosmeticId() {
		// XXX Auto-generated method stub
		return 2;
	}

	@Override
	public CosmeticRank getCosmeticRank() {

		return new CRNovice();
	}
	
	@Override
	public ProjectileGadget getProjectile() {
		
		return new PGPaintBall();
	}

}
