package plugin;

import java.util.ArrayList;

public class Generador {

	static boolean[][] laberinto = new boolean[51][51];


	public static boolean[][] generarLaberinto(){
		for(int i=0;i<laberinto.length;i++){
			for(int j=0;j<laberinto[i].length;j++){
				laberinto[i][j] = false;
			}
		}
		
		generar(1, 1);
		
		
		return laberinto;
	}
	

	private static void generar(int x, int z){
		//Obtener lista de vecinos aleatorios
		ArrayList<Vec2> vecinos = vecinosAleatorios(x, z);


		//Para todos los de la lista
		for(int i = 0;i<vecinos.size();i++){
			Vec2 vecino = vecinos.get(i);
			//Si no está visitado
			if(!laberinto[vecino.x][vecino.z]){
				laberinto[vecino.x][vecino.z] = true;
				Vec2 puntoMedio = new Vec2((vecino.x + x)/2, (vecino.z + z)/2);
				laberinto[puntoMedio.x][puntoMedio.z] = true;
				//Llamar a generar para ese vecino
				generar(vecino.x, vecino.z);
			}

		}


	}


	private static ArrayList<Vec2> vecinosAleatorios(int x, int z){
		boolean limiteDerecho = x >=48;
		boolean limiteAbajo = z <= 1;
		boolean limiteIzquierda = x <= 1;
		boolean limiteArriba = z >= 48;
		ArrayList<Vec2> resultado = new ArrayList<>();


		Vec2[] vecinos = new Vec2[4];

		vecinos[0] = new Vec2(x, z+2);
		vecinos[1] = new Vec2(x+2, z);
		vecinos[2] = new Vec2(x-2, z);
		vecinos[3] = new Vec2(x, z-2);
		if(!limiteArriba){

			resultado.add(vecinos[0]);
		}

		if(!limiteDerecho){

			resultado.add(vecinos[1]);
		}

		if(!limiteIzquierda){

			resultado.add(vecinos[2]);
		}

		if(!limiteAbajo){

			resultado.add(vecinos[3]);
		}

		int ale1 = (int)(Math.random()*20);

		for(int i = 0;i<ale1;i++){
			int ale2 = (int)(Math.random()*resultado.size());
			int ale3 = (int)(Math.random()*resultado.size());
			Vec2 uno =  resultado.get(ale2);
			resultado.set(ale2, resultado.get(ale3));
			resultado.set(ale3, uno);
		}

		return resultado;
	}


	public static void main(String[] args){
		
	}

}
