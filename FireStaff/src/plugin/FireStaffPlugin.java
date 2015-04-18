package plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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


public class FireStaffPlugin extends JavaPlugin implements Listener{
	int numBolas = 10; //El número de bolas de fuego a generar

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Player p = (Player)sender;

		if(command.getName().equalsIgnoreCase("firestaff")){

			if(args.length > 0){
				numBolas = Integer.parseInt(args[0]);
			}
			ItemStack varaFuego = new ItemStack(Material.BLAZE_ROD);
			ItemMeta varaMeta = varaFuego.getItemMeta();
			varaMeta.setDisplayName(ChatColor.GOLD + "Vara de fuego de " + p.getName());
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
