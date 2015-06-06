package plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class PlumaDimensional extends JavaPlugin implements Listener{
	

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Player p = (Player)sender;
		
		if(command.getName().equalsIgnoreCase("tpstaff")){
			
			
			ItemStack pluma = new ItemStack(Material.FEATHER);
			ItemMeta plumaMeta = pluma.getItemMeta();
			plumaMeta.setDisplayName(ChatColor.BLUE + "Pluma Dimensional de: " + p.getName());
			pluma.setItemMeta(plumaMeta);
			p.setItemInHand(pluma);

		}

		return false;
	}


	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);

	}


	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getAction() ==(Action.LEFT_CLICK_AIR) || event.getAction() == (Action.LEFT_CLICK_BLOCK) || event.getAction() ==(Action.RIGHT_CLICK_BLOCK) || event.getAction() == (Action.RIGHT_CLICK_AIR)){
			ItemStack itemEnMano = event.getPlayer().getItemInHand();

			if(itemEnMano != null){
				ItemMeta im = itemEnMano.getItemMeta();
				if(im != null){
					if(im.getDisplayName() !=null && im.getDisplayName().contains("Pluma Dimensional")){
						Player p = event.getPlayer();
						
							Location tpLoc  = p.getTargetBlock(null, 255).getLocation();

							p.teleport(tpLoc);
						
					}
				}
			}
		}
	}
}
