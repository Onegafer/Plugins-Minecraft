package plugin;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Laberinto extends JavaPlugin implements Listener{


	@Override
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



		if(!(sender instanceof Player)){
			return false;
		}

		Player p = (Player)sender;

		if(command.getName().equalsIgnoreCase("laberinto")){

			construirLaberinto(p);

		}		

		return false;
	}

	private void construirLaberinto(Player p) {

		Location centro = p.getLocation().add(5, 0, 0);

		int xCentro = centro.getBlockX();
		int yCentro = centro.getBlockY();
		int zCentro = centro.getBlockZ();

		boolean[][] laberinto = Generador.generarLaberinto();
		for(int a=0;a<3;a++){
			for(int i=0;i<laberinto.length;i++){
				for(int j=0;j<laberinto[i].length;j++){
					if(!laberinto[i][j]){
						centro.getWorld().getBlockAt(i + xCentro, a + yCentro, j + zCentro).setType(Material.QUARTZ_BLOCK);
						
					}
					if(a==0){
						centro.getWorld().getBlockAt(i + xCentro, a + yCentro, j + zCentro).setType(Material.SEA_LANTERN);
					}
				}
			}
		}
		
		 

	}




}