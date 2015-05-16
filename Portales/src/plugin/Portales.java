package plugin;

import java.util.HashMap;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Portales extends JavaPlugin implements Listener{

	private HashMap<String, Location> destinos = new HashMap<String, Location>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(command.getName().equalsIgnoreCase("destino")){
				if(args.length > 0){

					String nombreDestino = args[0];
					Location loc = p.getLocation();
					destinos.put(nombreDestino, loc);
					
					construirPortal(p);
					p.sendMessage(ChatColor.YELLOW + "Destino creado");
					return true;
				}

			}

			if(command.getName().equalsIgnoreCase("casa")){
				if(args.length > 0){

					String nombreCasa = args[0];
					Location casa = destinos.get(nombreCasa);
					if(casa != null){
						p.teleport(casa);
					}else{
						p.sendMessage(ChatColor.RED + "Ese portal no existe!");
					}
					return true;
				}

			}





		}
		return false;
	}


	private void construirPortal(Player p) {
		Location playerLoc = p.getLocation();
		playerLoc.add(-2, 0, -2);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, 1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, 1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, 1, 0);
		playerLoc.getBlock().setType(Material.GLOWSTONE);
	}


	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);

	}


}
