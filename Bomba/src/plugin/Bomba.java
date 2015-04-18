package plugin;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class Bomba extends JavaPlugin implements Listener{
	int numRayos = 10; //El número de rayos a generar

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		final Player p = (Player)sender;
		//Comprobamos si el que envía el comando es un jugador
		if(sender instanceof Player){
			//Comprobamos si el comando es "bomba"
			if(command.getName().equalsIgnoreCase("bomba")){
				final Location playerLoc = p.getLocation(); //Localización del jugador

				
				int n = 0;

				if(args.length > 0){
					
					try{
						n = Integer.parseInt(args[0]);
					}catch(NumberFormatException e){
						p.sendMessage (ChatColor.RED + "No has introducido un número!!");
						
						return true;
					}

					if(n > 100){
						p.sendMessage (ChatColor.RED + "Has puesto un número demasiado grande!!");
						
						return true;
					}
				}else{
					p.sendMessage("Introduce un número detrás del comando");

					return true;
				}

				final int radioExp = n;
				BukkitRunnable r = new BukkitRunnable() {
					int i = playerLoc.getBlockY();
					Location bombaLoc = playerLoc.add(0, -1, 0);
					Block bombaBloque = bombaLoc.getBlock(); 


					@Override
					public void run() {
						if(i > 0){
							bombaLoc.add(0,-1,0);
							bombaBloque = bombaLoc.getBlock();
							if(bombaBloque.getType() != Material.AIR && bombaBloque.getType() != Material.TNT){



								bombaLoc.getWorld().createExplosion(bombaLoc, radioExp);
								cancel();

							}else{
								bombaLoc.add(0,1,0);
								bombaBloque = bombaLoc.getBlock();
								bombaBloque.setType(Material.AIR);
								bombaLoc.setY(i--);
								bombaBloque = bombaLoc.getBlock();
								bombaBloque.setType(Material.TNT);
								bombaLoc.getWorld().playEffect(bombaLoc, Effect.SMOKE, 100);
							}
						}
						else{
							cancel();
						}
					}
				};
				r.runTaskTimer(this, 5, 5);
				return true;
			}

			return false;
		}
		return false;
	}

	public void wait(int milis){

	}
}