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

public class Constructor extends JavaPlugin implements Listener{


	@Override
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		//Si no es un jugador no hacemos nada. ! = Negación
		if(!(sender instanceof Player)){
			return false;
		}

		//Comprabamos que el comando es construir
		if(command.getName().equalsIgnoreCase("construir")){

			if(args != null && args.length > 0 && args[0].equalsIgnoreCase("cupula")){
				Player p = (Player)sender;

				int radioCupula = 10;

				if(args.length > 1){
					radioCupula = Integer.parseInt(args[1]);
				}

				int limiteRadio = 30;

				if(radioCupula > limiteRadio){
					p.sendMessage(ChatColor.RED + "Te has pasado de listo.");
					p.sendMessage(ChatColor.BLUE + "El radio debe ser como máximo" + limiteRadio);
					return true;
				}



				construirCupula(p, radioCupula);
			}else if(args[0].equalsIgnoreCase("piramide")){



				Player p = (Player)sender;

				Location centro = p.getLocation();

				int alturaPiramide = 10;

				if(args.length > 1){
					alturaPiramide = Integer.parseInt(args[1]);
				}

				Material materialPiramide = Material.SANDSTONE;

				if(args.length > 2){
					try{
						materialPiramide = Material.valueOf(args[2].toUpperCase());
					}catch(IllegalArgumentException e){
						materialPiramide = null;
					}
					if(materialPiramide == null){
						materialPiramide = Material.SANDSTONE;
						p.sendMessage(ChatColor.RED + "Ese material no existe!");
					}
				}

				construirPiramide(centro, alturaPiramide, materialPiramide );

			}


			return true;
		}		

		return false;
	}

	private void construirPiramide(Location centro, int alturaPiramide,  Material materialPiramide) {

		int xCentro = centro.getBlockX();
		int yCentro = centro.getBlockY();
		int zCentro = centro.getBlockZ();

		for(int h = 0; h <= alturaPiramide; h++){

			int lado = (alturaPiramide - h);
			for(int i = -lado; i <= lado; i++){
				for(int j = -lado; j <= lado; j++){

					centro.getWorld().getBlockAt(i + xCentro, h + yCentro, j + zCentro).setType(materialPiramide);
					if(j != 0){
						if(h == 0 && i % j == 0){
							centro.getWorld().getBlockAt(i + xCentro, h + yCentro, j + zCentro).setType(Material.SEA_LANTERN);
						}
					}
					int dist = (int)Math.sqrt(i*i+j*j);
					if(dist  % 4 ==0){
						centro.getWorld().getBlockAt(i + xCentro, h + yCentro, j + zCentro).setType(Material.GOLD_BLOCK);
					}
					
					
					
				}
			}
		}

		alturaPiramide = alturaPiramide -1;




		for(int h = 1; h < alturaPiramide; h++){

			int lado = (alturaPiramide - h);
			for(int i = -lado; i <= lado; i++){
				for(int j = -lado; j <= lado; j++){
					centro.getWorld().getBlockAt(i + xCentro, h + yCentro, j + zCentro).setType(Material.AIR);
				}
			}
		}

	}

	private void construirCupula(Player p, int radioCupula) {
		Location centro = p.getLocation();
		int xCentro = centro.getBlockX();
		int yCentro = centro.getBlockY();
		int zCentro = centro.getBlockZ();
		Material materialCupula = Material.GLASS;

		for(int i = -radioCupula; i <= radioCupula; i++){
			for(int j = 0; j <= radioCupula; j++){
				for(int k = -radioCupula; k <= radioCupula; k++){
					if( (int)Math.sqrt((i*i)+(j*j)+(k*k)) == radioCupula)
						centro.getWorld().getBlockAt(i + xCentro, j +yCentro, k + zCentro).setType(materialCupula);
				}
			}
		}
	}
}