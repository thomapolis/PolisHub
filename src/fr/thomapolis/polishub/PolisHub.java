package fr.thomapolis.polishub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thomapolis.poliscore.PolisCore;
import fr.thomapolis.polishub.commands.CommandMoney;
import fr.thomapolis.polishub.listeners.ListenerPlayer;
import fr.thomapolis.polishub.listeners.ListenerProjectile;
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
		
		getServer().getConsoleSender().sendMessage(getPrefix()+"PolisHub is enable !");
		
	}
	
	public static String getPrefix() {

		return prefix;
	}
	
	public void setPrefix(String prefix2) {
		
		prefix = prefix2;
	}
	
	public void registerCommands() {
		
		getCommand("money").setExecutor(new CommandMoney(this));
		
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
	
}
