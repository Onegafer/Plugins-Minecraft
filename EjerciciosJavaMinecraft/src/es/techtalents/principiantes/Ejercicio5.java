package es.techtalents.principiantes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*5. Programa java que realice lo siguiente: 
 *  Crea una variable nombreJugador de tipo String
 *  Crea una variable jugador de tipo Player
 *  Crea una variable lugar de tipo Location
 *  
 *  Pide por la pantalla de minecraft  que introduzcan el nombre de un jugador y almacena 
 *  el valor en la variable nombreJugador
 *  
 *  Obten el jugador con el metodo getPlayer() y almacenalo en la variable jugador
 *  
 *  Obten la localizacion del jugador y almacenala en la variable lugar
 *  
 *  Lanza un rayo en la localizacion almacenada en la variable lugar!!!
 * */
public class Ejercicio5 extends Ejercicio{
	
	public Ejercicio5(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		String nombreJugador;
		Player jugador;
		Location lugar;
		
		print("Porfavor, escribe tu nombre");
		
		nombreJugador = getString();
		
		jugador = getPlayer(nombreJugador);
		
		lugar = jugador.getLocation();
		
		//////////////////////////////////////////////////
		
		jugador.getWorld().strikeLightning(lugar);
		
		wait(2000);
		
		jugador.getWorld().strikeLightning(lugar);
		
		wait(2000);
		
		jugador.getWorld().strikeLightning(lugar);
		
		wait(2000);
		
	}
	
}