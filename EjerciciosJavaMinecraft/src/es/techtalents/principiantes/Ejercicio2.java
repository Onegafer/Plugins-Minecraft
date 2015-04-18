package es.techtalents.principiantes;

import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*2. Programa java que realice lo siguiente: 
 * declarar dos variables x e y de tipo int, 
 * dos variables n y m de tipo double y 
 * asigna a cada una un valor. 
 * A continuación reliza y muestra muestra por pantalla el valor de cada variable y
 * la suma de n + m.
 * la multiplicacion de n * n 
 * la division de x / y
 * la division de x / m
 * la operacion (n+n/x)*y
 * la diferencia de y - x
 * la suma de y + 4
 * 
 * * indicando lo que es cada cosa, Por Ejemplo: 
 * "n es: 3.5"
 * "m es: 4.5"
 * "la suma de n + m es: 8.0"
 * 
 * */
public class Ejercicio2 extends Ejercicio{
	
	public Ejercicio2(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		int x = 15;
		int y = 25;
		double n = 5.5;
		double m = 10.5;
		
		double nMasm = n + m;
		double nporn = n * n;
		double xentrey = x / y;
		double xentrem = n / m;
		double operacion = (n + n / x) * y;
		double ymenosx = y - x;
		double ymas4 = y + 4;
		
		print("x vale: " + x);
		print("y vale: " + y);
		print("n vale: " + n);
		print("m vale: " + m);
		
		print("la suma de n + m es: " + nMasm);
		print("la multiìclación de n * n es: " + nporn);
		print("la división de x / y es: " + xentrey);
		print("la división de x / m es: " + xentrem);
		print("la operación de (n + n / x) * y es: " + operacion);
		print("la resta de y - x es: " + ymenosx);
		print("la suma de y + 4 es: " + ymas4);
	}
	
}
