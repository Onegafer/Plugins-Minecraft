package plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class FireStaffPlugin extends JavaPlugin implements Listener{
	int numBolas = 10; //El número de bolas de fuego a generar
	
	Location entidadLoc;


	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		final Player p = (Player)sender;

		if(command.getName().equalsIgnoreCase("firestaff")){

			if(args.length > 0){
				numBolas = Integer.parseInt(args[0]);
			}
			ItemStack varaFuego = new ItemStack(Material.BLAZE_ROD);
			ItemMeta varaMeta = varaFuego.getItemMeta();
			varaMeta.setDisplayName(ChatColor.GOLD + "Vara de fuego de " + p.getName());
			varaFuego.setItemMeta(varaMeta);
			p.setItemInHand(varaFuego);

			BukkitRunnable r = new BukkitRunnable() {

				@Override
				public void run() {
					
					List<Entity> entidades = p.getWorld().getEntities();

					for (Entity entidad : entidades) {
						if (entidad.getLocation().distance(p.getLocation()) < 10) {
							entidadLoc = entidad.getLocation();
						}
					}
				}
			};
			r.runTaskTimer(this, 5, 5);

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

		if(event.getAction() ==(Action.RIGHT_CLICK_AIR)){
			ItemStack itemEnMano = event.getPlayer().getItemInHand();

			if(itemEnMano != null){
				ItemMeta im = itemEnMano.getItemMeta();
				if(im != null){
					if(im.getDisplayName() !=null && im.getDisplayName().contains("fuego")){
						Player p = event.getPlayer();

						Entity flecha = p.getWorld().spawnEntity(p.getLocation(), EntityType.ARROW);

						Vector direccion = entidadLoc.add(0, 1, 0).subtract(p.getLocation()).toVector();

						flecha.setVelocity(direccion);



					}
				}
			}
		}
	}
}
