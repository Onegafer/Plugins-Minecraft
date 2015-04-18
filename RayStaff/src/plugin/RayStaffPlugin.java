package plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class RayStaffPlugin extends JavaPlugin implements Listener{
	int numRayos = 10; //El número de rayos a generar

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		Player p = (Player)sender;

		if(command.getName().equalsIgnoreCase("raystaff")){
			
			
			try{
				if(args.length > 0){
					numRayos = Integer.parseInt(args[0]);
				}
			}catch(NumberFormatException e){
				p.sendMessage("Colega " + args[0] + " no es un numero!!!!!!" + ChatColor.GOLD + " ¿Estas flipando?");
			}
			
			
			
			//Crea una nueva vara
			ItemStack varaFuego = new ItemStack(Material.STICK);
			ItemMeta varaMeta = varaFuego.getItemMeta();
			varaMeta.setDisplayName(ChatColor.BLUE + "Vara de rayos de " + p.getName());
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
					if(im.getDisplayName() !=null && im.getDisplayName().contains("rayos")){
						Player p = event.getPlayer();

						//Lanza rayo



						for (int i = 0; i < numRayos ; i++){
							Location locRayo  = p.getTargetBlock(null, 255).getLocation();

							double numAleatorio = Math.random()*20 -10; //Variable que genera un numero aleatorio entr 1 y 10
							double numAleatorio2 = Math.random()*20 -10; //Variable que genera un numero aleatorio entr 1 y 10

							Location rayAleatorio = locRayo.add(numAleatorio, 0, numAleatorio2); //Variable que crea un rayo con el numero generado anteriormente

							p.getWorld().strikeLightning(rayAleatorio);
						}
					}
				}
			}
		}
	}
}
