package es.techtalents.principiantes;

import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*6. Programa Java que declare una variable entera n y asígnale un valor. 
 * A continuación escribe las instrucciones que realicen lo siguiente: 
 * Incrementar n en 77, 
 * Decrementarla en 3, 
 * Duplicar su valor. 
 * 
 * Muestra el valor de la variable despues de cada cambio
 * */
public class Ejercicio6 extends Ejercicio{
	
	public Ejercicio6(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){
		
		//SOLUCION
		
		int n = 10;
		
		int nIncrementarEn77 = 10 + 77;
		
		int decrementarEn3 = nIncrementarEn77 - 3;
		
		int duplicar = decrementarEn3 * 2;
		
		print("Incrementar " + n + " en 77: " + nIncrementarEn77);
		
		print("Decrementarlo en 3: " + decrementarEn3);
		
		print("Duplicar su valor: " + duplicar);
		
		print("Resultado final: " + duplicar);
	}
	
}
