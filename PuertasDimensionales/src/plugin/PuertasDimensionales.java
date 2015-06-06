package plugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PuertasDimensionales extends JavaPlugin implements Listener{

	public static final String FILE_PATH = "/carpeta/miarchivo.txt";

	String nombrePuerta;
	private HashMap<String, Portal> puertas = new HashMap<String, Portal>();
	private long tiempoTranscurrido;
	private long ultimoTiempo;


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(command.getName().equalsIgnoreCase("puerta")){

				if(args.length > 0){
					if(puertas.get(args[0]) == null){
						nombrePuerta = args[0];
						Location loc = p.getLocation();
						Portal portal = new Portal();
						puertas.put(nombrePuerta, portal);
						portal.l1 = loc;

						construirPortal(p, nombrePuerta);
						p.sendMessage(ChatColor.YELLOW + "Puerta de entrada creada: "+ nombrePuerta);
						return true;
					}else{
						nombrePuerta = args[0];
						Location loc = p.getLocation();
						Portal portal = puertas.get(nombrePuerta);
						portal.l2 = loc;

						construirPortal(p, nombrePuerta);
						p.sendMessage(ChatColor.YELLOW + "Puerta de salida creada: "+ nombrePuerta);
						return true;
					}
				}

			}else if(command.getName().equalsIgnoreCase("hola")){

				if(args.length > 0){
					try {

						FileWriter outFile = new FileWriter("carpeta/miarchivo.txt");

						PrintWriter out = new PrintWriter(outFile);

						// Also could be written as follows on one line

						// Printwriter out = new PrintWriter(new FileWriter(filename));

						// Write text to file

						out.println(args[0]);

						out.close();

					} catch (IOException e) {

						e.printStackTrace();

					}
				}
				/*
				try {
					BufferedReader br = new BufferedReader(new FileReader(f));
					String linea = br.readLine();
					while(linea != null){
						Bukkit.getServer().broadcastMessage(linea);
						linea = br.readLine();
					}
					br.close();
				} catch (FileNotFoundException e) {
					Bukkit.getServer().broadcastMessage(FILE_PATH + " no existe o no se encuentra");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

				Collection<Portal> puertasSet = puertas.values();
				for(Portal po : puertasSet){
					if(po!=null){
						if(po.l1 != null){
							Bukkit.getServer().broadcastMessage(po.l1.getBlockX()+ ", " +po.l1.getBlockY()+", "+po.l1.getBlockZ());
						}
						if(po.l2!= null){
							Bukkit.getServer().broadcastMessage(po.l2.getBlockX()+ ", " +po.l2.getBlockY()+", "+po.l2.getBlockZ());
						}
					}
				}
			}

		}
		return false;
	}


	private void construirPortal(Player p, String nombrePuerta) {
		Location playerLoc = p.getLocation();
		playerLoc.add(0, 2, 0);
		playerLoc.getBlock().setType(Material.GLOWSTONE);
		
		ArmorStand entidad = (ArmorStand) playerLoc.getWorld().spawnEntity(playerLoc.add(0, -1, 0), EntityType.ARMOR_STAND);
		entidad.setGravity(false);
		entidad.setCustomName(nombrePuerta);
		entidad.setCustomNameVisible(true);
		entidad.setVisible(false);
		
		playerLoc.add(0, 1, 0);

		playerLoc.add(0, -3, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);



		playerLoc.add(0, 0, 1);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);

		playerLoc.add(0, 1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, 1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, 1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);

		playerLoc.add(0, 0, -2);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, -1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, -1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);
		playerLoc.add(0, -1, 0);
		playerLoc.getBlock().setType(Material.QUARTZ_BLOCK);

		playerLoc.add(0, 1, 0);
	}

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);

	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player player = e.getPlayer();
		long tiempoActual = System.currentTimeMillis();
		tiempoTranscurrido = tiempoActual  - ultimoTiempo;
		if(tiempoTranscurrido  > 2000){

			Collection<Portal> puertasSet = puertas.values();
			for(Portal p : puertasSet){
				if(p.l1 != null && p.l2 != null){
					if(p.l1.distance(player.getLocation()) < 1){
						player.teleport(p.l2);
						ultimoTiempo = tiempoActual;
					}else if(p.l2.distance(player.getLocation()) < 1){
						player.teleport(p.l1);
						ultimoTiempo = tiempoActual;
					}

				}
			}
		}


	}




}
