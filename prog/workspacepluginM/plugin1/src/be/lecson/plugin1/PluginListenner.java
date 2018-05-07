package be.lecson.plugin1;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class PluginListenner implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK)return;
		if(e.getClickedBlock().getType() != Material.SIGN) return;
		Sign sign = (Sign) e.getClickedBlock().getState();
		if(e.getClickedBlock().getType() == Material.SIGN && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
		if(sign.getLine(2).equals("[Spawn]")) {
			e.getPlayer().sendMessage("les coordonees du spawn sont 0 0 0");
			Bukkit.broadcastMessage("test");
		}
	}}
	
}
