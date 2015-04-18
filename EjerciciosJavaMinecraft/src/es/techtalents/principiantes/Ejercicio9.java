package es.techtalents.principiantes;

import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*9. Programa Java que declare una variable b de tipo entero 
 * pide al jugador que introduzca un numero por el chat de minecraft y asignale el numero a la variable.
 * 
 *  A continuación muestra un mensaje indicando si el valor de b es positivo o negativo.
 *   Consideraremos el 0 como positivo. 
 *  
 *  pista: usar un condicional (if) y el metodo getInt();
 *  
 *  Muestra el valor de cada variable antes y despues de los cambios
 * */
public class Ejercicio9 extends Ejercicio{
	
	public Ejercicio9(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		print("Porfavor, escribe un número");
		
		int b = getInt();
		
		if(b <= 0) {
			print(b + " es un número negativo");
		}
		
		if(b >= -1) {
			print(b + " es un número positivo");
		}
		
		
	}
	
}
