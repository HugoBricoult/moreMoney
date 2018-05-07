package be.lecson.moremoney.listenner;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.lecson.moremoney.Main;
import be.lecson.moremoney.filemanager.DataFile;

public class MoneyListenner implements Listener {

	private File data;
	private Main main;
	
	public MoneyListenner(File data,Main main) {
		this.data = data;
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		String pseudo = player.getName();
		DataFile datafile = new DataFile(data);
		if(datafile.playerJoin(pseudo)) {
			player.sendMessage(main.getConfig().getString("joinserv.join").replace("&", "§")+datafile.getPrice(pseudo)+main.getConfig().getString("money").replace("&", "§"));
		}
		else {
			player.sendMessage(main.getConfig().getString("joinserv.firstjoin").replace("&", "§")+datafile.getPrice(pseudo)+main.getConfig().getString("money").replace("&", "§"));
		}
	}
}
