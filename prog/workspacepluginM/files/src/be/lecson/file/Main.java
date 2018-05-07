package be.lecson.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	File saveTo = null;
	File temp = null;
	
	@Override
	public void onLoad() {
		
		try {
					
					File dataFolder = getDataFolder();
					if(!dataFolder.exists()) {
						dataFolder.mkdirs();
					}
					
					saveTo = new File(getDataFolder(),"data.txt");
					if(!saveTo.exists()) {
						saveTo.createNewFile();
					}
					temp = new File(getDataFolder(),"temp.txt");
					if(!temp.exists()) {
						temp.createNewFile();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
	}
	
	@Override
	public void onEnable() {
	

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"file charge");
		getServer().getPluginManager().registerEvents(new Money(saveTo), this);
		getCommand("money").setExecutor(new CommandMoney(saveTo));
		getCommand("moneyadd").setExecutor(new CommandMoneyadd(saveTo));
		getCommand("pay").setExecutor(new CommandPay(saveTo));
		
	}
	
	
	
	
	
}

