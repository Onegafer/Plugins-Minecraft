package plugin;

import java.util.HashMap;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Creeperpollo extends JavaPlugin implements Listener{

	ItemStack pluma = new ItemStack(Material.FEATHER);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(command.getName().equalsIgnoreCase("creeperstaff")){

				ItemMeta im = pluma.getItemMeta();
				im.setDisplayName(ChatColor.GOLD + "Creeper Staff.");
				pluma.setItemMeta(im);
				p.setItemInHand(pluma);

			}





		}
		return false;
	}


	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent event){

		Player p = event.getPlayer();
		Entity entity = event.getRightClicked();

		ItemStack i = p.getItemInHand();
		if(i != null){
			ItemMeta im = i.getItemMeta();
			if(im != null){
				String name = im.getDisplayName();
				if(name != null){
					if(name.contains("Creeper Staff.")){

						Location entityLoc = entity.getLocation();
						entity.remove();
						for(int a = 0; a < 5; a++){
							p.getWorld().spawnEntity(entityLoc, EntityType.CHICKEN);
						}
					}
				}	
			}
		}
	}

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);

	}


}
