package be.lecson.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandMoney implements CommandExecutor {
	
	File data;
	
	public CommandMoney(File data) {
		this.data = data;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			String pseudo = player.getName();
			BufferedReader bf = null;
			FileReader fr = null;
			
			if(args.length == 0) {
			
			
			try {
				fr = new FileReader(data);
				bf = new BufferedReader(fr);
				String currentline;
				String line[] = {"pseudo","money"};
				boolean isInFile = false;
				
				while((currentline = bf.readLine()) != null) {
					
					line = currentline.split(":");
					if(line[0].equalsIgnoreCase(pseudo)) {
						player.sendMessage("Votre compte est de §3"+line[1]+"§f$");
						currentline = null;
					}
					
				}
				
			} catch (Exception e) {
				
			}
			}
			if(args.length > 0) {
				player.sendMessage(ChatColor.RED+"/money");
			}
		}
		return false;
	}

}










