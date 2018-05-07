package be.lecson.plugin1;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandDonner implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			//sword custom
			ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,1);
			ItemMeta swordM = sword.getItemMeta();
			swordM.setDisplayName("§5Voleur de vie");
			swordM.setLore(Arrays.asList("epee de la","mort","incassable"));
			swordM.setUnbreakable(true);
			swordM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
			sword.setItemMeta(swordM);
			
			// no parameters
			if(args.length == 0) {
				player.sendMessage("§4/donner <sword,stone,grass>");
			}
			//too many parameters
			else if(args.length >= 2) {
				player.sendMessage("§4/donner <sword,stone,grass>");
			}
			else {
				switch(args[0]){
				case "stone":
					player.getInventory().addItem(new ItemStack(Material.STONE,61));
				break;
				case "sword":
					player.getInventory().addItem(sword);
				break;
				case "grass":
					player.getInventory().addItem(new ItemStack(Material.GRASS,61));
				break;
				default:
					player.sendMessage("§4/donner <sword,stone,grass>");
				break;
				}
			}
		}
		return false;
	}

}
