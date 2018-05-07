package be.lecson.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Money implements Listener {
	
	File data;
	
	public Money(File data) {
		this.data = data;
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		String pseudo = player.getName();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(data);
			br = new BufferedReader(fr);
			String currentLine;
			String[] line = {"pseudo","money"};
			
			boolean isInFile = false;
			
			FileWriter fw = new FileWriter(data,true);
			PrintWriter pw = new PrintWriter(fw);
			
			
			
			
			while((currentLine = br.readLine()) != null) {
				line = currentLine.split(":");
				if(line[0].equalsIgnoreCase(pseudo)) {
					player.sendMessage("Votre compte est de §3"+line[1]+"§f$");
					isInFile = true;
				}
				
				
				currentLine = null;
				
			}
			if(isInFile == false) {
				pw.println(pseudo + ":0");
				pw.flush();
				pw.close();
				player.sendMessage("Nouveau compte ouvert sous le nom de : §3"+pseudo);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
			}
			catch(Exception e3){
				e3.printStackTrace();
			}
		}
	
		
		


	}
}


















