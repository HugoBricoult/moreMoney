package be.lecson.moremoney.jobs;

import java.io.File;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import be.lecson.moremoney.Main;
import be.lecson.moremoney.filemanager.DataFile;
import be.lecson.moremoney.jobs.CheckInventory;

public class ShopListenner implements Listener {

	private File jobs;
	private Main main;
	private File data;
	
	
	public ShopListenner(File jobs, File data, Main main) {
		this.jobs = jobs;
		this.main = main;
		this.data = data;
	}

	@EventHandler
	public void onInteract(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		ItemStack current = e.getCurrentItem();
		String[] listmetier = main.getConfig().getString("jobs").split(",");
		boolean invIsJobs = false;
		for(int i = 0; i < (listmetier.length) ;i++) {
			if(inv.getName().equalsIgnoreCase("§5WorkShop "+listmetier[i])) {
				if(current.hasItemMeta()) {
					if(current.getItemMeta().hasLore()) {
				List<String> lore = current.getItemMeta().getLore();
				String lores = lore.get(0);
				String lo = lores.replaceAll("[\\D]", "");
				int prix = 0;
				prix = Integer.parseInt(lo);
				DataFile datafile = new DataFile(data);
				String price = datafile.getPrice(player.getName());
				int pric = 0;
				pric = Integer.parseInt(price);
				ItemStack cur = new ItemStack(current.getType(),current.getAmount());
				CheckInventory ci = new CheckInventory(player.getInventory(),cur);
					if(ci.inventoryContains()) {
				pric += prix;
				StringBuilder sb = new StringBuilder();
				sb.append(player.getName()+":"+String.valueOf(pric));
				datafile.setPrice(player.getName(), sb.toString());
				ci.removeFromInventory();
				player.sendMessage("ajout de §5"+lo+main.getConfig().getString("money").replace('&', '§'));
				player.setItemOnCursor(null);
				player.openInventory(inv);
					}
					else {
					player.sendMessage(main.getConfig().getString("shop.blocless").replace('&', '§'));
					player.closeInventory();
					}
				
				}
				
				}
			}else if(current.getItemMeta().getDisplayName().equalsIgnoreCase("fermer")) {
				player.closeInventory();
			}
			
		}
		
	}

}
