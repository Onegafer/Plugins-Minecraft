package es.techtalents.medio;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*1. Programa java que realice lo siguiente: 
 * 
 * pide al jugador que introduzca un numero entre 1 y 10 y asignalo a una variable
 * 
 * si el numero introducido es menor que 1 o mayor que 10 lanzale un rayo como castigo
 * 
 * si el numero introducido es correcto dale 2 diamantes al jugador 
 * 
 * 
*/
public class Ejercicio1m extends Ejercicio{
	
	public Ejercicio1m(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		int num;
		
		print("Dame un numero entre 1 y 10");
		num = getInt();
		Player p = getLastChatPlayer();
		
		if(num < 1 || num > 10){
			strikeLightning(p);
		}else{
			giveItem(p, Material.DIAMOND);
			giveItem(p, Material.DIAMOND);
			
		}
	}
}
