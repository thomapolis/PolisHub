package fr.thomapolis.polishub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thomapolis.poliscore.PolisCore;
import fr.thomapolis.polishub.commands.CommandMoney;
import fr.thomapolis.polishub.commands.CommandPet;
import fr.thomapolis.polishub.listeners.ListenerPlayer;
import fr.thomapolis.polishub.listeners.ListenerProjectile;
import fr.thomapolis.polishub.nms.register.RegisterCustomEntity;
import fr.thomapolis.polishub.type.GadgetType;
import fr.thomapolis.polishub.type.ItemEffectType;
import fr.thomapolis.polishub.type.ProjectileGadgetType;

public class PolisHub extends JavaPlugin {

	private static String prefix;
	
	
	private static PolisCore api = (PolisCore) Bukkit.getServer().getPluginManager().getPlugin("PolisCore");
	
	private ItemEffectType ieType;
	private GadgetType gadgeType;
	private ProjectileGadgetType pgType;
	
	@Override
	public void onEnable() {
		
		//Init
		setPrefix(ChatColor.GRAY+"["+ChatColor.GREEN+"PolisHub"+ChatColor.GRAY+"] ");
		ieType = new ItemEffectType();
		gadgeType = new GadgetType();
		pgType = new ProjectileGadgetType();
		
		//Register
		registerCommands();
		registerEvents();
		RegisterCustomEntity.registerEntities();
		
		getServer().getConsoleSender().sendMessage(getPrefix()+"PolisHub is enable !");
		
	}
	
	@Override
	public void onDisable() {
		
		RegisterCustomEntity.unregisterEntities();
	}
	
	public static String getPrefix() {

		return prefix;
	}
	
	public void setPrefix(String prefix2) {
		
		prefix = prefix2;
	}
	
	public void registerCommands() {
		
		getCommand("money").setExecutor(new CommandMoney(this));
		getCommand("pet").setExecutor(new CommandPet(this));
		
	}
	
	public void registerEvents() {
		
		getServer().getPluginManager().registerEvents(new ListenerPlayer(this), this);
		getServer().getPluginManager().registerEvents(new ListenerProjectile(this), this);
		
	}
	
	public static PolisCore getAPI() {
		
		return api;
	}
	
	public ItemEffectType getItemEffectType() {
		
		return this.ieType;
	}
	
	public GadgetType getGadgetType() {
		
		return this.gadgeType;
	}
	
	public ProjectileGadgetType getProjectileType() {
		
		return this.pgType;
	}
	
	public static List<Player> getActiveCosmeticPlayer(){
		
		List<Player> players = new ArrayList<>();
		
		for(Player online : Bukkit.getServer().getOnlinePlayers()) {
			
			players.add(online);
		}
		
		return players;
	}
}
