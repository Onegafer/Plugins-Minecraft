package plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;


public class CambiarBloque extends JavaPlugin implements Listener{

	Material m = Material.STONE;
	boolean activo = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Player p = (Player)sender;

		if(command.getName().equalsIgnoreCase("cambiar")){
			activo = true;
			
			if(args.length > 0){
				m = Integer.parseInt(args[0]);
			}

		return false;
	}


	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(!activo){
			return;
		}
		if(event.getAction() ==(Action.LEFT_CLICK_AIR) || event.getAction() == (Action.LEFT_CLICK_BLOCK)){
			Player p = event.getPlayer();
			Location locObjetivo  = p.getTargetBlock(null, 255).getLocation();
			locObjetivo.getBlock().setType(m);
			
		}
	}
}
