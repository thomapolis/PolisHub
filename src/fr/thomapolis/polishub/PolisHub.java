package fr.thomapolis.polishub;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class PolisHub extends JavaPlugin {

	private String prefix;
	
	@Override
	public void onEnable() {
		
		//Init
		setPrefix(ChatColor.GRAY+"["+ChatColor.GREEN+"PolisHub"+ChatColor.GRAY+"] ");
		
		getServer().getConsoleSender().sendMessage(getPrefix()+"PolisHub is enable !");
		
	}
	
	public String getPrefix() {
		
		return this.prefix;
	}
	
	public void setPrefix(String prefix) {
		
		this.prefix = prefix;
	}
	
}
