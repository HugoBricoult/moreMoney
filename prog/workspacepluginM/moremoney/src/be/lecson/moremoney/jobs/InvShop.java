package be.lecson.moremoney.jobs;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import be.lecson.moremoney.Main;

public class InvShop {
	
	private Player player;
	private String metier;
	private Main main;
	private File jobs;


	public InvShop(Player player, String metier, Main main, File jobs) {
		this.player = player;
		this.metier = metier;
		this.main = main;
		this.jobs = jobs;
	}
	
	public void openInvShop() {
		String[] itemsShop = main.getConfig().getString(metier+".item").split(",");
		String[] itemsPrice = main.getConfig().getString(metier+".prix").split(",");
		String[] itemNumb = main.getConfig().getString(metier+".nombre").split(",");
		int nombre;
		Inventory inv = Bukkit.createInventory(null, 54,"�5WorkShop "+metier);
		InvItem close = new InvItem("Fermer","Fermer l'inventaire",Material.BARRIER,1);
		for(int i = 0; i < (itemsShop.length); i++) {
			nombre = Integer.parseInt(itemNumb[i]);
			InvItem invitem = new InvItem(itemsShop[i],itemsPrice[i]+" "+main.getConfig().getString("money").replace("&", "�"),Material.getMaterial(itemsShop[i]),nombre);
			inv.setItem(i, invitem.getItemMenu());
			
		}
		inv.setItem(53,close.getItemMenu());
		player.openInventory(inv);
	}

}
