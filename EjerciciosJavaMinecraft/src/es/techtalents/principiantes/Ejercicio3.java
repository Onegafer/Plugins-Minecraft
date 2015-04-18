package es.techtalents.principiantes;


import org.bukkit.plugin.java.JavaPlugin;

import es.techtalents.main.Ejercicio;

/*3. Programa java que realice lo siguiente: 
 *  
 *  El programa debe simular una conversacion falsa entre dos jugadores en minecraft
 *  para ello se hara uso de variables de tipo String y los comandos print() y wait()
 *  
 *  Ejemplo:
 *  <Pepito> Hola
 *  <Jaimito> Hola Pepito
 *  <Pepito> hazme tp
 *  <Jaimito> no puedo no soy op
 *  .....
 *  .....
 * 
 * */
public class Ejercicio3 extends Ejercicio{

	public Ejercicio3(JavaPlugin plugin) {
		super(plugin);
	}

	public void run(){

		//SOLUCION
		
		print("<Pepito>" + "Hola!");
		
		wait(1500);
		
		print("<Jaimito>" + "Hola Pepito!");
		
		wait(2000);
		
		print("<Pepito>" + "hazme tp");
		
		wait(3000);
		
		print("<Jaimito>" + "no puedo no soy op");
		
		wait(2000);
		
		print("<Pepito>" + "donde estas");
		
		wait(1500);
		
		print("<Jaimito>" + "en mi casa");
		
		wait (1500);
	}

}
