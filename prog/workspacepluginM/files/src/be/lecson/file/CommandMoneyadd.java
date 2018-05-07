package be.lecson.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandMoneyadd implements CommandExecutor {

	File data;
	
	public CommandMoneyadd(File data) {
		this.data = data;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length >= 0 && args.length <=2 || args.length >= 4) {
				player.sendMessage(ChatColor.RED+"/moneyadd <add,sub,set> <player> <price>");
			}
			if(args.length == 3) {
				if(args[0].equalsIgnoreCase("add")) {
					
					
					String pseudo = args[1];
					BufferedWriter bw;
					BufferedReader bf = null;
					FileReader fr = null;
					FileWriter fw = null;
					
					try {
						
						fr = new FileReader(data);
						bf = new BufferedReader(fr);
						String currentline = null;
						String[] line = {"pseudo","money"};
						boolean isInFile = false;
						int price;
						int compte;
						int nouveauCompte;
						String nouveauMontant;
						String replace;
						Path path = data.toPath();
						
						
						while((currentline = bf.readLine()) != null) {
							line = currentline.split(":");
							if(line[0].equalsIgnoreCase(pseudo)) {
								isInFile = true;
								compte = Integer.parseInt(line[1]);
								price = Integer.parseInt(args[2]);
								Player target = Bukkit.getServer().getPlayer(args[1]);
								if(target.isEmpty()) {
								nouveauCompte = compte + price;
								nouveauMontant = String.valueOf(nouveauCompte);
								StringBuilder sb = new StringBuilder();
								sb.append(pseudo+":"+nouveauMontant);
								replace = sb.toString();
								player.sendMessage(replace);
								List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
								for(int i = 0; i < fileContent.size();i++) {
									if(fileContent.get(i).equals(pseudo+":"+line[1])) {
										fileContent.set(i,replace);
										break;
									}
								}
								Files.write(path, fileContent, StandardCharsets.UTF_8);
								bf.close();
								currentline = null;
								
								
							}
								else {
									player.sendMessage(ChatColor.RED+"Le joueurs doit etre connecte");
								}
							}
						}
						
						
						
						
					} catch (Exception e) {
						
					}
					
				}
				else if(args[0].equalsIgnoreCase("sub")) {

					
					String pseudo = args[1];
					BufferedWriter bw;
					BufferedReader bf = null;
					FileReader fr = null;
					FileWriter fw = null;
					
					try {
						
						fr = new FileReader(data);
						bf = new BufferedReader(fr);
						String currentline = null;
						String[] line = {"pseudo","money"};
						boolean isInFile = false;
						int price;
						int compte;
						int nouveauCompte;
						String nouveauMontant;
						String replace;
						Path path = data.toPath();
						
						
						while((currentline = bf.readLine()) != null) {
							line = currentline.split(":");
							if(line[0].equalsIgnoreCase(pseudo)) {
								isInFile = true;
								compte = Integer.parseInt(line[1]);
								price = Integer.parseInt(args[2]);
								Player target = Bukkit.getServer().getPlayer(args[1]);
								if(target.isOnline()) {
								nouveauCompte = compte - price;
								if(nouveauCompte < 0) {
									nouveauCompte = 0;
								}
								nouveauMontant = String.valueOf(nouveauCompte);
								StringBuilder sb = new StringBuilder();
								sb.append(pseudo+":"+nouveauMontant);
								replace = sb.toString();
								player.sendMessage(replace);
								List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
								for(int i = 0; i < fileContent.size();i++) {
									if(fileContent.get(i).equals(pseudo+":"+line[1])) {
										fileContent.set(i,replace);
										break;
									}
								}
								Files.write(path, fileContent, StandardCharsets.UTF_8);
								bf.close();
								currentline = null;
								
							}
								else {
									player.sendMessage(ChatColor.RED+"Le joueurs doit etre connecte");
								}
							}
						}
						
						
						
						
					} catch (Exception e) {
						
					}
					
				}
				else if(args[0].equalsIgnoreCase("set")) {

					
					String pseudo = args[1];
					BufferedWriter bw;
					BufferedReader bf = null;
					FileReader fr = null;
					FileWriter fw = null;
					
					try {
						
						fr = new FileReader(data);
						bf = new BufferedReader(fr);
						String currentline = null;
						String[] line = {"pseudo","money"};
						boolean isInFile = false;
						int price;
						int nouveauCompte;
						String nouveauMontant;
						String replace;
						Path path = data.toPath();
						
						
						while((currentline = bf.readLine()) != null) {
							line = currentline.split(":");
							if(line[0].equalsIgnoreCase(pseudo)) {
								isInFile = true;
								price = Integer.parseInt(args[2]);
								Player target = Bukkit.getServer().getPlayer(args[1]);
								if(target.isOnline()) {
								nouveauCompte = price;
								nouveauMontant = String.valueOf(nouveauCompte);
								StringBuilder sb = new StringBuilder();
								sb.append(pseudo+":"+nouveauMontant);
								replace = sb.toString();
								player.sendMessage(replace);
								List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
								for(int i = 0; i < fileContent.size();i++) {
									if(fileContent.get(i).equals(pseudo+":"+line[1])) {
										fileContent.set(i,replace);
										break;
									}
								}
								Files.write(path, fileContent, StandardCharsets.UTF_8);
								bf.close();
								currentline = null;
								
							}
								else {
									player.sendMessage(ChatColor.RED+"Le joueurs doit etre connecte");
								}
							}
						}
						
						
						
						
					} catch (Exception e) {
						
					}
					
				}
				else {
					player.sendMessage(ChatColor.RED+"/moneyadd <add,sub,set> <player> <price>");
				}
			}
			
			
		}
		
		
		
		return false;
	}

}
