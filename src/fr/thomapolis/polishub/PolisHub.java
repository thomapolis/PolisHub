package fr.thomapolis.polishub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thomapolis.poliscore.PolisCore;
import fr.thomapolis.polishub.commands.CommandMoney;
import fr.thomapolis.polishub.listeners.ListenerPlayer;
import fr.thomapolis.polishub.type.ItemEffectType;

public class PolisHub extends JavaPlugin {

	private static String prefix;
	
	
	private PolisCore api = (PolisCore) Bukkit.getServer().getPluginManager().getPlugin("PolisCore");
	
	private ItemEffectType ieType;
	
	@Override
	public void onEnable() {
		
		//Init
		setPrefix(ChatColor.GRAY+"["+ChatColor.GREEN+"PolisHub"+ChatColor.GRAY+"] ");
		ieType = new ItemEffectType();
		
		
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
		
	}
	
	public PolisCore getAPI() {
		
		return this.api;
	}
	
	public ItemEffectType getItemEffectType() {
		
		return this.ieType;
	}
	
}
