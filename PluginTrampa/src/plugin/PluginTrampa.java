package plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginTrampa extends JavaPlugin implements Listener{

	Location trampa;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	
		//Comprobamos si el que envía el comando es un juador
		if(sender instanceof Player){
			
			//Comprobamos si el comando es "trampa"
			if(command.getName().equalsIgnoreCase("trampa")){
				
				Player p = (Player)sender;				
				Location playerLoc = p.getLocation();				
				trampa = playerLoc;				
				return true;
			}
		}	
		return false;
	}

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerMoves(PlayerMoveEvent event){
		
		Player p = event.getPlayer();
		
		//Comprobamos is hay una trampa
		if(trampa != null){
			
			//Comprobamos si el nombre del jugador es distinto de el vuestro
			if(!p.getName().equals("Fernando")){
				
				Location playerLocation = p.getLocation();
				
				int radioDetonacion = 5;
				if(trampa.distance(playerLocation) <= radioDetonacion){
					trampa.getWorld().createExplosion(trampa, 10);
					trampa = null;
				}
				
			}
		}
		
	}
	
	

}