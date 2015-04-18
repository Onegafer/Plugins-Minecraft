package es.techtalents.principiantes;

import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*7. Programa java que declare cuatro variables enteras a, b, c y d y asígnale un valor acada una.
 *  A continuación realiza las instrucciones necesarias para que: 
 *  
 *  b tome el valor de c, 
 *  c tome el valor de a, 
 *  a tome el valor de d, 
 *  d tome el valor de b.
 *  
 *  
 *  Muestra el valor de cada variable antes y despues de los cambios
 * */
public class Ejercicio7 extends Ejercicio{
	
	public Ejercicio7(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40;
		
		print("b es: " + b);
		print("c es: " + c);
		print("a es: " + a);
		print("d es: " + d);
		
		int aux = c;
		
		c = a;
		a = d;
		d = b;
		b = aux;
		
		print("Ahora b es: " + b);
		print("Ahora c es: " + c);
		print("Ahora a es: " + a);
		print("Ahora d es: " + d);
		
		
	}
	
}
