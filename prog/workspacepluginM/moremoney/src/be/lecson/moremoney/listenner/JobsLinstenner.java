package be.lecson.moremoney.listenner;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import be.lecson.moremoney.Main;
import be.lecson.moremoney.filemanager.DataFile;
import net.minecraft.server.v1_12_R1.Material;

public class JobsLinstenner implements Listener {

	private Main main;
	private File data;

	
	public JobsLinstenner(File jobs,Main main) {
		this.main = main;
		this.data = jobs;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		String pseudo = player.getName();
		ItemStack current = e.getCurrentItem();
		String currentName = current.getItemMeta().getDisplayName();
		if(inv.getName().equalsIgnoreCase("�5Choisir un job")) {
			switch(currentName) {
			case "Mineur":
				DataFile datafile = new DataFile(data);
				datafile.playerJobs(player, pseudo, "mineur");
				player.closeInventory();
			break;
			case "Pecheur":
				DataFile datafilep = new DataFile(data);
				datafilep.playerJobs(player, pseudo, "pecheur");
				player.closeInventory();
			break;
			case "Boulanger":
				DataFile datafileb = new DataFile(data);
				datafileb.playerJobs(player, pseudo, "boulanger");
				player.closeInventory();
			break;
			case "Bucheron":
				DataFile datafileB = new DataFile(data);
				datafileB.playerJobs(player, pseudo, "bucheron");
				player.closeInventory();
			break;
			case "Chasseur":
				DataFile datafilec = new DataFile(data);
				datafilec.playerJobs(player, pseudo, "chasseur");
				player.closeInventory();
			break;
			case "Jardinier":
				DataFile datafilej = new DataFile(data);
				datafilej.playerJobs(player, pseudo, "jardinier");
				player.closeInventory();
			break;
			case "Macon":
				DataFile datafilem = new DataFile(data);
				datafilem.playerJobs(player, pseudo, "macon");
				player.closeInventory();
			break;
			case "Fermer":
				player.closeInventory();
			break;
			default:
				player.closeInventory();
			break;
			}
		}
	}

}