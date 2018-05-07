package be.lecson.moremoney.jobs;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvItem {
	
	private String name;
	private String lore;
	private Material material;
	private int nombre;
	
	public InvItem(String name, String lore,Material material,int nombre) {
		
		this.name = name;
		this.lore = lore;
		this.material = material;
		this.nombre = nombre;
	}
	
	public ItemStack getItemMenu() {
		
		ItemStack item = new ItemStack(material,nombre);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName(name);
		itemM.setLore(Arrays.asList(lore));
		item.setItemMeta(itemM);
		
		return item;
		
	}
}
