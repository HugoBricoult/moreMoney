package be.lecson.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandPay implements CommandExecutor {
	
	File data;
	
	
	public CommandPay(File data) {
		this.data = data;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			String pseudo = player.getName();
			if(args.length <= 1 || args.length >= 3) {
				player.sendMessage(ChatColor.RED+"/pay <player> <prix>");
			}
			if(args.length == 2) {
				BufferedReader br = null;
				FileReader fr = null;
				BufferedReader br2 = null;
				FileReader fr2 = null;
				int prix = Integer.parseInt(args[1]);
				try {
					fr = new FileReader(data);
					br = new BufferedReader(fr);
					fr2 = new FileReader(data);
					br2 = new BufferedReader(fr2);
					Path path = data.toPath();
					String currentline;
					String[] line = {"pseudo","money"};
					int compte;
					int compteplayer;
					String nouveauMontantPlayer;
					String replace;
					
					while((currentline = br.readLine()) != null) {
						line = currentline.split(":");
						if(line[0].equalsIgnoreCase(pseudo)) {
							compte = Integer.parseInt(line[1]);
							if(compte < prix) {
								player.sendMessage(ChatColor.RED+"solde insuffisant");
							}
							else {
								compteplayer = compte - prix;
								nouveauMontantPlayer = String.valueOf(compteplayer);
								StringBuilder sb = new StringBuilder();
								sb.append(pseudo+":"+nouveauMontantPlayer);
								replace = sb.toString();
								
								List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
								for(int i = 0; i < fileContent.size();i++) {
									if(fileContent.get(i).equals(pseudo+":"+line[1])) {
										fileContent.set(i,replace);
										break;
									}
								}
								Files.write(path, fileContent, StandardCharsets.UTF_8);
								br.close();
								currentline = null;
								
								while((currentline = br2.readLine()) != null) {
									line =currentline.split(":");
									if(line[0].equalsIgnoreCase(args[0])) {
										//2eme joueur a finir
									}
								}
							}
						}
					}
				} catch (Exception e) {
					
				}
			}
			
		}
		return false;
	}

}




















