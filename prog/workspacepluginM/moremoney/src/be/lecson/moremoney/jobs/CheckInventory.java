package be.lecson.moremoney.jobs;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CheckInventory {
	
	private Inventory inv;
	private ItemStack current;
	

	public CheckInventory(PlayerInventory inventory, ItemStack cur) {
		this.inv = (Inventory) inventory;
		this.current = cur;
	}
	
	public boolean inventoryContains() {
		
		int count = 0;
		ItemStack[] items = inv.getContents();
		for(int i = 0; i <items.length;i++) {
			if(items[i] != null && items[i].getType() == current.getType()) {
				count += items[i].getAmount();
			}
		}
		if(count >= current.getAmount()) {
			return true;
		}
		else {
		
		return false;
		}
	}
	
	public void removeFromInventory() {
		int amt = current.getAmount();
		ItemStack[] items = inv.getContents();
		for(int i = 0; i < items.length;i++) {
			if(items[i] != null && items[i].getType() == current.getType()) {
				if(items[i].getAmount() > amt) {
					items[i].setAmount(items[i].getAmount()-amt);
					break;
				}
				else if(items[i].getAmount() == amt) {
					items[i] = null;
					break;
				}
				else {
					amt -= items[i].getAmount();
					items[i] = null;
				}
			}
		}
		inv.setContents(items);
	}

}






















