package plugin;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class TorreDeVigilancia extends JavaPlugin implements Listener {

	String playerName;
	int radioTorre;
	int desactivar = 0;
	int numeroDeVeces = 0;

	int a;
	int b;
	int c;
	int d;

	int rayo = 0;

	boolean animales;

	Location torreLoc;
	Location defaultPlayerLoc;
	
	int alturaTorre = 63;

	ArrayList<Location> locs = new ArrayList<Location>();

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);

		new BukkitRunnable() {

			@Override
			public void run() {
				if(torreLoc != null) {
					List<Entity> entidades = Bukkit.getWorld(torreLoc.getWorld().getName()).getEntities();
					if(torreLoc.getWorld().getName() == "world_the_end" || torreLoc.getWorld().getName() == "world_nether"){
						alturaTorre = 10;
					}else{
						alturaTorre = 63;
					}

					for (Entity entidad : entidades) {
						if (entidad.getLocation().distance(torreLoc) < radioTorre) {

							double distancia = entidad.getLocation().distance(
									torreLoc);

							if (distancia < radioTorre) {

								if (animales) {
									if (entidad.getType() == EntityType.GHAST
											|| entidad.getType() == EntityType.PIG_ZOMBIE
											|| entidad.getType() == EntityType.ZOMBIE
											|| entidad.getType() == EntityType.CREEPER
											|| entidad.getType() == EntityType.SKELETON
											|| entidad.getType() == EntityType.ENDERMAN
											|| entidad.getType() == EntityType.SPIDER) {
										if (entidad.getLocation().getY() >= alturaTorre) {
											entidad.getWorld().strikeLightning(entidad.getLocation());
										}
									}
								} else {
									if (entidad instanceof Player) {
										if (((Player)entidad).getGameMode() == GameMode.SURVIVAL) {
											entidad.getWorld().strikeLightning(entidad.getLocation());
										}
									}
								}

							}

						}

					}
				}
			}
		}.runTaskTimer(this, 10, 10);

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		final Player p = (Player) sender;

		if (command.getName().equalsIgnoreCase("torre") && p.isOp()) {
			Location playerLoc = p.getLocation();
			defaultPlayerLoc = p.getLocation();
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Introduce el tipo de torre: "
						+ ChatColor.YELLOW + "animales" + " o "
						+ ChatColor.BLUE + "jugadores");
			}

			if (args != null && args.length > 0) {
				if (args[0].equalsIgnoreCase("animales")) {
					animales = true;

					torreLoc = playerLoc.add(5, 0, 5);

					if (args.length > 1) {
						try {
							radioTorre = Integer.parseInt(args[1]);
						} catch (NumberFormatException e) {
							p.sendMessage(ChatColor.RED
									+ "Tienes que meter un número, no una palabra!");
						}
						construirTorre(p);
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("jugadores")) {
					animales = false;
					torreLoc = playerLoc.add(5, 0, 5);
					if (args.length > 1) {
						try {
							radioTorre = Integer.parseInt(args[1]);
						} catch (NumberFormatException e) {
							p.sendMessage(ChatColor.RED
									+ "Tienes que meter un número, no una palabra!");
						}
						desactivar = 0;

						if (radioTorre > 200) {

							p.sendMessage(ChatColor.RED
									+ "Radio demasiado grande, el máximo es 200");
							radioTorre = 200;

						}

					} else {

						p.sendMessage(ChatColor.RED
								+ "No has introducido el radio de la torre!");
						return true;
					}
					construirTorre(p);
					return true;
				}

				if (args[0].equalsIgnoreCase("desactivar")) {

					desactivar = 1;
					p.sendMessage(ChatColor.BLUE + "Torre desactivada!");
					return true;
				}
			}
		}

		return false;

	}

	private void construirTorre(final Player p) {

		p.sendMessage(ChatColor.YELLOW + "Construyendo torre de vigilancia...");

		playerName = p.getName();

		torreLoc.getBlock().setType(Material.STONE);

		// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		torreLoc.add(-3, 0, -3);
		for (int t = 0; t < 25; t++) {

			for (int j = 0; j < 5; j++) {

				for (int f = 0; f < 5; f++) {

					torreLoc.getBlock().setType(Material.QUARTZ_BLOCK);
					torreLoc.add(1, 0, 0);

				}
				torreLoc.add(-5, 0, 0);
				torreLoc.add(0, 0, 1);
			}

			torreLoc.add(0, 0, -5);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(4, 0, 0);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(0, 0, 4);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(-4, 0, 0);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(0, 0, -4);
			torreLoc.add(0, 1, 0);

		}

		torreLoc.add(-2, -5, -2);

		for (int j = 0; j < 9; j++) {

			for (int f = 0; f < 9; f++) {

				torreLoc.getBlock().setType(Material.SEA_LANTERN);
				torreLoc.add(1, 0, 0);

			}
			torreLoc.add(-9, 0, 0);
			torreLoc.add(0, 0, 1);
		}

		torreLoc.add(0, 0, -9);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(8, 0, 0);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(0, 0, 8);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(-8, 0, 0);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(0, 0, -8);
		torreLoc.add(0, 1, 0);

		for (int t = 0; t < 2; t++) {

			for (int j = 0; j < 9; j++) {

				for (int f = 0; f < 9; f++) {

					torreLoc.getBlock().setType(Material.GLASS);
					torreLoc.add(1, 0, 0);

				}
				torreLoc.add(-9, 0, 0);
				torreLoc.add(0, 0, 1);
			}

			torreLoc.add(0, 0, -9);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(8, 0, 0);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(0, 0, 8);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(-8, 0, 0);
			torreLoc.getBlock().setType(Material.AIR);

			torreLoc.add(0, 0, -8);
			torreLoc.add(0, 1, 0);

		}

		for (int j = 0; j < 9; j++) {

			for (int f = 0; f < 9; f++) {

				torreLoc.getBlock().setType(Material.SEA_LANTERN);
				torreLoc.add(1, 0, 0);

			}
			torreLoc.add(-9, 0, 0);
			torreLoc.add(0, 0, 1);
		}

		torreLoc.add(0, 0, -9);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(8, 0, 0);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(0, 0, 8);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(-8, 0, 0);
		torreLoc.getBlock().setType(Material.AIR);

		torreLoc.add(0, 0, -8);
		torreLoc.add(0, 1, 0);

		torreLoc.add(2, 0, 2);
		torreLoc.add(0, 0, 0);

		for (int j = 0; j < 5; j++) {

			for (int f = 0; f < 5; f++) {

				torreLoc.getBlock().setType(Material.IRON_BLOCK);
				torreLoc.add(1, 0, 0);

			}
			torreLoc.add(-5, 0, 0);
			torreLoc.add(0, 0, 1);
		}

		if (animales == true) {
			torreLoc.add(0, 0, -5);
			torreLoc.getBlock().setType(Material.LAPIS_BLOCK);

			torreLoc.add(4, 0, 0);
			torreLoc.getBlock().setType(Material.LAPIS_BLOCK);

			torreLoc.add(0, 0, 4);
			torreLoc.getBlock().setType(Material.LAPIS_BLOCK);

			torreLoc.add(-4, 0, 0);
			torreLoc.getBlock().setType(Material.LAPIS_BLOCK);

			torreLoc.add(0, 0, -4);
			torreLoc.add(0, -1, 0);
		}

		if (animales == false) {
			torreLoc.add(0, 0, -5);
			torreLoc.getBlock().setType(Material.REDSTONE_BLOCK);

			torreLoc.add(4, 0, 0);
			torreLoc.getBlock().setType(Material.REDSTONE_BLOCK);

			torreLoc.add(0, 0, 4);
			torreLoc.getBlock().setType(Material.REDSTONE_BLOCK);

			torreLoc.add(-4, 0, 0);
			torreLoc.getBlock().setType(Material.REDSTONE_BLOCK);

			torreLoc.add(0, 0, -4);
			torreLoc.add(0, -1, 0);
		}

		torreLoc.add(2, 2, 2);

		torreLoc.getBlock().setType(Material.BEACON);
		torreLoc.add(0, 1, 0);

		new BukkitRunnable() {

			@Override
			public void run() {
				p.getWorld().strikeLightningEffect(torreLoc);

			}
		}.runTaskTimer(this, 60L, 60L);

	}
}