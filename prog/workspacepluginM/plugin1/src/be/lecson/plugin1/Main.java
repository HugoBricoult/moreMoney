package be.lecson.plugin1;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "plugin active");
		getCommand("test").setExecutor(new CommandTest());
		getCommand("alert").setExecutor(new CommandAlert());
		getCommand("donner").setExecutor(new CommandDonner());
		getServer().getPluginManager().registerEvents(new PluginListenner(),this);
		
	}
	@Override
	public void onDisable() {
		
	
	}
	
}
