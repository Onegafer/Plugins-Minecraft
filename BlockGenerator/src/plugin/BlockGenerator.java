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


public class BlockGenerator extends JavaPlugin implements Listener{
	int bloque; //El número de rayos a generar
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Player p = (Player)sender;
		
		if(command.getName().equalsIgnoreCase("generador")){
			
			if(args.length > 0){
				bloque = Integer.parseInt(args[0]);
			}
			
			//Crea una nueva vara
			ItemStack varaFuego = new ItemStack(Material.bloque);
			ItemMeta varaMeta = varaFuego.getItemMeta();
			varaMeta.setDisplayName(ChatColor.Y + "Generador de bloques de " + bloque ());
			varaFuego.setItemMeta(varaMeta);
			p.setItemInHand(varaFuego);
			
		}
		
		return false;
	}


	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);

	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getAction() ==(Action.LEFT_CLICK_AIR) || event.getAction() == (Action.LEFT_CLICK_BLOCK)){
			ItemStack itemEnMano = event.getPlayer().getItemInHand();

			if(itemEnMano != null){
				ItemMeta im = itemEnMano.getItemMeta();
				if(im != null){
					if(im.getDisplayName() !=null && im.getDisplayName().contains("fuego")){
						Player p = event.getPlayer();
						Vector direccion = p.getEyeLocation().getDirection();

						p.launchProjectile(SmallFireball.class, Vector.getRandom() );

						for (int i = 0; i < numBolas ; i++){
							p.launchProjectile(SmallFireball.class, Vector.getRandom() );
	
	

						}
					}
				}
			}
		}
	}
}
