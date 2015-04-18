package es.techtalents.principiantes;

import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*8. Programa Java que declare una variable b de tipo entero y asígnale un valor.
 * 
 *  A continuación muestra un mensaje indicando si el valor de b es positivo o negativo.
 *   Consideraremos el 0 como positivo. 
 *  
 *  pista: usar un condicional (if)
 *  
 *  Muestra el valor de cada variable antes y despues de los cambios
 * */
public class Ejercicio8 extends Ejercicio{
	
	public Ejercicio8(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		int b = 10;
		
		if(b <= 0) {
			print("b es: " + b + " y es un número negativo");
		}
		
		if(b > 0) {
			print("b es: " + b + " y es un número positivo");
		}
	}
}
