package be.lecson.moremoney.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.lecson.moremoney.Main;
import be.lecson.moremoney.filemanager.DataFile;
import net.md_5.bungee.api.ChatColor;

public class CommandMoney implements CommandExecutor {
	
	File data;
	Main main;
	public CommandMoney(File data,Main main) {
		this.data = data;
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			String pseudo = player.getName();
			
			if(args.length > 0) {
				player.sendMessage(ChatColor.RED+"/money");
			}
			if(args.length == 0) {
				DataFile datafile; 
				datafile = new DataFile(data);
				String price = datafile.getPrice(pseudo);
				sender.sendMessage(main.getConfig().getString("message").replace("&", "§").replaceAll("%a", price)+main.getConfig().getString("money").replace("&", "§"));
				
			}
		}
		return false;
	}

}
