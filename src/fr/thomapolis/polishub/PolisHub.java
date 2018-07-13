package fr.thomapolis.polishub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thomapolis.poliscore.PolisCore;
import fr.thomapolis.polishub.commands.CommandMoney;
import fr.thomapolis.polishub.listeners.ListenerPlayer;

public class PolisHub extends JavaPlugin {

	private String prefix;
	
	private PolisCore api = (PolisCore) Bukkit.getServer().getPluginManager().getPlugin("PolisCore");
	
	@Override
	public void onEnable() {
		
		//Init
		setPrefix(ChatColor.GRAY+"["+ChatColor.GREEN+"PolisHub"+ChatColor.GRAY+"] ");
		
		//Register
		registerCommands();
		
		getServer().getConsoleSender().sendMessage(getPrefix()+"PolisHub is enable !");
		
	}
	
	public String getPrefix() {
		
		return this.prefix;
	}
	
	public void setPrefix(String prefix) {
		
		this.prefix = prefix;
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
	
}
