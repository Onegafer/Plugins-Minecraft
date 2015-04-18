package es.techtalents.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.medio.Ejercicio1m;
import es.techtalents.principiantes.Ejercicio1;
import es.techtalents.principiantes.Ejercicio10;
import es.techtalents.principiantes.Ejercicio2;
import es.techtalents.principiantes.Ejercicio3;
import es.techtalents.principiantes.Ejercicio4;
import es.techtalents.principiantes.Ejercicio5;
import es.techtalents.principiantes.Ejercicio6;
import es.techtalents.principiantes.Ejercicio7;
import es.techtalents.principiantes.Ejercicio8;
import es.techtalents.principiantes.Ejercicio9;

public class Main extends JavaPlugin implements Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("ejercicio1")){
			new Ejercicio1(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio2")){
			new Ejercicio2(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio3")){
			new Ejercicio3(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio4")){
			new Ejercicio4(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio5")){
			new Ejercicio5(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio6")){
			new Ejercicio6(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio7")){
			new Ejercicio7(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio8")){
			new Ejercicio8(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio9")){
			new Ejercicio9(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio10")){
			new Ejercicio10(this).runTaskLaterAsynchronously(this, 1);
		}
		if(command.getName().equalsIgnoreCase("ejercicio1m")){
			new Ejercicio1m(this).runTaskLaterAsynchronously(this, 1);
		}
		
		return false;
	}

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}


	@EventHandler
	public void chatEvent(AsyncPlayerChatEvent e){
		if(Ejercicio.dataEntered(e.getMessage(), e.getPlayer())){
			e.setCancelled(true);
		}
	}
}
