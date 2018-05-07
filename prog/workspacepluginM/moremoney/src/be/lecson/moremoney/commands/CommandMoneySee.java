package be.lecson.moremoney.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.lecson.moremoney.Main;
import be.lecson.moremoney.filemanager.DataFile;
import net.md_5.bungee.api.ChatColor;

public class CommandMoneySee implements CommandExecutor {

	File data;
	Main main;
	
	public CommandMoneySee(File data, Main main) {
		this.data = data;
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player player = (Player) sender;
		if(args.length <1 || args.length >1) {
			player.sendMessage(ChatColor.RED+"/moneysee <player>");
		}
		if(args.length == 1) {
			DataFile datafile = new DataFile(data);
			String price;
			price = datafile.getPrice(args[0]);
			player.sendMessage(main.getConfig().getString("moneysee").replace("&", "§").replaceAll("%p",args[0]).replaceAll("%a",price));
		}
		return false;
	}

}
