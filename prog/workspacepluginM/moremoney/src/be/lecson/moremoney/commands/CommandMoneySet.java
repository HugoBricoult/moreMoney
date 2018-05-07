package be.lecson.moremoney.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.lecson.moremoney.Main;
import be.lecson.moremoney.filemanager.DataFile;
import net.md_5.bungee.api.ChatColor;

public class CommandMoneySet implements CommandExecutor {
	
	private File data;
	private Main main;
	
	public CommandMoneySet(File data, Main main) {
		this.data = data;
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player player = (Player) sender;
		String pseudo = player.getName();
		int arg = args.length;
		
		if(arg < 3 || arg >3) {
			player.sendMessage(ChatColor.RED+"/moneyset <add,sub,set> <player> <price>");
		}
		if(arg == 3) {
			String target = args[1];
			if(Bukkit.getPlayerExact(target) != null) {
			if(args[0].equalsIgnoreCase("add")) {
				int price;
				int addprice;
				String getprice;
				String setprice;
				String phrase;
				DataFile datafile = new DataFile(data);
				getprice = datafile.getPrice(target);
				price = Integer.parseInt(getprice);
				addprice = Integer.parseInt(args[2]);
				price += addprice;
				setprice = String.valueOf(price);
				StringBuilder sb = new StringBuilder();
				sb.append(target+":"+setprice);
				phrase = sb.toString();
				datafile.setPrice(target, phrase);
				player.sendMessage(main.getConfig().getString("moneyset.add").replace('&','§').replaceAll("%a", args[2]).replaceAll("%p",target));
				
			}
			else if(args[0].equalsIgnoreCase("sub")) {
				int price;
				int addprice;
				String getprice;
				String setprice;
				String phrase;
				target = args[1];
				DataFile datafile = new DataFile(data);
				getprice = datafile.getPrice(target);
				price = Integer.parseInt(getprice);
				addprice = Integer.parseInt(args[2]);
				if(price > addprice) {
				price -= addprice;
				}
				else {
					price = 0;
				}
				setprice = String.valueOf(price);
				StringBuilder sb = new StringBuilder();
				sb.append(target+":"+setprice);
				phrase = sb.toString();
				datafile.setPrice(target, phrase);
				player.sendMessage(main.getConfig().getString("moneyset.sub").replace('&','§').replaceAll("%a", args[2]).replaceAll("%p",target));
			}
			else if(args[0].equalsIgnoreCase("set")) {
				DataFile datafile = new DataFile(data);
				String phrase;
				target = args[1];
				StringBuilder sb = new StringBuilder();
				sb.append(target+":"+args[2]);
				phrase = sb.toString();
				datafile.setPrice(target, phrase);
				player.sendMessage(main.getConfig().getString("moneyset.set").replace('&','§').replaceAll("%a", args[2]).replaceAll("%p",target));
			}
			else {
				player.sendMessage(ChatColor.RED+"/moneyset <add,sub,set> <player> <price>");
			}
			
			}
			else {
				player.sendMessage(ChatColor.RED+"Le joueur "+target+" est offline !");
			}
		}
		
		return false;
	}

}
