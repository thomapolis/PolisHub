package fr.thomapolis.polishub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.thomapolis.polisapi.PolisAPI;
import fr.thomapolis.polishub.commands.CommandMoney;

public class PolisHub extends JavaPlugin {

	private String prefix;
	
	private PolisAPI api = (PolisAPI) Bukkit.getServer().getPluginManager().getPlugin("PolisAPI");
	
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
	
	public PolisAPI getAPI() {
		
		return this.api;
	}
	
}
