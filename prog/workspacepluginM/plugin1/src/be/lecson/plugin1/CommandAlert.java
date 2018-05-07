package be.lecson.plugin1;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandAlert implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			//alert aucun arguments
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED+"/alert <message>");	
					}
			//alert text text text
				else {
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part+" ");
					}
					player.sendMessage("§3["+player.getName()+"]§f : §5"+bc.toString());
				}
		}		
		return false;
	}

}
