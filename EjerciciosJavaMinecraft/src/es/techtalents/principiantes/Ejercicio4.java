package es.techtalents.principiantes;

import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*4. Programa java que realice lo siguiente: 
 *  declara una variable de tipo int y nombre n
 *  a continuacion pide al jugador que introduzca un numero en el chat de minecraft
 *  dale las gracias y asigna el numero a la variable n
 *  
 *  declara una variable de tipo int y nombre m
 *  a continuacion pide al jugador que introduzca otro numero en el chat de minecraft
 *  dale las gracias y asigna el numero a la variable m
 *  
 *  declara una variable de tipo int y nombre sum y asignale el valor de la operacion n + m
 *  imprime por pantalla el mensaje: "La suma de n + m es: "
 *  e imprime por pantalla el valor de la variable sum
 *  
 *  
 * */
public class Ejercicio4 extends Ejercicio{
	
	public Ejercicio4(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		
		print("Porfavor, introduce un número");
		
		int n = getInt();
		
		print("Gracias");
		
	/////////////////////////////////////////////////////
		
		print("Porfavor, introduce otro número");
		
		int m = getInt();
		
		print("Gracias");
		
	/////////////////////////////////////////////////////
		
		int sum = n + m;
		
		print("La suma de n + m es: " + sum);
		
	}
	
}
